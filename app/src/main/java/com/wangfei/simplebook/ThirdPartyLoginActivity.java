package com.wangfei.simplebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThirdPartyLoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_login);
    }

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
}
