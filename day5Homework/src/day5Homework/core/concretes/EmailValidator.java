package day5Homework.core.concretes;

import java.util.regex.Pattern;


import java.util.regex.Matcher;

import day5Homework.core.abstracts.ValidationService;
import day5Homework.entities.concretes.User;


public class EmailValidator{
	String validMail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
	Pattern emailPattern = Pattern.compile(validMail, Pattern.CASE_INSENSITIVE);
	

	public boolean check(String email) {
		Matcher matcher = emailPattern.matcher(email);
		if(matcher.matches()) {
			System.out.println("Valid Email.");
			return true;
		}else {
			System.out.println("Invalid Email.");
			return false;
		}
	}
}
