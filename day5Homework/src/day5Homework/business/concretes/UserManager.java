package day5Homework.business.concretes;

import java.util.ArrayList;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


public class UserManager implements UserService{

	private LoggerService loggerService;
	private UserDao userDao;

    List<User> users = new ArrayList<>();
    
	public UserManager(UserDao userDao, LoggerService loggerService) {
		super();
		this.userDao = userDao;
		this.loggerService = loggerService;

	}

	@Override
	public void add(User user) {
		this.userDao.add(user);
 		this.loggerService.logToSystem(user.getFirstName() + " " + user.getLastName() + " registered succesfully to the DataBase.");
	}
	

	@Override
	public List<User> getAll() {
		return userDao.getAll();	
		
	}

	

}

	

