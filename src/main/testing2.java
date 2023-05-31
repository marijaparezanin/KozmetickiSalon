package main;

import datamanager.DataManager;

public class testing2 {
/*
	public static void main(String[] args) {		
		String delimiter = System.getProperty("file.separator");
		DataManager dm = new DataManager();
		dm.setKlijentPath("src" + delimiter +"files" + delimiter + "klijent.csv");
		dm.setKozmeticarPath("src" + delimiter +"files" + delimiter + "kozmeticar.csv");
		dm.setMenadzerPath("src" + delimiter +"files" + delimiter + "menadzer.csv");
		dm.setRecepcionerPath("src" + delimiter +"files" + delimiter + "recepcioner.csv");
		dm.setTipTretmanaPath("src" + delimiter +"files" + delimiter + "tiptretmana.csv");
		dm.setUslugeTretmanaPath("src" + delimiter +"files" + delimiter + "uslugetretmana.csv");
		dm.setCjenovnikPath("src" + delimiter +"files" + delimiter + "cjenovnik.csv");
		
		System.out.println("\n" + "------------------------------------------------Klijenti-----------------------------------------------");

		dm.addKlijent("marijap", "loznika123", "Marija", "Parezanin", "z", "065123123", "Trebinje");
		dm.addKlijent("lanap", "loznika234", "Lana", "Parezanin", "z", "065111111", "Berlin");
		dm.addKlijent("milosp", "loznika345", "Milos", "Matic", "z", "065123123", "Beograd");
		dm.addKlijent("helenat", "loznika345", "Helena", "Tadic", "z", "065123123", "Novi Sad");
		dm.saveData();
		dm.loadData();
		System.out.println("\nKlijenti prije brisanja Milosa: ");
		dm.printAllKlijent();
		dm.removeKlijent("milosp");
		System.out.println("\nKlijenti posle brisanja: ");
		
		System.out.println("-------------------------------------------Changing adress marijap");
		dm.klijentChangeAdresa("marijap", "Novi Sad");
		dm.printAllKlijent();
		System.out.println("--------------------------------Changing username marijap-->MARIJA");
		dm.klijentChangeKorIme("marijap", "MARIJA");
		dm.printAllKlijent();
		
		System.out.println("\n" + "------------------------------------------------Menadzeri-----------------------------------------------");
		dm.addMenadzer("lukab", "loznika345", "Luka", "Bradic", "z", "065123123", "Beograd");
		dm.MenadzerChangePlata("lukab", 600);
		dm.MenadzerChangeStaz("lukab", 5);
		dm.addMenadzer("ristom", "loznika123", "Risto", "Markovic", "m", "065123123", "Bileca");
		dm.addMenadzer("anak", "loznika234", "Ana", "Krunic", "z", "065111111", "Kraljevo");
		dm.MenadzerChangePlata("anak", 750);
		dm.MenadzerChangePlataOsnova("anak", 400);
		dm.MenadzerChangeStaz("anak", 2);
		dm.addMenadzer("milicas", "loznika345", "Milica", "Stanojlovic", "z", "065123123", "Kraljevo");
		dm.MenadzerChangePlata("milicas", 980);
		dm.MenadzerChangePlataOsnova("milicas", 700);
		dm.MenadzerChangeStaz("milicas", 1);
		dm.saveData();
		
		System.out.println("\nMenadzeri prije izmjena i brisanja 'ristom'");
		dm.printAllMenadzer();
		
		
		System.out.println("\nMenadzeri posle (lukab plata)");
		dm.MenadzerChangePlata("lukab", 800);
		dm.MenadzerChangePlataOsnova("lukab", 750);
		dm.removeMenadzer("ristom");
		dm.saveData();
		dm.loadData();
		dm.printAllMenadzer();
		
		System.out.println("\n" + "------------------------------------------------TipTretmana-----------------------------------------------");
		
		dm.addTipTretmana("Klasicni Manikir", 2);
		dm.addTipTretmana("Trajni lak",3);
		dm.addTipTretmana("Izlivanje", 4);
		dm.addTipTretmana("ZaBrisanje", 1);

		dm.saveData();
		
		System.out.println("\nTipovi Tretmana prije izmjena i brisanja 'ZaBrisanje'");
		dm.printAllTT();
		
		
		System.out.println("\nTipovi Tretmana posle (opis sportska masaza)");
		dm.TTChangeNaziv("Izlivanje", "Izlivanje gelom");
		dm.removeTT("ZaBrisanje");
		dm.printAllTT();
		
		System.out.println("\n" + "------------------------------------------------Cjenovnik-----------------------------------------------");
		dm.addCijena("Klasicni Manikir", 1000.0);
		dm.addCijena("Izlivanje gelom", 2000.0);
		dm.addCijena("Trajni lak", 2000.0);
		dm.printCjenovnik();
		
		System.out.println("Nakon izbacivanja trajni lak i promjene izlivanja: ");
		dm.changeCijena("Izlivanje gelom", 3000.0);
		dm.removeCjena("Trajni lak");
		dm.printCjenovnik();
		
		System.out.println("\nTipovi Tretmana posle brisanja trajni lak iz cjenovnika: ");
		dm.printAllTT();
		
		System.out.println("\n" + "----------------------------------------------KozmetickiSalon--------------------------------------------");
		dm.addKozmeticar("ristom", "loznika123", "Risto", "Markovic", "m", "065123123", "Bileca");
		dm.KozmeticarAddTretman("ristom", "Izlivanje gelom");
		dm.KozmeticarAddTretman("ristom", "Izlivanje gelom");
		dm.KozmeticarAddTretman("ristom", "Izlivanje gelom");
		dm.KozmeticarAddTretman("ristom", "Izlivanje gelom");
		
	}*/
}
