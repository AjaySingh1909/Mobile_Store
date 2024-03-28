package com.sopra.MobileStore.Exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileException {
	String msg;
	Throwable cause;
	HttpStatus code;
	
	

}
