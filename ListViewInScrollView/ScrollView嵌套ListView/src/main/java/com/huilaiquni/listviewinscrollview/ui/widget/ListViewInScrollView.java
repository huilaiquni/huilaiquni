package com.huilaiquni.listviewinscrollview.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 *
 *  三个构造方法完全不用动，只要重写onMeasure方法
 在xml布局中和Activty中使用的ListView改成这个自定义ListView就行了。
 这个方法有一个毛病，就是默认显示的首项是ListView，需要手动把ScrollView滚动至最顶端。
 scrollView = (ScrollView) findViewById(R.id.scrollView);
 scrollView.smoothScrollTo(0, 0);

 * Created by acer on 2016/8/9.
 */
public class ListViewInScrollView extends ListView{
    public ListViewInScrollView(Context context) {
        super(context);
    }

    public ListViewInScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewInScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }



}
