package com.example.administrator.jackwaiting_greendao.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by JackWaiting on 2016/8/9.
 */
public class RealmUser extends RealmObject {

    @PrimaryKey
    private long id;
    private String name;
    private int age;

    public RealmUser(){

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
