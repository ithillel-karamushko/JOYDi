package org.hillel.it.joydi.service.bootstrap;

import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.persistance.inmemory.InMemory;
import org.hillel.it.joydi.service.diaryService.DiaryService;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;

public class Starter {
	public static void main(String[] args) {
		InMemory inMemory = new InMemory();
		User user = new User("John", "email", "ukraine", "male", 22);
		User user1 = new User("Andrew", "email", "ukraine", "male", 25);
		User user2 = new User("Frosya", "email", "poland", "female", 15);
		inMemory.saveUser(user);
		inMemory.saveUser(user1);
		inMemory.saveUser(user2);
	}
}
