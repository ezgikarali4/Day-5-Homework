package day5Homework.core.abstracts;

import day5Homework.entities.concretes.User;

public interface ValidationService {
	
	boolean check(User user);
}
