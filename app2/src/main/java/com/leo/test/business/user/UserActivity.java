package com.leo.test.business.user;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.leo.test.R;
import com.leo.test.base.BaseActivity;

import butterknife.BindView;

/**
 * @author leo, ZhangWei
 * @date 2018/6/12
 */
public class UserActivity extends BaseActivity {


    @BindView(R.id.content_layout)
    FrameLayout contentLayout;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_user;
    }

    @Override
    protected void initDagger() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupView() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.content_layout, UserFragment.newInstance());
        transaction.commit();
    }
}
