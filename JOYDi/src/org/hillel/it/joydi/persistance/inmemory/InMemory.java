package org.hillel.it.joydi.persistance.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.it.joydi.model.entities.Admin;
import org.hillel.it.joydi.model.entities.Article;
import org.hillel.it.joydi.model.entities.Comment;
import org.hillel.it.joydi.model.entities.Person;
import org.hillel.it.joydi.model.entities.User;

public class InMemory {
	public static List <Article> article = new ArrayList();
	public static List <Person> admin = new ArrayList();
	public static List <Person> user = new ArrayList();
	public static List <Comment> comment = new ArrayList();
}


