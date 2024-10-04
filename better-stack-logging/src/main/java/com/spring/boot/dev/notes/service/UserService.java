package com.spring.boot.dev.notes.service;

import com.spring.boot.dev.notes.dto.UserDto;

public interface UserService {
    UserDto getUserById(Long id);
}
