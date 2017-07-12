package com.example.revern.eventbustest;

import android.os.AsyncTask;

import com.example.revern.eventbustest.model.User;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Revern on 12.07.2017.
 */

public class UserUpdateTask extends AsyncTask <Void, Void, User> {

    String name;
    int age;

    public UserUpdateTask(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected User doInBackground(Void... voids) {
        return new User(name, age);
    }

    @Override
    protected void onPostExecute(User user) {
        EventBus.getDefault().post(new UserUpdatedEvent(user));
    }
}
