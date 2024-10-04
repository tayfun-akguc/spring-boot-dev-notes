package com.spring.boot.dev.notes.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
}
