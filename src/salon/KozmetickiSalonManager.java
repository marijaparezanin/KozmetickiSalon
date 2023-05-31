package salon;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;



/*Kozmeticki salon zapravo ne treba da ima hashmapu, jer svaki koz salon ce se upisivati u novi set fajlova
 tj. kozmeticki salon ima vise zaposlenih ali samo jedan naziv i radno vrijeme*/
public class KozmetickiSalonManager {
	private String kozmetickiSalonPath;
	HashMap<Integer, KozmetickiSalon> saloni = new HashMap<Integer, KozmetickiSalon>();
	private int indKS = 0;
	
	public KozmetickiSalonManager() {
	}
	
	public KozmetickiSalonManager(String kozmetickiSalonPath) {
		this.setKozmetickiSalonPath(kozmetickiSalonPath);
	}
	
	
	public String getKozmetickiSalonPath() {
		return kozmetickiSalonPath;
	}
	
	public void setKozmetickiSalonPath(String kozmetickiSalonPath) {
		this.kozmetickiSalonPath = kozmetickiSalonPath;
	}
	
	public void saveChanges(KozmetickiSalon salon) {
		this.saloni.replace(salon.getId(), salon);
		this.saveData();
	}
	
	public HashMap<Integer, KozmetickiSalon> getAllSaloni(){
		if(this.saloni.size() == 0) {
			this.loadData();
		}
		return this.saloni;
	}
	
	public void addKozmetickiSalon(KozmetickiSalon salon) {
		this.indKS = saloni.size();
		salon.setId(indKS);
		this.saloni.put(this.indKS, salon);
		this.indKS += 1;
		this.saveData();
	}
	
	
	public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.kozmetickiSalonPath));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] elementi = linija.split(",");
				Integer id = Integer.parseInt(elementi[0]);
				KozmetickiSalon k = new KozmetickiSalon();
				String open = elementi[2].split("-")[0];
				String close = elementi[2].split("-")[1];
				k.setImeSalona(elementi[1]);
				k.setRadnoVrijeme(open, close);
				k.setId(id);
				this.saloni.put(id, k);
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean saveData() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.kozmetickiSalonPath, false));
			for (Map.Entry<Integer, KozmetickiSalon> t : this.saloni.entrySet()) {
				pw.println(t.getKey() + "," + t.getValue().toFileString());				
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public boolean remove(KozmetickiSalon salon) {
		if (this.getId(salon) != -1) {
			this.saloni.remove(this.getId(salon));
		}
		else {
			System.out.println("Nepostojeca rezervacija");
			return false;
		}
		this.saveData();
		return true;
	}
	
	public KozmetickiSalon findByNaziv(String naziv) {
		for (Map.Entry<Integer, KozmetickiSalon> t : this.saloni.entrySet()) {
			if(t.getValue().getImeSalona().equals(naziv)) {
				return t.getValue();
			}
		}

		return null;
	}
	
	
	public Integer getId(KozmetickiSalon salon) {
		for (Map.Entry<Integer, KozmetickiSalon> t : this.saloni.entrySet()) {
			if(salon.getImeSalona().equals(t.getValue().getImeSalona()) && salon.getRadnoVrijeme().equals(t.getValue().getRadnoVrijeme())) {
				return t.getKey();
			}
		}
		return -1;
	}

	public void printAll() {
		for (Map.Entry<Integer, KozmetickiSalon> t : this.saloni.entrySet()) {
			System.out.println(t.getValue());
		}
	}
}
