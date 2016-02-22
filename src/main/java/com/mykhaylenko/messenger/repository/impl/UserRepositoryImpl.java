package com.mykhaylenko.messenger.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**Hibernate implementation of user repository with use of {@link SessionFactory}
 * Created by pavlo.mykhaylenko on 8/26/2015.
 */
@Repository
public class UserRepositoryImpl {//implements UserRepository {

//    @Autowired
//    private SessionFactory sessionFactory;

//    @Override
//    public User save(User user) {
//        Serializable id = getCurrentSession().save(user);
//
//        return new User((long) id, user.getUsername(), user.getEmail(), user.getPassword());
//    }
//
//    private Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//    }
}
