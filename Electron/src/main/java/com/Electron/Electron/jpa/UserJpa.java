package com.Electron.Electron.jpa;

import com.Electron.Electron.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
