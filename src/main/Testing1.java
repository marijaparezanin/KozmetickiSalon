package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;


import korisnik.*;
import korisnikmanager.*;
import usluge.*;
import uslugemanager.*;
import salon.*;

public class Testing1 {
	public static void main(String[] args) {
		/*
		String delimiter = System.getProperty("file.separator");
		System.out.println("File Delimiter: " + delimiter);
		
		//file managers
		FileManager fm = new FileManager("src" + delimiter +"files" + delimiter + "kozmeticar.csv", "src" + delimiter +"files" + delimiter + "recepcioner.csv", "src" + delimiter +"files" + delimiter + "menadzer.csv");
		KlijentFileManager kfm = new KlijentFileManager("src" + delimiter +"files" + delimiter + "klijent.csv");
		TTManager tt = new TTManager("src" + delimiter +"files" + delimiter + "tiptretmana.csv");
		//TUManager tu = new TUManager("src" + delimiter +"files" + delimiter + "tretmanusluge.csv", "src" + delimiter +"files" + delimiter + "tiptretmana.csv");
		ZTManager zt = new ZTManager("src" + delimiter +"files" + delimiter + "zakazantretman.csv");
		
		//Cjenovnik cj = new Cjenovnik("src" + delimiter +"files" + delimiter + "cjenovnik.csv");
		
		//if the constructor is complete called saveData
		/*KozmetickiSalon ks = new KozmetickiSalon("MaPa Salon","08:00-20:00", "src" + delimiter +"files" + delimiter + "kozmetickisalon.csv");
		ks.loadData();
		System.out.println(ks
	
		
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("\n" + "------------------------------------------------Klijenti------------------------------------------------");

		kfm.addKlijent(new Klijent("marijap", "loznika123", "Marija", "Parezanin", "z", "065123123", "Trebinje"));
		kfm.addKlijent(new Klijent("lanap", "loznika234", "Lana", "Parezanin", "z", "065111111", "Berlin"));
		kfm.addKlijent(new Klijent("milosp", "loznika345", "Milos", "Matic", "z", "065123123", "Beograd"));
		kfm.addKlijent(new Klijent("helenat", "loznika345", "Helena", "Tadic", "z", "065123123", "Novi Sad"));
		kfm.saveData();
		kfm.loadData();
		System.out.println("\nKlijenti prije brisanja Milosa: ");
		kfm.printAll();
		kfm.remove(kfm.findByKorIme("milosp"));
		System.out.println("\nKlijenti posle brisanja: ");
		
		System.out.println("-------------------------------------------Changing adress marijap");
		kfm.findByKorIme("marijap").setAdresa("Novi Sad");
		kfm.saveChanges(kfm.findByKorIme("marijap"));
		kfm.printAll();
		System.out.println("--------------------------------Changing username marijap-->MARIJA");
		kfm.findByKorIme("marijap").setKorIme("MARIJA");
		kfm.saveChanges(kfm.findByKorIme("MARIJA"));
		kfm.printAll();
		
		System.out.println("\n" + "------------------------------------------------Menadzeri-----------------------------------------------");
		fm.addMenadzer(new Menadzer("lukab", "loznika345", "Luka", "Bradic", "z", "065123123", "Beograd"));
		fm.findByKorImeM("lukab").setPlata(600);
		fm.findByKorImeM("lukab").setStaz(5);
		fm.addMenadzer(new Menadzer("ristom", "loznika123", "Risto", "Markovic", "m", "065123123", "Bileca"));
		fm.addMenadzer(new Menadzer("anak", "loznika234", "Ana", "Krunic", "z", "065111111", "Kraljevo"));
		fm.findByKorImeM("anak").setPlata(750);
		fm.findByKorImeM("anak").setPlataOsnova(400);
		fm.findByKorImeM("anak").setStaz(2);
		fm.addMenadzer(new Menadzer("milicas", "loznika345", "Milica", "Stanojlovic", "z", "065123123", "Kraljevo"));
		fm.findByKorImeM("milicas").setPlata(980);
		fm.findByKorImeM("milicas").setPlataOsnova(700);
		fm.findByKorImeM("milicas").setStaz(1);
		fm.saveDataM();
		
		System.out.println("\nMenadzeri prije izmjena i brisanja 'ristom'");
		fm.printAllM();
		
		
		System.out.println("\nMenadzeri posle (lukab plata)");
		
		fm.findByKorImeM("lukab").setPlata(800);
		fm.findByKorImeM("lukab").setPlataOsnova(750);
		fm.saveChanges(fm.findByKorImeM("lukab"));
		
		fm.remove(fm.findByKorImeM("ristom"));
		fm.saveDataM();
		fm.loadDataM();
		fm.printAllM();

		System.out.println("\n" + "----------------------------------------------Recepcioneri----------------------------------------------");
		fm.addRecepcioner(new Recepcioner("matijaj", "loznika345", "Matija", "Jaredic", "m", "065123123", "Banja Luka"));
		fm.findByKorImeR("matijaj").setPlata(300);
		fm.findByKorImeR("matijaj").setStaz(8);
		fm.addRecepcioner(new Recepcioner("anak", "loznika234", "Ana", "Krunic", "z", "065111111", "Kraljevo"));
		fm.addRecepcioner(new Recepcioner("milijanar", "loznika123", "Milijana", "Ratkovic", "z", "065123123", "Trebinje"));
		fm.findByKorImeR("milijanar").setPlata(1200);
		fm.findByKorImeR("milijanar").setPlataOsnova(920);
		fm.findByKorImeR("milijanar").setStaz(10);
		fm.addRecepcioner(new Recepcioner("duskop", "loznika345", "Dusko", "Petkovic", "m", "065123123", "Nevesinje"));
		fm.findByKorImeR("duskop").setPlata(1500);
		fm.findByKorImeR("duskop").setPlataOsnova(1200);
		fm.findByKorImeR("duskop").setStaz(15);
		fm.saveDataR();
		
		System.out.println("\nRecepcioneri prije izmjena i brisanja 'anaK'");
		fm.printAllR();
		
		
		System.out.println("\nRecepcioneri posle (plata duskop)");

		fm.findByKorImeR("duskop").setPlata(1700);
		fm.findByKorImeR("duskop").setPlataOsnova(750);
		fm.saveChanges(fm.findByKorImeR("duskop"));
		
		fm.remove(fm.findByKorImeR("anak"));
		fm.saveDataR();
		fm.loadDataR();
		fm.printAllR();
		
		
		System.out.println("\n" + "----------------------------------------------Kozmeticari----------------------------------------------");
		fm.addKozmeticar(new Kozmeticar("violetap", "loznika345", "Violeta", "Popovic", "z", "065123123", "Banja Luka"));
		fm.findByKorImeK("violetap").setPlata(300);
		fm.findByKorImeK("violetap").setStaz(8);
		fm.addKozmeticar(new Kozmeticar("duskanr", "loznika234", "Dusan", "Radovic", "m", "065111111", "Beograd"));
		fm.addKozmeticar(new Kozmeticar("ivoa", "loznika123", "Ivo", "Andric", "m", "065123123", "Visegrad"));
		fm.findByKorImeK("ivoa").setPlata(1200);
		fm.findByKorImeK("ivoa").setPlataOsnova(920);
		fm.findByKorImeK("ivoa").setStaz(10);
		fm.addKozmeticar(new Kozmeticar("milevam", "loznika345", "Mileva", "Maric", "z", "065123123", "Titel"));
		fm.findByKorImeK("milevam").setPlata(1500);
		fm.findByKorImeK("milevam").setPlataOsnova(1200);
		fm.findByKorImeK("milevam").setStaz(15);
		fm.saveDataK();
		
		
		System.out.println("\nKozmeticari prije izmjena i brisanja 'duskanr'");
		fm.printAllK();
		
		System.out.println("\nKozmeticari posle (plata milevm)");

		fm.findByKorImeK("milevam").setPlata(1700);
		fm.findByKorImeK("milevam").setPlataOsnova(750);
		fm.saveChanges(fm.findByKorImeK("milevam"));
		
		Kozmeticar koz = new Kozmeticar("MARIJAP", "loznika345", "MARIJA", "PAREZANIN", "z", "065123123", "Banja Luka");
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(0);
		lista.add(1);
		
		koz.setspisakTretmana(lista);
		fm.addKozmeticar(koz);
		
		fm.findByKorImeK("ivoa").setspisakTretmana(lista);
		fm.saveChanges(fm.findByKorImeK("ivoa"));
		
		fm.remove(fm.findByKorImeK("duskanr"));
		fm.saveDataK();
		fm.loadDataK();
		fm.printAllK();
		System.out.println("-------------------------------------------------------------------------------------------------------");

		System.out.println("\n" + "----------------------------------------------TipTretmana----------------------------------------------");
		tt.addTipTretmana(new TipTretmana("Klasicni Manikir", "Klasićan manikir – podrazumijeva oblikovanje nokatne ploče sredjivanje zanoktica i poliranje noktiju.", 2));
		tt.addTipTretmana(new TipTretmana("Trajni lak", "Trajni lak nanosi se na prirodni nokat. Namijenjen je klijenticama kojima nokti listaju pucaju i cvjetaju", 3));
		tt.addTipTretmana(new TipTretmana("Izlivanje gelom", "Gel Lak čini savršenu kombinaciju omiljene nam boje i jakih i čvrstih noktiju", 4));
		tt.addTipTretmana(new TipTretmana("Relax masaza", "Relaks masaza utiče na opštu relaksaciju smanjuje napetost i poboljšava cirkulaciju.", 1));
		tt.addTipTretmana(new TipTretmana("Sportska masaza", "Promjena", 2));
		tt.addTipTretmana(new TipTretmana("Terapeutska (medicinska)", "Terapeutska masaža je stil koji se fokusira na postizanje rezultata.", 1));
		tt.addTipTretmana(new TipTretmana("ZaBrisanje", "Terapeutska masaža je stil koji se fokusira na postizanje rezultata.", 1));
		tt.saveData();
		
		System.out.println("\nTipovi Tretmana prije izmjena i brisanja 'ZaBrisanje'");
		tt.printAll();
		
		System.out.println("\nTipovi Tretmana posle (opis sportska masaza)");
		tt.findBynazivTretmana("Sportska masaza").setDodatniOpis("Sportska masaža je usmjerena na mišiće koji su podvrgnuti nekom udaru.");
		tt.saveChanges(tt.findBynazivTretmana("Sportska masaza"));

		
		tt.remove(tt.findBynazivTretmana("ZaBrisanje"));
		tt.saveData();
		tt.loadData();
		tt.printAll();
		
		System.out.println("\n" + "----------------------------------------------UslugaTretmana----------------------------------------------");
		tt.loadData();
		UslugeTretmana t = new UslugeTretmana("nokti");
		
		//added nokti like this
		ArrayList<Integer> listica = new ArrayList<>();
		listica.add(0);
		listica.add(1);
		listica.add(2);
		t.setspisakTretmana(listica);
		tu.addUslugeTretmana(t);
		
		//much prettier added masaza like this
		tu.addUslugeTretmana(new UslugeTretmana("m"));
		tu.printAll();
		
		System.out.println("\nNakon promjene naziva i dodavanja: ");
		tu.addTipTretmana("Relax masaza", "m");
		tu.addTipTretmana("Sportska masaza", "m");
		tu.addTipTretmana("Terapeutska (medicinska)", "m");
		
		tu.findBynazivUsluge("m").setNazivUsluge("masaza");
		tu.saveChanges(tu.findBynazivUsluge("masaza"));
		
		tu.printAll();
		
		System.out.println("\n" + "----------------------------------------------ZakazaniTretmani----------------------------------------------");
		zt.loadData();
		zt.addZakazaniTretman(new ZakazaniTretman(4, 1, 0, 200, ZakazaniTretman.STANJE.IZVRŠEN));
		zt.addZakazaniTretman(new ZakazaniTretman(4, 2, 1, 100,ZakazaniTretman.STANJE.ZAKAZAN));
		zt.printAll();
		
		
		
		System.out.println("\nPosle dodjele: ");
		ZakazaniTretman z1 = new ZakazaniTretman(4, 1, 0, 300,ZakazaniTretman.STANJE.IZVRŠEN);
		z1.setDatum(LocalDate.now());
		zt.addZakazaniTretman(z1);

		zt.printAll();
		//WHAT WILL I USE TO IDENTIFY THESE
		
		System.out.println("\n" + "----------------------------------------------Cjenovnik----------------------------------------------");

		*/
	}
}
