package com.masaischool.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<ErrorDetail> noOrderFound(CategoryNotFoundException cnf,WebRequest wr){
		
		ErrorDetail eDetail = ErrorDetail.builder().messageString(cnf.getMessage()).localDate(LocalDateTime.now()).uriString(wr.getDescription(false)).build();
		return new ResponseEntity<>(eDetail,HttpStatus.OK);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorDetail> noOrderFound(OrderNotFoundException cnf,WebRequest wr){
		
		ErrorDetail eDetail = ErrorDetail.builder().messageString(cnf.getMessage()).localDate(LocalDateTime.now()).uriString(wr.getDescription(false)).build();
		return new ResponseEntity<>(eDetail,HttpStatus.OK);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetail> noProductFound(ProductNotFoundException cnf,WebRequest wr){
		
		ErrorDetail eDetail = ErrorDetail.builder().messageString(cnf.getMessage()).localDate(LocalDateTime.now()).uriString(wr.getDescription(false)).build();
		return new ResponseEntity<>(eDetail,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<ErrorDetail> noRoleFound(RoleNotFoundException cnf,WebRequest wr){
		
		ErrorDetail eDetail = ErrorDetail.builder().messageString(cnf.getMessage()).localDate(LocalDateTime.now()).uriString(wr.getDescription(false)).build();
		return new ResponseEntity<>(eDetail,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetail> noUserFound(UserNotFoundException cnf,WebRequest wr){
		
		ErrorDetail eDetail = ErrorDetail.builder().messageString(cnf.getMessage()).localDate(LocalDateTime.now()).uriString(wr.getDescription(false)).build();
		return new ResponseEntity<>(eDetail,HttpStatus.OK);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetail> noHandlerFound(NoHandlerFoundException cnf,WebRequest wr){
		
		ErrorDetail eDetail = ErrorDetail.builder().messageString(cnf.getMessage()).localDate(LocalDateTime.now()).uriString(wr.getDescription(false)).build();
		return new ResponseEntity<>(eDetail,HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> noHandlerFound(Exception cnf,WebRequest wr){
		
		ErrorDetail eDetail = ErrorDetail.builder().messageString(cnf.getMessage()).localDate(LocalDateTime.now()).uriString(wr.getDescription(false)).build();
		return new ResponseEntity<>(eDetail,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> noHandlerFound(MethodArgumentNotValidException cnf,WebRequest wr){
		
		List<ObjectError> allErrors = cnf.getAllErrors();
		List<String> errorsToStringList = MethodArgumentNotValidException.errorsToStringList(allErrors);
		
		return new ResponseEntity<>(errorsToStringList,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  
	
}
