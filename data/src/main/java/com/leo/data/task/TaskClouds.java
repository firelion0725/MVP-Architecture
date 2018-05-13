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

    private static class ServiceSingleton{
        private static final TaskService SERVICE = RetrofitManger.getInsatance().create(TaskService.class);
        static TaskService getService(){
            return SERVICE;
        }
    }

    public static Single<TaskModel> getTaskData(PostTaskModel body) {
        return RxUtils.compile(ServiceSingleton.getService().getTaskData(body));
    }

}
