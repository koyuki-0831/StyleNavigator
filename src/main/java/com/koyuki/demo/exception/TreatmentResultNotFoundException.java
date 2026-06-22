package com.koyuki.demo.exception;

public class TreatmentResultNotFoundException extends RuntimeException {
	
	public TreatmentResultNotFoundException(Long id) {
		super("施術結果が見つかりません。ID: " + id);
	}
}
