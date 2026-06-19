package com.koyuki.demo.dto.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreatmentResultResponseDto {

    private Long id;

    private Long visitId;

    private String styleName;

    private String colorName;

    private String treatmentMenu;

    private String stylistComment;

    private String customerReaction;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
