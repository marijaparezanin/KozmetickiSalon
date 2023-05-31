package korisnik;

abstract class Zaposleni extends Korisnik{
	protected double nivoStrucneSpreme, staz;
	protected double plataOsnova, plata;
	protected boolean bonus = false;
	
	
	public Zaposleni() {
		super();
	}
	
	public Zaposleni(String ime, String prezime) {
		super(ime, prezime);
	}

	
	public Zaposleni(String korIme, String lozinka,String ime, String prezime, String pol, String telefon, String adresa, boolean izbrisan) {
		super(korIme, lozinka, ime, prezime, pol, telefon, adresa, izbrisan);
	}
	
	public void setNivo(double nivo) {
		this.nivoStrucneSpreme = nivo;
	}
	
	public double getNivo() {
		return this.nivoStrucneSpreme;
	}
	
	public void setStaz(double staz) {
		this.staz = staz;
	}
	
	public double getStaz() {
		return this.staz;
	}
	
	
	public void setPlataOsnova(double plataOsnova) {
		this.plataOsnova = plataOsnova;
	}
	
	public double getplataOsnova() {
		return this.plataOsnova;
	}
	
	public double getPlata() {
		return this.plata;	
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}
	public boolean getBonus() {
		return this.bonus;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}
}
