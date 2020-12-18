package com.Electron.Electron.controller;

import com.Electron.Electron.Exception.BadRequest;
import com.Electron.Electron.jpa.UserJpa;
import com.Electron.Electron.model.Role;
import com.Electron.Electron.model.RoleEnum;
import com.Electron.Electron.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class ApiService implements IApiService{
    @Autowired
    private UserJpa userJpa;
    @Override
    public void delete(Long id) {
        Optional<User> userById = userJpa.findById(id);
        if(userById.isEmpty()) throw new BadRequest("No user found");
        userJpa.delete(userById.get());
    }

    @Override
    public User update(Long id,User user) {
        User userById = userJpa.findById(id).orElse(null);
        if(userById==null) throw new BadRequest("No user found");
        if(user.getUsername()==null || user.getUsername().isEmpty()){
            throw new BadRequest("Username is empty");
        }
        userById.setUsername(user.getUsername());
        if(user.getPassword() !=null){
            if(user.getPassword().isEmpty()) throw new BadRequest("Password is empty");
            userById.setPassword(user.getPassword());
        }
        if(user.getId()!=null){
            if(!user.getId().equals(id)) throw new BadRequest("Id is not equal");
        }

        if(user.getRoles()!=null){
            userById.setRoles(user.getRoles());
        }

        return userJpa.save(userById);
    }

    @Override
    public User findUser(Long id) {
        return userJpa.findById(id).orElse(null);
    }

    @Override
    public User findUser(User user) {
        if(user == null || user.getUsername().isEmpty() || user.getUsername() == null)
            throw new BadRequest("username is empty");
        return userJpa.findByUsername(user.getUsername());
    }

    @Override
    public Iterable<User> findAll() {
        return userJpa.findAll();
    }

    @Override
    public User create(User user) {
        if(user.getUsername()==null || user.getUsername().isEmpty()) throw new BadRequest("Username is empty");
        if(user.getPassword()==null || user.getPassword().isEmpty()) throw new BadRequest("Password is empty");
        User userByUsername = userJpa.findByUsername(user.getUsername());
        if(userByUsername!=null) throw new BadRequest("User already exists");
        if(user.getRoles()==null) user.setRoles(Collections.singleton(new Role(RoleEnum.USER)));
        return userJpa.save(user);
    }
}
