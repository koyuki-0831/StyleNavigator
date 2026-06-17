package com.koyuki.demo.dto.request;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDto {

    @NotBlank(message = "顧客名は必須です")
    private String name;

    private String phone;

    private String email;

    private String memo;

    private String ageGroup;

}
