package org.hillel.it.joydi.service.bootstrap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Months;
import org.hillel.it.joydi.model.entities.Picture;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;
import org.hillel.it.joydi.model.entities.Gender;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPersonRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryPictureRepository;
import org.hillel.it.joydi.persistance.inmemory.InMemoryTextRepository;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.persistance.repository.PictureRepository;
import org.hillel.it.joydi.persistance.repository.TextRepository;

public class Starter {
	public static void main(String[] args) throws FileNotFoundException,
			IOException, SQLException {
		TextRepository textRepository = new InMemoryTextRepository();
		PersonRepository personRepository = new InMemoryPersonRepository();
		PictureRepository pictureRepository = new InMemoryPictureRepository();
		DiaryServiceImpl ds = new DiaryServiceImpl(textRepository,
				personRepository, pictureRepository);
		User user1 = new User("John", "email@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		ds.saveUser(user1);
		ds.enter("email@gmail.com", "rretert");
		User user2 = new User("Mary", "email2@gmail.com", "Albania",
				Gender.MALE, 2004, Months.February, 28, "rretert");
		ds.saveUser(user2);
	}
}
