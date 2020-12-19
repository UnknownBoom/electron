package com.Electron.Electron.controller;

import com.Electron.Electron.model.User;
import com.Electron.Electron.service.IAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController implements IAuthController{

    private final IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @Override
    @PostMapping
    public User auth(@RequestBody User user) {
        return authService.auth(user);
    }
}
