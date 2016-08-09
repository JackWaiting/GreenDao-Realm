package com.example.administrator.jackwaiting_greendao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.jackwaiting_greendao.R;
import com.example.administrator.jackwaiting_greendao.adapter.GreenDaoListAdapter;
import com.example.administrator.jackwaiting_greendao.db.DBManager;
import com.example.administrator.jackwaiting_greendao.been.User;
import com.example.administrator.jackwaiting_greendao.util.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

public class GreenDaoActivity extends Activity implements View.OnClickListener{

    private ListView lvUser;
    private DBManager greenDaoHelper;
    private List<User> users;
    private TextView tvTime;
    private Button btnAdd,btnDelete;
    private int maxCount = 0;
    private EditText ediMaxCount;
    private PreferenceUtil preferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);

        initView();
        getGreenDaoHelper();
        initData();
        long seleteTime=System.currentTimeMillis();
        refreshData();
        tvTime.setText("GreenDao查询" + preferenceUtil.getGreenDaoCount() + "条数据花了" + (System.currentTimeMillis() - seleteTime) + "毫秒");
    }

    private void refreshData() {
        lvUser.setAdapter(new GreenDaoListAdapter(this, greenDaoHelper.getUserAll()));
    }

    private void initData() {
        users = new ArrayList<User>();
        users.clear();
        for (int i= 0;i< maxCount;i++){
            User user = new User();
            user.setId(i);
            user.setName("JackWaiting"+i);
            user.setAge(i);
            users.add(user);
        }
    }

    private void initView() {
        preferenceUtil = PreferenceUtil.getIntance(this);
        lvUser = (ListView) findViewById(R.id.lv_user);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        tvTime = (TextView) findViewById(R.id.tv_time);
        ediMaxCount = (EditText) findViewById(R.id.edi_maxCount);
    }

    public void getGreenDaoHelper() {
        greenDaoHelper= new DBManager(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                greenDaoHelper.deleteAll();

                maxCount= Integer.parseInt(ediMaxCount.getText().toString());
                preferenceUtil.saveGreenDaoCount(maxCount);
                initData();
                long addTime=System.currentTimeMillis();
                for (int i= 0;i<maxCount;i++){
                   greenDaoHelper.insertUser(users.get(i));
                }
                tvTime.setText("GreenDao添加" + preferenceUtil.getGreenDaoCount()+"条数据花了" + (System.currentTimeMillis()-addTime)+"毫秒");
                refreshData();

                break;
            case R.id.btn_delete:
                long deleteTime=System.currentTimeMillis();
                greenDaoHelper.deleteAll();
                tvTime.setText("GreenDao删除" + preferenceUtil.getGreenDaoCount() + "条数据花了" + (System.currentTimeMillis() - deleteTime) + "毫秒");
                refreshData();
                preferenceUtil.saveGreenDaoCount(0);
                break;
        }
    }
}
