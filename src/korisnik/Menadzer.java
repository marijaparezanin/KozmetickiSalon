package korisnik;


public class Menadzer extends Zaposleni{
	private double kriterijumLojalnost;
	private double kriterijumBonus;
	
	public Menadzer() {
		super();
	}
	
	public Menadzer(String korIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa, boolean izbrisan) {
		super(korIme, lozinka, ime, prezime, pol, telefon, adresa, izbrisan);
	}
	
	
	/*public void setKriterijumLojalnost(double potrosenIznos) {
		this.kriterijumLojalnost = potrosenIznos;
	}
	
	public double getKriterijumLojalnost() {
		return this.kriterijumLojalnost;
	}

	public double getKriterijumBonus() {
		return kriterijumBonus;
	}

	public void setKriterijumBonus(double kriterijumBonus) {
		this.kriterijumBonus = kriterijumBonus;
	}*/
	
	public void setKriterijumLojalnost(double potrosenIznos) {
		this.kriterijumLojalnost = potrosenIznos;
	}
	
	public void setKriterijumBonus(double kriterijumBonus) {
		this.kriterijumBonus = kriterijumBonus;
	}
	
	public void setAllBonus() {
		//projeni u svim fajlovima
	}
	/*change bonus in zaposleni files*/
	
	
	@Override
	public String toString() {
		return "Kor ime:" + this.korIme + " Lozinka: " + this.lozinka + " Ime:" + this.ime + " Prezime:" + this.prezime + " Pol:" + this.pol + " Tel:" + this.telefon + " Adresa:" + this.adresa + " KritBonus: " + this.kriterijumBonus + " KritLojal" + this.kriterijumLojalnost + " NivoSS: " + this.nivoStrucneSpreme + " Staz" + this.staz + " PlataOsnova" + this.plataOsnova + " Plata: "+ this.plata + " Bonus: " + this.bonus + " Izbrisan:" + this.izbrisan;
	}
	
	public String toFileString() {
		return this.korIme + "," + this.lozinka + "," + this.ime + "," + this.prezime + "," + this.pol + ","  + this.telefon + ","+ this.adresa + "," + this.kriterijumBonus + "," + this.kriterijumLojalnost + "," + this.nivoStrucneSpreme + "," + this.staz +"," + this.plataOsnova + "," + this.plata + "," + this.bonus +','+ this.izbrisan;
	}
	
}
