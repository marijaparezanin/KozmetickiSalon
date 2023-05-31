package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import datamanager.DataManager;
import korisnik.Klijent;

public class DataManagerTest {
	DataManager dm;
	
	@Before
	public void setUp() {
		dm = new DataManager();
		String delimiter = System.getProperty("file.separator");
		dm.setKlijentPath("src" + delimiter +"files" + delimiter + "klijent.csv");
		dm.setKozmeticarPath("src" + delimiter +"files" + delimiter + "kozmeticar.csv");
		dm.setMenadzerPath("src" + delimiter +"files" + delimiter + "menadzer.csv");
		dm.setRecepcionerPath("src" + delimiter +"files" + delimiter + "recepcioner.csv");
		dm.setTipTretmanaPath("src" + delimiter +"files" + delimiter + "tiptretmana.csv");
		dm.setUslugeTretmanaPath("src" + delimiter +"files" + delimiter + "uslugetretmana.csv");
	}

	@Test
	public void test1() {
		Klijent k = new Klijent("Marija", "Pa");
		dm.addKlijent("Marija", "Marija", "Marija", "Marija", "Marija", "Marija", "Marija");
		assertEquals(k.getIme(), dm.getAllKlijenti().get(0).getIme());
	}

}
