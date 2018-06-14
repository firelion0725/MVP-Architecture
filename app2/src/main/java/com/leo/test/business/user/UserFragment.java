package com.leo.test.business.user;

import android.util.Log;

import com.leo.test.R;
import com.leo.test.base.BaseFragment;

/**
 * @author leo, ZhangWei
 * @date 2018/6/12
 */
public class UserFragment extends BaseFragment<UserPresenterImpl> implements UserContract.UserView {

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    protected void initDagger() {
        getComponent().inject(this);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void setupView() {

    }

    @Override
    protected int getLayoutResID() {
        return R.layout.fragment_user;
    }

    @Override
    protected void onVisibleToUser() {

    }

    @Override
    protected void onInvisibleToUser() {

    }

    @Override
    public void showData(String str) {
        Log.i("UserFragment", "str:" + str);
    }


}
