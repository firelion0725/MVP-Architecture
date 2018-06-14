package com.leo.test.business.user;

import com.leo.test.base.BaseFragmentView;
import com.leo.test.base.BasePresenter;

/**
 * @author leo, ZhangWei
 * @date 2018/6/12
 */
public interface UserContract {

    interface UserView extends BaseFragmentView {
        void showData(String str);
    }

    interface UserPresenter extends BasePresenter<UserView> {
        void getData();
    }
}
