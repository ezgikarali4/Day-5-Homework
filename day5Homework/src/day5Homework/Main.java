package day5Homework;

import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

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
import day5Homework.core.concretes.RepetitionControl;
import day5Homework.dataAccess.abstracts.UserDao;
import day5Homework.dataAccess.concretes.ABCUserDao;
import day5Homework.dataAccess.concretes.HibernateUserDao;
import day5Homework.entities.concretes.User;



public class Main {

	public static void main(String[] args) {
		
		HibernateUserDao hibernateUserDao = new HibernateUserDao();
		ABCUserDao abcUserDao = new ABCUserDao();
		EmailVerification emailVerification = new EmailVerification();
		EmailValidator emailValidator = new EmailValidator();

		VerificationService verificationService;
		LoggerService loggerService;
		
		ValidationService[] validationServices = {new NameValidator(), new PasswordValidator()};
		ValidationService validationService1 = new NameValidator();
		ValidationService validationService2 = new PasswordValidator();
		ValidationService validationService3 = new RepetitionControl();

		UserManager userManager1 = new UserManager(new HibernateUserDao(), new GoogleLoggerManagerAdapter());
		UserManager userManager2 = new UserManager(new ABCUserDao(), new GoogleLoggerManagerAdapter());
		UserManager userManager3 = new UserManager(new HibernateUserDao(), new LoggerManager());
		UserManager userManager4 = new UserManager(new ABCUserDao(), new LoggerManager());
		
		//Correction for the email
		System.out.println("----------------EMAIL CORRECTION---------------");
		String email1 = "ezgi@";
		while(!emailValidator.check(email1)) {
			email1 = "ezgi@example.com";
		};
		
		System.out.println("----------------USER 1---------------");
		User user1 = new User(1, "Ezgi", "Karali", "123456", email1, (int)(Math.random()*1000000));

		//USER 1 
		//Name check
		validationService1.check(user1);
		//Password check
		validationService2.check(user1);
		validationService3.check(user1);
		//Hibernate and Google
		userManager1.add(user1);
		//ABC and Google
		userManager2.add(user1);
		//Hibernate and Normal Service
		userManager3.add(user1);
		//ABC and Normal Service
		userManager4.add(user1);
		
		emailVerification.send(user1);
		VerificationCode verificationCode1 = new VerificationCode(user1.getUserVerificationCode());
		
		System.out.println("Verification code is: " + user1.getUserVerificationCode());
		emailVerification.verify(user1, verificationCode1);

		//using the same email with user1
		System.out.println("----------------USER 2---------------");
		User user2 = new User(1, "Ezgi", "Karali", "123456", email1 , (int)(Math.random()*1000000));
		validationService1.check(user2);
		validationService2.check(user2);
		validationService3.check(user2);
		
		System.out.println("----------------USER 3---------------");
		String email3 = "abc";
		while(!emailValidator.check(email3)) {
			email3 = "abc@example.com";
		};
		User user3 = new User(1, "Ezgi", "Karali", "123456", email3 , (int)(Math.random()*1000000));
		validationService1.check(user3);
		validationService2.check(user3);
		validationService3.check(user3);
		userManager3.add(user3);
		
		emailVerification.send(user1);
		VerificationCode verificationCode3 = new VerificationCode(user3.getUserVerificationCode());
		
		System.out.println("Verification code is: " + user3.getUserVerificationCode());
		emailVerification.verify(user3, verificationCode3);
		
	}

}
