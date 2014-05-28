package org.hillel.it.joydi.model.entities;

import java.text.SimpleDateFormat;
import java.util.*;

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

	public String getCreatingDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = sdf.format(creatingDate);
		return curDate;
	}

	public void setCreatingDate(Date creatingDate) {
		this.creatingDate = creatingDate;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}
