package ua.mainacademy.exception;

public class MyException extends RuntimeException{
	
	public MyException(String message){
		super(message);
	}
	
	@Override
	public  String getMessage() {
		return super.getMessage();
	}
}
