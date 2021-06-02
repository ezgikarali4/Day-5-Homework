package day5Homework.core.concretes;

import day5Homework.core.abstracts.ValidationService;

import day5Homework.entities.concretes.User;
import java.util.ArrayList;
import day5Homework.entities.concretes.VerificationCode;
import day5Homework.business.abstracts.UserService;
import day5Homework.business.concretes.UserManager;
import day5Homework.core.abstracts.LoggerService;
import day5Homework.core.abstracts.ValidationService;
import day5Homework.core.abstracts.VerificationService;
import day5Homework.core.concretes.EmailValidator;
import day5Homework.core.concretes.EmailVerification;
import day5Homework.core.concretes.GoogleLoggerManagerAdapter;
import day5Homework.core.concretes.LoggerManager;
import day5Homework.core.concretes.NameValidator;
import day5Homework.core.concretes.PasswordValidator;
import day5Homework.dataAccess.abstracts.UserDao;
import day5Homework.dataAccess.concretes.ABCUserDao;
import day5Homework.dataAccess.concretes.HibernateUserDao;
import day5Homework.entities.concretes.User;

public class RepetitionControl implements ValidationService{

	 ArrayList<String> emailControl = new ArrayList<String>();


	    public RepetitionControl(ArrayList<String> emailControl) {
	        this.emailControl = emailControl;
	    }
	    
	    public RepetitionControl() {
	    }
	@Override
	public boolean check(User user) {
		 if (!this.emailControl.contains(user.getEmail())) {
			 System.out.println(user.getEmail() + " is added.");
	 		 this.emailControl.add(user.getEmail());
	 		 return true;
	     }else {
	          System.out.println(user.getEmail() + " is already in use.");
	          return false;
	     }
 
	   }
}


