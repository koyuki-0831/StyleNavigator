package com.koyuki.demo.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitRequestDto {
	
	@NotNull(message = "来店日必須です")
	private LocalDate visitDate;
	
	private String hairLength;
	
	private String hairTexture;
	
	private String hairVolime;
	
	private String desiredImage;
	
	private String concerns;
	
	private String memo;
}
