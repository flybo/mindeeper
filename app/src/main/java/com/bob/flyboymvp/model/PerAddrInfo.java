package com.bob.flyboymvp.model;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 人脉主表信息
 * Created by Administrator on 2018/6/15.
 */
@Entity
public class PerAddrInfo {
    @Id(autoincrement = true)  //指明id
    private Long id;
    private int per_addr_list_id;//同步成功成功后服务端返回id，用来修改
    private transient int per_expeducation_id;//人脉教育经历id,同步时用 == 在对象对应字段前面加transient，表示该字段不用序列化，即在生成json的时候就不会包含该字段了。
    private transient int per_expjob_id;//人脉工作经历id,同步时用
    private transient int per_expother_id;//人脉其他经历id,同步时用
    private String user_phone = "";//用户帐号
    private int per_private;//标记 0：人脉，1：自己
    private String user_guid = "";
    private String per_last_name = "";
    private String per_first_name = "";
    private String per_full_name = "";
    private String per_pinyin = "";
    private String per_allpinyin = "";
    private String per_english_name = "";
    private String per_portrait = "";
    private String per_portrait_life = "";//生活图像
    private String per_portrait_social = "";//社交图像
    private int per_sex;
    private String per_nick_name = "";
    private String per_group = "";
    private String per_favorite = "";
    private int per_range;
    private String per_unit_name = "";
    private String per_unit_english_name = "";
    private String per_unit_pinyin = "";
    private String per_unit_py_short = "";//公司简拼，排序用
    private String per_unit_short_name = "";//公司简称
    private String per_introducer = "";//介绍人
    private String per_scene = "";//认识途径
    private String per_industry = "";
    private String per_dept = "";
    private String per_position = "";
    private String per_unit_log = "";
    private String per_busi_info = "";
    private String per_phone0 = "";
    private String per_phone1 = "";
    private String per_phone2 = "";
    private String per_tel = "";
    private String per_home_tel = "";
    private String per_unit_tel = "";
    private String per_fax = "";
    private String per_email = "";
    private String per_email2 = "";
    private String per_qq = "";
    private String per_webchat = "";
    private String per_web = "";
    private String per_stage = "";//驿站地址
    private String per_yellow_page = "";//黄页
    private String per_address = "";
    private String per_unit_address = "";
    private String per_other_url = "";
    private String per_memo = "";
    private String per_other_json = "";
    private String per_create_datetime = "";
    @Generated(hash = 1223104273)
    public PerAddrInfo(Long id, int per_addr_list_id, String user_phone, int per_private, String user_guid,
            String per_last_name, String per_first_name, String per_full_name, String per_pinyin, String per_allpinyin,
            String per_english_name, String per_portrait, String per_portrait_life, String per_portrait_social, int per_sex,
            String per_nick_name, String per_group, String per_favorite, int per_range, String per_unit_name,
            String per_unit_english_name, String per_unit_pinyin, String per_unit_py_short, String per_unit_short_name,
            String per_introducer, String per_scene, String per_industry, String per_dept, String per_position,
            String per_unit_log, String per_busi_info, String per_phone0, String per_phone1, String per_phone2,
            String per_tel, String per_home_tel, String per_unit_tel, String per_fax, String per_email, String per_email2,
            String per_qq, String per_webchat, String per_web, String per_stage, String per_yellow_page, String per_address,
            String per_unit_address, String per_other_url, String per_memo, String per_other_json,
            String per_create_datetime) {
        this.id = id;
        this.per_addr_list_id = per_addr_list_id;
        this.user_phone = user_phone;
        this.per_private = per_private;
        this.user_guid = user_guid;
        this.per_last_name = per_last_name;
        this.per_first_name = per_first_name;
        this.per_full_name = per_full_name;
        this.per_pinyin = per_pinyin;
        this.per_allpinyin = per_allpinyin;
        this.per_english_name = per_english_name;
        this.per_portrait = per_portrait;
        this.per_portrait_life = per_portrait_life;
        this.per_portrait_social = per_portrait_social;
        this.per_sex = per_sex;
        this.per_nick_name = per_nick_name;
        this.per_group = per_group;
        this.per_favorite = per_favorite;
        this.per_range = per_range;
        this.per_unit_name = per_unit_name;
        this.per_unit_english_name = per_unit_english_name;
        this.per_unit_pinyin = per_unit_pinyin;
        this.per_unit_py_short = per_unit_py_short;
        this.per_unit_short_name = per_unit_short_name;
        this.per_introducer = per_introducer;
        this.per_scene = per_scene;
        this.per_industry = per_industry;
        this.per_dept = per_dept;
        this.per_position = per_position;
        this.per_unit_log = per_unit_log;
        this.per_busi_info = per_busi_info;
        this.per_phone0 = per_phone0;
        this.per_phone1 = per_phone1;
        this.per_phone2 = per_phone2;
        this.per_tel = per_tel;
        this.per_home_tel = per_home_tel;
        this.per_unit_tel = per_unit_tel;
        this.per_fax = per_fax;
        this.per_email = per_email;
        this.per_email2 = per_email2;
        this.per_qq = per_qq;
        this.per_webchat = per_webchat;
        this.per_web = per_web;
        this.per_stage = per_stage;
        this.per_yellow_page = per_yellow_page;
        this.per_address = per_address;
        this.per_unit_address = per_unit_address;
        this.per_other_url = per_other_url;
        this.per_memo = per_memo;
        this.per_other_json = per_other_json;
        this.per_create_datetime = per_create_datetime;
    }
    @Generated(hash = 467657858)
    public PerAddrInfo() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getPer_addr_list_id() {
        return this.per_addr_list_id;
    }
    public void setPer_addr_list_id(int per_addr_list_id) {
        this.per_addr_list_id = per_addr_list_id;
    }
    public int getPer_expeducation_id() {
        return this.per_expeducation_id;
    }
    public void setPer_expeducation_id(int per_expeducation_id) {
        this.per_expeducation_id = per_expeducation_id;
    }
    public int getPer_expjob_id() {
        return this.per_expjob_id;
    }
    public void setPer_expjob_id(int per_expjob_id) {
        this.per_expjob_id = per_expjob_id;
    }
    public int getPer_expother_id() {
        return this.per_expother_id;
    }
    public void setPer_expother_id(int per_expother_id) {
        this.per_expother_id = per_expother_id;
    }
    public String getUser_phone() {
        return this.user_phone;
    }
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
    public int getPer_private() {
        return this.per_private;
    }
    public void setPer_private(int per_private) {
        this.per_private = per_private;
    }
    public String getUser_guid() {
        return this.user_guid;
    }
    public void setUser_guid(String user_guid) {
        this.user_guid = user_guid;
    }
    public String getPer_last_name() {
        return this.per_last_name;
    }
    public void setPer_last_name(String per_last_name) {
        this.per_last_name = per_last_name;
    }
    public String getPer_first_name() {
        return this.per_first_name;
    }
    public void setPer_first_name(String per_first_name) {
        this.per_first_name = per_first_name;
    }
    public String getPer_full_name() {
        return this.per_full_name;
    }
    public void setPer_full_name(String per_full_name) {
        this.per_full_name = per_full_name;
    }
    public String getPer_pinyin() {
        return this.per_pinyin;
    }
    public void setPer_pinyin(String per_pinyin) {
        this.per_pinyin = per_pinyin;
    }
    public String getPer_allpinyin() {
        return this.per_allpinyin;
    }
    public void setPer_allpinyin(String per_allpinyin) {
        this.per_allpinyin = per_allpinyin;
    }
    public String getPer_english_name() {
        return this.per_english_name;
    }
    public void setPer_english_name(String per_english_name) {
        this.per_english_name = per_english_name;
    }
    public String getPer_portrait() {
        return this.per_portrait;
    }
    public void setPer_portrait(String per_portrait) {
        this.per_portrait = per_portrait;
    }
    public String getPer_portrait_life() {
        return this.per_portrait_life;
    }
    public void setPer_portrait_life(String per_portrait_life) {
        this.per_portrait_life = per_portrait_life;
    }
    public String getPer_portrait_social() {
        return this.per_portrait_social;
    }
    public void setPer_portrait_social(String per_portrait_social) {
        this.per_portrait_social = per_portrait_social;
    }
    public int getPer_sex() {
        return this.per_sex;
    }
    public void setPer_sex(int per_sex) {
        this.per_sex = per_sex;
    }
    public String getPer_nick_name() {
        return this.per_nick_name;
    }
    public void setPer_nick_name(String per_nick_name) {
        this.per_nick_name = per_nick_name;
    }
    public String getPer_group() {
        return this.per_group;
    }
    public void setPer_group(String per_group) {
        this.per_group = per_group;
    }
    public String getPer_favorite() {
        return this.per_favorite;
    }
    public void setPer_favorite(String per_favorite) {
        this.per_favorite = per_favorite;
    }
    public int getPer_range() {
        return this.per_range;
    }
    public void setPer_range(int per_range) {
        this.per_range = per_range;
    }
    public String getPer_unit_name() {
        return this.per_unit_name;
    }
    public void setPer_unit_name(String per_unit_name) {
        this.per_unit_name = per_unit_name;
    }
    public String getPer_unit_english_name() {
        return this.per_unit_english_name;
    }
    public void setPer_unit_english_name(String per_unit_english_name) {
        this.per_unit_english_name = per_unit_english_name;
    }
    public String getPer_unit_pinyin() {
        return this.per_unit_pinyin;
    }
    public void setPer_unit_pinyin(String per_unit_pinyin) {
        this.per_unit_pinyin = per_unit_pinyin;
    }
    public String getPer_unit_py_short() {
        return this.per_unit_py_short;
    }
    public void setPer_unit_py_short(String per_unit_py_short) {
        this.per_unit_py_short = per_unit_py_short;
    }
    public String getPer_unit_short_name() {
        return this.per_unit_short_name;
    }
    public void setPer_unit_short_name(String per_unit_short_name) {
        this.per_unit_short_name = per_unit_short_name;
    }
    public String getPer_introducer() {
        return this.per_introducer;
    }
    public void setPer_introducer(String per_introducer) {
        this.per_introducer = per_introducer;
    }
    public String getPer_scene() {
        return this.per_scene;
    }
    public void setPer_scene(String per_scene) {
        this.per_scene = per_scene;
    }
    public String getPer_industry() {
        return this.per_industry;
    }
    public void setPer_industry(String per_industry) {
        this.per_industry = per_industry;
    }
    public String getPer_dept() {
        return this.per_dept;
    }
    public void setPer_dept(String per_dept) {
        this.per_dept = per_dept;
    }
    public String getPer_position() {
        return this.per_position;
    }
    public void setPer_position(String per_position) {
        this.per_position = per_position;
    }
    public String getPer_unit_log() {
        return this.per_unit_log;
    }
    public void setPer_unit_log(String per_unit_log) {
        this.per_unit_log = per_unit_log;
    }
    public String getPer_busi_info() {
        return this.per_busi_info;
    }
    public void setPer_busi_info(String per_busi_info) {
        this.per_busi_info = per_busi_info;
    }
    public String getPer_phone0() {
        return this.per_phone0;
    }
    public void setPer_phone0(String per_phone0) {
        this.per_phone0 = per_phone0;
    }
    public String getPer_phone1() {
        return this.per_phone1;
    }
    public void setPer_phone1(String per_phone1) {
        this.per_phone1 = per_phone1;
    }
    public String getPer_phone2() {
        return this.per_phone2;
    }
    public void setPer_phone2(String per_phone2) {
        this.per_phone2 = per_phone2;
    }
    public String getPer_tel() {
        return this.per_tel;
    }
    public void setPer_tel(String per_tel) {
        this.per_tel = per_tel;
    }
    public String getPer_home_tel() {
        return this.per_home_tel;
    }
    public void setPer_home_tel(String per_home_tel) {
        this.per_home_tel = per_home_tel;
    }
    public String getPer_unit_tel() {
        return this.per_unit_tel;
    }
    public void setPer_unit_tel(String per_unit_tel) {
        this.per_unit_tel = per_unit_tel;
    }
    public String getPer_fax() {
        return this.per_fax;
    }
    public void setPer_fax(String per_fax) {
        this.per_fax = per_fax;
    }
    public String getPer_email() {
        return this.per_email;
    }
    public void setPer_email(String per_email) {
        this.per_email = per_email;
    }
    public String getPer_email2() {
        return this.per_email2;
    }
    public void setPer_email2(String per_email2) {
        this.per_email2 = per_email2;
    }
    public String getPer_qq() {
        return this.per_qq;
    }
    public void setPer_qq(String per_qq) {
        this.per_qq = per_qq;
    }
    public String getPer_webchat() {
        return this.per_webchat;
    }
    public void setPer_webchat(String per_webchat) {
        this.per_webchat = per_webchat;
    }
    public String getPer_web() {
        return this.per_web;
    }
    public void setPer_web(String per_web) {
        this.per_web = per_web;
    }
    public String getPer_stage() {
        return this.per_stage;
    }
    public void setPer_stage(String per_stage) {
        this.per_stage = per_stage;
    }
    public String getPer_yellow_page() {
        return this.per_yellow_page;
    }
    public void setPer_yellow_page(String per_yellow_page) {
        this.per_yellow_page = per_yellow_page;
    }
    public String getPer_address() {
        return this.per_address;
    }
    public void setPer_address(String per_address) {
        this.per_address = per_address;
    }
    public String getPer_unit_address() {
        return this.per_unit_address;
    }
    public void setPer_unit_address(String per_unit_address) {
        this.per_unit_address = per_unit_address;
    }
    public String getPer_other_url() {
        return this.per_other_url;
    }
    public void setPer_other_url(String per_other_url) {
        this.per_other_url = per_other_url;
    }
    public String getPer_memo() {
        return this.per_memo;
    }
    public void setPer_memo(String per_memo) {
        this.per_memo = per_memo;
    }
    public String getPer_other_json() {
        return this.per_other_json;
    }
    public void setPer_other_json(String per_other_json) {
        this.per_other_json = per_other_json;
    }
    public String getPer_create_datetime() {
        return this.per_create_datetime;
    }
    public void setPer_create_datetime(String per_create_datetime) {
        this.per_create_datetime = per_create_datetime;
    }
}
