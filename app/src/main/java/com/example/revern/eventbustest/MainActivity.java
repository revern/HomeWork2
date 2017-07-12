package com.example.revern.eventbustest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.revern.eventbustest.model.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView uiUserName;
    TextView uiUserAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiUserName = (TextView) findViewById(R.id.user_name);
        uiUserAge = (TextView) findViewById(R.id.user_age);

        EventBus.getDefault().register(this);

        UserUpdateTask task = new UserUpdateTask("Ivan", 20);
        task.execute();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(UserUpdatedEvent event) {
        User user = event.getUser();

        uiUserName.setText("User name is " + user.getName());
        uiUserAge.setText("User is " + user.getAge() + " years old");
    }

//    @Subscribe(threadMode = ThreadMode.ASYNC)
//    public void onEvent(TestEvent event){
//
//    }

}
