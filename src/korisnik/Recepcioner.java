package korisnik;

public class Recepcioner extends Zaposleni{

	public Recepcioner() {
		super();
	}
	
	public Recepcioner(String ime, String prezime) {
		super(ime, prezime);
	}
	
	public Recepcioner(String korIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa, boolean izbrisan) {
		super(korIme, lozinka,ime, prezime, pol, telefon, adresa, izbrisan);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Kor ime:" + this.korIme + " Lozinka: " + this.lozinka + " Ime:" + this.ime + " Prezime:" + this.prezime + " Pol:" + this.pol + " Tel:" + this.telefon + " Adresa:" + this.adresa + " NivoSS: " + this.nivoStrucneSpreme + " Staz" + this.staz + " PlataOsnova" + this.plataOsnova + " Plata: "+ this.plata + " Bonus: " + this.bonus + " Izbrisan:" + this.izbrisan;
	}
	
	public String toFileString() {
		return this.korIme + "," + this.lozinka + "," + this.ime + "," + this.prezime + "," + this.pol + ","  + this.telefon + ","+ this.adresa + "," + this.nivoStrucneSpreme + "," + this.staz +"," + this.plataOsnova + "," + this.plata + "," + this.bonus + "," + this.izbrisan;
	}
}
