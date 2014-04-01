package org.hillel.it.joydi.persistance.inmemory;

import java.util.ArrayList;
import java.util.List;

import org.hillel.id.joydi.persistance.repository.PictureRepository;
import org.hillel.it.joydi.model.entities.Picture;

public class InMemoryPictureRepository implements PictureRepository {
	
	private List<Picture> picture;
	
	public InMemoryPictureRepository (){
		this.picture = new ArrayList<Picture>();
	}

	@Override
	public void addPicture(Picture picture) {
		this.picture.add(picture);

	}

	@Override
	public void deletePicture(Picture picture) {
		this.picture.remove(picture);

	}

	public void getPicture() {
		System.out.println(picture);
	}

}
