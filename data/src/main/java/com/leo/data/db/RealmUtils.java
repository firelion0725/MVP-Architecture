package com.leo.data.db;

import android.content.Context;

import com.leo.data.dao.db.MyRealmMigration;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * @author leo, ZhangWei
 * @date 2018/4/24
 * @function
 */
public class RealmUtils {

    /**
     * 初始化Realm 需传入applicationContext
     *
     * @param context applicationContext
     */
    public static void initRealm(Context context) {
        Realm.init(context);
    }

    public static Realm getDefaultRealm() {
        return Realm.getDefaultInstance();
    }

    public static Realm getRealm(RealmConfiguration configuration) {
        return Realm.getInstance(configuration);
    }

    public static Realm getDefaultConfigRealm() {
        return getRealm(getDefaultRealmConfiguration());
    }

    public static RealmConfiguration getDefaultRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .name("default.realm")
                .schemaVersion(3)
                .migration(new MyRealmMigration())
                .build();
    }

    /**
     * 同步方式查询
     */
    public static <E extends RealmModel> Flowable<RealmResults<E>> query(Realm realm, Class<E> clazz, String fieldName) {
        return realm.where(clazz)
                .sort(fieldName)
                .findAll()
                .asFlowable()
                .observeOn(AndroidSchedulers.mainThread());

    }

    /**
     * 异步方式查询
     */
    public static <E extends RealmModel> Flowable<RealmResults<E>> queryAsync(final Realm realm, final Class<E> clazz, final String fieldName) {
        return realm.where(clazz)
                .sort(fieldName)
                .findAllAsync()
                .asFlowable()
                .observeOn(AndroidSchedulers.mainThread());

    }

    /**
     * 同步方式增加或更新数据
     */
    public static <E extends RealmModel> void addList(Realm realm, List<E> objects) {
        realm.executeTransaction(r -> r.copyToRealmOrUpdate(objects));
    }

    /**
     * 同步方式增加或更新数据
     */
    public static <E extends RealmModel> void add(Realm realm, E object) {
        realm.executeTransaction(r -> r.copyToRealmOrUpdate(object));
    }

    /**
     * 异步方式增加数据 强制执行成功和失败方法
     * {@link Realm.Transaction.OnSuccess},{@link Realm.Transaction.OnError}
     */
    public static <E extends RealmModel> RealmAsyncTask addAsync(Realm realm, E object, Realm.Transaction.OnSuccess success, Realm.Transaction.OnError error) {
        return realm.executeTransactionAsync(r -> r.copyToRealmOrUpdate(object), success, error);
    }

    /**
     * 删除该对象的整个表
     */
    public static <E extends RealmModel> void delete(Realm realm, E object) {
        realm.delete(object.getClass());
    }

}
