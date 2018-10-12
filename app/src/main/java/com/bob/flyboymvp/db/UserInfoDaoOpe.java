package com.bob.flyboymvp.db;

/**
 * Created by bob on 2018/5/18.
 */

import android.content.Context;

import com.bob.flyboymvp.dao.UserInfoDao;
import com.bob.flyboymvp.model.UserInfo;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


public class UserInfoDaoOpe {

    /**
     * 添加数据至数据库
     *
     * @param context
     * @param stu
     */
    public static void insertData(Context context, UserInfo stu) {
        DbManager.getDaoSession(context).getUserInfoDao().insert(stu);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<UserInfo> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getUserInfoDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param student
     */
    public static void saveData(Context context, UserInfo student) {
        DbManager.getDaoSession(context).getUserInfoDao().save(student);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param student 删除具体内容
     */
    public static void deleteData(Context context, UserInfo student) {
        DbManager.getDaoSession(context).getUserInfoDao().delete(student);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbManager.getDaoSession(context).getUserInfoDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getUserInfoDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param context
     * @param student
     */
    public static void updateData(Context context, UserInfo student) {
        DbManager.getDaoSession(context).getUserInfoDao().update(student);
    }


    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<UserInfo> queryAll(Context context) {
        QueryBuilder<UserInfo> builder = DbManager.getDaoSession(context).getUserInfoDao().queryBuilder();

        return builder.build().list();
    }


    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<UserInfo> queryPaging( int pageSize, int pageNum,Context context){

        UserInfoDao studentDao = DbManager.getDaoSession(context).getUserInfoDao();
        List<UserInfo> listMsg = studentDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }

    public static UserInfo queryItem(String name,String pwd,Context context){
        UserInfoDao studentDao = DbManager.getDaoSession(context).getUserInfoDao();
        return studentDao.queryBuilder()
                .where(UserInfoDao.Properties.UserPhone.eq(name),UserInfoDao.Properties.UserPassword.eq(pwd))
                .unique();

    }
}