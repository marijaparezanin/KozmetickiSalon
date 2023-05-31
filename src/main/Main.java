package main;

import gui.MainFrame;
import java.time.LocalDateTime;

import datamanager.DataManager;

public class Main {
/*
	public static void main(String[] args) {
		MainFrame w = new MainFrame();
		
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
		dm.addKozmetickiSalon("Moj Salon", "08:00", "20:00");
		dm.changeOpeningTime("Moj Salon", "09:00");
		dm.printKS();
		
		System.out.println("\n" + "------------------------------------------------Klijenti--------------------------------------------------\n");
		dm.addKlijent("MMilic", "loznika111", "Milica", "Milic", "z", "065123123", "Kraljevo");
		dm.addKlijent("MMikic", "loznika222", "Mika", "Mikic", "m", "065123123", "Mostar");
		dm.printAllKlijent();
		
		
		System.out.println("\n" + "------------------------------------------------Menadzeri-------------------------------------------------\n");
		dm.addMenadzer("NNikolic", "loznika345", "Nikola", "Nikolic", "m", "065123123", "Beograd");
		dm.printAllMenadzer();
		
		System.out.println("\n" + "-----------------------------------------------Recepcioneri-----------------------------------------------\n");
		dm.addRecepcioner("PPeric", "lozinka123", "Pera", "Peric", "m", "065123123", "Trebinje");
		dm.printAllRecepcioner();
		
		System.out.println("\n" + "------------------------------------------------Kozmeticari-----------------------------------------------\n");
		dm.addKozmeticar("SSimic", "lozinka456", "Sima", "Simic", "m", "065123123", "Novi Sad");
		dm.addKozmeticar("ZZikic", "lozinka236", "Zika", "Zikic", "m", "065123123", "Temerin");
		dm.addKozmeticar("JJovanovic", "lozinka456", "Jadranka", "Jovanovic", "z", "065123123", "Dubrovnik");
		dm.printAllKozmeticar();
		
		System.out.println("\nPosle brisanja Zike i Jadranka-->Jovana-------------------------------------------------------------------\n");
		dm.KozmeticarChangeIme("JJovanovic", "Jovana");
		dm.removeKozmeticar("ZZikic");
		dm.printAllKozmeticar();
	
		System.out.println("\n" + "--------------------------------------------------Tretmani------------------------------------------------\n");
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

		dm.printAllTT();
		
		System.out.println("\nPosle franc. manikir---> 55 min---------------------------------------------------------------------------\n");
		dm.TTChangeTrajanje("Francuski manikir", 55);
		dm.printAllTT();
		
		System.out.println("\n" + "--------------------------------------------------Cjenovnik-----------------------------------------------\n");

		dm.printCjenovnik();
		
		System.out.println("----------------------------------------------------------------------------------------------------------");
		dm.addUslugaTip("masaza", "Relaks masaža");
		dm.addUslugaTip("masaza", "Sportska masaža");
		dm.addUslugaTip("manikir", "Francuski manikir");
		dm.addUslugaTip("manikir", "Gel lak");
		dm.addUslugaTip("manikir", "Spa pedikir");
		dm.printAllUsluge();
		System.out.println("\nPosle spa pedikir---> pedikir-----------------------------------------------------------------------------\n");
		dm.removeUslugaTip("manikir", "Spa pedikir");
		dm.addUslugaTip("pedikir", "Spa pedikir");
		dm.printAllUsluge();
		
		
		System.out.println("\nKozmeticari sa uslugama koje znaju, prije brisnanja pedikira:---------------------------------------------\n");
		dm.KozmeticarAddUsluga("SSimic", "masaza");
		dm.KozmeticarAddUsluga("SSimic", "manikir");
		
		dm.KozmeticarAddUsluga("JJovanovic", "manikir");
		dm.KozmeticarAddUsluga("JJovanovic", "pedikir");
		dm.printAllKozmeticar();


		System.out.println("\n------------------------------------------------ZakazanTretman--------------------------------------------\n");
		dm.addZakazaniTretman("SSimic", "MMilic", LocalDateTime.now(), "Relaks masaža");
		dm.addZakazaniTretman("SSimic", "MMikic", LocalDateTime.now(), "Gel lak");
		dm.addZakazaniTretman("JJovanovic", "MMikic", LocalDateTime.now(), "Spa pedikir");
		dm.printAllZT();

		System.out.println("\n------------------------------------------------Obrisan pedikir-------------------------------------------");
		dm.removeUsluga("pedikir");
		System.out.println("Usluge posle: ");
		dm.printAllUsluge();
		System.out.println("\nTretmani posle:");
		dm.printAllTT();
		System.out.println("\nKozmeticari posle: ");
		dm.printAllKozmeticar();
		System.out.println("\nZakazani tretmani posle: ");
		dm.printAllZT();
		System.out.println("\nCjenovnik posle: ");
		dm.printCjenovnik();
		
	}*/
}
