package com.bob.flyboymvp.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.witdiv.CSSwit;


/**
 * Created on 2017/6/6.
 */

public class MyDelLayout extends RelativeLayout implements View.OnClickListener{
    private Context context;
    EditText editText;
    ImageView imgL,imgR;
    private ICallbackListener iCallbackListener = null;
    public MyDelLayout(Context context) {
        super(context);
        this.context=context;
        initView();
    }

    public MyDelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initView();
    }

    public MyDelLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initView();
    }

    /**
     * 初始化
     */
    private void initView(){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_mydel_et, this);
        editText=view.findViewById(R.id.editText);
        editText.setPadding(CSSwit.getInstance().H,0,CSSwit.getInstance().H,0);
        imgL=view.findViewById(R.id.img_l);
        imgL.getLayoutParams().width=CSSwit.getInstance().H;
        imgL.getLayoutParams().height=CSSwit.getInstance().H;
        imgL.setOnClickListener(this);
        imgR=view.findViewById(R.id.img_r);
        imgR.getLayoutParams().width=CSSwit.getInstance().H;
        imgR.getLayoutParams().height=CSSwit.getInstance().H;
        imgR.setOnClickListener(this);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0){
                    imgR.setVisibility(View.VISIBLE);
                    imgR.setImageResource(R.mipmap.del);
                }else{
                    imgR.setVisibility(View.GONE);
                }
            }
        });
    }

    //设置左边图片数据源
    public void setImageResourceLeft(int resourceLeft){
        imgL.setImageResource(resourceLeft);
    }

    public EditText getEditText(){
        return editText;
    }

    public ImageView getImgR(){
        return imgR;
    }

    //设置文本框数据
    public void setEditTextValue(String val){
        editText.setText(val);
        editText.setSelection(val.length());
    }

    public String getEditTextValue(){
        return editText.getText().toString();
    }

    public void setEditTextHint(String val){
        editText.setHint(val);
    }

    public void setEditTextInputType(int inputType){
        editText.setInputType(inputType);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_l:
                if(iCallbackListener!=null) iCallbackListener.click();
                break;
            case R.id.img_r:
                editText.setText("");
                break;
        }
    }


    public void setOnCallbackListener(ICallbackListener iCallbackListener) {
        this.iCallbackListener = iCallbackListener;
    }

    //自定义接口文件，click方法由调用处实现
    public interface ICallbackListener {
        public void click();
    }
}
