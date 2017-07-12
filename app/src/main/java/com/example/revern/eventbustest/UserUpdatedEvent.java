package com.example.revern.eventbustest;

import com.example.revern.eventbustest.model.User;

/**
 * Created by Revern on 12.07.2017.
 */

public class UserUpdatedEvent {

    private User user;

    public UserUpdatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
