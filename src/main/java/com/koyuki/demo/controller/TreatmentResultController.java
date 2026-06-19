package com.koyuki.demo.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.koyuki.demo.dto.request.TreatmentResultRequestDto;
import com.koyuki.demo.dto.response.TreatmentResultResponseDto;
import com.koyuki.demo.service.TreatmentResultService;

@RestController
public class TreatmentResultController {
	
	private final TreatmentResultService treatmentResultService;
	
	public TreatmentResultController(TreatmentResultService treatmentResultService) {
		this.treatmentResultService = treatmentResultService;
	}
	
	//施術結果登録
	@PostMapping("/visits/{visitId}/treatment-result")
	@ResponseStatus(HttpStatus.CREATED)
	public TreatmentResultResponseDto createTreatmentResult(
			@PathVariable Long visitId,
			@Valid @RequestBody TreatmentResultRequestDto requestDto) {
		
		return treatmentResultService.createTreatmentResult(visitId, requestDto);
	}
	
	//施術結果詳細取得
	@GetMapping("/treatment-result/{id}")
	public TreatmentResultResponseDto getTreatmentResultById(
			@PathVariable Long id) {
		
		return treatmentResultService.getTreatmentResultById(id);
	}
	
	//施術結果更新
	@PutMapping("/treatment-result/{id}")
	public TreatmentResultResponseDto updateTreatmentResult(
			@PathVariable Long id,
			@Valid @RequestBody TreatmentResultRequestDto requestDto) {
		
		return treatmentResultService.updateTreatmentResult(id, requestDto);
	}
	
	//施術結果削除
	@DeleteMapping("/treatment-result/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTreatmentRsult(
			@PathVariable Long id) {
		
		treatmentResultService.deleteTreatmentResult(id);
	}
}
