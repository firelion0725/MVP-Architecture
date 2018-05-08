package com.leo.data.task;

import com.leo.data.dao.load.TaskModel;
import com.leo.data.dao.upload.PostTaskModel;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author leo, ZhangWei
 * @date 2018/3/28
 * @function
 */
public interface TaskService {

    @POST("papi/login/login")
    Single<TaskModel> getTaskData(@Body PostTaskModel body);

}
