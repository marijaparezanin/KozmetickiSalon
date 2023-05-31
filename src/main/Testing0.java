package main;
/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import korisnik.*;
import usluge.*;
import korisnikmanager.*;
import uslugemanager.*;*/

public class Testing0 {

	/*public static void main(String[] args) {
		String delimiter = System.getProperty("file.separator");
		System.out.println(delimiter);
		FileManager fm = new FileManager("src" + delimiter +"files" + delimiter + "kozmeticar.csv", "src" + delimiter +"files" + delimiter + "recepcioner.csv", "src" + delimiter +"files" + delimiter + "menadzer.csv");
		
		System.out.println("---------------------Menadzeri------------------------------");

		// making new managers
		Menadzer m1 = new Menadzer("marijapar", "sifra","Marija", "Parezanin", "z", "065123123", "Knez Mihajlova 15");
		Menadzer m2 = new Menadzer("lanapar", "sifra","Lana", "Parezanin", "z", "065123123", "Knez Mihajlova 15");
		
		
		// adding to hm of all managers
		fm.addMenadzer(m1);
		fm.addMenadzer(m2);
		fm.saveDataM();
		
		// retrieving all managers
		HashMap<Integer, Menadzer> menadzeri = fm.getAllMenadzeri();
		//printing retrieved managers
		for (Map.Entry<Integer, Menadzer> m : menadzeri.entrySet()) {
			System.out.println(m.getKey() + "," + (m.getValue()).toFileString());
		}
		
		//saving to file
		fm.saveDataM();
		
		System.out.println();
		//loading hm from file
		fm.loadDataM();
		//getting and printing the hm
		menadzeri = fm.getAllMenadzeri();
		for (Map.Entry<Integer, Menadzer> m : menadzeri.entrySet()) {
			System.out.println(m.getKey() + "," + (m.getValue()).toFileString());
		}
		
		System.out.println("---------------------Kozmeticari------------------------------");
		
		// making new Kozmeticar
		Kozmeticar k1 = new Kozmeticar("arijapar", "sifra","Marija", "Parezanin", "z", "065123123", "Knez Mihajlova 15");
		Kozmeticar k2 = new Kozmeticar("lanapar", "sifra","Lana", "Parezanin", "z", "065123123", "Knez Mihajlova 15");
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(0);
		lista.add(3);
		lista.add(8);
		k1.setspisakTretmana(lista);
		//k2.setspisakTretmana(lista);

		// adding to hm of all managers
		fm.addKozmeticar(k1);
		fm.addKozmeticar(k2);
		fm.saveDataK();
		
		// retrieving all managers
		HashMap<Integer, Kozmeticar> kozmeticari = fm.getAllKozmeticari();
		//printing retrieved managers
		
		for (Map.Entry<Integer, Kozmeticar> k : kozmeticari.entrySet()) {
			System.out.println(k.getKey() + "," + (k.getValue()).toFileString());
		}
		System.out.println();
		//saving to file
		fm.saveDataK();
		//loading hm from file
		fm.loadDataK();
		//getting and printing the hm
		kozmeticari = fm.getAllKozmeticari();
		for (Map.Entry<Integer, Kozmeticar> k : kozmeticari.entrySet()) {
			System.out.println(k.getKey() + "," + (k.getValue()).toFileString());
		}
		
		fm.remove("arijapar");
		System.out.println("after");
		for (Map.Entry<Integer, Kozmeticar> k : kozmeticari.entrySet()) {
			System.out.println(k.getKey() + "," + (k.getValue()).toFileString());
		}
		fm.saveDataK();
				
		System.out.println("---------------------Recepcionari------------------------------");
		// making new Kozmeticar
		Recepcioner r1 = new Recepcioner("marijap", "sifra","Marija", "Parezanin", "z", "065123123", "Knez Mihajlova 15");
		Recepcioner r2 = new Recepcioner("lanapar", "sifra","Lana", "Parezanin", "z", "065123123", "Knez Mihajlova 15");

		// adding to hm of all managers
		fm.addRecepcioner(r1);
		fm.addRecepcioner(r2);
		fm.saveDataR();
		HashMap<Integer, Recepcioner> recepcioneri = fm.getAllRecepcioneri();
		//printing retrieved managers
		
		for (Map.Entry<Integer, Recepcioner> r : recepcioneri.entrySet()) {
			System.out.println(r.getKey() + "," + (r.getValue()).toFileString());
		}
		fm.saveDataR();
		// retrieving all managers
		recepcioneri = fm.getAllRecepcioneri();
		//printing retrieved managers
		
		for (Map.Entry<Integer, Recepcioner> r : recepcioneri.entrySet()) {
			System.out.println(r.getKey() + "," + (r.getValue()).toFileString());
		}
		System.out.println();

		//loading hm from file
		fm.loadDataR();
		//getting and printing the hm
		recepcioneri = fm.getAllRecepcioneri();
		for (Map.Entry<Integer, Recepcioner> r : recepcioneri.entrySet()) {
			System.out.println(r.getKey() + "," + (r.getValue()).toFileString());
		}
		
		fm.remove("marijap");
		
		
		
		
		
		System.out.println("---------------------Klijenti------------------------------");

		KlijentFileManager kfm = new KlijentFileManager("src" + delimiter + "files" + delimiter + "klijent.csv");
		kfm.addKlijent(new Klijent("Marko", "Markovic"));
		kfm.saveData();
		HashMap<Integer, Klijent> klijenti = kfm.getAllKlijenti();
		
		System.out.println("\nKlijenti after addition and saving to file: ");
		for (Map.Entry<Integer, Klijent> r : klijenti.entrySet()) {
			System.out.println(r.getKey() + "," + r.getValue());
		}
		
		kfm.addKlijent(new Klijent("kor", "pass", "Miki",  "markovic",  "z", "065", "beograd"));
		kfm.saveData();
		kfm.loadData();
		for (Map.Entry<Integer, Klijent> r : klijenti.entrySet()) {
			System.out.println(r.getKey() + "," + r.getValue());
		}
		kfm.remove("kor");
		kfm.saveData();
		
		
		
		System.out.println("---------------------Tipovi Tretmana------------------------------");
		TTManager ttm = new TTManager("src" + delimiter + "files" + delimiter + "tiptretmana.csv");
		ttm.addTipTretmana(new TipTretmana("gel nokti", "Profesionalno izlivanje gel noktiju"));
		ttm.saveData();
		HashMap<Integer, TipTretmana> tipoviTretmana = ttm.getAllTipovi();
		
		for (Map.Entry<Integer, TipTretmana> r : tipoviTretmana.entrySet()) {
			System.out.println(r.getKey() + "," + r.getValue());
		}
		
		ttm.addTipTretmana(new TipTretmana("akrilik nokti", "Profesionalno izlivanje gel noktiju"));
		ttm.saveData();
		ttm.loadData();
		for (Map.Entry<Integer, TipTretmana> r : tipoviTretmana.entrySet()) {
			System.out.println(r.getKey() + "," + r.getValue());
		}
		ttm.remove("akrilik nokti");
		ttm.saveData();
		
		ttm.addTipTretmana(new TipTretmana("akrilik nokti", "Profesionalno izlivanje gel noktiju"));
		ttm.saveData();
		System.out.println("---------------------Cjenovnik------------------------------");
		Cjenovnik cj = new Cjenovnik("src" + delimiter + "files" + delimiter + "cjenovnik.csv");
		HashMap<Integer, Double> cjenovnik = cj.getCjenovnik();
		System.out.println(tipoviTretmana.get(2));
		cj.addCijena(tipoviTretmana.get(2), 50.20);
		System.out.println(cj);
		cj.addCijena(tipoviTretmana.get(0), 25);
		cj.remove(tipoviTretmana.get(2));
		System.out.println(cj);
		System.out.println("---------------------UslugeTretmana------------------------------");
	}*/

}
