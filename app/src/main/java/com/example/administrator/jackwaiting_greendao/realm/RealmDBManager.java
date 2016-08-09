package com.example.administrator.jackwaiting_greendao.realm;

import android.content.Context;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by JackWaiting on 2016/8/9.
 */
public class RealmDBManager {

    private Realm myOtherRealm;
    public RealmDBManager(Context context) {
        myOtherRealm = Realm.getInstance(new RealmConfiguration
                .Builder(context)
                .name("myOtherRealm.realm")
                .build());
    }


    public List<RealmUser> readRealmObject(){
        RealmResults<RealmUser> results = myOtherRealm.where(RealmUser.class)
                .findAll();
        return  results;
    }

    public void beginTransaction(){
        myOtherRealm.beginTransaction();
    }

    public void saveRealmObject(RealmUser user){
        myOtherRealm.copyToRealmOrUpdate(user);

    }

    public void commitTransaction(){
        myOtherRealm.commitTransaction();
    }

    public void deleteRealmObject(){
        final RealmResults<RealmUser> results = myOtherRealm.where(RealmUser.class)
                .findAll();
        myOtherRealm.beginTransaction();
        results.clear();
        myOtherRealm.commitTransaction();
    }

}
