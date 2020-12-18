package com.Electron.Electron.controller;

import com.Electron.Electron.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("api")
public class ApiController implements IApiController{

    private final IApiService apiService;

    public ApiController(IApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        apiService.delete(id);
    }

    @Override
    @GetMapping("{id}")
    public User findUser(@PathVariable Long id) {
        return apiService.findUser(id);
    }


    @Override
    @GetMapping
    public User findUser(@RequestBody User user) {
        return apiService.findUser(user);
    }

    @Override
    @GetMapping("/all")
    public Iterable<User> findAll() {
        return apiService.findAll();
    }

    @Override
    @PutMapping("{id}")
    public User update(@PathVariable Long id,@RequestBody User user) {
        return apiService.update(id,user);
    }

    @Override
    @PostMapping
    public User create(@RequestBody User user) {
        return apiService.create(user);
    }
}
