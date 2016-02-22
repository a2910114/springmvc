package com.mykhaylenko.messenger.database;

import com.mykhaylenko.messenger.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pavlo.mykhaylenko on 8/14/2015.
 */
@Component
public class UserTable {

    private List<User> users = new ArrayList<>();

    public UserTable() {
        this.users.add(new User("user1", "user1@email.com", "password"));
        this.users.add(new User("user2", "user2@email.com", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8"));
        this.users.add(new User("user3", "user3@email.com", "password"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
