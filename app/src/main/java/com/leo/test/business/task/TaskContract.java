package com.leo.test.business.task;

import com.leo.test.base.BaseActivityView;
import com.leo.test.base.BaseView;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public interface TaskContract {

    interface TaskView extends BaseActivityView{
        void showData(String str);
    }

    interface TaskPresenter {
        void getData();
    }
}
