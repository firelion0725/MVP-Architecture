package com.leo.test.business.user;

import com.leo.test.base.BaseView;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public interface UserContract {

    interface UserView extends BaseView{
        void showData(String str);
    }

    interface UserPresenter {
        void getData();
    }
}
