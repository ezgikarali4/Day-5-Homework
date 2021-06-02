package day5Homework.core.concretes;

import java.util.ArrayList;

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
import day5Homework.dataAccess.abstracts.UserDao;
import day5Homework.dataAccess.concretes.ABCUserDao;
import day5Homework.dataAccess.concretes.HibernateUserDao;
import day5Homework.entities.concretes.User;

public class EmailVerification implements VerificationService{

	private VerificationService[] verificationServices;
	private VerificationCode verificationCodes;

	public EmailVerification(VerificationService[] verificationService, VerificationCode verificationCode) {
		super();
        this.verificationServices = verificationService;
        this.verificationCodes = verificationCode;
	}
	
	public EmailVerification() {
	}

	@Override
	public void send(User user) {
		System.out.println("Verification code is sent to your email. Please verify your email before login.");
	}

	@Override
	public boolean verify(User user, VerificationCode verificationCode) {
            if (verificationCode.getVerificationCode() == user.getUserVerificationCode()) {
                System.out.println("Verification code is correct. You can login with your account.");
                return true;
            }else {
            	System.out.println("Verification code is incorrect.");
            }
	return false;
	
}
}



