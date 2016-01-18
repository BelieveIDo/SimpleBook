package com.wangfei.simplebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.wangfei.simplebook.adapters.MainViewPagerAdapter;
import com.wangfei.simplebook.fragments.EssenceFragment;
import com.wangfei.simplebook.fragments.PictureFragment;
import com.wangfei.simplebook.fragments.RecommandFragment;
import com.wangfei.simplebook.fragments.TextFragment;
import com.wangfei.simplebook.fragments.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, ViewPager.OnPageChangeListener,
        NavigationView.OnNavigationItemSelectedListener,
        DrawerLayout.DrawerListener {

    private CoordinatorLayout coordinatorlayout;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private NavigationView navigation;
    private FloatingActionButton floatBt;
    private List<Fragment> list;
    private DrawerLayout drawerlayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        setListener();
    }


    //初始化视图
    private void initView() {
        setContentView(R.layout.activity_main);
        coordinatorlayout = ((CoordinatorLayout) findViewById(R.id.main_coordinator));
        tablayout = (TabLayout) findViewById(R.id.main_tablayout);
        viewpager = (ViewPager) findViewById(R.id.main_viewpager);
        navigation = (NavigationView) findViewById(R.id.main_navigationview);
        floatBt = (FloatingActionButton) findViewById(R.id.main_float_btn);
        drawerlayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
    }

    //初始化数据
    private void initData() {
        list = new ArrayList<>();

        list.add(new RecommandFragment());
        list.add(new VideoFragment());
        list.add(new PictureFragment());
        list.add(new TextFragment());
        list.add(new EssenceFragment());
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);


    }

    //    设置监听
    private void setListener() {
        viewpager.addOnPageChangeListener(this);
        navigation.setNavigationItemSelectedListener(this);
        drawerlayout.setDrawerListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_navigationview:
                drawerlayout.closeDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

//    navigation的Item的选择
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
//                启动第三方登录界面
                startActivity(new Intent(this,ThirdPartyLoginActivity.class));
                break;
            case R.id.exit:
                ActivityCompat.finishAffinity(this);
                break;
        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
