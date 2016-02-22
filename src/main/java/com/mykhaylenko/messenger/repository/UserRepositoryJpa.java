package com.mykhaylenko.messenger.repository;

import com.mykhaylenko.messenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pavlo.mykhaylenko on 8/28/2015.
 */
public interface UserRepositoryJpa extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
