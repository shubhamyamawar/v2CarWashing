package com.order.exception;

import java.util.Date;

import org.springframework.data.mongodb.core.aggregation.BooleanOperators.Or;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

@ControllerAdvice

public class GlobalExceptionHandler {

	@ExceptionHandler(OrderNotFoundException.class)

	public ResponseEntity<?> resourceNotFoundException(OrderNotFoundException ex, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}

}