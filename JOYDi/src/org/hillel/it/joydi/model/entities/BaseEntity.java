package org.hillel.it.joydi.model.entities;
import java.util.Date;

public class BaseEntity {
	protected int id;
	protected Date created;
	protected Date modified;
	protected Person createdBy;
	protected Person modifiedBy;
	

}