package com.spring.boot.dev.notes.service.impl;

import com.spring.boot.dev.notes.service.MockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MockServiceImpl implements MockService {
    @Override
    public void logUserId(Long id) {
        log.info("The user id: {}", id);
    }
}
