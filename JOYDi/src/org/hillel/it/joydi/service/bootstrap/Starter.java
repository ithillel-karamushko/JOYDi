package org.hillel.it.joydi.service.bootstrap;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.persistance.inmemory.InMemory;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;

public class Starter {
	
	public Starter (DiaryServiceImpl diaryServiseImpl){
		DiaryServiceImpl dsi = new DiaryServiceImpl();
	}
	
	public static void main(String[] args) {
		DiaryServiceImpl ds = new DiaryServiceImpl();
//		Starter start = new Starter(ds);
		User user1 = new User("John", "email", "ukraine", "male", 22);
		User user2= new User("John", "email", "ukraine", "male", 22);
		User user3 = new User("Andrew", "email", "ukraine", "male", 25);
		Admin admin1 = new Admin("Hanna", "email", "poland", "female", 15);
		Admin admin2 = new Admin("Helen", "email", "poland", "female", 23);
		System.out.println(user1.getName() + " is from " + user1.getCountry());
		ds.saveUser(user1);
		ds.saveUser(user2);
		ds.saveUser(user3);
		ds.saveAdmin(admin1);
		ds.saveAdmin(admin2);
		System.out.println(InMemory.user);
		System.out.println(InMemory.admin);
		
	}
}
