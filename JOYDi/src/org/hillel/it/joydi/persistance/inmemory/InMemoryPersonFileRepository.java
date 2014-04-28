package org.hillel.it.joydi.persistance.inmemory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.infra.config.Configuration;
import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.User;
import org.hillel.it.joydi.persistance.repository.PersonRepository;

public class InMemoryPersonFileRepository implements PersonRepository {
	
	private List <Person> persons;
	private Configuration config;
	private List <String> initProperties;
	
	public InMemoryPersonFileRepository (){
		this.persons = new ArrayList <Person> ();
		this.initProperties = new ArrayList<>();
	}

	@Override
	public void saveUser(User person) throws FileNotFoundException, IOException {
		this.persons.add(person);
		serialize(this.persons);
		
	}

	@Override
	public void modifyUser(User person) throws FileNotFoundException,
			IOException {
		this.persons.remove(person);
		this.persons.add(person);
		
	}

	@Override
	public void deleteUser(User person) {
		this.persons.remove(person);
		
	}

	@Override
	public void saveAdmin(Admin person) throws FileNotFoundException,
			IOException {
		this.persons.add(person);
		
	}

	@Override
	public void deleteAdmin(Admin person) {
		this.persons.remove(person);
		
	}

	public void serialize (List <Person> person) throws FileNotFoundException, IOException{
		Configuration config = Configuration.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(config.getPropertie("file.path1")));
		oos.writeObject(person);
		oos.close();
	}
	
	
	
	
//	
//	@Override
//	public void saveUser(User person) throws FileNotFoundException, IOException {
//		String name = person.getName();
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
//				"D://" + name + ".txt"));
//		oos.writeObject(person);
//		oos.close();
//
//	}
//
//	@Override
//	public void deleteUser(User person) {
//		String name = person.getName();
//		File file = new File("D://" + name + ".txt");
//		file.delete();
//
//	}
//
//	@Override
//	public void saveAdmin(Admin person) throws FileNotFoundException,
//			IOException {
//		String name = person.getName();
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
//				"D://" + name + ".txt"));
//		oos.writeObject(person);
//		oos.close();
//
//	}
//
//	@Override
//	public void deleteAdmin(Admin person) {
//		String name = person.getName();
//		File file = new File("D://" + name + ".txt");
//		file.delete();
//
//	}
//
//	@Override
//	public void modifyUser(User person) throws FileNotFoundException,
//			IOException {
//		saveUser(person);
//
//	}

}
