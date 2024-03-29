package com.bob.flyboymvp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.bob.flyboymvp.R;
import com.bob.flyboymvp.app.AppConst;
import com.bob.flyboymvp.util.SPUtils;
import com.bob.flyboymvp.witdiv.CSSwit;


public class SideBar extends View {
	// 触摸事件
	private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
	// 26个字母
	private String [] a={ "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z","#"};
	private String [] d={ "A", "•", "D", "•", "G", "•",
			"J", "•", "M", "•", "P", "•", "S", "•", "V",
			"•", "Z", "#"};
	private String[] b =a;
	private int choose = -1;// 选中
	boolean blIsW=true;//是否竖屏
	private Paint paint = new Paint();

	private TextView mTextDialog;
	private String strOldValue="";
	int xmm=1;
	Context mContext;
	public void setTextView(TextView mTextDialog) {
		this.mTextDialog = mTextDialog;
	}


	public SideBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		mContext=context;
	}

	public SideBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext=context;
	}

	public SideBar(Context context) {
		super(context);
		mContext=context;
	}

	/**
	 * 重写这个方法
	 */
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 获取焦点改变背景颜色.
		int height = getHeight();// 获取对应高度
		int width = getWidth(); // 获取对应宽度
		int singleHeight = height / b.length;// 获取每一个字母的高度

		for (int i = 0; i < b.length; i++) {
			paint.setColor(Color.rgb(33, 65, 98));
			// paint.setColor(Color.WHITE);
//			paint.setTypeface(Typeface.DEFAULT_BOLD);
			paint.setAntiAlias(true);
			paint.setTextSize(CSSwit.getInstance().F3);
			// 选中的状态
			if (i == choose && mTextDialog.getText().length()==1) {
				paint.setColor(Color.parseColor("#3399ff"));
				paint.setTextSize(CSSwit.getInstance().F3);
				paint.setFakeBoldText(true);
			}
			// x坐标等于中间-字符串宽度的一半.
			float xPos = width / 2 - paint.measureText(b[i]) / 2;
			float yPos = singleHeight * i + singleHeight;
			canvas.drawText(b[i], xPos, yPos, paint);
			paint.reset();// 重置画笔
		}

	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		final int action = event.getAction();
		final float y = event.getY();// 点击y坐标
		final OnTouchingLetterChangedListener listener = onTouchingLetterChangedListener;
		final int c = (int) (y / getHeight() * a.length);// 点击y坐标所占总高度的比例*b数组的长度就等于点击b中的个数.
		final int ws=(int) (y / getHeight() * d.length);
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			setBackgroundResource(R.drawable.sidebar_background);
			if (c >= 0 && c < a.length) {
				if (listener != null) {
					listener.onTouchingLetterChanged(a[c]);
				}
				if (mTextDialog != null) {
					mTextDialog.setText(a[c]);
					mTextDialog.setVisibility(View.VISIBLE);
				}
				
				choose = blIsW?c:ws;
				invalidate();
			}
			break;
		case MotionEvent.ACTION_UP:
			setBackgroundDrawable(new ColorDrawable(0x20000000));
			//choose = -1;//
			invalidate();
			if (mTextDialog != null) {
				mTextDialog.setVisibility(View.GONE);
			}
			break;
		case MotionEvent.ACTION_MOVE:
			double xmx=0;
			if(SPUtils.getInstance(mContext).getInt(AppConst.User.HAND_WHAT,0)==1){
				xmx=(double)(CSSwit.getInstance().CW-event.getRawX())/ CSSwit.getInstance().CW;
			}else{
				xmx=(double)event.getRawX()/ CSSwit.getInstance().CW;
			}
			int xm=xmx>0.85?1:(xmx>0.7?2:(xmx>0.55?4:(xmx>0.4?8:(xmx>0.25?16:32))));
			setBackgroundResource(R.drawable.sidebar_background);
//			if (oldChoose != c) {
				if (c >= 0 && c < a.length) {
					if (mTextDialog != null) {
						if(strOldValue.equals("")){
							strOldValue=a[c];
						}
						if(xmm!=xm){
							if(xm>xmm){
								strOldValue+=a[c];
							}else{
								strOldValue=strOldValue.substring(0,strOldValue.length()-1);
							}
							xmm=xm;
						}else{
							if(xmm!=1){
								strOldValue=strOldValue.substring(0,strOldValue.length()-1)+a[c];
							}else{
								strOldValue=a[c];
							}
						}
						if (listener != null) {
							listener.onTouchingLetterChanged(strOldValue);
						}
						mTextDialog.setText(strOldValue);
						mTextDialog.setVisibility(View.VISIBLE);
					}
					
					choose = blIsW?c:ws;
					invalidate();
				}
//			}
			break;
		case MotionEvent.ACTION_CANCEL:
			setBackgroundDrawable(new ColorDrawable(0x20000000));
			//choose = -1;//
			invalidate();
			if (mTextDialog != null) {
				mTextDialog.setVisibility(View.GONE);
			}
			break;
		}
		return true;
	}
	
	/**
	 * 设置选中索引
	 * @param str
	 */
	public void setCheckIndex(String str){
		for (int i = 0; i < b.length; i++) {
			if(b[i].equals(str)){
				choose=i;
				invalidate();
				break;
			}
		}
	}
	
	public void refNone(){
		choose=-1;
		invalidate();
	}
	
	//设置横屏
	public void setCrossScreen(){
		blIsW=false;
		b =d;
		invalidate();
	}
	
	//设置竖屏
	public void setVerticalScreen(){
		blIsW=true;
		b = a;
		invalidate();
	}

	/**
	 * 向外公开的方法
	 * 
	 * @param onTouchingLetterChangedListener
	 */
	public void setOnTouchingLetterChangedListener(
			OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
		this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
	}

	/**
	 * 接口
	 * 
	 * @author coder
	 * 
	 */
	public interface OnTouchingLetterChangedListener {
		public void onTouchingLetterChanged(String s);
	}

}