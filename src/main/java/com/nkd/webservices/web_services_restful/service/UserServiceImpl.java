package com.nkd.webservices.web_services_restful.service;

import com.nkd.webservices.web_services_restful.Exception.UserException;
import com.nkd.webservices.web_services_restful.entity.User;
import com.nkd.webservices.web_services_restful.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new UserException("user not found "+ id)));
        return optionalUser;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new UserException("User with id " + user.getId() + " not found");
        }
        return userRepository.save(user);
    }
}
