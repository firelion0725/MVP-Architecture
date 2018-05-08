package com.leo.data.dao.db;

import io.realm.RealmModel;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

/**
 * @author leo, ZhangWei
 * @date 2018/4/26
 * @function
 */
@RealmClass
public class PersonRealmDAO implements RealmModel {

    private long id;
    @Required
    private String name;
    @Required
    private String sex;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
