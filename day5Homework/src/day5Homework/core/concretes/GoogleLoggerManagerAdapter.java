package day5Homework.core.concretes;

import day5Homework.core.abstracts.LoggerService;
import day5Homework.google.GoogleLoggerManager;


public class GoogleLoggerManagerAdapter implements LoggerService{

	@Override
	public void logToSystem(String message) {
		GoogleLoggerManager manager = new GoogleLoggerManager();
		manager.logWithGoogle(message);		
	}

}
