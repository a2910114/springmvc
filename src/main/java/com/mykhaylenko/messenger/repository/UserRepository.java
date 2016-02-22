package com.mykhaylenko.messenger.repository;

import com.mykhaylenko.messenger.model.User;

/**
 * Created by pavlo.mykhaylenko on 8/26/2015.
 */
public interface UserRepository {

    User save(User user);
}
