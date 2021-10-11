package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * Let's say that we've created a business exception of some sort. We can actually directly
 * annotate the exception that we have created using Spring web annotations.
 * 
 * The annotation that we can use directly on the class is called @ResponseStatus.
 */

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="Sorry. We can't complete your request as it was sent.")
public class BusinessException extends RuntimeException{

}
