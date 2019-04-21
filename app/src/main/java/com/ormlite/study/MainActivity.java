package com.ormlite.study;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button addButton;
    private Button updateButton;
    private Button queryButton;
    private Button queryAll;
    private Button queryBuilder2;

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userDao = new UserDao(this);

        addButton  =(Button)this.findViewById(R.id.button);
        updateButton = (Button) this.findViewById(R.id.button2);
        queryButton = (Button) this.findViewById(R.id.button3);
        queryAll = (Button) this.findViewById(R.id.button_queryAll);
        queryBuilder2 = (Button) this.findViewById(R.id.button_QueryBuilder2);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setName("张三");
                user.setDesc("北京人");

                userDao.addUser(user);
                userDao.addUser(new User("jack","湖北人"));
                userDao.addUser(new User("tom","湖南人"));
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user =  new User();
                user.setId(1);
                user.setName("张学友");
                user.setDesc("Hong Kong");
                userDao.updateUser(user);
            }
        });

        /**
         * 查询按钮
         */
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> list = userDao.queryBuilder_1("张学友");
                Log.e(TAG, "onClick: " + list.toString());
            }
        });

        queryAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> list = userDao.listAll();
                Log.e(TAG, "listAll: "+list.toString() );
            }
        });

        queryBuilder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> list = userDao.queryBuilder_2();
                Log.e(TAG, "queryBuilder_2: " + list.toString());
            }
        });

    }


}
