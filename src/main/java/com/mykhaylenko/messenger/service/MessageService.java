package com.mykhaylenko.messenger.service;

import com.mykhaylenko.messenger.model.Message;

import java.util.List;

/**
 * Created by pavlo.mykhaylenko on 8/13/2015.
 */
public interface MessageService {

    List<Message> findMessages(int max, int count);

    List<Message> findAllMessages();

    Message findOneById(int id);

}
