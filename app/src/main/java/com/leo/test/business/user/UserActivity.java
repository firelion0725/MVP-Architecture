package com.leo.test.business.user;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.leo.test.R;
import com.leo.test.base.BaseActivity;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function 用户类
 */
public class UserActivity extends BaseActivity<UserPresenterImpl> implements UserContract.UserView {

    FrameLayout containerLayout;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user);
//        setFragment();
//    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_user;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupView() {
        containerLayout = findViewById(R.id.container_layout);
        setFragment();
    }

    private void setFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.container_layout, UserFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void showData(String str) {

    }

    @Override
    public void show(String string) {

    }
}
