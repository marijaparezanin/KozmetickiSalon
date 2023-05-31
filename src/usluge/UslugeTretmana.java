package usluge;

import java.util.ArrayList;

public class UslugeTretmana {
	private String nazivUsluge;
	private ArrayList<Integer> spisakTretmana = new ArrayList<>();
	private Integer id;
	
	
	
	public UslugeTretmana() {
		
	}
	
	public UslugeTretmana(String nazivUsluge) {
		this.nazivUsluge = nazivUsluge;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getNazivUsluge() {
		return nazivUsluge;
	}
	
	public void setNazivUsluge(String nazivUsluge) {
		this.nazivUsluge = nazivUsluge;
	}
	
	public void setspisakTretmana(ArrayList<Integer> spisakTretmana) {
		this.spisakTretmana = spisakTretmana;
	}
	
	public ArrayList<Integer> getspisakTretmana() {
		return this.spisakTretmana;
	}
	
	
	public boolean isEqual(UslugeTretmana usluga) {
		if(this.getNazivUsluge().equals(usluga.getNazivUsluge()) && this.getspisakTretmana().equals(usluga.getspisakTretmana())) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		String listaTretmana = "";
		if (this.getspisakTretmana().size() != 0) {
			for(Integer i: this.getspisakTretmana()) {
				listaTretmana += i + ";";
			}
		}
		return "Naziv: " + this.nazivUsluge + " Lista usluga: " + listaTretmana;
	}
	
	public String toFileString() {
		String lista = "";
		if (spisakTretmana.size() != 0) {
			for(Integer i: this.getspisakTretmana()) {
				lista += i + ";";
			}
		}
		return this.getNazivUsluge() + "," + lista;
	}

	
}
