package org.hillel.it.joydi.model.entities;

import java.util.*;

/**
 * 
 * @author Æåíÿ
 * 
 */
public class Picture extends BaseEntity {
	private Date creatingDate;

	/**
	 * Method that returns field creatingDate
	 * 
	 * @return Date when picture was created
	 */
	public Date getCreatingDate() {
		return creatingDate;
	}

	/**
	 * Method that set creatingDate
	 * 
	 * @param creatingDate Date which we need to initialized
	 */
	public void setCreatingDate(Date creatingDate) {
		this.creatingDate = creatingDate;
	}

}
