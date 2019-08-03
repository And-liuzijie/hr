package com.briup.util.exception;

public class DataAccessException extends Exception{
	private static final long serialVersionUID = 1L;
	public DataAccessException(String msg) {
		super(msg);
	}
	public DataAccessException(Throwable e) {
		super(e);
	}
	public DataAccessException(String msg,Throwable e) {
		super(msg, e);
	}
}
