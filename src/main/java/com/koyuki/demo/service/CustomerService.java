package com.koyuki.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koyuki.demo.dto.request.CustomerRequestDto;
import com.koyuki.demo.dto.response.CustomerResponseDto;
import com.koyuki.demo.entity.Customer;
import com.koyuki.demo.exception.CustomerNotFoundException;
import com.koyuki.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 顧客登録
    public CustomerResponseDto createCustomer(CustomerRequestDto requestDto) {
        Customer customer = new Customer();

        customer.setName(requestDto.getName());
        customer.setPhone(requestDto.getPhone());
        customer.setEmail(requestDto.getEmail());
        customer.setMemo(requestDto.getMemo());
        customer.setAgeGroup(requestDto.getAgeGroup());

        Customer savedCustomer = customerRepository.save(customer);

        return toResponseDto(savedCustomer);
    }

    // 顧客一覧取得
    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    // 顧客詳細取得
    public CustomerResponseDto getCustomerById(Long id) {
    	Customer customer = customerRepository.findById(id)
    	        .orElseThrow(() -> new CustomerNotFoundException(id));

        return toResponseDto(customer);
    }

    // 顧客更新
    public CustomerResponseDto updateCustomer(Long id, CustomerRequestDto requestDto) {
    	Customer customer = customerRepository.findById(id)
    	        .orElseThrow(() -> new CustomerNotFoundException(id));

        customer.setName(requestDto.getName());
        customer.setPhone(requestDto.getPhone());
        customer.setEmail(requestDto.getEmail());
        customer.setMemo(requestDto.getMemo());
        customer.setAgeGroup(requestDto.getAgeGroup());

        Customer updatedCustomer = customerRepository.save(customer);

        return toResponseDto(updatedCustomer);
    }

    // 顧客削除
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }

        customerRepository.deleteById(id);
    }

    // Entity → ResponseDto に変換
    private CustomerResponseDto toResponseDto(Customer customer) {
        CustomerResponseDto responseDto = new CustomerResponseDto();

        responseDto.setId(customer.getId());
        responseDto.setName(customer.getName());
        responseDto.setPhone(customer.getPhone());
        responseDto.setEmail(customer.getEmail());
        responseDto.setMemo(customer.getMemo());
        responseDto.setAgeGroup(customer.getAgeGroup());
        responseDto.setCreatedAt(customer.getCreatedAt());
        responseDto.setUpdatedAt(customer.getUpdatedAt());

        return responseDto;
    }
}