package com.example.ritesh.demo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ritesh.demo.model.User;

@Component
public class UserDaoService {
	private static int usersCounts = 3;
	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(1, "Ritesh", new Date()));
		users.add(new User(2, "Mukesh", new Date()));
		users.add(new User(3, "Akhilesh", new Date()));
	}

	public List<User> findAll() {
		return users;

	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCounts);
		}
		users.add(user);
		return user;

	}

	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User findUserByName(String name) {
		for (User use : users) {
			if (use.getName().equals(name)) {
				return use;
			}
		}
		return null;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
