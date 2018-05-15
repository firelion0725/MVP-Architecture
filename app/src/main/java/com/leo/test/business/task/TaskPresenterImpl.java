package com.leo.test.business.task;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.leo.data.dao.db.MessageDAO;
import com.leo.data.dao.db.MessageRealmDao;
import com.leo.data.dao.db.TestRealmDAO;
import com.leo.data.dao.transform.TransformUtils;
import com.leo.data.db.RealmUtils;
import com.leo.data.db.SqlHelper;
import com.leo.data.rx.AbstractSubscriber;
import com.leo.test.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * @author leo, ZhangWei
 * @date 2018/4/19
 * @function
 */
public class TaskPresenterImpl extends BasePresenter<TaskContract.TaskView> implements TaskContract.TaskPresenter {

    private TaskContract.TaskView view;
    Realm realm;

    Handler handler = new Handler(Looper.getMainLooper());

    @Inject
    public TaskPresenterImpl(TaskContract.TaskView view) {
        this.view = view;
    }

    @Override
    public void getData() {
        realm = RealmUtils.getDefaultConfigRealm();
        realm.setAutoRefresh(false);
        addRealm();
//        delete(view.getViewApplicationContext()).getApplicationContext(), realm, TestRealmDAO.class, "name", "数据1");
        showRealm();
//        PostTaskModel body = new PostTaskModel("18302278175", "abcd0987");
//
//        TaskClouds.getTaskData(body)
//                .compose(view.bindToLifecycle())
//                .subscribe(new AbstractSingleHttp<TaskModel>() {
//
//                    @Override
//                    public void onSuccess(TaskModel taskModel) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//                    }
//                });

        String msg = "this is get data";
        view.showData(msg);
//        testRealm();
//        addDb();
//        testDbHelper();
    }

    void showOther() {
        Log.i("TaskPresenterImpl", "show other msg");
    }


    private void testRealm() {

//        PostTaskModel body = new PostTaskModel("18302278175", "abcd0987");
//        PostTaskModel body2 = new PostTaskModel("18302278176", "abcd09876");
//        RealmUtils.add(realm, body);
//        RealmUtils.add(realm, body2);

        RealmUtils.query(realm, MessageRealmDao.class, "id")
                .subscribe(new AbstractSubscriber<RealmResults<MessageRealmDao>>() {
            @Override
            public void onNext(RealmResults<MessageRealmDao> postTaskModels) {
                Log.i("testRealm", "query success:" + postTaskModels.size());
                List<MessageRealmDao> list = postTaskModels.subList(0, postTaskModels.size());
                for (MessageRealmDao model : list) {
                    Log.i("testRealm", "data:" + model);
                }
            }

            @Override
            public void onError(Throwable t) {
                Log.i("testRealm", "query error:");
                t.printStackTrace();
            }
        });
    }

    private void showRealm() {
        handler.postDelayed(()->  RealmUtils.query(realm, TestRealmDAO.class, "id").subscribe(new AbstractSubscriber<RealmResults<TestRealmDAO>>() {
            @Override
            public void onNext(RealmResults<TestRealmDAO> postTaskModels) {
                Log.i("testRealm", "query success:" + postTaskModels.size());
                List<TestRealmDAO> list = postTaskModels.subList(0, postTaskModels.size());
                for (TestRealmDAO model : list) {
                    Log.i("testRealm", "data:" + model);
                }
            }

            @Override
            public void onError(Throwable t) {
                Log.i("testRealm", "query error:");
                t.printStackTrace();
            }
        }),100);

    }

    private void addRealm(List<MessageDAO> list) {
        List<MessageRealmDao> realmDaos = TransformUtils.transformMessageDaos(list);
        RealmUtils.addList(realm, realmDaos);
    }

    void addRealm() {
        List<TestRealmDAO> realmDaos = new ArrayList<>(3);
        for (int i = 1; i < 4; i++) {
            TestRealmDAO dao = new TestRealmDAO(i, "数据" + i);
            realmDaos.add(dao);
        }
        RealmUtils.addList(realm, realmDaos);
    }

    private void addDb() {
        SqlHelper helper = SqlHelper.getInstance(view.getViewContext());
        for (int i = 1; i < 5; i++) {
            MessageDAO messageDAO = new MessageDAO("" + i, "第一个数据", "第一个内容", "mct_id_" + i, "0", "" + System.currentTimeMillis());
            helper.saveMessage(messageDAO);
            Log.i("add data", "" + messageDAO);
        }
    }

    private void testDbHelper() {
        SqlHelper helper = SqlHelper.getInstance(view.getViewContext());
        List<MessageDAO> list = helper.getAllData();
        addRealm(list);
        testRealm();
        for (MessageDAO messageDAO : list) {
            Log.i("DB Helper", "message:" + messageDAO);
        }
    }

//    /**
//     * 异步删除指定记录
//     *
//     * @param clazz RealmObject 字节码
//     * @param field 数据库中的列名
//     * @param value 对应的列值
//     */
//    public static <E extends RealmObject> void delete(Context context, Realm realm, Class<E> clazz, String field, String value) {
//        realm.executeTransactionAsync(realm1 -> {
//                    E e = realm1.where(clazz).findFirst();
//                    if (e != null) {
//                        e.deleteFromRealm();
//                    }
//                }, () -> Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show()
//                , error -> Toast.makeText(context, "更新失败", Toast.LENGTH_SHORT).show());
//    }

}
