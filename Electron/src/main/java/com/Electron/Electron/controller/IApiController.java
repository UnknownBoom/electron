package com.Electron.Electron.controller;

import com.Electron.Electron.model.User;

import java.util.Set;

public interface IApiController {
    void delete(Long id);
    User findUser(Long id);
    User findUser(User user);
    Iterable<User> findAll();
    User update(Long id,User user);
    User create(User user);
}
