package com.bob.flyboymvp.db;

/**
 * 个人数据库管理
 * Created by bob on 2018/5/18.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.dao.DaoMaster;
import com.bob.flyboymvp.dao.DaoSession;
import com.bob.flyboymvp.helper.MyOpenHelper;
import com.bob.flyboymvp.util.SPUtils;


public class DbUserManager {

    // 是否加密
    public static final boolean ENCRYPTED = true;

    private static DbUserManager mDbManager;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    private Context mContext;

    private DbUserManager(Context context) {
        this.mContext = context;
        // 初始化数据库信息
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context, SPUtils.getInstance(context).getString(AppConst.User.USER_GUID,"")+"_db");
        getDaoMaster(context);
        getDaoSession(context);
    }

    public static DbUserManager getInstance(Context context) {
        if (null == mDbManager) {
            synchronized (DbUserManager.class) {
                if (null == mDbManager) {
                    mDbManager = new DbUserManager(context);
                }
            }
        }
        return mDbManager;
    }

    /**
     * 获取可读数据库
     *
     * @param context
     * @return
     */
    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     * @param context
     * @return
     */
    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }

        return mDevOpenHelper.getWritableDatabase();
    }

    /**
     * 获取DaoMaster
     *
     * @param context
     * @return
     */
//    public static DaoMaster getDaoMaster(Context context) {
//        if (null == mDaoMaster) {
//            synchronized (DbManager.class) {
//                if (null == mDaoMaster) {
//                    mDaoMaster = new DaoMaster(getWritableDatabase(context));
//                }
//            }
//        }
//        return mDaoMaster;
//    }

    /**
     * 获取DaoMaster
     *
     * 判断是否存在数据库，如果没有则创建数据库
     * @param context
     * @return
     */
    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (DbUserManager.class) {
                if (null == mDaoMaster) {
                    MyOpenHelper helper = new MyOpenHelper(context,SPUtils.getInstance(context).getString(AppConst.User.USER_GUID,"")+"_db",null);
                    mDaoMaster = new DaoMaster(helper.getWritableDatabase());
                }
            }
        }
        return mDaoMaster;
    }

    /**
     * 获取DaoSession
     *
     * @param context
     * @return
     */
    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DbUserManager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }
}
