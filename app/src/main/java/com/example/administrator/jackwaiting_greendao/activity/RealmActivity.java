package com.example.administrator.jackwaiting_greendao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.jackwaiting_greendao.R;
import com.example.administrator.jackwaiting_greendao.adapter.RealmListAdapter;
import com.example.administrator.jackwaiting_greendao.realm.RealmDBManager;
import com.example.administrator.jackwaiting_greendao.realm.RealmUser;
import com.example.administrator.jackwaiting_greendao.util.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

public class RealmActivity extends Activity implements View.OnClickListener{

    private RealmDBManager myRealm;

    private ListView lvUser;
    private List<RealmUser> users;
    private TextView tvTime;
    private Button btnAdd,btnDelete;
    private int maxCount = 0;
    private EditText ediMaxCount;
    private TextView tvTitle;
    private PreferenceUtil preferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);
        getRealm();
        initView();
        initData();
        long seleteTime=System.currentTimeMillis();
        refreshData();
        tvTime.setText("Realm查询" + preferenceUtil.getRealmCount() + "条数据花了" + (System.currentTimeMillis() - seleteTime) + "毫秒");
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        lvUser = (ListView) findViewById(R.id.lv_user);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        tvTime = (TextView) findViewById(R.id.tv_time);
        ediMaxCount = (EditText) findViewById(R.id.edi_maxCount);

        tvTitle.setText("Realm");
    }

    private void initData() {
        preferenceUtil = PreferenceUtil.getIntance(this);
        users = new ArrayList<RealmUser>();
        users.clear();
        for (int i= 0;i< maxCount;i++){
            RealmUser user = new RealmUser();
            user.setId(i);
            user.setName("JackWaiting"+i);
            user.setAge(i);
            users.add(user);
        }
    }

    private void refreshData() {
        lvUser.setAdapter(new RealmListAdapter(this, myRealm.readRealmObject()));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                myRealm.deleteRealmObject();

                maxCount= Integer.parseInt(ediMaxCount.getText().toString());
                preferenceUtil.saveRealmCount(maxCount);
                initData();
                long addTime=System.currentTimeMillis();
                myRealm.beginTransaction();
                for (int i= 0;i<maxCount;i++){
                    myRealm.saveRealmObject(users.get(i));
                }
                myRealm.commitTransaction();
                tvTime.setText("Realm添加" + preferenceUtil.getRealmCount() +"条数据花了" + (System.currentTimeMillis()-addTime)+"毫秒");
                refreshData();

                break;
            case R.id.btn_delete:
                long deleteTime=System.currentTimeMillis();
                myRealm.deleteRealmObject();
                tvTime.setText("Realm删除" + preferenceUtil.getRealmCount() + "条数据花了" + (System.currentTimeMillis() - deleteTime) + "毫秒");
                refreshData();
                preferenceUtil.saveGreenDaoCount(0);
                break;
        }
    }

    public void getRealm() {
        myRealm = new RealmDBManager(this);
    }
}
