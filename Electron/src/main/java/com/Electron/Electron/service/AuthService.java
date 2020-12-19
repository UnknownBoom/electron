package com.Electron.Electron.service;

import com.Electron.Electron.Exception.BadRequest;
import com.Electron.Electron.Exception.NotFoundException;
import com.Electron.Electron.jpa.UserJpa;
import com.Electron.Electron.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    private final IApiService apiService;
    private final IValidateService validateService;

    public AuthService(IApiService apiService, IValidateService validateService) {
        this.apiService = apiService;
        this.validateService = validateService;
    }
    public boolean checkUser(User userFromDb,User user){
        if(userFromDb.getUsername().equals(user.getUsername())
                && userFromDb.getPassword().equals(user.getPassword())) return true;
        return false;
    }

    @Override
    public User auth(User user) {
        if(!validateService.validateUser(user)) throw new BadRequest("validation failed");
        User userByUsername = apiService.findUser(user);
        if(userByUsername==null) throw new NotFoundException("User not exists");
        if(checkUser(userByUsername,user)) throw new BadRequest("Validation failed");
        return userByUsername;
    }
}
