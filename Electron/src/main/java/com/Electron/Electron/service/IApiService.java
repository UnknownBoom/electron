package com.Electron.Electron.service;

import com.Electron.Electron.model.User;

import java.util.Set;

public interface IApiService {
    void delete(Long id);
    User update(Long id,User user);
    User findUser(Long id);
    User findUser(User user);
    User findUser(String username);
    Iterable<User> findAll();
    User create(User user);
}
