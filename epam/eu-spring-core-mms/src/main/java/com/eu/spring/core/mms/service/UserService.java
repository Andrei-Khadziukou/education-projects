package com.eu.spring.core.mms.service;

import com.eu.spring.core.mms.domain.User;

import java.util.List;

/**
 * The interface to define contract for actions which can be performed on {@link User}.
 *
 * @author Andrei Khadziukou
 */
public interface UserService {

    void register(User user);

    void remove(User user);

    User getById(String id);

    User findByNickname(String nickname);

    User findByEmail(String email);

    List<User> findByFullNamePart(String fullNamePart);

}
