package com.koyuki.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koyuki.demo.dto.request.VisitRequestDto;
import com.koyuki.demo.dto.response.VisitResponseDto;
import com.koyuki.demo.entity.Customer;
import com.koyuki.demo.entity.Visit;
import com.koyuki.demo.exception.CustomerNotFoundException;
import com.koyuki.demo.exception.VisitNotFoundException;
import com.koyuki.demo.repository.CustomerRepository;
import com.koyuki.demo.repository.VisitRepository;

@Service
public class VisitService {
	
	private final VisitRepository visitRepository;
	private final CustomerRepository customerRepository;
	
	public VisitService(VisitRepository visitRepository, CustomerRepository customerRepository) {
		this.visitRepository = visitRepository;
		this.customerRepository = customerRepository;
	}
	
	//来店記録登録
	public VisitResponseDto createVisit(Long customerId, VisitRequestDto requestDto) {
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException(customerId));
		
		Visit visit = new Visit();
		
		visit.setCustomer(customer);
		visit.setVisitDate(requestDto.getVisitDate());
		visit.setHairLength(requestDto.getHairLength());
		visit.setHairTexture(requestDto.getHairTexture());
		visit.setHairVolime(requestDto.getHairVolime());
		visit.setDesiredImage(requestDto.getDesiredImage());
		visit.setConcerns(requestDto.getConcerns());
		visit.setMemo(requestDto.getMemo());
		
		Visit savedVisit = visitRepository.save(visit);
		
		return toResponseDto(savedVisit);
	}
	
	//顧客ごとの来店記録一覧取得
	public List<VisitResponseDto> getVisitsByCustomerId(Long customerId) {
		if (!customerRepository.existsById(customerId)) {
			throw new CustomerNotFoundException(customerId);
		}
		
		return visitRepository.findByCustomerId(customerId)
				.stream()
				.map(this::toResponseDto)
				.toList();
	}
	
	//来店記録詳細取得
	public VisitResponseDto getVisitById(Long id) {
		Visit visit = visitRepository.findById(id)
				.orElseThrow(() -> new VisitNotFoundException(id));
		
		return toResponseDto(visit);
	}
	
	//来店記録更新
	public VisitResponseDto updateVisit(Long id, VisitRequestDto requestDto) {
		Visit visit = visitRepository.findById(id)
				.orElseThrow(() -> new VisitNotFoundException(id));
		
		visit.setVisitDate(requestDto.getVisitDate());
		visit.setHairLength(requestDto.getHairLength());
		visit.setHairTexture(requestDto.getHairTexture());
		visit.setHairVolime(requestDto.getHairVolime());
		visit.setDesiredImage(requestDto.getDesiredImage());
		visit.setConcerns(requestDto.getConcerns());
		visit.setMemo(requestDto.getMemo());
		
		Visit updatedVisit = visitRepository.save(visit);
		
		return toResponseDto(updatedVisit);
	}
	
	//来店記録削除
	public void deleteVisit(Long id) {
		if(!visitRepository.existsById(id)) {
			throw new VisitNotFoundException(id);
		}
		
		visitRepository.deleteById(id);
	}
	
	//Entity → ResponseDto 変換
	private VisitResponseDto toResponseDto(Visit visit) {
		VisitResponseDto responseDto = new VisitResponseDto();
		
		responseDto.setId(visit.getId());
		responseDto.setCustomerId(visit.getCustomer().getId());
		responseDto.setCustomerName(visit.getCustomer().getName());
		responseDto.setVisitDate(visit.getVisitDate());
		responseDto.setHairLength(visit.getHairLength());
		responseDto.setHairTexture(visit.getHairTexture());
		responseDto.setHairVolime(visit.getHairVolime());
		responseDto.setDesiredImage(visit.getDesiredImage());
		responseDto.setConcerns(visit.getConcerns());
		responseDto.setMemo(visit.getMemo());
		responseDto.setCreatedAt(visit.getCreatedAt());
		responseDto.setUpdatedAt(visit.getUpdatedAt());
		
		return responseDto;
	}

}
