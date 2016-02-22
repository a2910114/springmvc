package com.mykhaylenko.messenger.service.impl;

import com.mykhaylenko.messenger.database.UserTable;
import com.mykhaylenko.messenger.model.User;
import com.mykhaylenko.messenger.repository.UserRepositoryJpa;
import com.mykhaylenko.messenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pavlo.mykhaylenko on 8/14/2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserTable userTable;

//    @Autowired
//    private UserRepository userRepository;

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    //    @Override
    //    public User save(User user) {
    //        if (user != null) {
    //            userTable.getUsers().add(user);
    //        }
    //
    //        return user;
    //    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepositoryJpa.save(user);
    }

    @Override
    public User findByUserName(String username) {
        if (username != null) {
            return getUser(username);
        }

        return null;
    }

    private User getUser(String username) {
        for (User user : userTable.getUsers()) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }
}
