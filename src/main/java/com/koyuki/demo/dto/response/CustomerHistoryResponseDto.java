package com.koyuki.demo.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerHistoryResponseDto {

    private Long customerId;

    private String customerName;

    private List<CustomerHistoryItemDto> visitHistory;
}