package com.wangfei.simplebook.myview;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/12
 * Email : wangfeijn@163.com
 */
public class MyBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    public MyBehavior() {
    }

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
//      关心垂直滚动
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL)!=0;
    }



    //    即将发生的滚动监听，还没有分发事件
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dx, int dy, int[] consumed) {

        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy>0) {
            ViewCompat.animate(child).translationY(child.getHeight()).alpha(0).start();
            child.setVisibility(View.GONE);
        }else{
            ViewCompat.animate(child).translationY(-child.getHeight()).alpha(1).start();
            child.setVisibility(View.VISIBLE);
        }
    }
}
