package uslugemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import usluge.TipTretmana;


public class TTManager{
	private String tipTretmanaPath;
	HashMap<Integer, TipTretmana> tipoviTretmana = new HashMap<Integer, TipTretmana>();	
	private int indTT = 0;
	
	public TTManager() {
		
	}
	
	public TTManager(String tipTretmanaPath) {
		this.tipTretmanaPath = tipTretmanaPath;
	}
	
	public String getTipTretmanaPath() {
		return tipTretmanaPath;
	}
	
	public void setTipTretmanaPath(String tipTretmanaPath) {
		this.tipTretmanaPath = tipTretmanaPath;
	}
	
	public HashMap<Integer, TipTretmana> getAllTipovi(){
		if(this.tipoviTretmana.size() == 0) {
			this.loadData();
		}
		return this.tipoviTretmana;
	}
	
	public Integer getId(TipTretmana novi) {
		for (Map.Entry<Integer, TipTretmana> t : this.getAllTipovi().entrySet()) {
			if(novi.isEqual(t.getValue())) {
				return t.getKey();
			}
		}
		return -1;
	}
	
	public void addTipTretmana(TipTretmana novi) {
		this.indTT = tipoviTretmana.size();
		novi.setId(this.indTT);
		this.tipoviTretmana.put(this.indTT, novi);
		this.indTT += 1;
		this.saveData();
	}

	public boolean saveData() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.tipTretmanaPath, false));
			for (Map.Entry<Integer, TipTretmana> t : this.tipoviTretmana.entrySet()) {
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
			this.tipoviTretmana.clear();  //so it wouldnt append if the list already contains elements
			BufferedReader br = new BufferedReader(new FileReader(this.tipTretmanaPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				int index = Integer.parseInt(elementi[0]);
				TipTretmana t = new TipTretmana(elementi[1]);
				t.setVrijemeTrajanja(Integer.parseInt(elementi[2]));
				t.setCijena(Double.parseDouble(elementi[3]));
				t.setId(index);
				this.tipoviTretmana.put(index, t);	//adding to hashmap
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public TipTretmana findBynazivTretmana(String nazivTretmana) {
		TipTretmana retVal = null;
		for (Map.Entry<Integer, TipTretmana> t : tipoviTretmana.entrySet()) {
			if(t.getValue().getnazivTretmana().equals(nazivTretmana)) {
				retVal = t.getValue();
				break;
			}
		}
		return retVal;
	}
	
	public void saveChanges(TipTretmana tiptretmana) {
		this.tipoviTretmana.replace(tiptretmana.getId(), tiptretmana);
		this.saveData();
	}
	
	
	public boolean edit(TipTretmana tretman,String nazivTretmana, Double cijena, Integer trajanje) {
		int id = this.getId(tretman);
		if (id != -1) {
			tretman.setnazivTretmana(nazivTretmana);
			tretman.setVrijemeTrajanja(trajanje);
			this.getAllTipovi().put(id, tretman);
			this.saveData();
		}
		else {
			System.out.println("Nepostojeci tretman");
		}
		return false;
	}

	
	public void remove(TipTretmana tretman) {
		this.tipoviTretmana.remove(tretman.getId());
		this.saveData();
	}
	
	public void printAll() {
		for (Map.Entry<Integer, TipTretmana> t : this.getAllTipovi().entrySet()) {
			System.out.println(t.getValue());
		}
	}
}
