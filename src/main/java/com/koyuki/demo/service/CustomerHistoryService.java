package com.koyuki.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koyuki.demo.dto.response.CustomerHistoryItemDto;
import com.koyuki.demo.dto.response.CustomerHistoryResponseDto;
import com.koyuki.demo.entity.Customer;
import com.koyuki.demo.entity.Visit;
import com.koyuki.demo.repository.CustomerRepository;
import com.koyuki.demo.repository.TreatmentResultRepository;
import com.koyuki.demo.repository.VisitRepository;

@Service
public class CustomerHistoryService {

    private final CustomerRepository customerRepository;
    private final VisitRepository visitRepository;
    private final TreatmentResultRepository treatmentResultRepository;

    public CustomerHistoryService(
            CustomerRepository customerRepository,
            VisitRepository visitRepository,
            TreatmentResultRepository treatmentResultRepository) {
        this.customerRepository = customerRepository;
        this.visitRepository = visitRepository;
        this.treatmentResultRepository = treatmentResultRepository;
    }

    public CustomerHistoryResponseDto getCustomerHistory(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("顧客が見つかりません"));

        List<Visit> visits = visitRepository.findByCustomerId(customerId);

        List<CustomerHistoryItemDto> historyItems = visits.stream()
                .map(visit -> {
                    CustomerHistoryItemDto item = new CustomerHistoryItemDto();

                    item.setVisitId(visit.getId());
                    item.setVisitDate(visit.getVisitDate());
                    item.setDesiredImage(visit.getDesiredImage());

                    treatmentResultRepository.findByVisitId(visit.getId())
                            .ifPresent(treatmentResult -> {
                                item.setStyleName(treatmentResult.getStyleName());
                                item.setColorName(treatmentResult.getColorName());
                                item.setTreatmentMenu(treatmentResult.getTreatmentMenu());
                            });

                    return item;
                })
                .toList();

        CustomerHistoryResponseDto responseDto = new CustomerHistoryResponseDto();
        responseDto.setCustomerId(customer.getId());
        responseDto.setCustomerName(customer.getName());
        responseDto.setVisitHistory(historyItems);

        return responseDto;
    }
}
