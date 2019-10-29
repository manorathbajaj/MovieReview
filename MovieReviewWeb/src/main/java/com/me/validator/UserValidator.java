package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fName", "empty.fName", "First Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lName", "empty.lName", "Last Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uName", "empty.uName", "User Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty.password", "Password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty.email", " email is Required");	
	}

	
}
