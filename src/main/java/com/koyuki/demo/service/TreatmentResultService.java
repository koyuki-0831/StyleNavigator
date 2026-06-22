package com.koyuki.demo.service;

import org.springframework.stereotype.Service;

import com.koyuki.demo.dto.request.TreatmentResultRequestDto;
import com.koyuki.demo.dto.response.TreatmentResultResponseDto;
import com.koyuki.demo.entity.TreatmentResult;
import com.koyuki.demo.entity.Visit;
import com.koyuki.demo.exception.TreatmentResultNotFoundException;
import com.koyuki.demo.exception.VisitNotFoundException;
import com.koyuki.demo.repository.TreatmentResultRepository;
import com.koyuki.demo.repository.VisitRepository;

@Service
public class TreatmentResultService {

    private final TreatmentResultRepository treatmentResultRepository;
    private final VisitRepository visitRepository;

    public TreatmentResultService(
            TreatmentResultRepository treatmentResultRepository,
            VisitRepository visitRepository) {
        this.treatmentResultRepository = treatmentResultRepository;
        this.visitRepository = visitRepository;
    }

    // 施術結果登録
    public TreatmentResultResponseDto createTreatmentResult(
            Long visitId,
            TreatmentResultRequestDto requestDto) {

    	Visit visit = visitRepository.findById(visitId)
    	        .orElseThrow(() -> new VisitNotFoundException(visitId));

        TreatmentResult treatmentResult = new TreatmentResult();

        treatmentResult.setVisit(visit);
        treatmentResult.setStyleName(requestDto.getStyleName());
        treatmentResult.setColorName(requestDto.getColorName());
        treatmentResult.setTreatmentMenu(requestDto.getTreatmentMenu());
        treatmentResult.setStylistComment(requestDto.getStylistComment());
        treatmentResult.setCustomerReaction(requestDto.getCustomerReaction());

        TreatmentResult savedResult = treatmentResultRepository.save(treatmentResult);

        return toResponseDto(savedResult);
    }

    // 施術結果詳細取得
    public TreatmentResultResponseDto getTreatmentResultById(Long id) {
    	TreatmentResult treatmentResult = treatmentResultRepository.findById(id)
    	        .orElseThrow(() -> new TreatmentResultNotFoundException(id));

        return toResponseDto(treatmentResult);
    }

    // 施術結果更新
    public TreatmentResultResponseDto updateTreatmentResult(
            Long id,
            TreatmentResultRequestDto requestDto) {

    	TreatmentResult treatmentResult = treatmentResultRepository.findById(id)
    	        .orElseThrow(() -> new TreatmentResultNotFoundException(id));

        treatmentResult.setStyleName(requestDto.getStyleName());
        treatmentResult.setColorName(requestDto.getColorName());
        treatmentResult.setTreatmentMenu(requestDto.getTreatmentMenu());
        treatmentResult.setStylistComment(requestDto.getStylistComment());
        treatmentResult.setCustomerReaction(requestDto.getCustomerReaction());

        TreatmentResult updatedResult = treatmentResultRepository.save(treatmentResult);

        return toResponseDto(updatedResult);
    }

    // 施術結果削除
    public void deleteTreatmentResult(Long id) {
    	if (!treatmentResultRepository.existsById(id)) {
    	    throw new TreatmentResultNotFoundException(id);
        }

        treatmentResultRepository.deleteById(id);
    }

    // Entity → ResponseDto 変換
    private TreatmentResultResponseDto toResponseDto(TreatmentResult treatmentResult) {
        TreatmentResultResponseDto responseDto = new TreatmentResultResponseDto();

        responseDto.setId(treatmentResult.getId());
        responseDto.setVisitId(treatmentResult.getVisit().getId());
        responseDto.setStyleName(treatmentResult.getStyleName());
        responseDto.setColorName(treatmentResult.getColorName());
        responseDto.setTreatmentMenu(treatmentResult.getTreatmentMenu());
        responseDto.setStylistComment(treatmentResult.getStylistComment());
        responseDto.setCustomerReaction(treatmentResult.getCustomerReaction());
        responseDto.setCreatedAt(treatmentResult.getCreatedAt());
        responseDto.setUpdatedAt(treatmentResult.getUpdatedAt());

        return responseDto;
    }
}