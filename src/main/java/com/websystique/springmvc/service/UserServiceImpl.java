package com.websystique.springmvc.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	private static Map<String, List<User>> userMap = new HashMap<String, List<User>>();


	static{
		// TODO rework to make it work with new model
		// users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
        List<User> users = new LinkedList<User>();
		userMap.values().stream().flatMap(List::stream).forEach(user -> users.add(user));
        return users;
	}
	
	public User findById(long id) {
        return userMap.values().stream().flatMap(List::stream).filter(user -> user.getId()==(id)).findFirst().orElse(null);
	}

	public List<User> findAllEmployees() {
		return userMap.get("employees");
	}

	public List<User> findAllConsultants() {
		return userMap.get("consultants");
	}
	
	public User findByName(String name) {
        return userMap.values().stream().flatMap(List::stream).filter(user -> user.getUsername().equals(name)).findFirst().orElse(null);
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		userMap.getOrDefault(user.getGroup().toLowerCase(), new LinkedList<User>()).add(user);
	}

	public void updateUser(User user) {
        //TODO Konflikt om man byter grupp (?)
        List<User> users = userMap.get(user.getGroup());
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {
		User usr = userMap.values().stream().flatMap(List::stream).filter(user -> user.getId()==(id)).findFirst().orElse(null);
        userMap.get(usr.getGroup()).remove(usr);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}
	
	public void deleteAllUsers() {
        userMap.clear();
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		/*
		users.add(new User(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
		users.add(new User(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
		users.add(new User(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));
		*/
		return users;
	}

}
