package com.koyuki.demo.dto.response;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerHistoryItemDto {

    private Long visitId;

    private LocalDate visitDate;

    private String desiredImage;

    private String styleName;

    private String colorName;

    private String treatmentMenu;
}
