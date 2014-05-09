package org.hillel.it.joydi.persistance.repository;

import java.sql.SQLException;

import org.hillel.it.joydi.model.entities.Picture;

public interface PictureRepository {
	void addPicture(Picture picture) throws SQLException;

	void deletePicture(Picture picture);

	void getPicture();

}
