package salon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import usluge.TipTretmana;



public class Cjenovnik {
	private String cjenovnikPath;
	HashMap<Integer, Double> cjenovnik = new HashMap<Integer, Double>();	
	//HashMap<Integer, Cjenovnik> cjenovnici = new HashMap<Integer, Cjenovnik>();	
	int indC = 0;
	
	public Cjenovnik() {
		
	}
	
	public Cjenovnik(String cjenovnikPath) {
		this.cjenovnikPath = cjenovnikPath;
	}

	public double getCijena(TipTretmana tt) {
		return cjenovnik.get(tt.getId());
	}
	
	public void setCjenovnikPath(String cjenovnikPath) {
		this.cjenovnikPath = cjenovnikPath;
	}
	
	public String getCjenovnikPath() {
		return this.cjenovnikPath;
	}
	
	public HashMap<Integer, Double> getCjenovnik(){
		return this.cjenovnik;
	}
	
	public void addCijena(TipTretmana tip, double cijena) {
		this.indC = tip.getId(); 
		this.cjenovnik.put(indC, cijena);
		this.saveData();
	}
	
	
	public boolean saveData() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.cjenovnikPath, false));
			for (Map.Entry<Integer, Double> t : this.cjenovnik.entrySet()) {
				pw.println(t.getKey() + "," + t.getValue());	//treba mi getvalue da bi dosla do objekta i mogla koristiti njegove metode
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean loadData() {
		try {
			this.cjenovnik.clear();  //so it wouldnt append if the list already contains elements
			BufferedReader br = new BufferedReader(new FileReader(this.cjenovnikPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				int index = Integer.parseInt(elementi[0]);
				double cijena = Double.parseDouble(elementi[1]);			
				this.cjenovnik.put(index, cijena);	//adding to hashmap
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public void remove(TipTretmana tip) {
		Integer index = tip.getId();
		this.cjenovnik.remove(index);
		this.saveData();
	}

	
	/*
	//ispis citavog cjenovnika
	@Override
	public String toString() {
		String citavIspis = "";
		ttm.loadData();
		HashMap<Integer, TipTretmana> tipoviTretmana = ttm.getAllTipovi();
		for (Map.Entry<Integer, Double> c : this.getCjenovnik().entrySet()) {
			citavIspis += "Naziv tretmana: " + tipoviTretmana.get(c.getKey()).getnazivTretmana() + " Cijena: " + c.getValue() + " Opis usluge: " + tipoviTretmana.get(c.getKey()).getDodatniOpis() + "\n";
		}
		return this.naziv + ":   " + citavIspis;
	}
	public String toString(Integer index) {
		ttm.loadData();
		HashMap<Integer, TipTretmana> tipoviTretmana = ttm.getAllTipovi();
		return "Naziv tretmana: " + tipoviTretmana.get(index).getnazivTretmana() + " Cijena: " + this.getCjenovnik().get(index) + " Opis usluge: " + tipoviTretmana.get(index).getDodatniOpis();
	}kjhhhhhhhhh*/
	

}
 
