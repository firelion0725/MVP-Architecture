package com.leo.test.third;

import javax.inject.Inject;

/**
 * @author leo, ZhangWei
 * @date 2018/5/28
 */
public class ThirdObject {

    private String name;
    private String message;

    @Inject
    public ThirdObject(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ThirdObject{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
