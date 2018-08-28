package com.leo.test.business.user;

import android.util.Log;

import com.leo.test.R;
import com.leo.test.base.BaseFragment;
import com.leo.test.scoped.ActivityScoped;
import com.leo.test.scoped.FragmentScoped;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/5/28
 */
@FragmentScoped
public class UserFragment extends BaseFragment<UserPresenterImpl> implements UserContract.UserView {

    @Inject
    public UserFragment() {
        // Requires empty public constructor
    }

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void setupView() {

    }

    @Override
    public void show(String string) {
        Log.i("UserFragment", "data:" + string);
    }

    @Override
    public void showData(String str) {

    }
}
