package korisnik;

public class Klijent extends Korisnik{
	private double istorijaKupovine = 0;
	public boolean hasLojaltiKartica = false;
	
	public Klijent() {
		super();
	}
	
	public Klijent(String ime, String prezime) {
		super(ime, prezime);
	}
	
	public Klijent(String korIme, String lozinka,String ime, String prezime, String pol, String telefon, String adresa, boolean izbrisan) {
		super(korIme, lozinka, ime, prezime, pol, telefon, adresa, izbrisan);
	}
	
	public void removeIstorijaKupovine(double iznos) {
		this.setIstorijaKupovine(this.getIstorijaKupovine() - iznos);
	}

	public Boolean hasLojaltiKartica() {
		return this.hasLojaltiKartica;
	}
	
	public void setLojaltiKartica(boolean vrijednost) {
		this.hasLojaltiKartica = vrijednost;
	}

	public void setIstorijaKupovine(double istorijaKupovine) {
		this.istorijaKupovine = istorijaKupovine;
	}
	
	public double getIstorijaKupovine() {
		return istorijaKupovine;
	}

	
	public void addIstorijaKupovine(double potroseno) {
		this.istorijaKupovine += potroseno;
	}
	
	public void klijentRefund(double potroseno) {
		this.istorijaKupovine -= potroseno;
	}
	
	@Override
	public String toFileString() {
		return this.korIme + "," + this.lozinka + "," + this.ime + "," + this.prezime + "," + this.pol + ","  + this.telefon + ","+ this.adresa + "," + this.istorijaKupovine + "," + this.hasLojaltiKartica + "," + this.izbrisan;
	}
	
	@Override
	public String toString() {
		return "Korime:" + this.korIme + " Lozinka:" + this.lozinka + " Ime:" + this.ime + " Prezime:" + this.prezime + " Pol:" + this.pol + " Tel:" + this.telefon + " Adresa:" + this.adresa + " IstorijaKupovine:" + this.istorijaKupovine + " LojaltiK:" + this.hasLojaltiKartica + " Izbrisan:" + this.izbrisan;	
	}
}
