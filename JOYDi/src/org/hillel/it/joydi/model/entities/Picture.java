package org.hillel.it.joydi.model.entities;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @author Æåíÿ
 * 
 */
/**
 * create table if not exists pictures ( id integer not null auto_increment
 * primary key, fileUrl varchar(1024) not null, creatingDate datetime not null
 * );
 * 
 * @author Þëÿ
 * 
 */

public class Picture extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2656773965062298313L;
	private Date creatingDate;
	private String fileUrl;

	public Picture(String fileUrl) {
		this.fileUrl = fileUrl;
		creatingDate = new Date();
	}

	/**
	 * Method that returns field creatingDate
	 * 
	 * @return Date when picture was created
	 */
	public String getCreatingDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd");
		String curDate = sdf.format(creatingDate);
		return curDate;
	}

	/**
	 * Method that set creatingDate
	 * 
	 * @param creatingDate
	 *            Date which we need to initialized
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
	 * @param fileUrl
	 *            the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}
