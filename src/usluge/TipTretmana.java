package usluge;

public class TipTretmana {
	private String nazivTretmana;
	private Integer vrijemeTrajanja, id;
	private double cijena;
	
	public TipTretmana() {
		
	}
	
	public TipTretmana(String nazivTretmana) {
		this.nazivTretmana = nazivTretmana;
	}
	
	public TipTretmana(String nazivTretmana, Integer vrijemeTrajanja) {
		this.nazivTretmana = nazivTretmana;
		this.vrijemeTrajanja = vrijemeTrajanja;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getnazivTretmana() {
		return nazivTretmana;
	}

	public void setnazivTretmana(String nazivTretmana) {
		this.nazivTretmana = nazivTretmana;
	}

	public double getCijena() {
		return cijena;
	}
	
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	/*
	public double getCijena() {
		return this.cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}*/
	
	public Integer getVrijemeTrajanja() {
		return vrijemeTrajanja;
	}
	
	public void setVrijemeTrajanja(Integer vrijemeTrajanja) {
		this.vrijemeTrajanja = vrijemeTrajanja;
	}
	
	public boolean isEqual(TipTretmana t2) {
		if (this.getnazivTretmana().equals(t2.getnazivTretmana()) && this.getVrijemeTrajanja().equals(t2.getVrijemeTrajanja())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Naziv: " + this.nazivTretmana + " Trajanje: " + this.getVrijemeTrajanja() + "min " + "Cijena: " + this.getCijena();
	}
	
	public String toFileString() {
		return this.nazivTretmana + ","+ this.getVrijemeTrajanja() + "," + this.getCijena();
	}



	
	
}
