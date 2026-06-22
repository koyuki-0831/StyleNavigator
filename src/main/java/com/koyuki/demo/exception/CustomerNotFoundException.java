package com.koyuki.demo.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(Long id) {
		super("顧客が見つかりません。ID: " + id);
	}
}
