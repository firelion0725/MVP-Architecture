package com.leo.test.business.user;

import android.util.Log;
import android.widget.FrameLayout;

import com.leo.test.R;
import com.leo.test.base.BaseRxLifecycleActivity;
import com.leo.test.order.list.ListActivity;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function 用户类
 */
public class UserActivity extends BaseRxLifecycleActivity<UserPresenterImpl> implements UserContract.UserView {

    FrameLayout containerLayout;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_user;
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void setupView() {
        containerLayout = findViewById(R.id.container_layout);
//        replaceFragment(userFragment, false);
    }

    @Override
    public void showData(String str) {
        Log.i("UserActivity", "show Data:" + str);
        goActivity(ListActivity.class);
    }

    @Override
    public void show(String string) {

    }
}
