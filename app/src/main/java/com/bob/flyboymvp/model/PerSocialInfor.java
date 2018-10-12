package com.bob.flyboymvp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 社交信息表
 * Created by Administrator on 2018/6/20.
 */
@Entity
public class PerSocialInfor {
    @Id(autoincrement = true)  //指明id
    private Long id;
    private String per_user_guid; //guid，用来全部覆盖时用
    private int per_social_infor_id;//服务端同步id
    private int per_addr_list_id;
    private transient String per_blog="";
    private String per_motto="";//座佑铭
    private String per_contact_purpose="";
    private String per_giving_field="";
    private int per_marriage=-1;//婚姻状况键
    private transient String per_marriage_value="";//婚姻状况值
    private int per_children=-1;//子女键
    private transient String per_children_value="";//子女值
    private String per_birthday="";//生日
    private String per_birth_date="";//出生日期
    private String per_birth_lunar="";//阴历生日
    private int per_zodiac=-1;//生肖
    private transient String per_zodiac_value="";//生肖值
    private int per_constellation=-1;//星座
    private transient String per_constellation_value="";//星座值
    private String per_enneagram="";//九型人格
    private String per_character="";//性格
    private String per_sport_hobby="";//运行爱好
    private String per_ent_hobby="";//娱乐爱好
    private String per_leisure_hobby="";//休闲爱好
    private String per_culture_hobby="";//文化爱好
    private String per_read_hobby="";//阅读爱好
    private int per_read_time=-1;//阅读时间
    private transient String per_read_time_value="";//阅读时间值
    private String per_tv_hobby="";//影视爱好
    private int per_tv_time=-1;//观看时间
    private transient String per_tv_time_value="";
    private String per_like_idol="";//喜爱的人物
    @Generated(hash = 443768245)
    public PerSocialInfor(Long id, String per_user_guid, int per_social_infor_id,
            int per_addr_list_id, String per_motto, String per_contact_purpose,
            String per_giving_field, int per_marriage, int per_children,
            String per_birthday, String per_birth_date, String per_birth_lunar,
            int per_zodiac, int per_constellation, String per_enneagram,
            String per_character, String per_sport_hobby, String per_ent_hobby,
            String per_leisure_hobby, String per_culture_hobby,
            String per_read_hobby, int per_read_time, String per_tv_hobby,
            int per_tv_time, String per_like_idol) {
        this.id = id;
        this.per_user_guid = per_user_guid;
        this.per_social_infor_id = per_social_infor_id;
        this.per_addr_list_id = per_addr_list_id;
        this.per_motto = per_motto;
        this.per_contact_purpose = per_contact_purpose;
        this.per_giving_field = per_giving_field;
        this.per_marriage = per_marriage;
        this.per_children = per_children;
        this.per_birthday = per_birthday;
        this.per_birth_date = per_birth_date;
        this.per_birth_lunar = per_birth_lunar;
        this.per_zodiac = per_zodiac;
        this.per_constellation = per_constellation;
        this.per_enneagram = per_enneagram;
        this.per_character = per_character;
        this.per_sport_hobby = per_sport_hobby;
        this.per_ent_hobby = per_ent_hobby;
        this.per_leisure_hobby = per_leisure_hobby;
        this.per_culture_hobby = per_culture_hobby;
        this.per_read_hobby = per_read_hobby;
        this.per_read_time = per_read_time;
        this.per_tv_hobby = per_tv_hobby;
        this.per_tv_time = per_tv_time;
        this.per_like_idol = per_like_idol;
    }
    @Generated(hash = 31200362)
    public PerSocialInfor() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPer_user_guid() {
        return this.per_user_guid;
    }
    public void setPer_user_guid(String per_user_guid) {
        this.per_user_guid = per_user_guid;
    }
    public int getPer_social_infor_id() {
        return this.per_social_infor_id;
    }
    public void setPer_social_infor_id(int per_social_infor_id) {
        this.per_social_infor_id = per_social_infor_id;
    }
    public int getPer_addr_list_id() {
        return this.per_addr_list_id;
    }
    public void setPer_addr_list_id(int per_addr_list_id) {
        this.per_addr_list_id = per_addr_list_id;
    }
    public String getPer_motto() {
        return this.per_motto;
    }
    public void setPer_motto(String per_motto) {
        this.per_motto = per_motto;
    }
    public String getPer_contact_purpose() {
        return this.per_contact_purpose;
    }
    public void setPer_contact_purpose(String per_contact_purpose) {
        this.per_contact_purpose = per_contact_purpose;
    }
    public String getPer_giving_field() {
        return this.per_giving_field;
    }
    public void setPer_giving_field(String per_giving_field) {
        this.per_giving_field = per_giving_field;
    }
    public int getPer_marriage() {
        return this.per_marriage;
    }
    public void setPer_marriage(int per_marriage) {
        this.per_marriage = per_marriage;
    }
    public int getPer_children() {
        return this.per_children;
    }
    public void setPer_children(int per_children) {
        this.per_children = per_children;
    }
    public String getPer_birthday() {
        return this.per_birthday;
    }
    public void setPer_birthday(String per_birthday) {
        this.per_birthday = per_birthday;
    }
    public String getPer_birth_date() {
        return this.per_birth_date;
    }
    public void setPer_birth_date(String per_birth_date) {
        this.per_birth_date = per_birth_date;
    }
    public String getPer_birth_lunar() {
        return this.per_birth_lunar;
    }
    public void setPer_birth_lunar(String per_birth_lunar) {
        this.per_birth_lunar = per_birth_lunar;
    }
    public int getPer_zodiac() {
        return this.per_zodiac;
    }
    public void setPer_zodiac(int per_zodiac) {
        this.per_zodiac = per_zodiac;
    }
    public int getPer_constellation() {
        return this.per_constellation;
    }
    public void setPer_constellation(int per_constellation) {
        this.per_constellation = per_constellation;
    }
    public String getPer_enneagram() {
        return this.per_enneagram;
    }
    public void setPer_enneagram(String per_enneagram) {
        this.per_enneagram = per_enneagram;
    }
    public String getPer_character() {
        return this.per_character;
    }
    public void setPer_character(String per_character) {
        this.per_character = per_character;
    }
    public String getPer_sport_hobby() {
        return this.per_sport_hobby;
    }
    public void setPer_sport_hobby(String per_sport_hobby) {
        this.per_sport_hobby = per_sport_hobby;
    }
    public String getPer_ent_hobby() {
        return this.per_ent_hobby;
    }
    public void setPer_ent_hobby(String per_ent_hobby) {
        this.per_ent_hobby = per_ent_hobby;
    }
    public String getPer_leisure_hobby() {
        return this.per_leisure_hobby;
    }
    public void setPer_leisure_hobby(String per_leisure_hobby) {
        this.per_leisure_hobby = per_leisure_hobby;
    }
    public String getPer_culture_hobby() {
        return this.per_culture_hobby;
    }
    public void setPer_culture_hobby(String per_culture_hobby) {
        this.per_culture_hobby = per_culture_hobby;
    }
    public String getPer_read_hobby() {
        return this.per_read_hobby;
    }
    public void setPer_read_hobby(String per_read_hobby) {
        this.per_read_hobby = per_read_hobby;
    }
    public int getPer_read_time() {
        return this.per_read_time;
    }
    public void setPer_read_time(int per_read_time) {
        this.per_read_time = per_read_time;
    }
    public String getPer_tv_hobby() {
        return this.per_tv_hobby;
    }
    public void setPer_tv_hobby(String per_tv_hobby) {
        this.per_tv_hobby = per_tv_hobby;
    }
    public int getPer_tv_time() {
        return this.per_tv_time;
    }
    public void setPer_tv_time(int per_tv_time) {
        this.per_tv_time = per_tv_time;
    }
    public String getPer_like_idol() {
        return this.per_like_idol;
    }
    public void setPer_like_idol(String per_like_idol) {
        this.per_like_idol = per_like_idol;
    }
}
