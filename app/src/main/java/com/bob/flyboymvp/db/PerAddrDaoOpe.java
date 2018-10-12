package com.bob.flyboymvp.db;

/**
 * Created by bob on 2018/5/18.
 */

import android.content.Context;

import com.bob.flyboymvp.dao.PerAddrInfoDao;
import com.bob.flyboymvp.dao.UserInfoDao;
import com.bob.flyboymvp.model.PerAddrInfo;
import com.bob.flyboymvp.model.UserInfo;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


public class PerAddrDaoOpe {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, PerAddrInfo stu) {
        DbUserManager.getDaoSession(context).getPerAddrInfoDao().insert(stu);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<PerAddrInfo> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbUserManager.getDaoSession(context).getPerAddrInfoDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param student
     */
    public static void saveData(Context context, PerAddrInfo student) {
        DbUserManager.getDaoSession(context).getPerAddrInfoDao().save(student);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param student 删除具体内容
     */
    public static void deleteData(Context context, PerAddrInfo student) {
        DbUserManager.getDaoSession(context).getPerAddrInfoDao().delete(student);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbUserManager.getDaoSession(context).getPerAddrInfoDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbUserManager.getDaoSession(context).getPerAddrInfoDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param context
     * @param student
     */
    public static void updateData(Context context, PerAddrInfo student) {
        DbUserManager.getDaoSession(context).getPerAddrInfoDao().update(student);
    }


    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<PerAddrInfo> queryAll(Context context) {
        QueryBuilder<PerAddrInfo> builder = DbUserManager.getDaoSession(context).getPerAddrInfoDao().queryBuilder();

        return builder.build().list();
    }


    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<PerAddrInfo> queryPaging( int pageSize, int pageNum,Context context){
        PerAddrInfoDao studentDao = DbUserManager.getDaoSession(context).getPerAddrInfoDao();
        List<PerAddrInfo> listMsg = studentDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }
    public static PerAddrInfo queryMyselfItem(Context context){
        PerAddrInfoDao mDao = DbUserManager.getDaoSession(context).getPerAddrInfoDao();
        return mDao.queryBuilder()
                .where(PerAddrInfoDao.Properties.Per_private.eq(1))
                .unique();

    }

}