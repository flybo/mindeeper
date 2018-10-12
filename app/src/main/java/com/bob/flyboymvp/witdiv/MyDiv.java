package com.bob.flyboymvp.witdiv;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MyDiv extends ViewGroup
{

	private List mAllChildViews;
	private List mLineHeight;

	public MyDiv(Context context)
	{
		this(context, null);
	}

	public MyDiv(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public MyDiv(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		mAllChildViews = new ArrayList();
		mLineHeight = new ArrayList();
	}

	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		int layHeight=0;
		int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
		int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
		int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
		int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
		int width = 0;
		int height = 0;
		int lineWidth = 0;
		int lineHeight = 0;
		int childCount = getChildCount();
		for (int i = 0; i < childCount; i++)
		{
			View child = getChildAt(i);
			measureChild(child, widthMeasureSpec, heightMeasureSpec);
			MarginLayoutParams lp = (MarginLayoutParams)child.getLayoutParams();
			int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
			int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
			if (lineWidth + childWidth > sizeWidth)
			{
				width = Math.max(width, lineWidth);
				lineWidth = childWidth;
				height += lineHeight;
				lineHeight = childHeight;
				layHeight+=childHeight;
				if (i == childCount - 1){
					continue;
				}
			} else
			{
				lineWidth += childWidth;
				lineHeight = Math.max(lineHeight, childHeight);
			}
			if (i == childCount - 1)
			{
				width = Math.max(width, lineWidth);
				height += lineHeight;
				layHeight+=childHeight;
			}
		}
		LinearLayout.LayoutParams param=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,layHeight);
		setLayoutParams(param);
		setMeasuredDimension(modeWidth != 0x40000000 ? width : sizeWidth, modeHeight != 0x40000000 ? height : sizeHeight);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	protected void onLayout(boolean changed, int l, int t, int r, int b)
	{
		mAllChildViews.clear();
		mLineHeight.clear();
		int width = getWidth();
		int lineWidth = 0;
		int lineHeight = 0;
		List lineViews = new ArrayList();
		int childCount = getChildCount();
		for (int i = 0; i < childCount; i++)
		{
			View child = getChildAt(i);
			MarginLayoutParams lp = (MarginLayoutParams)child.getLayoutParams();
			int childWidth = child.getMeasuredWidth();
			int childHeight = child.getMeasuredHeight();
			if (childWidth + lineWidth + lp.leftMargin + lp.rightMargin > width)
			{
				mLineHeight.add(Integer.valueOf(lineHeight));
				mAllChildViews.add(lineViews);
				lineWidth = 0;
				lineHeight = childHeight + lp.topMargin + lp.bottomMargin;
				lineViews = new ArrayList();
			}
			lineWidth += childWidth + lp.leftMargin + lp.rightMargin;
			lineHeight = Math.max(lineHeight, childHeight + lp.topMargin + lp.bottomMargin);
			lineViews.add(child);
		}

		mLineHeight.add(Integer.valueOf(lineHeight));
		mAllChildViews.add(lineViews);
		int left = 0;
		int top = 0;
		int lineCount = mAllChildViews.size();
		for (int i = 0; i < lineCount; i++)
		{
			lineViews = (List)mAllChildViews.get(i);
			lineHeight = ((Integer)mLineHeight.get(i)).intValue();
			for (int j = 0; j < lineViews.size(); j++)
			{
				View child = (View)lineViews.get(j);
				if (child.getVisibility() != View.GONE)
				{
					MarginLayoutParams lp = (MarginLayoutParams)child.getLayoutParams();
					int cLeft = left + lp.leftMargin;
					int cTop = top + lp.topMargin;
					int cRight = cLeft + child.getMeasuredWidth();
					int cBottom = cTop + child.getMeasuredHeight();
					child.layout(cLeft, cTop, cRight, cBottom);
					left += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
				}
			}

			left = 0;
			top += lineHeight;
		}

	}

	public LayoutParams generateLayoutParams(AttributeSet attrs)
	{
		return new MarginLayoutParams(getContext(), attrs);
	}
}
