package com.koyuki.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreatmentResultRequestDto {

    private String styleName;

    private String colorName;

    private String treatmentMenu;

    private String stylistComment;

    private String customerReaction;
}