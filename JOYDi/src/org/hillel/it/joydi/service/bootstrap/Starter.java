package org.hillel.it.joydi.service.bootstrap;

import org.hillel.it.joydi.service.diary.DiaryService;
import org.hillel.it.joydi.service.imp.DiaryServiceImpl;

public class Starter {
	public static void main(String[] args) {
		DiaryService service = new DiaryServiceImpl();
	}
}
