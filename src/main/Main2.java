package main;

import java.time.LocalDateTime;

import datamanager.DataManager;
import gui.MainFrame;
import korisnik.Recepcioner;

public class Main2 {

	public static void main(String[] args) {
		System.out.println("Podesavanje aplikacije ...");

		System.out.println("Pokretanje glavnog prozora");
		
		
		System.out.println("Tip tretmana sam uradila kao podkategoriju usluga, tj usluga nokti, tt - gel nokti");
		System.out.println("DataManager mi je zapravo kozmeticki salon, tako da ako hocu da napravim jos jedan, napravila bi novi objekat tipa DataManager, i prosljedila mu nove fajl putanje");
		String delimiter = System.getProperty("file.separator");
		DataManager dm = new DataManager();
		dm.setKlijentPath("src" + delimiter +"files" + delimiter + "klijent.csv");
		dm.setKozmeticarPath("src" + delimiter +"files" + delimiter + "kozmeticar.csv");
		dm.setMenadzerPath("src" + delimiter +"files" + delimiter + "menadzer.csv");
		dm.setRecepcionerPath("src" + delimiter +"files" + delimiter + "recepcioner.csv");
		dm.setTipTretmanaPath("src" + delimiter +"files" + delimiter + "tiptretmana.csv");
		dm.setUslugeTretmanaPath("src" + delimiter +"files" + delimiter + "uslugetretmana.csv");
		dm.setCjenovnikPath("src" + delimiter +"files" + delimiter + "cjenovnik.csv");
		dm.setZakazaniTretmaniPath("src" + delimiter +"files" + delimiter + "zakazanitretman.csv");
		dm.setKozmetickiSalonPath("src" + delimiter +"files" + delimiter + "kozmetickisalon.csv");
		
		dm.loadData();
		//dm.changeCijena("Gel lak", 123);\
		//dm.addZakazaniTretman("SSimic", "MMilic", LocalDateTime.now(), "Relaks masaža");
		//dm.addZakazaniTretman("SSimic", "MMikic", LocalDateTime.now(), "Gel lak");
		//dm.addZakazaniTretman("JJovanovic", "MMikic", LocalDateTime.now(), "Spa pedikir");
		MainFrame w = new MainFrame(dm);
		//dm.removeRecepcioner("Mato");
		/*dm.removeRecepcioner("Ivana");
		dm.removeKozmeticar("JJovanovic");
		dm.removeMenadzer("Milicam");
		dm.addKozmetickiSalon("Moj Salon", "08:00", "20:00");
		dm.changeOpeningTime("Moj Salon", "09:00");

		dm.addUslugaTretmana("masaza");
		dm.addUslugaTretmana("manikir");
		dm.addUslugaTretmana("pedikir");
		
		dm.addTipTretmana("Relaks masaža", 45);
		dm.addCijena("Relaks masaža", 2000);
		
		dm.addTipTretmana("Sportska masaža", 75);
		dm.addCijena("Sportska masaža", 2500);
		
		dm.addTipTretmana("Francuski manikir", 50);
		dm.addCijena("Francuski manikir", 2000);
		
		dm.addTipTretmana("Gel lak", 80);
		dm.addCijena("Gel lak", 1600);
		
		dm.addTipTretmana("Spa manikir", 90);
		dm.addCijena("Spa manikir", 2000);
		
		dm.addTipTretmana("Spa pedikir", 45);
		dm.addCijena("Spa pedikir", 1600);
		dm.addUslugaTip("masaza", "Relaks masaža");
		dm.addUslugaTip("masaza", "Sportska masaža");
		dm.addUslugaTip("manikir", "Francuski manikir");
		dm.addUslugaTip("manikir", "Gel lak");
		dm.addUslugaTip("manikir", "Spa pedikir");
		
		dm.KozmeticarAddUsluga("SSimic", "masaza");
		dm.KozmeticarAddUsluga("SSimic", "manikir");
		
		dm.KozmeticarAddUsluga("JJovanovic", "manikir");
		dm.KozmeticarAddUsluga("JJovanovic", "pedikir");

		dm.removeKlijent("MMilic");
		dm.removeKlijent("MMikic");
*/
		//dm.removeRecepcioner("Ivana");
		//dm.printAllRecepcioner();
		
		/*
		dm.addUslugaTretmana("masaza");
		dm.addUslugaTretmana("manikir");
		dm.addUslugaTretmana("pedikir");
		
		dm.addTipTretmana("Relaks masaža", 45);
		dm.addCijena("Relaks masaža", 2000);
		
		dm.addTipTretmana("Sportska masaža", 75);
		dm.addCijena("Sportska masaža", 2500);
		
		dm.addTipTretmana("Francuski manikir", 50);
		dm.addCijena("Francuski manikir", 2000);
		
		dm.addTipTretmana("Gel lak", 80);
		dm.addCijena("Gel lak", 1600);
		
		dm.addTipTretmana("Spa manikir", 90);
		dm.addCijena("Spa manikir", 2000);
		
		dm.addTipTretmana("Spa pedikir", 45);
		dm.addCijena("Spa pedikir", 1600);
		dm.addUslugaTip("masaza", "Relaks masaža");
		dm.addUslugaTip("masaza", "Sportska masaža");
		dm.addUslugaTip("manikir", "Francuski manikir");
		dm.addUslugaTip("manikir", "Gel lak");
		dm.addUslugaTip("manikir", "Spa pedikir");
		
		dm.KozmeticarAddUsluga("SSimic", "masaza");
		dm.KozmeticarAddUsluga("SSimic", "manikir");
		
		dm.KozmeticarAddUsluga("JJovanovic", "manikir");
		dm.KozmeticarAddUsluga("JJovanovic", "pedikir");*/
		
		//MainFrame w = new MainFrame(dm);
		
		// Instanciranje glavnog prozora aplikacije koji ce dalje otvarati/zatvarati naredne prozore i dijaloge
		//MainFrame main = new MainFrame(controlers);
		//main.toString();
		
		
	}

}
