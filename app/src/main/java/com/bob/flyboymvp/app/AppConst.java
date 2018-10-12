package com.bob.flyboymvp.app;

import com.bob.flyboymvp.util.FileUtils;
import com.bob.flyboymvp.util.LogUtils;

/**
 * @创建者 CSDN_LQR
 * @描述 全局常量类
 */
public class AppConst {

    public static final String TAG = "CSDN_LQR";
    public static final int DEBUGLEVEL = LogUtils.LEVEL_ALL;//日志输出级别

    public static final String REGION = "86";
    public static final String DEFAULT_BG_COLOR="#039EA1";

    /*================== 广播Action begin ==================*/

    public static final class Broadcast{

        public static final String SKIN_BG_SET="set_skin_bg";//皮肤颜色修改
        public static final String FULL_SCREEN="full_screen";//是否全屏
    }

    /*================== 广播Action end ==================*/

    //用户图像路径
    public static String pathUserImg="http://121.43.233.185/mavenwitlinkweb/source/images/userimg/";

    public static final class User {
        public static final String ID = "id";
        public static final String PHONE = "phone";
        public static final String TOKEN = "token";
        public static final String COLOR_MAIN="color_main";//主要皮肤色
        public static final String COLOR_LESS="color_less";//次要皮肤色
        public static final String FULL_SCREEN="full_screen";//全屏
        public static final String HAND_WHAT="hand_what";//左右手
        public static final String USER_GUID="user_guid";
        public static final String USER_TYPE="user_type";
        public static final String USER_POWER="user_power";

    }

    public static final class MainSP{
        public static final String GUID="guid";
        public static final String USER_PHONE="user_phone";
        public static final String USER_PWD="user_pwd";
    }


    public static final class WeChatUrl {
        public static final String HELP_FEED_BACK = "https://kf.qq.com/touch/product/wechat_app.html?scene_id=kf338&code=001ls8gj1IuCnz0kiUfj15uIfj1ls8ga&state=123";
        public static final String JD = "https://m.jd.com/";
        public static final String GAME = "http://h.4399.com/android/?301";
        public static final String MY_JIAN_SHU = "http://www.jianshu.com/u/f9de259236a3";
        public static final String MY_CSDN = "http://blog.csdn.net/csdn_lqr";
        public static final String MY_OSCHINA = "https://git.oschina.net/CSDNLQR";
        public static final String MY_GITHUB = "https://github.com/GitLqr";
    }

    public static final class QrCodeCommon {
        public static final String ADD = "add:";//加好友
        public static final String JOIN = "join:";//入群
    }

    //语音存放位置
    public static final String AUDIO_SAVE_DIR = FileUtils.getDir("audio");
    public static final int DEFAULT_MAX_AUDIO_RECORD_TIME_SECOND = 120;
    //视频存放位置
    public static final String VIDEO_SAVE_DIR = FileUtils.getDir("video");
    //照片存放位置
    public static final String PHOTO_SAVE_DIR = FileUtils.getDir("photo");
    //头像保存位置
    public static final String HEADER_SAVE_DIR = FileUtils.getDir("header");

}
