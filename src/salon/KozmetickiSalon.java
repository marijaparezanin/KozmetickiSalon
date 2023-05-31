package salon;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class KozmetickiSalon {
	private String imeSalona;
	private Integer id;
	LocalTime openingTime, closingTime;

	
	public KozmetickiSalon() {
	}
	
	public KozmetickiSalon(String ime, String vrijemeOtvaranja, String vrijemeZatvaranja) {
		this.setImeSalona(ime);
		this.openingTime =  LocalTime.parse(vrijemeOtvaranja, DateTimeFormatter.ofPattern("HH:mm"));
		this.closingTime =  LocalTime.parse(vrijemeZatvaranja, DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public String getImeSalona() {
		return imeSalona;
	}
	public void setImeSalona(String imeSalona) {
		this.imeSalona = imeSalona;
	}
	public String getRadnoVrijeme() {
		return this.openingTime + ":" + this.closingTime;
	}
	
	public void setRadnoVrijeme(String vrijemeOtvaranja, String vrijemeZatvaranja) {
		this.openingTime =  LocalTime.parse(vrijemeOtvaranja, DateTimeFormatter.ofPattern("HH:mm"));
		this.closingTime =  LocalTime.parse(vrijemeZatvaranja, DateTimeFormatter.ofPattern("HH:mm"));
	
	}
	
	public void setOpeningTime(String vrijemeOtvaranja) {
		this.openingTime =  LocalTime.parse(vrijemeOtvaranja, DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public void setClosingTime(String vrijemeZatvaranja) {
		this.closingTime =  LocalTime.parse(vrijemeZatvaranja, DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Ime salona: " + this.getImeSalona() + " Radno vrijeme: " + this.getRadnoVrijeme();
	}
	
	public String toFileString() {
		return this.imeSalona + "," + this.openingTime + "-" + this.closingTime;
	}

	
}
