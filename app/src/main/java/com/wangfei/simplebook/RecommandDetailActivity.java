package com.wangfei.simplebook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.wangfei.simplebook.domain.Recommand;
import com.wangfei.simplebook.fragments.RecommandDetailFragment;

public class RecommandDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomand_detail);
        Recommand.ItemsEntity bean = (Recommand.ItemsEntity) getIntent().getSerializableExtra(RecommandDetailFragment.EXTRA_BEAN);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = RecommandDetailFragment.newInstance(bean);
            manager.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }
}
