package com.koyuki.demo.controller;

import java.util.List;

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

import com.koyuki.demo.dto.request.VisitRequestDto;
import com.koyuki.demo.dto.response.VisitResponseDto;
import com.koyuki.demo.service.VisitService;

@RestController
public class VisitController {
	
	private final VisitService visitService;
	
	public VisitController(VisitService visitService) {
		this.visitService = visitService;
	}
	
	//来店記録登録
	@PostMapping("/customers/{customerId}/visits")
	@ResponseStatus(HttpStatus.CREATED)
	public VisitResponseDto createVisit(
			@PathVariable Long customerId,
			@Valid @RequestBody VisitRequestDto requestDto) {
		
		return visitService.createVisit(customerId, requestDto);
	}
	
	// 顧客ごとの来店記録一覧取得
    @GetMapping("/customers/{customerId}/visits")
    public List<VisitResponseDto> getVisitsByCustomerId(@PathVariable Long customerId) {
        return visitService.getVisitsByCustomerId(customerId);
    }

    // 来店記録詳細取得
    @GetMapping("/visits/{id}")
    public VisitResponseDto getVisitById(@PathVariable Long id) {
        return visitService.getVisitById(id);
    }

    // 来店記録更新
    @PutMapping("/visits/{id}")
    public VisitResponseDto updateVisit(
            @PathVariable Long id,
            @Valid @RequestBody VisitRequestDto requestDto) {

        return visitService.updateVisit(id, requestDto);
    }

    // 来店記録削除
    @DeleteMapping("/visits/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVisit(@PathVariable Long id) {
        visitService.deleteVisit(id);
    }
}
