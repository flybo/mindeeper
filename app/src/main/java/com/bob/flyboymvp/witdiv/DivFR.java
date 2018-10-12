package com.bob.flyboymvp.witdiv;

import android.view.View;
import android.widget.AbsoluteLayout;

public class DivFR {@SuppressWarnings("deprecation")
	public void divlayout(AbsoluteLayout layout, float MH, float MV, float PW){
		float PWP=0, EW = 0,EH = 0,EX = 0,EY=0,LH = 0;
		View tv;
		AbsoluteLayout.LayoutParams textviewparams;
		AbsoluteLayout panel;
		panel=layout;
		PWP=PW-panel.getPaddingLeft()-panel.getPaddingRight();
		EX=PWP+MH;
		for (int i=0;i<panel.getChildCount();i++){
			if(panel.getChildAt(i).getVisibility()!= View.VISIBLE) continue;
			EW = panel.getChildAt(i).getLayoutParams().width;
			EH = panel.getChildAt(i).getLayoutParams().height;
			if(EX-EW-MH<0){EX=PWP-EW;EY=EY+LH+MV;LH=EH;}else{EX=EX-EW-MH;LH= Math.max(LH,EH);}
			textviewparams=new AbsoluteLayout.LayoutParams((int) EW, (int) EH, (int)EX, (int)EY);
			tv=panel.getChildAt(i);	tv.setLayoutParams(textviewparams);	
}}}
/*浮动布局，右对齐，传入参数：MH:子对象横向间距；MV：子对象纵向间距；PW：父容器宽度。
PWP:除去padding的父容器有效宽度；EW/EH：子对象宽度/高度；EX/EY:子对象坐标；LH:最大行高度。
*/