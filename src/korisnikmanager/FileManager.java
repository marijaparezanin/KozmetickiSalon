package korisnikmanager;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import korisnik.*;

public class FileManager {
	private String kozmeticarPath, recepcionerPath, menadzerPath;
	HashMap<Integer, Menadzer> menadzeri = new HashMap<Integer, Menadzer>();
	HashMap<Integer, Kozmeticar> kozmeticari = new HashMap<Integer, Kozmeticar>();
	HashMap<Integer, Recepcioner> recepcioneri = new HashMap<Integer, Recepcioner>();
	private int indM = 0, indR = 0, indK = 0;
	

	public FileManager() {
		
	}
	
	public FileManager(String kozmeticarPath, String recepcionerPath, String menadzerPath) {
		this.kozmeticarPath = kozmeticarPath;
		this.recepcionerPath = recepcionerPath;
		this.menadzerPath = menadzerPath;
	}
	
	
	public String getKozmeticarPath() {
		return kozmeticarPath;
	}

	public void setKozmeticarPath(String kozmeticarPath) {
		this.kozmeticarPath = kozmeticarPath;
	}

	public String getRecepcionerPath() {
		return recepcionerPath;
	}

	public void setRecepcionerPath(String recepcionerPath) {
		this.recepcionerPath = recepcionerPath;
	}

	public String getMenadzerPath() {
		return menadzerPath;
	}

	public void setMenadzerPath(String menadzerPath) {
		this.menadzerPath = menadzerPath;
	}
	
	
	public HashMap<Integer, Menadzer> getAllMenadzeri() {
		if(this.menadzeri.size() == 0) {
			this.loadDataM();
		}
		return this.menadzeri;
	}
	
	
	
	public HashMap<Integer, Recepcioner> getAllRecepcioneri() {
		if(this.recepcioneri.size() == 0) {
			this.loadDataR();
		}
		return this.recepcioneri;
	}
	
	public HashMap<Integer, Kozmeticar> getAllKozmeticari() {
		if(this.kozmeticari.size() == 0) {
			this.loadDataK();
		}
		return this.kozmeticari;
	}
	
	public void setAllKozmeticari(HashMap<Integer, Kozmeticar> kozmeticari) {
		this.kozmeticari = kozmeticari;
	}
	
	//------------------------------------------CREATE------------------------------------------------------
	public void addRecepcioner(Recepcioner novi) {
		this.indR = this.recepcioneri.size();
		novi.setId(indR);
		this.recepcioneri.put(indR, novi);
		this.indR += 1;
		this.saveDataR();

	}
	
	public void addMenadzer(Menadzer novi) {
		this.indM = menadzeri.size();
		novi.setId(indM);
		this.menadzeri.put(indM, novi);
		this.indM += 1;
		this.saveDataM();
	}
	
	public void addKozmeticar(Kozmeticar novi) {
		this.indK = kozmeticari.size();
		novi.setId(indK);

		this.kozmeticari.put(this.indK, novi);
		this.indK += 1;
		this.saveDataK();
	}
	
	
	/*Saves from hashmap to file*/
	
	public boolean saveDataM() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.menadzerPath, false));
			for (Map.Entry<Integer, Menadzer> m : menadzeri.entrySet()) {
				pw.println(m.getKey() + "," + (m.getValue()).toFileString());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean saveDataR() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.recepcionerPath, false));
			for (Map.Entry<Integer, Recepcioner> r : this.recepcioneri.entrySet()) {
				pw.println(r.getKey() + "," + (r.getValue()).toFileString());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean saveDataK() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.kozmeticarPath, false));
			for (Map.Entry<Integer, Kozmeticar> k : this.kozmeticari.entrySet()) {
				pw.println(k.getKey() + "," + (k.getValue()).toFileString());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean saveDataAll() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.kozmeticarPath, false));
			for (Map.Entry<Integer, Kozmeticar> k : kozmeticari.entrySet()) {
				pw.println(k.getKey() + "," + (k.getValue()).toFileString());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.recepcionerPath, false));
			for (Map.Entry<Integer, Recepcioner> r : recepcioneri.entrySet()) {
				pw.println(r.getKey() + "," + (r.getValue()).toFileString());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.menadzerPath, false));
			for (Map.Entry<Integer, Menadzer> m : menadzeri.entrySet()) {
				pw.println(m.getKey() + "," + (m.getValue()).toFileString());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}		
		return true;
	}

	//--------------------------------------READ--------------------------------------------------------------
	/*Importing from file to hashmap*/
	
	public boolean loadDataR() {
		try {
			this.recepcioneri.clear();  //so it wouldnt append if the list already contains elements
			BufferedReader br = new BufferedReader(new FileReader(this.recepcionerPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				int index = Integer.parseInt(elementi[0]);

				Boolean izbrisan = Boolean.parseBoolean(elementi[13]);
				Recepcioner m = new Recepcioner(elementi[1], elementi[2],elementi[3],elementi[4],elementi[5], elementi[6], elementi[7], izbrisan);
				if (!elementi[8].equals("null")) {
					m.setNivo(Double.parseDouble(elementi[8]));}
				if (!elementi[9].equals("null")) {
					m.setStaz(Double.parseDouble(elementi[9]));}
				if (!elementi[10].equals("null")) {
					m.setPlataOsnova(Double.parseDouble(elementi[10]));}
				if (!elementi[11].equals("null")) {
					m.setPlata(Double.parseDouble(elementi[11]));}
				if (!elementi[12].equals("null")) {
					m.setBonus(elementi[12] == "true");}	//vratice boolean
				m.setId(index);
				this.recepcioneri.put(index, m);	//adding to hashmap
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean loadDataM() {
		try {
			this.menadzeri.clear();
			BufferedReader br = new BufferedReader(new FileReader(this.menadzerPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				int index = Integer.parseInt(elementi[0]);
				Boolean izbrisan = Boolean.parseBoolean(elementi[15]);

				Menadzer m = new Menadzer(elementi[1], elementi[2],elementi[3],elementi[4],elementi[5], elementi[6], elementi[7], izbrisan);
				if (!elementi[8].equals("null")) {
					m.setKriterijumBonus(Double.parseDouble(elementi[8]));}
				if (!elementi[9].equals("null")) {
					m.setKriterijumLojalnost(Double.parseDouble(elementi[9]));}
				if (!elementi[10].equals("null")) {
					m.setNivo(Double.parseDouble(elementi[10]));}
				if (!elementi[11].equals("null")) {
					m.setStaz(Double.parseDouble(elementi[11]));}
				if (!elementi[12].equals("null")) {
					m.setPlataOsnova(Double.parseDouble(elementi[12]));}
				if (!elementi[13].equals("null")) {
					m.setPlata(Double.parseDouble(elementi[13]));}
				if (!elementi[14].equals("null")) {
					m.setBonus(elementi[14] == "true");}	//vratice boolean
				m.setId(index);
				this.menadzeri.put(index, m);
									
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean loadDataK() {
		try {
			this.kozmeticari.clear();  //so it wouldnt append if the list already contains elements
			BufferedReader br = new BufferedReader(new FileReader(this.kozmeticarPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				int index = Integer.parseInt(elementi[0]);
				Boolean izbrisan = Boolean.parseBoolean(elementi[14]);
				Kozmeticar k = new Kozmeticar(elementi[1], elementi[2],elementi[3],elementi[4],elementi[5], elementi[6], elementi[7], izbrisan);
				
				if (!elementi[8].equals("")) {
					String[] elementiStringListe = elementi[8].split(";");
					ArrayList<Integer> spisakTretmana = new ArrayList<>();
					for(int i = 0; i < elementiStringListe.length; i++) {
						spisakTretmana.add(Integer.parseInt(elementiStringListe[i]));
					}
					k.setSpisakUsluga(spisakTretmana);
				}
				if (!elementi[9].equals("null")) {
					k.setNivo(Double.parseDouble(elementi[9]));}
				if (!elementi[10].equals("null")) {
					k.setStaz(Double.parseDouble(elementi[10]));}
				if (!elementi[11].equals("null")) {
					k.setPlataOsnova(Double.parseDouble(elementi[11]));}
				if (!elementi[12].equals("null")) {
					k.setPlata(Double.parseDouble(elementi[12]));}
				if (!elementi[13].equals("null")) {
					k.setBonus(elementi[13] == "true");}	//vratice boolean
				k.setId(index);
				this.kozmeticari.put(index, k);	//adding to hashmap
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	//----------------------------------------UPDATE----------------------------------------------
	//method overloading
	public void saveChanges(Kozmeticar kozmeticar) {
		this.kozmeticari.replace(kozmeticar.getId(), kozmeticar);
		this.saveDataK();
	}
	
	public void saveChanges(Menadzer menadzer) {
		this.menadzeri.replace(menadzer.getId(), menadzer);
		this.saveDataM();
	}
	
	public void saveChanges(Recepcioner recepcioner) {
		this.recepcioneri.replace(recepcioner.getId(), recepcioner);
		this.saveDataR();
	}
	

	public boolean edit(Kozmeticar kozmeticar, String korisnickoIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa) {
		int id = this.getId(kozmeticar);
		if (id != -1) {
			kozmeticar.setKorIme(korisnickoIme);
			kozmeticar.setLozinka(lozinka);
			kozmeticar.setIme(ime);
			kozmeticar.setPrezime(prezime);
			kozmeticar.setPol(pol);
			kozmeticar.setTelefon(telefon);
			kozmeticar.setAdresa(adresa);
			this.getAllKozmeticari().put(id, kozmeticar);
			this.saveDataK();
		}
		else {
			System.out.println("Nepostojeci kozmeticar");
			return false;
		}
		return true;
	}
	
	public boolean edit(Menadzer menadzer, String korisnickoIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa) {
		int id = this.getId(menadzer);
		if (id != -1) {
			menadzer.setKorIme(korisnickoIme);
			menadzer.setLozinka(lozinka);
			menadzer.setIme(ime);
			menadzer.setPrezime(prezime);
			menadzer.setPol(pol);
			menadzer.setTelefon(telefon);
			menadzer.setAdresa(adresa);
			this.getAllMenadzeri().put(id, menadzer);
			this.saveDataM();
		}
		else {
			System.out.println("Nepostojeci menadzer");
			return false;
		}
		return true;
	}
	
	public boolean edit(Recepcioner recepcioner, String korisnickoIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa) {
		int id = this.getId(recepcioner);
		if (id != -1) {
			recepcioner.setKorIme(korisnickoIme);
			recepcioner.setLozinka(lozinka);
			recepcioner.setIme(ime);
			recepcioner.setPrezime(prezime);
			recepcioner.setPol(pol);
			recepcioner.setTelefon(telefon);
			recepcioner.setAdresa(adresa);
			this.getAllRecepcioneri().put(id, recepcioner);
			this.saveDataR();
		}
		else {
			System.out.println("Nepostojeci recepcioner");
			return false;
		}
		return true;
	}
	
	//----------------------------------------DELETE-------------------------------------
	//method overloading
	
	public boolean remove(Kozmeticar kozmeticar) {
		if (this.getId(kozmeticar)!= -1) {
			for (Map.Entry<Integer, Kozmeticar> k : this.getAllKozmeticari().entrySet()) {
				if(k.getValue().isEqual(kozmeticar)) {
					this.getAllKozmeticari().remove(k.getKey());
					break;
				}
			}
		}
		else {
			System.out.println("Nepostojeci kozmeticar");
			return false;
		}
		this.saveDataK();
		return true;
	}
	
	public boolean remove(Menadzer menadzer) {
		if (this.getId(menadzer)!= -1) {
			for (Map.Entry<Integer, Menadzer> m : this.getAllMenadzeri().entrySet()) {
				if(m.getValue().isEqual(menadzer)) {
					this.getAllMenadzeri().remove(m.getKey());
					break;
				}
			}
		}
		else {
			System.out.println("Nepostojeci menadzer");
			return false;
		}
		this.saveDataM();
		return true;
	}

	public boolean remove(Recepcioner recepcioner) {
		/*
		if (this.getId(recepcioner)!= -1) {
			for (Map.Entry<Integer, Recepcioner> r : this.getAllRecepcioneri().entrySet()) {
				if(r.getValue().isEqual(recepcioner)) {
					this.getAllRecepcioneri().remove(r.getKey());
					break;
				}
			}
		}
		else {
			System.out.println("Nepostojeci recepcioner");
			return false;
		}
		this.saveDataR();*/
		if (this.getId(recepcioner)!= -1) {
			for (Map.Entry<Integer, Recepcioner> r : this.getAllRecepcioneri().entrySet()) {
				if(r.getValue().isEqual(recepcioner)) {
					r.getValue().setIzbrisan(true);
					System.out.println(r.getValue());
					System.out.println("------------");
					System.out.println(recepcioner.getId());
					this.recepcioneri.replace(recepcioner.getId(), r.getValue());
					System.out.println("------------");

					System.out.println(recepcioneri);
					this.saveDataR();

					break;
				}
			}
		}
		else {
			System.out.println("Nepostojeci recepcioner");
			return false;
		}
		this.saveDataR();
		return true;
	}
	//---------------------------------------------------------------------------------------------------
	//get key from value
	//Method overloading
	public Integer getId(Kozmeticar kozmeticar) {
		this.loadDataK();
		int retVal = -1;
		for (Map.Entry<Integer, Kozmeticar> k : this.getAllKozmeticari().entrySet()) {
			if(k.getValue().isEqual(kozmeticar)) {	//custom function
				retVal = k.getKey();
				break;
			}
		}
		return retVal;
	}
	
	public Integer getId(Menadzer menadzer) {
		this.loadDataM();
		int retVal = -1;
		for (Map.Entry<Integer, Menadzer> m : this.getAllMenadzeri().entrySet()) {
			if(m.getValue().isEqual(menadzer)) {	//custom function
				retVal = m.getKey();
				break;
			}
		}
		return retVal;
	}
	
	public Integer getId(Recepcioner recepcioner) {
		this.loadDataR();
		int retVal = -1;
		for (Map.Entry<Integer, Recepcioner> r : this.getAllRecepcioneri().entrySet()) {
			if(r.getValue().isEqual(recepcioner)) {	//custom function
				retVal = r.getKey();
				break;
			}
		}
		return retVal;
	}
	
	
	public void printAllM() {
		for (Map.Entry<Integer, Menadzer> m : this.getAllMenadzeri().entrySet()) {
			System.out.println(m.getValue());
		}
	}
	
	public void printAllK() {
		for (Map.Entry<Integer, Kozmeticar> k : this.getAllKozmeticari().entrySet()) {
			System.out.println(k.getValue());
		}
	}
	
	public void printAllR() {
		for (Map.Entry<Integer, Recepcioner> r : this.getAllRecepcioneri().entrySet()) {
			System.out.println(r.getValue());
		}
	}
	
	
	/*Search by username, returns null if not found*/
	
	public Recepcioner findByKorImeR(String korIme) {
		Recepcioner retVal = null;
		for (Map.Entry<Integer, Recepcioner> r : recepcioneri.entrySet()) {
			if(r.getValue().getKorIme().equals(korIme))
				return(r.getValue());
		}
		return retVal;
	}
	
	public Menadzer findByKorImeM(String korIme) {
		Menadzer retVal = null;
		for(Map.Entry<Integer, Menadzer> entry :menadzeri.entrySet()) {
			Menadzer m = entry.getValue();
			if (m.getKorIme().equals(korIme)){
				return m;
			}
		}
		return retVal;
	}
	
	public Kozmeticar findByKorImeK(String korIme) {
		Kozmeticar retVal = null;
		for (Map.Entry<Integer, Kozmeticar> k : kozmeticari.entrySet()) {
			if(k.getValue().getKorIme().equals(korIme))
				return(k.getValue());
		}
		return retVal;
	}
	
	
	/*Login validation for diffrent users*/
	
	public Menadzer isValidUserM(String korIme, String lozinka) {
		if (this.findByKorImeM(korIme) != null) {
			if(!this.findByKorImeM(korIme).isIzbrisan()) {
	
				if (this.findByKorImeM(korIme).getLozinka().equals(lozinka)) {
					return this.findByKorImeM(korIme);
				}
			}
		}
		return null;
	}
	
	public Recepcioner isValidUserR(String korIme, String lozinka) {
		if (this.findByKorImeR(korIme) != null) {
			if(!this.findByKorImeR(korIme).isIzbrisan()) {
				if(!this.findByKorImeR(korIme).isIzbrisan()) {
					if (this.findByKorImeR(korIme).getLozinka().equals(lozinka)) {
						return this.findByKorImeR(korIme);
					}
				}
			}
			
		}
		return null;
	}
	
	public Kozmeticar isValidUserK(String korIme, String lozinka) {
		if (this.findByKorImeK(korIme) != null) {
			if(!this.findByKorImeK(korIme).isIzbrisan()) {
				if (this.findByKorImeK(korIme).getLozinka().equals(lozinka)) {
					return this.findByKorImeK(korIme);
				}			
			}
		}
		return null;
	}
	
}
