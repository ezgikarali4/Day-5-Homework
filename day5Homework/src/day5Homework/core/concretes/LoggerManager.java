package day5Homework.core.concretes;

import day5Homework.core.abstracts.LoggerService;

public class LoggerManager implements LoggerService{

	@Override
	public void logToSystem(String message) {

		System.out.println("Logged with normal service.");
	}

}
