package com.koyuki.demo.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDto {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private String memo;

    private String ageGroup;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}