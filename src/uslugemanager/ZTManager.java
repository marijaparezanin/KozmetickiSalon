package uslugemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import korisnikmanager.FileManager;
import korisnikmanager.KlijentFileManager;
//import salon.CjenovnikManager;
import usluge.ZakazaniTretman;

enum STANJE{
	ZAKAZAN,
	IZVRŠEN,
	OTKAZAOKLIJENT,
	OTKAZAOSALON, 
	NIJESEPOJAVIO
}

public class ZTManager {
	private String zakazaniTretmaniPath;
	HashMap<Integer, ZakazaniTretman> zakazaniTretmani = new HashMap<Integer, ZakazaniTretman>();	
	private int indTT = 0;
	FileManager fm = new FileManager();
	KlijentFileManager kfm = new KlijentFileManager();
	//CjenovnikManager cj = new CjenovnikManager();
	TTManager tt = new TTManager();
	
	public ZTManager() {
		
	}
	
	public ZTManager(String zakazaniTretmaniPath) {
		this.zakazaniTretmaniPath = zakazaniTretmaniPath;
	}
	
	public String getZakazaniTretmaniPath() {
		return zakazaniTretmaniPath;
	}
	
	public void setZakazaniTretmaniPath(String zakazaniTretmaniPath) {
		this.zakazaniTretmaniPath = zakazaniTretmaniPath;
	}
	
	public HashMap<Integer, ZakazaniTretman> getAllZakazani(){
		if(this.zakazaniTretmani.size() == 0) {
			this.loadData();
		}
		return this.zakazaniTretmani;
	}
	
	public Integer getId(ZakazaniTretman novi) {
		for (Map.Entry<Integer, ZakazaniTretman> t : this.getAllZakazani().entrySet()) {
			if(novi.isEqual(t.getValue())) {
				return t.getKey();
			}
		}
		return -1;
	}
	
	public void addZakazaniTretman(ZakazaniTretman novi) {
		this.indTT = this.zakazaniTretmani.size();
		novi.setId(this.indTT);
		this.zakazaniTretmani.put(this.indTT, novi);
		this.indTT += 1;
		this.saveData();
	}
	
	public void saveChanges(ZakazaniTretman zakazaniTretmani) {
		this.zakazaniTretmani.replace(zakazaniTretmani.getId(), zakazaniTretmani);
		//this.generateCijena();
		this.saveData();
	}

	public ZakazaniTretman findByVrijeme(LocalDateTime vrijeme) {
		for (Map.Entry<Integer, ZakazaniTretman> t : this.zakazaniTretmani.entrySet()) {
			if(t.getValue().getVrijeme().equals(vrijeme)) {
				return t.getValue();
			}
		}
		return null;
	}
	
	/*
	public boolean generateCijena() {
		cj.load
		for (Map.Entry<Integer, ZakazaniTretman> t : this.zakazaniTretmani.entrySet()) {
			t.getValue().setCijena(cj.ge);
		}
		
		return false;
	}*/

	public boolean saveData() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.zakazaniTretmaniPath, false));
			for (Map.Entry<Integer, ZakazaniTretman> t : this.zakazaniTretmani.entrySet()) {
				pw.println(t.getKey() + "," + (t.getValue()).toFileString());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean loadData() {
		try {
			this.zakazaniTretmani.clear();  //so it wouldnt append if the list already contains elements
			BufferedReader br = new BufferedReader(new FileReader(this.zakazaniTretmaniPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				int index = Integer.parseInt(elementi[0]);
				ZakazaniTretman t = new ZakazaniTretman();
				
				t.setTipTretmanaID(Integer.parseInt(elementi[1]));
				t.setKlijentID(Integer.parseInt(elementi[2]));
				t.setKozmeticarID(Integer.parseInt(elementi[3]));
				ZakazaniTretman.STANJE state = ZakazaniTretman.STANJE.valueOf(elementi[4]);
				t.setStanje(state);
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					t.setVrijeme(LocalDateTime.parse(elementi[5], formatter));
				}catch(Exception e) {
				}
				t.setCijena(Double.parseDouble(elementi[6]));
				t.setId(index);
				this.zakazaniTretmani.put(index, t);	//adding to hashmap
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean remove(ZakazaniTretman tretman) {
		this.getAllZakazani().remove(tretman.getId());
		this.saveData();
		return true;
	}
	
	public void printAll() {
		for (Map.Entry<Integer, ZakazaniTretman> t : this.getAllZakazani().entrySet()) {
			System.out.println(t.getValue());
		}
	}

}
