package org.hillel.it.joydi.service.bootstrap;

import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.service.diaryService.DiaryService;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;

public class Starter {
	public static void main(String[] args) {
		DiaryService service = new DiaryServiceImpl();
		User user = new User ("John", "email", "ukraine", "male", 22);
		user.saveUser(user);
		System.out.println(user.getCountry());
		System.out.println();

	}
}
