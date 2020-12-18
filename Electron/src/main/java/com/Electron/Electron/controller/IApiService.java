package com.Electron.Electron.controller;

import com.Electron.Electron.model.User;

import java.util.Set;

public interface IApiService {
    void delete(Long id);
    User update(Long id,User user);
    User findUser(Long id);
    User findUser(User user);
    Iterable<User> findAll();
    User create(User user);
}
