package korisnikmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import korisnik.Klijent;

public class KlijentFileManager {
	private String klijentPath;
	HashMap<Integer, Klijent> klijenti = new HashMap<Integer, Klijent>();	
	private int indK = 0;
	
	public KlijentFileManager() {
		
	}
	
	public KlijentFileManager(String klijentPath) {
		this.klijentPath = klijentPath;
	}
	
	public void setKlijentPath(String klijentPath) {
		this.klijentPath = klijentPath;
	}
	
	public String getKlijentPath() {
		return this.klijentPath;
	}
	
	public HashMap<Integer, Klijent> getAllKlijenti(){
		if(this.klijenti.size() == 0) {
			this.loadData();
		}
		return this.klijenti;
	}
	
	public void addKlijent(Klijent novi) {
		this.indK = this.klijenti.size();
		novi.setId(indK);
		this.klijenti.put(indK, novi);
		this.indK += 1;
		this.saveData();
	}
	
	
/*Saves from hashmap to file*/
	
	public boolean saveData() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.klijentPath, false));
			for (Map.Entry<Integer, Klijent> k : klijenti.entrySet()) {
				pw.println(k.getKey() + "," + (k.getValue()).toFileString());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
/*Importing from file to hashmap*/
	
	public boolean loadData() {
		try {
			this.klijenti.clear();  //so it wouldnt append if the list already contains elements
			BufferedReader br = new BufferedReader(new FileReader(this.klijentPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				int index = Integer.parseInt(elementi[0]);
				Boolean izbrisan = Boolean.parseBoolean(elementi[8]);
				Klijent k = new Klijent(elementi[1], elementi[2],elementi[3],elementi[4],elementi[5], elementi[6], elementi[7], izbrisan);
				k.setId(index);
				this.klijenti.put(index, k);	//adding to hashmap
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public Integer getId(Klijent klijent) {
		this.loadData();
		int retVal = -1;
		for (Map.Entry<Integer, Klijent> k : this.getAllKlijenti().entrySet()) {
			if(k.getValue().isEqual(klijent)) {	//custom function
				retVal = k.getKey();
				break;
			}
		}
		return retVal;
	}
	
	public Klijent findByKorIme(String korIme) {
		Klijent retVal = null;
		for (Map.Entry<Integer, Klijent> k : klijenti.entrySet()) {
			if(k.getValue().getKorIme().equals(korIme))
				return(k.getValue());
		}
		return retVal;
	}
	
	//----------------------------------------UPDATE----------------------------------------------
	public void saveChanges(Klijent klijent) {
		this.klijenti.replace(klijent.getId(), klijent);
		this.saveData();
	}
	
	public boolean edit(Klijent klijent,String korisnickoIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa) {
		int id = this.getId(klijent);
		if (id != -1) {
			klijent.setKorIme(korisnickoIme);
			klijent.setLozinka(lozinka);
			klijent.setIme(ime);
			klijent.setPrezime(prezime);
			klijent.setPol(pol);
			klijent.setTelefon(telefon);
			klijent.setAdresa(adresa);
			this.getAllKlijenti().put(id, klijent);
			this.saveData();
		}
		else {
			System.out.println("Nepostojeci korisnik");
			return false;
		}
		return true;
	}
	
	//----------------------------------------DELETE-------------------------------------
	public boolean remove(Klijent klijent) {
		if (this.getId(klijent) != -1) {
			this.getAllKlijenti().remove(this.getId(klijent));
		}
		else {
			System.out.println("Nepostojeci korisnik");
			return false;
		}
		this.saveData();
		return true;
	}
	
	public Klijent isValidUser(String korIme, String lozinka) {
		if (this.findByKorIme(korIme) != null) {
			if(!this.findByKorIme(korIme).isIzbrisan()) {
				if (this.findByKorIme(korIme).getLozinka().equals(lozinka)) {
					return this.findByKorIme(korIme);
				}
			}
			
			
		}
		return null;
	}
	
	
	public void printAll() {
		this.loadData();
		for (Map.Entry<Integer, Klijent> k : this.getAllKlijenti().entrySet()) {
			System.out.println(k.getValue());
		}
	}
	
	
}


