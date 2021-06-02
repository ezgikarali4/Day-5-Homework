package day5Homework.core.concretes;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import day5Homework.core.abstracts.ValidationService;
import day5Homework.entities.concretes.User;

public class PasswordValidator implements ValidationService{


	@Override
	public boolean check(User user) {
		
		if (user.getPassword().length() >= 6) {
			System.out.println("Valid Password.");

			return true;
		}else {
			System.out.println("Invalid Password. Try again.");
		}
		return false;
	}

}
