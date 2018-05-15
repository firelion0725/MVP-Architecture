package com.leo.data.dao.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author leo, ZhangWei
 * @date 2018/5/14
 * @function
 */
public class TestRealmDAO extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;

    public TestRealmDAO() {
    }

    public TestRealmDAO(long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "TestRealmDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
