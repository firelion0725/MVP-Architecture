package com.leo.data.dao.db;

import io.realm.RealmObject;

/**
 * @author leo, ZhangWei
 * @date 2018/5/14
 * @function
 */
public class TestRealmDAO extends RealmObject {

    private int id;
    private String name;

    public TestRealmDAO(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "TestRealmDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
