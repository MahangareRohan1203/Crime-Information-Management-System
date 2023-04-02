package com.police.exceptions;

public class NoRecordFound extends Exception {

	public NoRecordFound(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
