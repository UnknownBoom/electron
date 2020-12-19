package com.Electron.Electron.service;

import com.Electron.Electron.Exception.BadRequest;
import com.Electron.Electron.model.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrateService implements IRegistrateService{
    private final IApiService apiService;
    private final IValidateService validateService;

    public RegistrateService(IApiService apiService, IValidateService validateService) {
        this.apiService = apiService;
        this.validateService = validateService;
    }

    @Override
    public User registrate(User user) {
        if(user==null) throw new BadRequest("User is null");
        if(validateService.validateUser(user)){
            if(apiService.findUser(user.getUsername())!=null) throw new BadRequest("User already exists");
            return apiService.create(user);
        }
        throw new BadRequest("validation failed");

    }
}
