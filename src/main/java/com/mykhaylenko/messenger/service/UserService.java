package com.mykhaylenko.messenger.service;

import com.mykhaylenko.messenger.model.User;

/**
 * Created by pavlo.mykhaylenko on 8/14/2015.
 */
public interface UserService {

    User save(User user);

    User findByUserName(String username);
}
