package com.koyuki.demo.exception;

public class VisitNotFoundException extends RuntimeException {

	public VisitNotFoundException(Long id) {
		super("来店記録が見つかりません。ID: " + id);
	}
}
