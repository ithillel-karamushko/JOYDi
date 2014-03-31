package org.hillel.id.joydi.persistance.repository;

import org.hillel.it.joydi.model.entities.Picture;

public interface PictureRepository {
	void addPicture(Picture picture);

	void deletePicture(Picture picture);

	void getPicture();

}
