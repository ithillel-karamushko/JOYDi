package org.hillel.it.joydi.model.entities;

import org.hillel.id.joydi.persistance.repository.PersonRepository;

public class User extends Person implements PersonRepository <User>  {
	public User createPerson(){
		return null;
	}
	
	public User modifyPerson(User person){
		return null;
	}
	
	public void deletePerson(User person){
	}

}
