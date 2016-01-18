package com.wangfei.simplebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThirdPartyLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mBackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_party_login);
        mBackTextView = ((TextView) findViewById(R.id.tv));
        mBackTextView.setOnClickListener(this);
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
            case R.id.tv:
                finish();
                break;
        }
    }
}
