package com.bob.flyboymvp.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.bob.flyboymvp.model.PerAddrInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PER_ADDR_INFO".
*/
public class PerAddrInfoDao extends AbstractDao<PerAddrInfo, Long> {

    public static final String TABLENAME = "PER_ADDR_INFO";

    /**
     * Properties of entity PerAddrInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Per_addr_list_id = new Property(1, int.class, "per_addr_list_id", false, "PER_ADDR_LIST_ID");
        public final static Property User_phone = new Property(2, String.class, "user_phone", false, "USER_PHONE");
        public final static Property Per_private = new Property(3, int.class, "per_private", false, "PER_PRIVATE");
        public final static Property User_guid = new Property(4, String.class, "user_guid", false, "USER_GUID");
        public final static Property Per_last_name = new Property(5, String.class, "per_last_name", false, "PER_LAST_NAME");
        public final static Property Per_first_name = new Property(6, String.class, "per_first_name", false, "PER_FIRST_NAME");
        public final static Property Per_full_name = new Property(7, String.class, "per_full_name", false, "PER_FULL_NAME");
        public final static Property Per_pinyin = new Property(8, String.class, "per_pinyin", false, "PER_PINYIN");
        public final static Property Per_allpinyin = new Property(9, String.class, "per_allpinyin", false, "PER_ALLPINYIN");
        public final static Property Per_english_name = new Property(10, String.class, "per_english_name", false, "PER_ENGLISH_NAME");
        public final static Property Per_portrait = new Property(11, String.class, "per_portrait", false, "PER_PORTRAIT");
        public final static Property Per_portrait_life = new Property(12, String.class, "per_portrait_life", false, "PER_PORTRAIT_LIFE");
        public final static Property Per_portrait_social = new Property(13, String.class, "per_portrait_social", false, "PER_PORTRAIT_SOCIAL");
        public final static Property Per_sex = new Property(14, int.class, "per_sex", false, "PER_SEX");
        public final static Property Per_nick_name = new Property(15, String.class, "per_nick_name", false, "PER_NICK_NAME");
        public final static Property Per_group = new Property(16, String.class, "per_group", false, "PER_GROUP");
        public final static Property Per_favorite = new Property(17, String.class, "per_favorite", false, "PER_FAVORITE");
        public final static Property Per_range = new Property(18, int.class, "per_range", false, "PER_RANGE");
        public final static Property Per_unit_name = new Property(19, String.class, "per_unit_name", false, "PER_UNIT_NAME");
        public final static Property Per_unit_english_name = new Property(20, String.class, "per_unit_english_name", false, "PER_UNIT_ENGLISH_NAME");
        public final static Property Per_unit_pinyin = new Property(21, String.class, "per_unit_pinyin", false, "PER_UNIT_PINYIN");
        public final static Property Per_unit_py_short = new Property(22, String.class, "per_unit_py_short", false, "PER_UNIT_PY_SHORT");
        public final static Property Per_unit_short_name = new Property(23, String.class, "per_unit_short_name", false, "PER_UNIT_SHORT_NAME");
        public final static Property Per_introducer = new Property(24, String.class, "per_introducer", false, "PER_INTRODUCER");
        public final static Property Per_scene = new Property(25, String.class, "per_scene", false, "PER_SCENE");
        public final static Property Per_industry = new Property(26, String.class, "per_industry", false, "PER_INDUSTRY");
        public final static Property Per_dept = new Property(27, String.class, "per_dept", false, "PER_DEPT");
        public final static Property Per_position = new Property(28, String.class, "per_position", false, "PER_POSITION");
        public final static Property Per_unit_log = new Property(29, String.class, "per_unit_log", false, "PER_UNIT_LOG");
        public final static Property Per_busi_info = new Property(30, String.class, "per_busi_info", false, "PER_BUSI_INFO");
        public final static Property Per_phone0 = new Property(31, String.class, "per_phone0", false, "PER_PHONE0");
        public final static Property Per_phone1 = new Property(32, String.class, "per_phone1", false, "PER_PHONE1");
        public final static Property Per_phone2 = new Property(33, String.class, "per_phone2", false, "PER_PHONE2");
        public final static Property Per_tel = new Property(34, String.class, "per_tel", false, "PER_TEL");
        public final static Property Per_home_tel = new Property(35, String.class, "per_home_tel", false, "PER_HOME_TEL");
        public final static Property Per_unit_tel = new Property(36, String.class, "per_unit_tel", false, "PER_UNIT_TEL");
        public final static Property Per_fax = new Property(37, String.class, "per_fax", false, "PER_FAX");
        public final static Property Per_email = new Property(38, String.class, "per_email", false, "PER_EMAIL");
        public final static Property Per_email2 = new Property(39, String.class, "per_email2", false, "PER_EMAIL2");
        public final static Property Per_qq = new Property(40, String.class, "per_qq", false, "PER_QQ");
        public final static Property Per_webchat = new Property(41, String.class, "per_webchat", false, "PER_WEBCHAT");
        public final static Property Per_web = new Property(42, String.class, "per_web", false, "PER_WEB");
        public final static Property Per_stage = new Property(43, String.class, "per_stage", false, "PER_STAGE");
        public final static Property Per_yellow_page = new Property(44, String.class, "per_yellow_page", false, "PER_YELLOW_PAGE");
        public final static Property Per_address = new Property(45, String.class, "per_address", false, "PER_ADDRESS");
        public final static Property Per_unit_address = new Property(46, String.class, "per_unit_address", false, "PER_UNIT_ADDRESS");
        public final static Property Per_other_url = new Property(47, String.class, "per_other_url", false, "PER_OTHER_URL");
        public final static Property Per_memo = new Property(48, String.class, "per_memo", false, "PER_MEMO");
        public final static Property Per_other_json = new Property(49, String.class, "per_other_json", false, "PER_OTHER_JSON");
        public final static Property Per_create_datetime = new Property(50, String.class, "per_create_datetime", false, "PER_CREATE_DATETIME");
    }


    public PerAddrInfoDao(DaoConfig config) {
        super(config);
    }
    
    public PerAddrInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PER_ADDR_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"PER_ADDR_LIST_ID\" INTEGER NOT NULL ," + // 1: per_addr_list_id
                "\"USER_PHONE\" TEXT," + // 2: user_phone
                "\"PER_PRIVATE\" INTEGER NOT NULL ," + // 3: per_private
                "\"USER_GUID\" TEXT," + // 4: user_guid
                "\"PER_LAST_NAME\" TEXT," + // 5: per_last_name
                "\"PER_FIRST_NAME\" TEXT," + // 6: per_first_name
                "\"PER_FULL_NAME\" TEXT," + // 7: per_full_name
                "\"PER_PINYIN\" TEXT," + // 8: per_pinyin
                "\"PER_ALLPINYIN\" TEXT," + // 9: per_allpinyin
                "\"PER_ENGLISH_NAME\" TEXT," + // 10: per_english_name
                "\"PER_PORTRAIT\" TEXT," + // 11: per_portrait
                "\"PER_PORTRAIT_LIFE\" TEXT," + // 12: per_portrait_life
                "\"PER_PORTRAIT_SOCIAL\" TEXT," + // 13: per_portrait_social
                "\"PER_SEX\" INTEGER NOT NULL ," + // 14: per_sex
                "\"PER_NICK_NAME\" TEXT," + // 15: per_nick_name
                "\"PER_GROUP\" TEXT," + // 16: per_group
                "\"PER_FAVORITE\" TEXT," + // 17: per_favorite
                "\"PER_RANGE\" INTEGER NOT NULL ," + // 18: per_range
                "\"PER_UNIT_NAME\" TEXT," + // 19: per_unit_name
                "\"PER_UNIT_ENGLISH_NAME\" TEXT," + // 20: per_unit_english_name
                "\"PER_UNIT_PINYIN\" TEXT," + // 21: per_unit_pinyin
                "\"PER_UNIT_PY_SHORT\" TEXT," + // 22: per_unit_py_short
                "\"PER_UNIT_SHORT_NAME\" TEXT," + // 23: per_unit_short_name
                "\"PER_INTRODUCER\" TEXT," + // 24: per_introducer
                "\"PER_SCENE\" TEXT," + // 25: per_scene
                "\"PER_INDUSTRY\" TEXT," + // 26: per_industry
                "\"PER_DEPT\" TEXT," + // 27: per_dept
                "\"PER_POSITION\" TEXT," + // 28: per_position
                "\"PER_UNIT_LOG\" TEXT," + // 29: per_unit_log
                "\"PER_BUSI_INFO\" TEXT," + // 30: per_busi_info
                "\"PER_PHONE0\" TEXT," + // 31: per_phone0
                "\"PER_PHONE1\" TEXT," + // 32: per_phone1
                "\"PER_PHONE2\" TEXT," + // 33: per_phone2
                "\"PER_TEL\" TEXT," + // 34: per_tel
                "\"PER_HOME_TEL\" TEXT," + // 35: per_home_tel
                "\"PER_UNIT_TEL\" TEXT," + // 36: per_unit_tel
                "\"PER_FAX\" TEXT," + // 37: per_fax
                "\"PER_EMAIL\" TEXT," + // 38: per_email
                "\"PER_EMAIL2\" TEXT," + // 39: per_email2
                "\"PER_QQ\" TEXT," + // 40: per_qq
                "\"PER_WEBCHAT\" TEXT," + // 41: per_webchat
                "\"PER_WEB\" TEXT," + // 42: per_web
                "\"PER_STAGE\" TEXT," + // 43: per_stage
                "\"PER_YELLOW_PAGE\" TEXT," + // 44: per_yellow_page
                "\"PER_ADDRESS\" TEXT," + // 45: per_address
                "\"PER_UNIT_ADDRESS\" TEXT," + // 46: per_unit_address
                "\"PER_OTHER_URL\" TEXT," + // 47: per_other_url
                "\"PER_MEMO\" TEXT," + // 48: per_memo
                "\"PER_OTHER_JSON\" TEXT," + // 49: per_other_json
                "\"PER_CREATE_DATETIME\" TEXT);"); // 50: per_create_datetime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PER_ADDR_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PerAddrInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getPer_addr_list_id());
 
        String user_phone = entity.getUser_phone();
        if (user_phone != null) {
            stmt.bindString(3, user_phone);
        }
        stmt.bindLong(4, entity.getPer_private());
 
        String user_guid = entity.getUser_guid();
        if (user_guid != null) {
            stmt.bindString(5, user_guid);
        }
 
        String per_last_name = entity.getPer_last_name();
        if (per_last_name != null) {
            stmt.bindString(6, per_last_name);
        }
 
        String per_first_name = entity.getPer_first_name();
        if (per_first_name != null) {
            stmt.bindString(7, per_first_name);
        }
 
        String per_full_name = entity.getPer_full_name();
        if (per_full_name != null) {
            stmt.bindString(8, per_full_name);
        }
 
        String per_pinyin = entity.getPer_pinyin();
        if (per_pinyin != null) {
            stmt.bindString(9, per_pinyin);
        }
 
        String per_allpinyin = entity.getPer_allpinyin();
        if (per_allpinyin != null) {
            stmt.bindString(10, per_allpinyin);
        }
 
        String per_english_name = entity.getPer_english_name();
        if (per_english_name != null) {
            stmt.bindString(11, per_english_name);
        }
 
        String per_portrait = entity.getPer_portrait();
        if (per_portrait != null) {
            stmt.bindString(12, per_portrait);
        }
 
        String per_portrait_life = entity.getPer_portrait_life();
        if (per_portrait_life != null) {
            stmt.bindString(13, per_portrait_life);
        }
 
        String per_portrait_social = entity.getPer_portrait_social();
        if (per_portrait_social != null) {
            stmt.bindString(14, per_portrait_social);
        }
        stmt.bindLong(15, entity.getPer_sex());
 
        String per_nick_name = entity.getPer_nick_name();
        if (per_nick_name != null) {
            stmt.bindString(16, per_nick_name);
        }
 
        String per_group = entity.getPer_group();
        if (per_group != null) {
            stmt.bindString(17, per_group);
        }
 
        String per_favorite = entity.getPer_favorite();
        if (per_favorite != null) {
            stmt.bindString(18, per_favorite);
        }
        stmt.bindLong(19, entity.getPer_range());
 
        String per_unit_name = entity.getPer_unit_name();
        if (per_unit_name != null) {
            stmt.bindString(20, per_unit_name);
        }
 
        String per_unit_english_name = entity.getPer_unit_english_name();
        if (per_unit_english_name != null) {
            stmt.bindString(21, per_unit_english_name);
        }
 
        String per_unit_pinyin = entity.getPer_unit_pinyin();
        if (per_unit_pinyin != null) {
            stmt.bindString(22, per_unit_pinyin);
        }
 
        String per_unit_py_short = entity.getPer_unit_py_short();
        if (per_unit_py_short != null) {
            stmt.bindString(23, per_unit_py_short);
        }
 
        String per_unit_short_name = entity.getPer_unit_short_name();
        if (per_unit_short_name != null) {
            stmt.bindString(24, per_unit_short_name);
        }
 
        String per_introducer = entity.getPer_introducer();
        if (per_introducer != null) {
            stmt.bindString(25, per_introducer);
        }
 
        String per_scene = entity.getPer_scene();
        if (per_scene != null) {
            stmt.bindString(26, per_scene);
        }
 
        String per_industry = entity.getPer_industry();
        if (per_industry != null) {
            stmt.bindString(27, per_industry);
        }
 
        String per_dept = entity.getPer_dept();
        if (per_dept != null) {
            stmt.bindString(28, per_dept);
        }
 
        String per_position = entity.getPer_position();
        if (per_position != null) {
            stmt.bindString(29, per_position);
        }
 
        String per_unit_log = entity.getPer_unit_log();
        if (per_unit_log != null) {
            stmt.bindString(30, per_unit_log);
        }
 
        String per_busi_info = entity.getPer_busi_info();
        if (per_busi_info != null) {
            stmt.bindString(31, per_busi_info);
        }
 
        String per_phone0 = entity.getPer_phone0();
        if (per_phone0 != null) {
            stmt.bindString(32, per_phone0);
        }
 
        String per_phone1 = entity.getPer_phone1();
        if (per_phone1 != null) {
            stmt.bindString(33, per_phone1);
        }
 
        String per_phone2 = entity.getPer_phone2();
        if (per_phone2 != null) {
            stmt.bindString(34, per_phone2);
        }
 
        String per_tel = entity.getPer_tel();
        if (per_tel != null) {
            stmt.bindString(35, per_tel);
        }
 
        String per_home_tel = entity.getPer_home_tel();
        if (per_home_tel != null) {
            stmt.bindString(36, per_home_tel);
        }
 
        String per_unit_tel = entity.getPer_unit_tel();
        if (per_unit_tel != null) {
            stmt.bindString(37, per_unit_tel);
        }
 
        String per_fax = entity.getPer_fax();
        if (per_fax != null) {
            stmt.bindString(38, per_fax);
        }
 
        String per_email = entity.getPer_email();
        if (per_email != null) {
            stmt.bindString(39, per_email);
        }
 
        String per_email2 = entity.getPer_email2();
        if (per_email2 != null) {
            stmt.bindString(40, per_email2);
        }
 
        String per_qq = entity.getPer_qq();
        if (per_qq != null) {
            stmt.bindString(41, per_qq);
        }
 
        String per_webchat = entity.getPer_webchat();
        if (per_webchat != null) {
            stmt.bindString(42, per_webchat);
        }
 
        String per_web = entity.getPer_web();
        if (per_web != null) {
            stmt.bindString(43, per_web);
        }
 
        String per_stage = entity.getPer_stage();
        if (per_stage != null) {
            stmt.bindString(44, per_stage);
        }
 
        String per_yellow_page = entity.getPer_yellow_page();
        if (per_yellow_page != null) {
            stmt.bindString(45, per_yellow_page);
        }
 
        String per_address = entity.getPer_address();
        if (per_address != null) {
            stmt.bindString(46, per_address);
        }
 
        String per_unit_address = entity.getPer_unit_address();
        if (per_unit_address != null) {
            stmt.bindString(47, per_unit_address);
        }
 
        String per_other_url = entity.getPer_other_url();
        if (per_other_url != null) {
            stmt.bindString(48, per_other_url);
        }
 
        String per_memo = entity.getPer_memo();
        if (per_memo != null) {
            stmt.bindString(49, per_memo);
        }
 
        String per_other_json = entity.getPer_other_json();
        if (per_other_json != null) {
            stmt.bindString(50, per_other_json);
        }
 
        String per_create_datetime = entity.getPer_create_datetime();
        if (per_create_datetime != null) {
            stmt.bindString(51, per_create_datetime);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PerAddrInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getPer_addr_list_id());
 
        String user_phone = entity.getUser_phone();
        if (user_phone != null) {
            stmt.bindString(3, user_phone);
        }
        stmt.bindLong(4, entity.getPer_private());
 
        String user_guid = entity.getUser_guid();
        if (user_guid != null) {
            stmt.bindString(5, user_guid);
        }
 
        String per_last_name = entity.getPer_last_name();
        if (per_last_name != null) {
            stmt.bindString(6, per_last_name);
        }
 
        String per_first_name = entity.getPer_first_name();
        if (per_first_name != null) {
            stmt.bindString(7, per_first_name);
        }
 
        String per_full_name = entity.getPer_full_name();
        if (per_full_name != null) {
            stmt.bindString(8, per_full_name);
        }
 
        String per_pinyin = entity.getPer_pinyin();
        if (per_pinyin != null) {
            stmt.bindString(9, per_pinyin);
        }
 
        String per_allpinyin = entity.getPer_allpinyin();
        if (per_allpinyin != null) {
            stmt.bindString(10, per_allpinyin);
        }
 
        String per_english_name = entity.getPer_english_name();
        if (per_english_name != null) {
            stmt.bindString(11, per_english_name);
        }
 
        String per_portrait = entity.getPer_portrait();
        if (per_portrait != null) {
            stmt.bindString(12, per_portrait);
        }
 
        String per_portrait_life = entity.getPer_portrait_life();
        if (per_portrait_life != null) {
            stmt.bindString(13, per_portrait_life);
        }
 
        String per_portrait_social = entity.getPer_portrait_social();
        if (per_portrait_social != null) {
            stmt.bindString(14, per_portrait_social);
        }
        stmt.bindLong(15, entity.getPer_sex());
 
        String per_nick_name = entity.getPer_nick_name();
        if (per_nick_name != null) {
            stmt.bindString(16, per_nick_name);
        }
 
        String per_group = entity.getPer_group();
        if (per_group != null) {
            stmt.bindString(17, per_group);
        }
 
        String per_favorite = entity.getPer_favorite();
        if (per_favorite != null) {
            stmt.bindString(18, per_favorite);
        }
        stmt.bindLong(19, entity.getPer_range());
 
        String per_unit_name = entity.getPer_unit_name();
        if (per_unit_name != null) {
            stmt.bindString(20, per_unit_name);
        }
 
        String per_unit_english_name = entity.getPer_unit_english_name();
        if (per_unit_english_name != null) {
            stmt.bindString(21, per_unit_english_name);
        }
 
        String per_unit_pinyin = entity.getPer_unit_pinyin();
        if (per_unit_pinyin != null) {
            stmt.bindString(22, per_unit_pinyin);
        }
 
        String per_unit_py_short = entity.getPer_unit_py_short();
        if (per_unit_py_short != null) {
            stmt.bindString(23, per_unit_py_short);
        }
 
        String per_unit_short_name = entity.getPer_unit_short_name();
        if (per_unit_short_name != null) {
            stmt.bindString(24, per_unit_short_name);
        }
 
        String per_introducer = entity.getPer_introducer();
        if (per_introducer != null) {
            stmt.bindString(25, per_introducer);
        }
 
        String per_scene = entity.getPer_scene();
        if (per_scene != null) {
            stmt.bindString(26, per_scene);
        }
 
        String per_industry = entity.getPer_industry();
        if (per_industry != null) {
            stmt.bindString(27, per_industry);
        }
 
        String per_dept = entity.getPer_dept();
        if (per_dept != null) {
            stmt.bindString(28, per_dept);
        }
 
        String per_position = entity.getPer_position();
        if (per_position != null) {
            stmt.bindString(29, per_position);
        }
 
        String per_unit_log = entity.getPer_unit_log();
        if (per_unit_log != null) {
            stmt.bindString(30, per_unit_log);
        }
 
        String per_busi_info = entity.getPer_busi_info();
        if (per_busi_info != null) {
            stmt.bindString(31, per_busi_info);
        }
 
        String per_phone0 = entity.getPer_phone0();
        if (per_phone0 != null) {
            stmt.bindString(32, per_phone0);
        }
 
        String per_phone1 = entity.getPer_phone1();
        if (per_phone1 != null) {
            stmt.bindString(33, per_phone1);
        }
 
        String per_phone2 = entity.getPer_phone2();
        if (per_phone2 != null) {
            stmt.bindString(34, per_phone2);
        }
 
        String per_tel = entity.getPer_tel();
        if (per_tel != null) {
            stmt.bindString(35, per_tel);
        }
 
        String per_home_tel = entity.getPer_home_tel();
        if (per_home_tel != null) {
            stmt.bindString(36, per_home_tel);
        }
 
        String per_unit_tel = entity.getPer_unit_tel();
        if (per_unit_tel != null) {
            stmt.bindString(37, per_unit_tel);
        }
 
        String per_fax = entity.getPer_fax();
        if (per_fax != null) {
            stmt.bindString(38, per_fax);
        }
 
        String per_email = entity.getPer_email();
        if (per_email != null) {
            stmt.bindString(39, per_email);
        }
 
        String per_email2 = entity.getPer_email2();
        if (per_email2 != null) {
            stmt.bindString(40, per_email2);
        }
 
        String per_qq = entity.getPer_qq();
        if (per_qq != null) {
            stmt.bindString(41, per_qq);
        }
 
        String per_webchat = entity.getPer_webchat();
        if (per_webchat != null) {
            stmt.bindString(42, per_webchat);
        }
 
        String per_web = entity.getPer_web();
        if (per_web != null) {
            stmt.bindString(43, per_web);
        }
 
        String per_stage = entity.getPer_stage();
        if (per_stage != null) {
            stmt.bindString(44, per_stage);
        }
 
        String per_yellow_page = entity.getPer_yellow_page();
        if (per_yellow_page != null) {
            stmt.bindString(45, per_yellow_page);
        }
 
        String per_address = entity.getPer_address();
        if (per_address != null) {
            stmt.bindString(46, per_address);
        }
 
        String per_unit_address = entity.getPer_unit_address();
        if (per_unit_address != null) {
            stmt.bindString(47, per_unit_address);
        }
 
        String per_other_url = entity.getPer_other_url();
        if (per_other_url != null) {
            stmt.bindString(48, per_other_url);
        }
 
        String per_memo = entity.getPer_memo();
        if (per_memo != null) {
            stmt.bindString(49, per_memo);
        }
 
        String per_other_json = entity.getPer_other_json();
        if (per_other_json != null) {
            stmt.bindString(50, per_other_json);
        }
 
        String per_create_datetime = entity.getPer_create_datetime();
        if (per_create_datetime != null) {
            stmt.bindString(51, per_create_datetime);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public PerAddrInfo readEntity(Cursor cursor, int offset) {
        PerAddrInfo entity = new PerAddrInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // per_addr_list_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // user_phone
            cursor.getInt(offset + 3), // per_private
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // user_guid
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // per_last_name
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // per_first_name
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // per_full_name
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // per_pinyin
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // per_allpinyin
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // per_english_name
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // per_portrait
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // per_portrait_life
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // per_portrait_social
            cursor.getInt(offset + 14), // per_sex
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // per_nick_name
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // per_group
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // per_favorite
            cursor.getInt(offset + 18), // per_range
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // per_unit_name
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // per_unit_english_name
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // per_unit_pinyin
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // per_unit_py_short
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // per_unit_short_name
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // per_introducer
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // per_scene
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26), // per_industry
            cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27), // per_dept
            cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28), // per_position
            cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29), // per_unit_log
            cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30), // per_busi_info
            cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31), // per_phone0
            cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32), // per_phone1
            cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33), // per_phone2
            cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34), // per_tel
            cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35), // per_home_tel
            cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36), // per_unit_tel
            cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37), // per_fax
            cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38), // per_email
            cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39), // per_email2
            cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40), // per_qq
            cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41), // per_webchat
            cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42), // per_web
            cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43), // per_stage
            cursor.isNull(offset + 44) ? null : cursor.getString(offset + 44), // per_yellow_page
            cursor.isNull(offset + 45) ? null : cursor.getString(offset + 45), // per_address
            cursor.isNull(offset + 46) ? null : cursor.getString(offset + 46), // per_unit_address
            cursor.isNull(offset + 47) ? null : cursor.getString(offset + 47), // per_other_url
            cursor.isNull(offset + 48) ? null : cursor.getString(offset + 48), // per_memo
            cursor.isNull(offset + 49) ? null : cursor.getString(offset + 49), // per_other_json
            cursor.isNull(offset + 50) ? null : cursor.getString(offset + 50) // per_create_datetime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PerAddrInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setPer_addr_list_id(cursor.getInt(offset + 1));
        entity.setUser_phone(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPer_private(cursor.getInt(offset + 3));
        entity.setUser_guid(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPer_last_name(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setPer_first_name(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setPer_full_name(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setPer_pinyin(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPer_allpinyin(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPer_english_name(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setPer_portrait(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPer_portrait_life(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setPer_portrait_social(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setPer_sex(cursor.getInt(offset + 14));
        entity.setPer_nick_name(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setPer_group(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setPer_favorite(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setPer_range(cursor.getInt(offset + 18));
        entity.setPer_unit_name(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setPer_unit_english_name(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setPer_unit_pinyin(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setPer_unit_py_short(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setPer_unit_short_name(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setPer_introducer(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setPer_scene(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setPer_industry(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
        entity.setPer_dept(cursor.isNull(offset + 27) ? null : cursor.getString(offset + 27));
        entity.setPer_position(cursor.isNull(offset + 28) ? null : cursor.getString(offset + 28));
        entity.setPer_unit_log(cursor.isNull(offset + 29) ? null : cursor.getString(offset + 29));
        entity.setPer_busi_info(cursor.isNull(offset + 30) ? null : cursor.getString(offset + 30));
        entity.setPer_phone0(cursor.isNull(offset + 31) ? null : cursor.getString(offset + 31));
        entity.setPer_phone1(cursor.isNull(offset + 32) ? null : cursor.getString(offset + 32));
        entity.setPer_phone2(cursor.isNull(offset + 33) ? null : cursor.getString(offset + 33));
        entity.setPer_tel(cursor.isNull(offset + 34) ? null : cursor.getString(offset + 34));
        entity.setPer_home_tel(cursor.isNull(offset + 35) ? null : cursor.getString(offset + 35));
        entity.setPer_unit_tel(cursor.isNull(offset + 36) ? null : cursor.getString(offset + 36));
        entity.setPer_fax(cursor.isNull(offset + 37) ? null : cursor.getString(offset + 37));
        entity.setPer_email(cursor.isNull(offset + 38) ? null : cursor.getString(offset + 38));
        entity.setPer_email2(cursor.isNull(offset + 39) ? null : cursor.getString(offset + 39));
        entity.setPer_qq(cursor.isNull(offset + 40) ? null : cursor.getString(offset + 40));
        entity.setPer_webchat(cursor.isNull(offset + 41) ? null : cursor.getString(offset + 41));
        entity.setPer_web(cursor.isNull(offset + 42) ? null : cursor.getString(offset + 42));
        entity.setPer_stage(cursor.isNull(offset + 43) ? null : cursor.getString(offset + 43));
        entity.setPer_yellow_page(cursor.isNull(offset + 44) ? null : cursor.getString(offset + 44));
        entity.setPer_address(cursor.isNull(offset + 45) ? null : cursor.getString(offset + 45));
        entity.setPer_unit_address(cursor.isNull(offset + 46) ? null : cursor.getString(offset + 46));
        entity.setPer_other_url(cursor.isNull(offset + 47) ? null : cursor.getString(offset + 47));
        entity.setPer_memo(cursor.isNull(offset + 48) ? null : cursor.getString(offset + 48));
        entity.setPer_other_json(cursor.isNull(offset + 49) ? null : cursor.getString(offset + 49));
        entity.setPer_create_datetime(cursor.isNull(offset + 50) ? null : cursor.getString(offset + 50));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(PerAddrInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(PerAddrInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PerAddrInfo entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
