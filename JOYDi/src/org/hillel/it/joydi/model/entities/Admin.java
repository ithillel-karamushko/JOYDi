package org.hillel.it.joydi.model.entities;

import org.hillel.id.joydi.persistance.repository.PersonRepository;

public class Admin extends Person implements PersonRepository <Admin> {
	public Admin createPerson(){
		return null;
	}
	
	public Admin modifyPerson(Admin person){
		return null;
	}
	
	public void deletePerson(Admin person){
	}

}
