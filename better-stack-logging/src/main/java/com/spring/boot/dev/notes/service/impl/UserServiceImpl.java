package com.spring.boot.dev.notes.service.impl;

import com.github.javafaker.Faker;
import com.spring.boot.dev.notes.dto.UserDto;
import com.spring.boot.dev.notes.service.MockService;
import com.spring.boot.dev.notes.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Faker faker = new Faker();
    private final MockService mockService;

    @Override
    public UserDto getUserById(Long id) {
        if (id == 0) {
            log.error("Invalid user id provided. userId: {}", id);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (id % 2 == 0) {
            log.warn("User not found. userId: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var user = UserDto.builder()
                .id(id)
                .email(faker.internet().emailAddress())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .build();
        log.info("User found! userId: {}{}", user.getId(), user.toJson());
        mockService.logUserId(id);
        return user;
    }
}
