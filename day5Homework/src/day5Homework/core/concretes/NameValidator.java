package day5Homework.core.concretes;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import day5Homework.core.abstracts.ValidationService;
import day5Homework.entities.concretes.User;


public class NameValidator implements ValidationService{

    
	@Override
	public boolean check(User user) {

		if (user.getFirstName().length() >= 2 && user.getLastName().length() >= 2) {
            System.out.println("Valid name.");

        } else {
            System.out.println("Your first and last name must be at least 2 characters long.");
            return false;

        }
		return false;
	}

	
}
