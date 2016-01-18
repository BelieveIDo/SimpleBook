package com.wangfei.simplebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class ThirdPartyLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private UMShareAPI mShareAPI;
    private SHARE_MEDIA platform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_login);
        initUmeng();
    }

    private void initUmeng(){
        //        首先获取UMShareAPI
        mShareAPI = UMShareAPI.get(this);


        platform = SHARE_MEDIA.SINA;
        mShareAPI.doOauthVerify(this, platform, umAuthListener);

    }
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

//       QQ登录
    public void QQClick(View view) {


    }
//      新浪登录
    public void SinaClick(View view) {


    }
//      微信登录
    public void WeChatClick(View view) {

    }
//      一键分享
    public void ShareClick(View view) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mShareAPI.deleteOauth(ThirdPartyLoginActivity.this, platform,  umAuthListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
