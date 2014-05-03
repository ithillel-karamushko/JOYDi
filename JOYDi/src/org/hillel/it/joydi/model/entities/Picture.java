package org.hillel.it.joydi.model.entities;

import java.util.*;

/**
 * 
 * @author Æåíÿ
 * 
 */
/**
 * create table if not exists pictures ( id integer not null auto_increment
primary key, fileUrl varchar(1024) not null, creatingDate datetime not null );
 * @author Þëÿ
 *
 */

public class Picture extends BaseEntity {
	private Date creatingDate;
	private String fileUrl;

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

	/**
	 * 
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}

	/**
	 * @param fileUrl the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}


}
