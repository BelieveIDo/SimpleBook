package com.wangfei.simplebook.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/11
 * Email : wangfeijn@163.com
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mData;
    private String[] str=new String[]{"推荐","视频","图片","段子","订阅","精华","同城","圈子"};
    public MainViewPagerAdapter(FragmentManager fm, List<Fragment> mData) {
        super(fm);
        this.mData = mData;
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        int ret=0;
        if(mData.size()!=0){
            ret=mData.size();
        }
        return ret;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
