package com.koyuki.demo.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitResponseDto {
	
	private Long id;
	
	private Long customerId;
	
	private String customerName;
	
	private LocalDate visitDate;
	
	private String hairLength;
	
	private String hairTexture;
	
	private String hairVolime;
	
	private String desiredImage;
	
	private String concerns;
	
	private String memo;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
}
