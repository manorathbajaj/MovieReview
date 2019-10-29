package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Movie;
import com.me.pojo.User;

public class MovieValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Movie.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty.name", "Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "empty.actor", "Actor Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "empty.actress", "Actress Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "empty.genre", "Genre Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "empty.year", "Year is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "empty.year", "Year is Required");
		
	}

}
