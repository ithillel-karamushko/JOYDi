package org.hillel.it.joydi.persistance.inmemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.hillel.it.joydi.infra.config.Configuration;
import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.InputException;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.persistance.repository.PersonRepository;
import org.hillel.it.joydi.model.entities.InputException;

public class InMemoryPersonFileRepository implements PersonRepository {

	private List<Person> persons;

	public InMemoryPersonFileRepository() {
		this.persons = new ArrayList<Person>();
	}

	@Override
	public void saveUser(User person) throws FileNotFoundException, IOException {
		this.persons.add(person);
		try {
			test(person);
			serialize(this.persons);
		} catch (InputException ce) {
			deleteUser(person);
			System.out
					.println("Please, complete all fields and try register again! "
							+ ce);

		}

	}

	@Override
	public void modifyUser(User person) throws FileNotFoundException,
			IOException {
		this.persons.remove(person);
		this.persons.add(person);
		serialize(this.persons);

	}

	@Override
	public void deleteUser(User person) throws IOException {
		this.persons.remove(person);
		serialize(this.persons);

	}

	@Override
	public void saveAdmin(Admin person) throws FileNotFoundException,
			IOException {
		this.persons.add(person);
		try {
			test(person);
			serialize(this.persons);
		} catch (InputException ce) {
			deleteAdmin(person);
			System.out
					.println("Please, complete all fields and try register again! "
							+ ce);

		}
	}

	@Override
	public void deleteAdmin(Admin person) throws IOException {
		this.persons.remove(person);
		serialize(this.persons);

	}

	public void serialize(List<Person> person) throws FileNotFoundException,
			IOException {
		Configuration config = Configuration.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				config.getPropertie("file.path")));
		oos.writeObject(person);
		oos.close();
	}

	public void deserialize() throws FileNotFoundException, IOException {
		Configuration config = Configuration.getInstance();
		FileInputStream fis = new FileInputStream(new File(
				config.getPropertie("file.path")));
		SerializationUtils.deserialize(fis);
	}

	protected void test(Person person) throws InputException {

		if (person.getCountry() == null || person.getDateOfBirth() == null
				|| person.geteMail() == null || person.getGender() == null
				|| person.getName() == null) {
			throw new InputException();
		}
	}

	public void birthday() {
		GregorianCalendar today = new GregorianCalendar();
		List<String> bDayPersons = new ArrayList<>();
		for (Person person : persons) {
			if (person.getDateOfBirth().DATE == today.DATE
					&& person.getDateOfBirth().MONTH == today.MONTH) {
				bDayPersons.add(person.getName());
			}
		}
		System.out.print("The administration of JOYdi wishing ");
		for (String bDayPerson : bDayPersons) {
			System.out.print(bDayPerson + ", ");
		}
		System.out.print("all the best. \n May all your dreams come true! Happy Birthday! \n ");
	}
}
