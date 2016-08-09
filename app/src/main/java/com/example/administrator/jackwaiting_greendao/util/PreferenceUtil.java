package com.example.administrator.jackwaiting_greendao.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JackWaiting on 2016/8/9.
 */
public class PreferenceUtil {

    private static SharedPreferences sp;
    private static PreferenceUtil settingPrefences;

    private static String GREENDAO = "garrndao";
    private static String REALM = "realm";


    private PreferenceUtil(Context context) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
    }

    public static PreferenceUtil getIntance(Context context) {
        if (null == settingPrefences) {
            settingPrefences = new PreferenceUtil(context.getApplicationContext());
        }
        return settingPrefences;
    }


    public void saveGreenDaoCount(int mode) {
        sp.edit().putInt(GREENDAO, mode).commit();
    }

    public int getGreenDaoCount() {
        return sp.getInt(GREENDAO, 0);
    }

    public void saveRealmCount(int mode) {
        sp.edit().putInt(REALM, mode).commit();
    }

    public int getRealmCount() {
        return sp.getInt(REALM, 0);
    }
}
