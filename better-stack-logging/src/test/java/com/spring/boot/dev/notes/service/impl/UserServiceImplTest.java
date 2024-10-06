package com.spring.boot.dev.notes.service.impl;

import com.spring.boot.dev.notes.service.MockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private MockService mockService;

    @Test
    void getUserById_whenUserIdIsZero_thenThrowBadRequest() {
        var userId = 0L;

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> userService.getUserById(userId));

        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        verify(mockService, never()).logUserId(anyLong());
    }
}
