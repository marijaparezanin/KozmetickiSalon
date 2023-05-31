package usluge;

import java.time.LocalDateTime;



public class ZakazaniTretman {
	public static enum STANJE{
		ZAKAZAN,
		IZVRŠEN,
		OTKAZAOKLIJENT,
		OTKAZAOSALON, 
		NIJESEPOJAVIO
	}
	private LocalDateTime vrijeme;
	private STANJE stanje;
	private double cijena;
	Integer id = 0, klijentID, kozmeticarID, tipTretmanaID;
	
	
	
	public ZakazaniTretman() {
		
	}
	
	public ZakazaniTretman(Integer kozmeticarID) {
		this.setKozmeticarID(kozmeticarID);
	}
	
	//ADD STANJE TO CONSTRUCTOR
	public ZakazaniTretman(Integer kozmeticarID, Integer klijentID, Integer tipTretmanaID, double cijena, STANJE stanje, LocalDateTime vrijeme) {
		this.setKozmeticarID(kozmeticarID);
		this.klijentID = klijentID;
		this.tipTretmanaID = tipTretmanaID;
		this.stanje = stanje;
		this.cijena = cijena;
		this.vrijeme = vrijeme;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getCijena() {
		return this.cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	
	public Integer getKlijentID() {
		return this.klijentID;
	}
	public void setKlijentID(Integer klijentID) {
		this.klijentID = klijentID;
	}
	
	public Integer getKozmeticarID() {
		return this.kozmeticarID;
	}
	public void setKozmeticarID(Integer kozmeticarID) {
		this.kozmeticarID = kozmeticarID;
	}
	
	public Integer getTipTretmanaID() {
		return this.tipTretmanaID;
	}
	public void setTipTretmanaID(Integer tipTretmanaID) {
		this.tipTretmanaID = tipTretmanaID;
	}
	
	
	public LocalDateTime getVrijeme() {
		return this.vrijeme;
	}
	public void setVrijeme(LocalDateTime novoVrijeme) {
		this.vrijeme = novoVrijeme;
	}

	public STANJE getStanje() {
		return stanje;
	}
	public void setStanje(STANJE stanje) {
		this.stanje = stanje;
	}
	
	
	
	
	public boolean isEqual(ZakazaniTretman ztretman) {
		if(this.getKlijentID().equals(ztretman.getKlijentID()) && this.getKozmeticarID().equals(ztretman.getKozmeticarID()) && this.getTipTretmanaID().equals(ztretman.getTipTretmanaID()) && this.getStanje().equals(ztretman.getStanje()) && this.getVrijeme().equals(ztretman.getVrijeme())){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		/*FileManager fm = new FileManager();
		KlijentFileManager kfm = new KlijentFileManager();
		TTManager tt = new TTManager();
		
		Klijent klijent = kfm.getAllKlijenti().get(this.getKlijentID());
		Kozmeticar kozmeticar = fm.getAllKozmeticari().get(this.getKozmeticarID());
		TipTretmana tretman = tt.getAllTipovi().get(this.getTipTretmanaID());*/
		
		//return "Naziv tretmana: " + tretman.getnazivTretmana() + " Klijent: " + klijent.getKorIme() + " Kozmeticar: " + kozmeticar.getKorIme() + " Stanje: " + this.getStanje() + " Datum: " + this.getDatum() + " Vrijeme: " + this.getVrijeme() + " Cijena: " + this.getCijena();
		return "Tretman: " + this.tipTretmanaID + " Klijent: " + this.klijentID + " Kozmeticar: " + this.kozmeticarID + " Stanje: " + this.getStanje() + " Vrijeme: " + this.vrijeme + " Cijena: " + this.getCijena();
	}
	
	public String toFileString() {
		return this.getTipTretmanaID() + "," + this.getKlijentID() + "," + this.getKozmeticarID() + "," + this.getStanje() + "," + this.getVrijeme() + "," + this.getCijena();
	}

	



}
