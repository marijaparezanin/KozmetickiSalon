package korisnik;

import java.util.ArrayList;

public class Kozmeticar extends Zaposleni{
	//private ArrayList<Integer> spisakTretmana = new ArrayList<>();	//spisak tretmana koji on zna izvrsiti, sadrzi id tipova Tretmana
	private ArrayList<Integer> spisakUsluga = new ArrayList<>();	

	
	
	public Kozmeticar() {
		super();
	}
	
	public Kozmeticar(String ime, String prezime) {
		super(ime, prezime);
	}
	
	public Kozmeticar(String korIme, String lozinka,String ime, String prezime, String pol, String telefon, String adresa, boolean izbrisan) {
		super(korIme, lozinka, ime, prezime, pol, telefon, adresa, izbrisan);
	}
	
	public void setSpisakUsluga(ArrayList<Integer> spisakUsluga) {
		this.spisakUsluga = spisakUsluga;
	}
	
	public ArrayList<Integer> getSpisakUsluga() {
		return this.spisakUsluga;
	}
	
	

	@Override
	public String toFileString() {
		String listaTretmana = "";
		
		if (this.spisakUsluga.size() != 0) {
			for(Integer i: this.spisakUsluga) {
				listaTretmana += i + ";";
			}
		}
		return this.korIme + "," + this.lozinka + "," + this.ime + "," + this.prezime + "," + this.pol + ","  + this.telefon + ","+ this.adresa + "," + listaTretmana + "," + this.nivoStrucneSpreme + "," + this.staz +"," + this.plataOsnova + "," + this.plata + "," + this.bonus + ','+this.izbrisan;
	}
	
	@Override
	public String toString() {
		String listaTretmana = "";
		if (this.spisakUsluga.size() != 0) {
			for(Integer i: this.spisakUsluga) {
				listaTretmana += i + ";";
			}
		}
		return "Kor ime:" + this.korIme + " Lozinka: " + this.lozinka + " Ime:" + this.ime + " Prezime:" + this.prezime + " Pol:" + this.pol + " Tel:" + this.telefon + " Adresa:" + this.adresa + " Lista tretmana: " + listaTretmana + " NivoSS: " + this.nivoStrucneSpreme + " Staz" + this.staz + " PlataOsnova" + this.plataOsnova + " Plata: "+ this.plata + " Bonus: " + this.bonus + " Izbrisan:" + this.izbrisan;	
	}

}
