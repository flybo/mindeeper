package com.bob.flyboymvp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by bob on 2018/5/18.
 */
@Entity
public class UserInfo {
    @Id(autoincrement = true)  //指明id
    private Long id;
    @Property  //属性字段
    private String userPhone;
    //@Property(nameInDb = "user_password")  //可以修改字段名称
    private String userPassword;
    private String userGuid;
    public UserInfo() {}
    @Generated(hash = 1023952814)
    public UserInfo(Long id, String userPhone, String userPassword,
            String userGuid) {
        this.id = id;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userGuid = userGuid;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserPhone() {
        return this.userPhone;
    }
    public void setUserPhone(String username) {
        this.userPhone = username;
    }
    public String getUserGuid() {
        return userGuid;
    }
    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }
    public String getUserPassword() {
        return this.userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
