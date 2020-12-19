package com.Electron.Electron.service;

import com.Electron.Electron.model.User;
import org.springframework.stereotype.Service;

@Service
public class ValidateService implements IValidateService {

    public boolean validateUser(User user){
        if(user == null) return false;
        if(user.getUsername()==null || user.getUsername().isEmpty()) return false;
        if(user.getPassword()==null || user.getPassword().isEmpty()) return false;
        return true;
    }
}
