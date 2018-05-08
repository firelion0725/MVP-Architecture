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
public class DogRealmDAO implements RealmModel {

    @PrimaryKey
    private int id;
    @Required
    private String name;
    @Required
    private String tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
