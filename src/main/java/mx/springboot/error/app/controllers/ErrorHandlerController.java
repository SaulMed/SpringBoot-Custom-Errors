package mx.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.springboot.error.app.customErrors.UserNotFoundException;

@ControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler(ArithmeticException.class)
	public String errorAritmetico(ArithmeticException ex, Model modelo) {
		modelo.addAttribute("error","Error : Aritmetico");
		modelo.addAttribute("message",ex.getMessage());
		modelo.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp",new Date());
		return "error/templateGenerico";
	}

	
	@ExceptionHandler(NumberFormatException.class)
	public String errorFormatoNumerico(NumberFormatException ex, Model modelo) {
		modelo.addAttribute("error","Error : Formato Numerico");
		modelo.addAttribute("message",ex.getMessage());
		modelo.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp",new Date());
		return "error/templateGenerico";
	}
	
	@ExceptionHandler(UserNotFoundException.class)	//Excepcion personalizada (package customErrors)
	public String userNotFoundException(UserNotFoundException ex, Model modelo) {
		modelo.addAttribute("error", "Error : User Not Found in the System.");
		modelo.addAttribute("message",ex.getMessage());
		modelo.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp", new Date());
		return "error/userNotFound";
	}
	
}
