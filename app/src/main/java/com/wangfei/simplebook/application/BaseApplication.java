package com.wangfei.simplebook.application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/11
 * Email : wangfeijn@163.com
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        //ActiveAndroid初始化
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //ActiveAndroid清理
        ActiveAndroid.dispose();
    }
}
