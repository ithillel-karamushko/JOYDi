package org.hillel.it.joydi.model.entities;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected Date created;
	protected Date modified;
	protected Person createdBy;
	protected Person modifiedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
