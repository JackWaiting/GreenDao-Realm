package com.example.administrator.jackwaiting_greendao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.jackwaiting_greendao.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btnGoGreenDao;
    private Button btnGoReaml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoGreenDao = (Button) findViewById(R.id.btn_go_greendao);
        btnGoReaml = (Button) findViewById(R.id.btn_go_realm);

        btnGoGreenDao.setOnClickListener(this);
        btnGoReaml.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_go_greendao:
                startActivity(new Intent(MainActivity.this,GreenDaoActivity.class));
                break;
            case R.id.btn_go_realm:
                startActivity(new Intent(MainActivity.this,RealmActivity.class));
                break;
        }

    }
}
