package com.nkd.webservices.web_services_restful.service;

import com.nkd.webservices.web_services_restful.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    Optional<User> getUserById(Long id);

    void deleteUser(Long id);

    User updateUser(Long id, User user);
}
