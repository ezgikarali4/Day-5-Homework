package day5Homework.dataAccess.concretes;

import java.util.List;

import day5Homework.dataAccess.abstracts.UserDao;
import day5Homework.entities.concretes.User;

public class ABCUserDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("User " + user.getFirstName() + " " + user.getLastName() + " added successfully with ABC.");		
	}

	@Override
	public void update(User user) {
		System.out.println("User " + user.getFirstName() + " " + user.getLastName() + " updated successfully with ABC.");		
	}

	@Override
	public void delete(User user) {
		System.out.println("User " + user.getFirstName() + " " + user.getLastName() + " deleted successfully with ABC.");		
	}

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public List<User> getAll() {
		return null;
	}


}
