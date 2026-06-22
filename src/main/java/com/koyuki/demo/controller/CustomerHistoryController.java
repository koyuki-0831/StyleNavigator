package com.koyuki.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.koyuki.demo.dto.response.CustomerHistoryResponseDto;
import com.koyuki.demo.service.CustomerHistoryService;

@RestController
public class CustomerHistoryController {

    private final CustomerHistoryService customerHistoryService;

    public CustomerHistoryController(CustomerHistoryService customerHistoryService) {
        this.customerHistoryService = customerHistoryService;
    }

    @GetMapping("/customers/{customerId}/history")
    public CustomerHistoryResponseDto getCustomerHistory(
            @PathVariable Long customerId) {

        return customerHistoryService.getCustomerHistory(customerId);
    }
}
