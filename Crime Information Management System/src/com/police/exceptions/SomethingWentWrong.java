package com.police.exceptions;

public class SomethingWentWrong extends Exception {


	public SomethingWentWrong(String x) {
		// TODO Auto-generated constructor stub
		super(x);
	}

	@Override
	public String toString() {
		return "Some thing went wrong, try again later";
	}
}
