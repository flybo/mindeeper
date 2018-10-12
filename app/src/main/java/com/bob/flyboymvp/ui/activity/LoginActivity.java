package com.bob.flyboymvp.ui.activity;


import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.ui.base.BaseActivity;
import com.bob.flyboymvp.ui.presenter.LoginAtPter;
import com.bob.flyboymvp.ui.view.ILoginAtView;
import com.bob.flyboymvp.util.UIUtils;
import com.bob.flyboymvp.widget.MyDelLayout;
import com.bob.flyboymvp.widget.StateButton;
import com.bob.flyboymvp.witdiv.CSSwit;

import butterknife.BindView;


/**
 * @创建者 CSDN_LQR
 * @描述 登录界面
 */
public class LoginActivity extends BaseActivity<ILoginAtView, LoginAtPter> implements ILoginAtView {
    @BindView(R.id.et_name)
    MyDelLayout mEtName;
    @BindView(R.id.et_pwd)
    MyDelLayout mEtPwd;
    @BindView(R.id.btn_login)
    StateButton mBtnLogin;
    @BindView(R.id.btn_reg)
    StateButton mBtnReg;
    @BindView(R.id.abslay_login)
    AbsoluteLayout absLogin;
    @BindView(R.id.img_bg)
    ImageView ivBg;
    @BindView(R.id.rv_users)
    RecyclerView rvUsers;
    @BindView(R.id.ll_user_sel)
    LinearLayout llUserSel;
    @BindView(R.id.ll_users)
    LinearLayout llUsers;

    @Override
    public void init() {
//        PermissionGen.with(this)
//                .addRequestCode(100)
//                .permissions(
//                        //电话通讯录
//                        Manifest.permission.GET_ACCOUNTS,
//                        Manifest.permission.READ_PHONE_STATE,
//                        //位置
//                        Manifest.permission.ACCESS_FINE_LOCATION,
//                        Manifest.permission.ACCESS_COARSE_LOCATION,
//                        Manifest.permission.ACCESS_FINE_LOCATION,
//                        //相机、麦克风
//                        Manifest.permission.RECORD_AUDIO,
//                        Manifest.permission.WAKE_LOCK,
//                        Manifest.permission.CAMERA,
//                        //存储空间
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_SETTINGS
//                ).request();
    }

    @Override
    public void initView() {
        setToolbarTitle(UIUtils.getString(R.string.app_name));
        mEtName.setEditTextValue("13750801849");
        mEtPwd.setEditTextValue("1");
        mEtPwd.setImageResourceLeft(R.mipmap.see1);
        mEtPwd.setEditTextInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        absLogin.setPadding(M,M*19,M,M);
        getBackground();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        mToolbarNavigation.setVisibility(View.VISIBLE);
        mToolbarNavigation.getLayoutParams().height=M*4;
        mToolbarNavigation.getLayoutParams().width=M*4;
        mToolbarNavigation.setPadding(0,0,0,0);
        mToolbarNavigation.setImageResource(R.mipmap.contact);
        mToolbarNavigation.setEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvUsers.setLayoutManager(layoutManager);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(CSSwit.getInstance().C51T2, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(M,M*23,0,0);
        llUsers.setLayoutParams(params);
    }

    @Override
    public void initListener() {
        mBtnLogin.setOnClickListener(v -> mPresenter.login());
        mEtName.setOnCallbackListener(() -> mPresenter.userSelWindow());
        mEtPwd.setOnCallbackListener(() -> mPresenter.pwdVisible());
        llUserSel.setOnClickListener(v -> llUserSel.setVisibility(View.GONE));
    }

    @Override
    protected LoginAtPter createPresenter() {
        return new LoginAtPter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isToolbarCanBack() {
        return false;
    }

    @Override
    public MyDelLayout getEtDelPhone() {
        return mEtName;
    }

    @Override
    public MyDelLayout getEtDelPwd() {
        return mEtPwd;
    }

    @Override
    public LinearLayout getLlUserSel() {
        return llUserSel;
    }

    @Override
    public LinearLayout llUsers() {
        return llUsers;
    }

    @Override
    public RecyclerView getRvUserList() {
        return rvUsers;
    }

    private void getBackground() {
        int irow = getResources().getConfiguration().orientation;
        Boolean issp = irow == Configuration.ORIENTATION_PORTRAIT;
        Resources res = getResources();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = true;
        Bitmap bmp = BitmapFactory.decodeResource(res, R.mipmap.login_bg, options);
        int picWidth = bmp.getWidth();
        int picHeight = bmp.getHeight();
        int winwidth = CSSwit.getInstance().CW;
        int winheight = CSSwit.getInstance().CH;
        if (issp) {
            int needwidth = winwidth * picWidth / winheight;
            int sub = picWidth - needwidth;
            Bitmap bt = Bitmap.createBitmap(bmp, sub / 2, 0,
                    picWidth - sub - 2, picHeight);
            Drawable drawable = new BitmapDrawable(bt);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                ivBg.setBackground(drawable);
            } else {
                ivBg.setBackgroundDrawable(drawable);
            }
            //
        } else {
            //
            int needheight = winheight * picHeight / winwidth;
            int sub = picHeight - needheight;
            Bitmap bt = Bitmap.createBitmap(bmp, 0, sub, picWidth, picHeight- sub);
            Drawable drawable = new BitmapDrawable(bt);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                ivBg.setBackground(drawable);
            } else {
                ivBg.setBackgroundDrawable(drawable);
            }
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getBackground();
        absLogin.setPadding(M,M*(CSSwit.getInstance().isHorScreen()?1:19),M,M);
    }
}