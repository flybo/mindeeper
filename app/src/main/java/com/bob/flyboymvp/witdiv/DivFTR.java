package com.bob.flyboymvp.witdiv;

import android.view.View;
import android.widget.AbsoluteLayout;

public class DivFTR {@SuppressWarnings("deprecation")
	public void divlayout(AbsoluteLayout layout, float MH, float MV, float PH, float PW){
		float PHP=0, EW = 0,EH = 0,EX = 0,EY=0,LH = 0,LX=0;
		View tv;
		AbsoluteLayout.LayoutParams textviewparams;
		AbsoluteLayout panel;
		panel=layout;
		PHP=PH-panel.getPaddingTop()-panel.getPaddingBottom();
		LX=PW-panel.getPaddingLeft()-panel.getPaddingRight();;
		for (int i=0;i<panel.getChildCount();i++){
			if(panel.getChildAt(i).getVisibility()!= View.VISIBLE) continue;
			EW = panel.getChildAt(i).getLayoutParams().width;
			EH = panel.getChildAt(i).getLayoutParams().height;
			if(EY+EH+MV>PHP){EY=0;LX=LX-LH-MH;LH=EW;}else{LH= Math.max(LH,EW);}
			EX=LX-EW; 
			textviewparams=new AbsoluteLayout.LayoutParams((int) EW, (int) EH, (int)EX, (int)EY);
			tv=panel.getChildAt(i);	tv.setLayoutParams(textviewparams);	
			EY=EY+EH+MV;
}}}
/*浮动布局，左上对齐，传入参数：MH:子对象横向间距；MV：子对象纵向间距；PW：父容器宽度;PH：父容器高度。
PWP:除去padding的父容器有效宽度；LX:除去padding的父容器宽度；EW/EH：子对象宽度/高度；EX/EY:子对象坐标；LH:最大列宽度。
*/
