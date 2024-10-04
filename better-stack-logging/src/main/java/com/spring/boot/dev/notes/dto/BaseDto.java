package com.spring.boot.dev.notes.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseDto {
    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException jsonProcessingException) {
            return "{}";
        }
    }
}
