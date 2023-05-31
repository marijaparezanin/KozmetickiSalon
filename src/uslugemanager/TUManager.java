package uslugemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import usluge.UslugeTretmana;

public class TUManager {
	private String uslugaTretmanaPath, tipTretmanaPath;
	HashMap<Integer, UslugeTretmana> uslugeTretmana = new HashMap<Integer, UslugeTretmana>();	
	private int indTU = 0;
	
	public TUManager() {
		
	}
	
	public TUManager(String uslugaTretmanaPath, String tipTretmanaPath) {
		this.uslugaTretmanaPath = uslugaTretmanaPath;
		this.setTipTretmanaPath(tipTretmanaPath);
	}
	
	public String getTipTretmanaPath() {
		return tipTretmanaPath;
	}

	public void setTipTretmanaPath(String tipTretmanaPath) {
		this.tipTretmanaPath = tipTretmanaPath;
	}
	
	public String getuslugaTretmanaPath() {
		return uslugaTretmanaPath;
	}
	
	public void setuslugaTretmanaPath(String uslugaTretmanaPath) {
		this.uslugaTretmanaPath = uslugaTretmanaPath;
	}
	
	public HashMap<Integer, UslugeTretmana> getAllUsluge(){
		if(this.uslugeTretmana.size() == 0) {
			this.loadData();
		}
		return this.uslugeTretmana;
	}
	
	public void addUslugeTretmana(UslugeTretmana novi) {
		this.indTU = this.uslugeTretmana.size();
		novi.setId(this.indTU);

		this.uslugeTretmana.put(this.indTU, novi);
		this.indTU += 1;
		this.saveData();
	}
	
	public void addTipTretmana(String nazivTretmana, String nazivUsluge) {
		TTManager tt = new TTManager(this.tipTretmanaPath);
		tt.loadData();
		this.findBynazivUsluge(nazivUsluge).getspisakTretmana().add(tt.findBynazivTretmana(nazivTretmana).getId());
		this.saveData();
	}
	
	public boolean saveData() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.uslugaTretmanaPath, false));
			for (Map.Entry<Integer, UslugeTretmana> t : this.uslugeTretmana.entrySet()) {
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
			this.uslugeTretmana.clear();  //so it wouldnt append if the list already contains elements
			BufferedReader br = new BufferedReader(new FileReader(this.uslugaTretmanaPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				int index = Integer.parseInt(elementi[0]);
				
				UslugeTretmana t = new UslugeTretmana(elementi[1]);
				if(elementi.length == 3) {
					String[] stringElementiListe = elementi[2].split(";");
					ArrayList<Integer> lista = new ArrayList<>();
					for(int i = 0; i < stringElementiListe.length; i++) {
						lista.add(Integer.parseInt(stringElementiListe[i]));
					}					
					t.setspisakTretmana(lista);
				}
				t.setId(index);
				this.uslugeTretmana.put(index, t);	//adding to hashmap
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public UslugeTretmana findBynazivUsluge(String nazivUsluge) {
		UslugeTretmana retVal = null;
		for (Map.Entry<Integer, UslugeTretmana> t : this.uslugeTretmana.entrySet()) {
			if(t.getValue().getNazivUsluge().equals(nazivUsluge)) {
				retVal = t.getValue();
				break;
			}
		}
		return retVal;
	}
	
	public Integer getId(UslugeTretmana usluga) {	//find key based on value
		this.loadData();
		int retVal = -1;
		for (Map.Entry<Integer, UslugeTretmana> t : this.uslugeTretmana.entrySet()) {
			if(t.getValue().isEqual(usluga)) {	//custom function
				retVal = t.getKey();
				break;
			}
		}
		return retVal;
	}
	
	public void saveChanges(UslugeTretmana usluga) {
		this.uslugeTretmana.replace(usluga.getId(), usluga);
		this.saveData();
	}
	
	
	
	public boolean edit(UslugeTretmana u,String noviNazivUsluge, ArrayList<Integer> listaTretmana) {
		int id = this.getId(u);
		if (id != -1) {				//provjerim da li postoji
			u.setNazivUsluge(noviNazivUsluge);	//izmjenim prosljedjenu uslugu
			u.setspisakTretmana(listaTretmana);
			this.getAllUsluge().put(id, u);	//azuriram promjenjenu uslugu
			return true;
		}
		else {
			System.out.println("Nepostojeca usluga");
		}
		return false;
	}
	
	public boolean remove(UslugeTretmana u) {	//ako imam samo naziv usluge mogu da pozovem findBynazivUsluge koji mi vrati objekat
		this.uslugeTretmana.remove(u.getId());
		this.saveData();
		return true;
	}
	
	
	public void printAll() {
		for (Map.Entry<Integer, UslugeTretmana> u : this.uslugeTretmana.entrySet()) {
			System.out.println(u.getValue());
		}
	}

}
