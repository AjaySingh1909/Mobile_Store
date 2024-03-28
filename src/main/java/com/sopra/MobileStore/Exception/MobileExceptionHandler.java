package com.sopra.MobileStore.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MobileExceptionHandler {
	
	@ExceptionHandler(value= {MobileNotFoundException.class})
	public ResponseEntity<Object> exception1(MobileNotFoundException m){
		MobileException me=new MobileException(m.getMessage(),m.getCause(), HttpStatus.NOT_FOUND);
		
//		me.getMsg();
//		me.getCause();
		//me.getCode();
		
		
		return new ResponseEntity<Object>(me, HttpStatus.NOT_FOUND) ;
	}
}
