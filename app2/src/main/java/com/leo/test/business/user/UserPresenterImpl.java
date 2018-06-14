package com.leo.test.business.user;

import com.leo.test.base.BaseMvpPresenter;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/6/12
 */
public class UserPresenterImpl extends BaseMvpPresenter<UserContract.UserView> implements UserContract.UserPresenter {

    @Inject
    public UserPresenterImpl() {
    }

    @Override
    public void getData() {
        view.showData("UserPresenterImpl");
    }
}
