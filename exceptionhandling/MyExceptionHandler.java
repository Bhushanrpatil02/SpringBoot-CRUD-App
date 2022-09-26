package com.yash.demo.exceptionhandling;

import java.net.http.HttpHeaders;

import com.yash.demo.exception.StudentNotFoundException;

@ControllerAdvice
public class MyExceptionHandler<WebRequest> extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> studentNotFound(){
		return new ResponseEntity<String>("Student Record Not Found",HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>("Method Not Supported",HttpStatus.METHOD_NOT_ALLOWED);
	}
}