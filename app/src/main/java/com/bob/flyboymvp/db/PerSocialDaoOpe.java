package com.bob.flyboymvp.db;

/**
 * Created by bob on 2018/5/18.
 */

import android.content.Context;

import com.bob.flyboymvp.dao.PerAddrInfoDao;
import com.bob.flyboymvp.dao.PerSocialInforDao;
import com.bob.flyboymvp.model.PerSocialInfor;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


public class PerSocialDaoOpe {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, PerSocialInfor stu) {
        DbUserManager.getDaoSession(context).getPerSocialInforDao().insert(stu);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<PerSocialInfor> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbUserManager.getDaoSession(context).getPerSocialInforDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param student
     */
    public static void saveData(Context context, PerSocialInfor student) {
        DbUserManager.getDaoSession(context).getPerSocialInforDao().save(student);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param student 删除具体内容
     */
    public static void deleteData(Context context, PerSocialInfor student) {
        DbUserManager.getDaoSession(context).getPerSocialInforDao().delete(student);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbUserManager.getDaoSession(context).getPerSocialInforDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbUserManager.getDaoSession(context).getPerSocialInforDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param context
     * @param student
     */
    public static void updateData(Context context, PerSocialInfor student) {
        DbUserManager.getDaoSession(context).getPerSocialInforDao().update(student);
    }


    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<PerSocialInfor> queryAll(Context context) {
        QueryBuilder<PerSocialInfor> builder = DbUserManager.getDaoSession(context).getPerSocialInforDao().queryBuilder();

        return builder.build().list();
    }


    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<PerSocialInfor> queryPaging( int pageSize, int pageNum,Context context){

        PerSocialInforDao studentDao = DbUserManager.getDaoSession(context).getPerSocialInforDao();
        List<PerSocialInfor> listMsg = studentDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }

    public static PerSocialInfor queryItem(Context context,int perid){
        PerSocialInforDao mDao = DbUserManager.getDaoSession(context).getPerSocialInforDao();
        return mDao.queryBuilder()
                .where(PerSocialInforDao.Properties.Per_addr_list_id.eq(perid))
                .unique();
    }

}