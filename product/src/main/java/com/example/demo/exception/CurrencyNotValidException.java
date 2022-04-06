package com.example.demo.exception;

public class CurrencyNotValidException extends RuntimeException
{
	public CurrencyNotValidException(String s)
	{
		super(s);
	}

}
