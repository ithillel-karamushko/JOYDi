package org.hillel.id.joydi.persistance.repository;

public interface TextRepository <T> {
	T addText(String text);
	T modifyText(T text);
	void deleteText(T text);
}
