package org.hillel.it.joydi.persistance.inmemory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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

public class InMemoryPersonRepository implements PersonRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4307847716316565505L;
	private List<Person> persons;
	private int idCount = 0;

	public InMemoryPersonRepository() {

	}

	public List<Person> getPersons() {
		return persons;
	}

	public int getIdCount() {
		return idCount;
	}

	public void setIdCount(int idCount) {
		this.idCount = idCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public synchronized boolean saveUser(User person)
			throws FileNotFoundException, IOException {
		for (Person allPerson : persons) {
			if (allPerson.geteMail().equals(person.geteMail())) {
				return false;
			}
		}
		person.setId(idCount++);
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
		return true;
	}

	@Override
	public synchronized void deleteUser(User person) throws IOException {
		this.persons.remove(person);
		serialize(this.persons);

	}

	@Override
	public synchronized void saveAdmin(Admin person)
			throws FileNotFoundException, IOException {
		person.setId(idCount++);
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
	public synchronized void deleteAdmin(Admin person) throws IOException {
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

	public List<Person> deserialize() throws FileNotFoundException, IOException {
		Configuration config = Configuration.getInstance();
		FileInputStream fis = new FileInputStream(new File(
				config.getPropertie("file.path")));
		persons = SerializationUtils.deserialize(fis);
		return persons;
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
		System.out.print("\n The administration of JOYdi wishing ");
		int i = -1;
		for (String bDayPerson : bDayPersons) {
			i++;
			System.out.print(bDayPerson);

			if (i < bDayPersons.size() - 2) {
				System.out.print(", ");
			} else if (i == bDayPersons.size() - 2) {
				System.out.print(" and ");
			}

		}
		System.out
				.print(" all the best. \n May all your dreams come true! Happy Birthday! \n ");
	}

	public Person enter(String email, String password) {
		Person user = returnUserByEmail(email);
		if (user == null) {
			return null;
		}
		if (user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}

	}

	public Person returnUserByEmail(String email) {
		try {
			persons = deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person user = null;
		for (Person person : persons) {
			if (person.geteMail().equals(email)) {
				user = person;
			}
		}
		return user;
	}

	@Override
	public void changePassword(String oldPassword, String newPassword,
			String confirmPassword, String email) {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person user = returnUserByEmail(email);
		if (user.getPassword().equals(oldPassword)
				&& newPassword.equals(confirmPassword)) {
			user.setPassword(newPassword);
		}
		try {
			serialize(persons);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeName(String name, String email) {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person user = returnUserByEmail(email);
		user.setName(name);
		try {
			serialize(persons);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void changeCountry(String country, String email) {
		try {
			deserialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Person user = returnUserByEmail(email);
		user.setCountry(country);
		try {
			serialize(persons);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
