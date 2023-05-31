package korisnik;

abstract class Korisnik{
	protected String ime, prezime, pol, telefon, adresa, korIme, lozinka;
	private Integer id;
	boolean izbrisan = false;
	
	public Korisnik() {
		this.setKorIme("Empty");
	}
		
	public Korisnik(String ime, String prezime) {
		this.setIme(ime);
		this.setPrezime(prezime);
	}
	
	public Korisnik(String korIme,String lozinka, String ime, String prezime, String pol, String telefon, String adresa, boolean izbrisan) {
		this.setKorIme(korIme);
		this.setLozinka(lozinka);
		this.setIme(ime);
		this.setPrezime(prezime);
		this.setPol(pol);
		this.setTelefon(telefon);
		this.setAdresa(adresa);
		this.setIzbrisan(izbrisan);
	}

	public Boolean isIzbrisan() {
		return this.izbrisan;
	}
	
	public void setIzbrisan(boolean izbrisi) {
		this.izbrisan = izbrisi;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	public boolean isEqual(Korisnik korisnik) {
		if(this.korIme.equals(korisnik.getKorIme()) && this.lozinka.equals(korisnik.getLozinka()) && this.ime.equals(korisnik.getIme()) && this.prezime.equals(korisnik.getPrezime())) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Korime:" + this.korIme + " Lozinka:" + this.lozinka + " Ime:" + this.ime + " Prezime:" + this.prezime + " Pol:" + this.pol + " Tel:" + this.telefon + " Adresa:" + this.adresa;
	}
	
	public String toFileString() {
		return this.korIme + "," + this.lozinka + "," + this.ime + "," + this.prezime + "," + this.pol + ","  + this.telefon + ","+ this.adresa;
	}

	
}
