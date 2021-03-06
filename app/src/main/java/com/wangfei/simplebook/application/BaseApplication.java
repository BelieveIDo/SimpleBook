package com.wangfei.simplebook.application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;

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

        initUmeng();
    }

    private void initUmeng() {
//        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
//        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("3921700954","04b48b094faeb16683c32669824ebdad");
        //新浪微博 appkey appsecret
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
//        // QQ和Qzone appid appkey
//        PlatformConfig.setAlipay("2015111700822536");
//        //支付宝 appid
//        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
//        //人人 appid appkey appsecret
//        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
//        //Twitter appid appkey
//        PlatformConfig.setPinterest("1439206");
//        //Pinterest appid
//        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //ActiveAndroid清理
        ActiveAndroid.dispose();
    }


}
