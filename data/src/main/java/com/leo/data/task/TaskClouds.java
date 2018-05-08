package com.leo.data.task;


import com.leo.data.RetrofitManger;
import com.leo.data.dao.load.TaskModel;
import com.leo.data.dao.upload.PostTaskModel;
import com.leo.data.rx.RxUtils;

import io.reactivex.Single;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function
 */
public class TaskClouds {

    private static TaskService service;

    private static TaskService getService() {
        if (service == null) {
            service = RetrofitManger.getInsatance().create(TaskService.class);
        }
        return service;
    }

    public static Single<TaskModel> getTaskData(PostTaskModel body) {
        return RxUtils.compile(getService().getTaskData(body));
    }

}
