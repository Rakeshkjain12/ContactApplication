package com.capp.command;
/*
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class passwordValidator  implements Validator{

	public boolean supports(Class<?> clazz) {
		return PasswordCommand.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password","Field name is required");		
            
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "required.confirmPassword","Field name is required");	
            
            PasswordCommand cmd=(PasswordCommand) target;
            if(!(cmd.getPassword().equals(cmd.confirmPassword))) {
            	errors.rejectValue("password", "Password do not match");
            }
	}*/


