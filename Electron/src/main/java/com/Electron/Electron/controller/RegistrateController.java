package com.Electron.Electron.controller;

import com.Electron.Electron.model.User;
import com.Electron.Electron.service.IRegistrateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration")
public class RegistrateController implements IRegistrateController{
    private final IRegistrateService registrateService;

    public RegistrateController(IRegistrateService registrateService) {
        this.registrateService = registrateService;
    }

    @Override
    @PostMapping
    public User create(@RequestBody User user) {
        return registrateService.registrate(user);
    }
}
