package datamanager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test.None;

import korisnik.*;
import korisnikmanager.*;
import salon.Cjenovnik;
import salon.KozmetickiSalon;
//import salon.CjenovnikManager;
import salon.KozmetickiSalonManager;
import usluge.*;
import uslugemanager.*;

public class DataManager {	
	FileManager fm = new FileManager();
	KlijentFileManager kfm = new KlijentFileManager();
	TTManager tt = new TTManager();
	TUManager tu = new TUManager();
	ZTManager zt = new ZTManager();
	Cjenovnik cj = new Cjenovnik();
	KozmetickiSalonManager ks = new KozmetickiSalonManager();
	String bonusKriterijum = "";
	
	public DataManager() {
		
	}
	
	public DataManager(String klijentPath) {
		kfm.setKlijentPath(klijentPath);
	}
	
	public DataManager(String klijentPath, String kozmeticarPath, String recepcionerPath, String menadzerPath, String TTpath, String TUpath, String ZTPath, String cjenovnikPath, String salonPath) {
		fm.setMenadzerPath(menadzerPath);
		fm.setKozmeticarPath(kozmeticarPath);
		fm.setRecepcionerPath(recepcionerPath);
		kfm.setKlijentPath(klijentPath);
		tt.setTipTretmanaPath(TTpath);
		tu.setuslugaTretmanaPath(TUpath);
		tu.setTipTretmanaPath(TTpath);
		zt.setZakazaniTretmaniPath(ZTPath);
		cj.setCjenovnikPath(cjenovnikPath);
		ks.setKozmetickiSalonPath(salonPath);
	}
	
	public void setMenadzerPath(String path) {
		fm.setMenadzerPath(path);
	}
	
	public void setRecepcionerPath(String path) {
		fm.setRecepcionerPath(path);
	}
	
	public void setKozmeticarPath(String path) {
		fm.setKozmeticarPath(path);
	}
	
	public void setKlijentPath(String path) {
		kfm.setKlijentPath(path);
	}
	
	public void setTipTretmanaPath(String path) {
		tt.setTipTretmanaPath(path);
		tu.setTipTretmanaPath(path);
	}
	
	public void setUslugeTretmanaPath(String path) {
		tu.setuslugaTretmanaPath(path);
	}
	
	public void setZakazaniTretmaniPath(String path) {
		zt.setZakazaniTretmaniPath(path);
	}
	
	public void setCjenovnikPath(String path) {
		cj.setCjenovnikPath(path);
	}
	
	public void setKozmetickiSalonPath(String path) {
		ks.setKozmetickiSalonPath(path);
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void saveData() {
		kfm.saveData();
		fm.saveDataAll();
		tt.saveData();
		tu.saveData();
		zt.saveData();
		cj.saveData();
		ks.saveData();
	}
	
	public void loadData() {
		kfm.loadData();
		fm.loadDataK();
		fm.loadDataM();
		fm.loadDataR();
		tt.loadData();
		tu.loadData();
		zt.loadData();
		cj.loadData();
		ks.loadData();
	}
	
	
	public String findUser(String korIme, String lozinka) {
		if(kfm.findByKorIme(korIme) != null) {
			return "klijent";
		}
		else if(fm.findByKorImeR(korIme) != null) {
			return "recepcioner";
		}else if(fm.findByKorImeM(korIme) != null) {
			return "menadzer";
		}else if(fm.findByKorImeK(korIme) != null) {
			return "kozmeticar";
		}
		return null;
	}
	
	public boolean edit(Kozmeticar kozmeticar,String korisnickoIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa) {
		return fm.edit(kozmeticar, korisnickoIme, lozinka, ime, prezime, pol, telefon, adresa);
	}
	
	public boolean edit(Menadzer menadzer, String korisnickoIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa) {
		return fm.edit(menadzer, korisnickoIme, lozinka, ime, prezime, pol, telefon, adresa);
	}
	
	public boolean edit(Recepcioner recepcioner, String korisnickoIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa) {
		return fm.edit(recepcioner, korisnickoIme, lozinka, ime, prezime, pol, telefon, adresa);
	}

	public boolean edit(Klijent klijent,String korisnickoIme, String lozinka, String ime, String prezime, String pol, String telefon, String adresa) {
		return kfm.edit(klijent, korisnickoIme, lozinka, ime, prezime, pol, telefon, adresa);
	}
	
	public boolean edit(TipTretmana tretman,String nazivTretmana, Double cijena, Integer trajanje) {
		return tt.edit(tretman, nazivTretmana, cijena, trajanje);
	}
	
	public boolean edit(UslugeTretmana u,String noviNazivUsluge, ArrayList<Integer> listaTretmana) {
		return tu.edit(u, noviNazivUsluge, listaTretmana);
	}
	
	public Klijent isValidKlijent(String korIme, String lozinka){
		return kfm.isValidUser(korIme, lozinka);		
	}
	
	public Recepcioner isValidRecepcioner(String korIme, String lozinka){
		return fm.isValidUserR(korIme, lozinka);		
	}
	
	public Kozmeticar isValidKozmeticar(String korIme, String lozinka){
		return fm.isValidUserK(korIme, lozinka);		
	}
	
	public Menadzer isValidMenadzer(String korIme, String lozinka){
		return fm.isValidUserM(korIme, lozinka);		
	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public Klijent findByKorKlijent(String korIme) {
		return kfm.findByKorIme(korIme);
	}
	
	
	public void addKlijent(String korIme, String password, String ime, String prezime, String pol, String telefon, String Adresa) {
		kfm.addKlijent(new Klijent(korIme, password, ime, prezime, pol, telefon, Adresa, false));
	}

	public HashMap<Integer, Klijent> getAllKlijenti() {
		return kfm.getAllKlijenti();
	}
	
	public void klijentChangeIme(String username, String ime) {
		kfm.findByKorIme(username).setIme(ime);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void klijentChangePrezime(String username, String prezime) {
		kfm.findByKorIme(username).setPrezime(prezime);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void klijentChangePol(String username, String pol) {
		kfm.findByKorIme(username).setPol(pol);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void klijentChangeTelefon(String username, String telefon) {
		kfm.findByKorIme(username).setTelefon(telefon);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void klijentChangeAdresa(String username, String Adresa) {
		kfm.findByKorIme(username).setAdresa(Adresa);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void klijentChangeKorIme(String username, String newusername) {
		kfm.findByKorIme(username).setKorIme(newusername);
		kfm.saveChanges(kfm.findByKorIme(newusername));
	}
	
	public void klijentAddSpentAmount(String username, double potroseno) {
		kfm.findByKorIme(username).addIstorijaKupovine(potroseno);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void klijentChangeIstorija(String username, double istorija) {
		kfm.findByKorIme(username).setIstorijaKupovine(istorija);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void klijentSetLojalti(String username, boolean val) {
		kfm.findByKorIme(username).setLojaltiKartica(val);;
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void KlijentRefund(String username, double povrat) {
		kfm.findByKorIme(username).klijentRefund(povrat);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void removeKlijent(String username) {
		kfm.findByKorIme(username).setIzbrisan(true);
		kfm.saveChanges(kfm.findByKorIme(username));
	}
	
	public void printAllKlijent() {
		kfm.printAll();
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public HashMap<Integer, Menadzer> getAllMenadzeri() {
		return fm.getAllMenadzeri();
	}
	
	public Menadzer findByKorMenadzer(String korIme) {
		return fm.findByKorImeM(korIme);
	}
	
	public void addMenadzer(String korIme, String password, String ime, String prezime, String pol, String telefon, String Adresa) {
		fm.addMenadzer(new Menadzer(korIme, password, ime, prezime, pol, telefon, Adresa, false));
	}

	public void MenadzerChangeIme(String username, String ime) {
		fm.findByKorImeM(username).setIme(ime);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangePrezime(String username, String prezime) {
		fm.findByKorImeM(username).setPrezime(prezime);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangePol(String username, String pol) {
		fm.findByKorImeM(username).setPol(pol);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangeTelefon(String username, String telefon) {
		fm.findByKorImeM(username).setTelefon(telefon);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangeAdresa(String username, String Adresa) {
		fm.findByKorImeM(username).setAdresa(Adresa);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangeKorIme(String username, String newusername) {
		fm.findByKorImeM(username).setKorIme(newusername);
		fm.saveChanges(fm.findByKorImeM(newusername));
	}
	
	public void MenadzerChangePlata(String username, double plata) {
		fm.findByKorImeM(username).setPlata(plata);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangePlataOsnova(String username, double plataOsnova) {
		fm.findByKorImeM(username).setPlataOsnova(plataOsnova);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangeNivo(String username, double nivo) {
		fm.findByKorImeM(username).setNivo(nivo);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangeStaz(String username, double staz) {
		fm.findByKorImeM(username).setStaz(staz);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void MenadzerChangeBonus(String username, boolean bonus) {
		fm.findByKorImeM(username).setBonus(bonus);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void setBonus(int opcija) {
		/*npr. broju izvedenih kozmetičkih tretmana ili ostvarenom prihodu u jednoj nedelji, mesecu itd.).*/
		if(opcija == 1) {	//broj izvedenih kozm tretmana
			
		}
			
	}
	
	public void removeMenadzer(String username) {
		fm.findByKorImeM(username).setIzbrisan(true);
		fm.saveChanges(fm.findByKorImeM(username));
	}
	
	public void printAllMenadzer() {
		fm.printAllM();
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public HashMap<Integer, Kozmeticar> getAllKozmeticari() {
		return fm.getAllKozmeticari();
	}
	
	public Kozmeticar findByKorKozmeticar(String korIme) {
		return fm.findByKorImeK(korIme);
	}
	
	public void addKozmeticar(String korIme, String password, String ime, String prezime, String pol, String telefon, String Adresa) {
		fm.addKozmeticar(new Kozmeticar(korIme, password, ime, prezime, pol, telefon, Adresa, false));
	}

	public void KozmeticarChangeIme(String username, String ime) {
		fm.findByKorImeK(username).setIme(ime);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangePrezime(String username, String prezime) {
		fm.findByKorImeK(username).setPrezime(prezime);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangePol(String username, String pol) {
		fm.findByKorImeK(username).setPol(pol);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangeTelefon(String username, String telefon) {
		fm.findByKorImeK(username).setTelefon(telefon);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangeAdresa(String username, String Adresa) {
		fm.findByKorImeK(username).setAdresa(Adresa);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangeKorIme(String username, String newusername) {
		fm.findByKorImeK(username).setKorIme(newusername);
		fm.saveChanges(fm.findByKorImeK(newusername));
	}
	
	public void KozmeticarChangePlata(String username, double plata) {
		fm.findByKorImeK(username).setPlata(plata);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangePlataOsnova(String username, double plataOsnova) {
		fm.findByKorImeK(username).setPlataOsnova(plataOsnova);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangeNivo(String username, double nivo) {
		fm.findByKorImeK(username).setNivo(nivo);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangeStaz(String username, double staz) {
		fm.findByKorImeK(username).setStaz(staz);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void KozmeticarChangeBonus(String username, boolean bonus) {
		fm.findByKorImeK(username).setBonus(bonus);
		fm.saveChanges(fm.findByKorImeK(username));
	}

	public void KozmeticarChangeListaUsluga(String username, ArrayList<Integer> lista) {
		fm.findByKorImeK(username).setSpisakUsluga(lista);;
		fm.saveChanges(fm.findByKorImeK(username));
	}

	public void KozmeticarAddUsluga(String username, String utname) {
		ArrayList<Integer> lista = fm.findByKorImeK(username).getSpisakUsluga();
		lista.add(tu.findBynazivUsluge(utname).getId());
		fm.findByKorImeK(username).setSpisakUsluga(lista);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public void removeKozmeticarUsluga(String username, String nazivusluge) {
		Integer idUsluge = tu.findBynazivUsluge(nazivusluge).getId();
		//ako je len 1 nezgodno je izbrisati njegove elemente dok je u petlji
		if(fm.findByKorImeK(username).getSpisakUsluga().size() == 1) {
			fm.findByKorImeK(username).getSpisakUsluga().remove(idUsluge);
			fm.saveChanges(fm.findByKorImeK(username));
		}else {
			for(Integer i: fm.findByKorImeK(username).getSpisakUsluga()) {
				if(i == idUsluge) {				
					fm.findByKorImeK(username).getSpisakUsluga().remove(idUsluge);
					fm.saveChanges(fm.findByKorImeK(username));
				}
			}
			
		}
		
	}
	
	
	public void removeKozmeticar(String username) {
		Integer id = fm.getId(fm.findByKorImeK(username));
		for(Map.Entry<Integer, ZakazaniTretman> tretman : zt.getAllZakazani().entrySet()) {
			if(tretman.getValue().getKozmeticarID() == id) {
				zt.remove(tretman.getValue());
			}
		}
		
		fm.findByKorImeK(username).setIzbrisan(true);
		fm.saveChanges(fm.findByKorImeK(username));
	}
	
	public String getListaKozmeticar(String username) {
		ArrayList<Integer> listaTretmana = fm.findByKorImeK(username).getSpisakUsluga();
		String lista = "";
		for(Integer i: listaTretmana) {
			lista += tu.getAllUsluge().get(i).getNazivUsluge() + ",";
		}
		return lista;
	}
	
	
	public String printKozmeticar(String username) {
		Kozmeticar k = fm.findByKorImeK(username);
		String lista = "";
		if(k.getSpisakUsluga().size() == 0) {
			lista = "Kozmeticar nema Tretmana";
		}
		else {
			ArrayList<Integer> listaTretmana = k.getSpisakUsluga();
			for(Integer i: listaTretmana) {
				lista += tu.getAllUsluge().get(i).getNazivUsluge() + "; ";
			}
		}
		return "Kor ime:" + k.getKorIme() + " Lozinka: " + k.getLozinka() + " Ime:" + k.getIme() + " Prezime:" + k.getPrezime() + " Pol:" + k.getPol() + " Tel:" + k.getTelefon() + " Adresa:" + k.getAdresa() + " Lista tretmana: " + lista + " NivoSS: " + k.getNivo() + " Staz" + k.getStaz() + " PlataOsnova" + k.getplataOsnova() + " Plata: "+ k.getPlata() + " Bonus: " + k.getBonus();
	}
	
	public void printAllKozmeticar() {
		for(Map.Entry<Integer, Kozmeticar> kozm : fm.getAllKozmeticari().entrySet()) {
			System.out.println(this.printKozmeticar(kozm.getValue().getKorIme()));
		}
	}
	
	public String getUslugaPoTretmanu(String nazivTretmana) {
		Integer tretmanId = tt.findBynazivTretmana(nazivTretmana).getId();
		for(Map.Entry<Integer, UslugeTretmana> element : tu.getAllUsluge().entrySet()) {
			for(Integer i: element.getValue().getspisakTretmana()) {
				if(i == tretmanId) {
					return element.getValue().getNazivUsluge();
				}
			}
		}
		return null;
	}

	public ArrayList<String> TreniraniKozmeticari(String nazivUsluge){
		ArrayList<String> lista = new ArrayList<>();
		Integer idTretmana = tu.findBynazivUsluge(nazivUsluge).getId();
		for(Map.Entry<Integer, Kozmeticar> element : fm.getAllKozmeticari().entrySet()) {
			if(!element.getValue().isIzbrisan()) {				
				for(Integer i : element.getValue().getSpisakUsluga()) {
					if(i == idTretmana) {
						lista.add(element.getValue().getKorIme());
					}
				}
			}
		}
		if(lista.size() == 0) {
			System.out.println("Nema kozmeticara treniranih za ovaj tretman");
		}
		return lista;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public HashMap<Integer, Recepcioner> getAllRecepcioneri() {
		return fm.getAllRecepcioneri();
	}
	
	public Recepcioner findByKorReceocioner(String korIme) {
		return fm.findByKorImeR(korIme);
	}
	
	public void addRecepcioner(String korIme, String password, String ime, String prezime, String pol, String telefon, String Adresa) {
		fm.addRecepcioner(new Recepcioner(korIme, password, ime, prezime, pol, telefon, Adresa, false));
	}

	public void RecepcionerChangeIme(String username, String ime) {
		fm.findByKorImeR(username).setIme(ime);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangePrezime(String username, String prezime) {
		fm.findByKorImeR(username).setPrezime(prezime);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangePol(String username, String pol) {
		fm.findByKorImeR(username).setPol(pol);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangeTelefon(String username, String telefon) {
		fm.findByKorImeR(username).setTelefon(telefon);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangeAdresa(String username, String Adresa) {
		fm.findByKorImeR(username).setAdresa(Adresa);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangeKorIme(String username, String newusername) {
		fm.findByKorImeR(username).setKorIme(newusername);
		fm.saveChanges(fm.findByKorImeR(newusername));
	}
	
	public void RecepcionerChangePlata(String username, double plata) {
		fm.findByKorImeR(username).setPlata(plata);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangePlataOsnova(String username, double plataOsnova) {
		fm.findByKorImeR(username).setPlataOsnova(plataOsnova);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangeNivo(String username, double nivo) {
		fm.findByKorImeR(username).setNivo(nivo);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangeStaz(String username, double staz) {
		fm.findByKorImeR(username).setStaz(staz);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void RecepcionerChangeBonus(String username, boolean bonus) {
		fm.findByKorImeR(username).setBonus(bonus);
		fm.saveChanges(fm.findByKorImeR(username));
	}

	public void removeRecepcioner(String username) {
		fm.findByKorImeR(username).setIzbrisan(true);
		fm.saveChanges(fm.findByKorImeR(username));
	}
	
	public void printAllRecepcioner() {
		fm.printAllR();
	}

	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public HashMap<Integer, TipTretmana> getAllTipovi(){
		return tt.getAllTipovi();
	}
	
	public TipTretmana TTretmanaFindByNaziv(String naziv) {
		return tt.findBynazivTretmana(naziv);
	}
	
	public void addTipTretmana(String nazivTretmana, Integer vrijemeTrajanja) {
		tt.addTipTretmana(new TipTretmana(nazivTretmana, vrijemeTrajanja));
	}
	
	public void TTChangeNaziv(String nazivTretmana, String newNaziv) {
		tt.findBynazivTretmana(nazivTretmana).setnazivTretmana(newNaziv);
		tt.saveChanges(tt.findBynazivTretmana(newNaziv));
	}
	
	/*
	public void TTChangeCijena(String nazivTretmana, double newCijena) {
		tt.findBynazivTretmana(nazivTretmana).setCijena(newCijena);
		tt.saveChanges(tt.findBynazivTretmana(nazivTretmana));
	}*/
	
	public void TTChangeTrajanje(String nazivTretmana, int trajanje) {
		tt.findBynazivTretmana(nazivTretmana).setVrijemeTrajanja(trajanje);
		tt.saveChanges(tt.findBynazivTretmana(nazivTretmana));
	}
	
	public void removeTT(String naziv) {
		cj.remove((tt.findBynazivTretmana(naziv)));
		this.removeAllTipUsluga(naziv);
		tt.remove(tt.findBynazivTretmana(naziv));
		tt.saveData();
	}
	
	public void printAllTT() {
		tt.printAll();
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public HashMap<Integer, UslugeTretmana> getAllUsluge(){
		return tu.getAllUsluge();
	}
	
	public void addUslugaTretmana(String naziv) {
		tu.addUslugeTretmana(new UslugeTretmana(naziv));
	}
	
	public Integer findIdUsluga(String naziv) {
		if(tu.findBynazivUsluge(naziv) != null) {
			return tu.findBynazivUsluge(naziv).getId();
		}
		return null;
	}
		
	public ArrayList<String> getListaTretmana(String nazivUsluge){
		ArrayList<String> novaStringLista = new ArrayList<>();
		for(Integer i: tu.findBynazivUsluge(nazivUsluge).getspisakTretmana()) {
			novaStringLista.add(tt.getAllTipovi().get(i).getnazivTretmana());
		}
		return novaStringLista;
	}
	
	
	public void addUslugaTip(String nazivUsluge, String imeTretmana) {
		ArrayList<Integer> listica = tu.findBynazivUsluge(nazivUsluge).getspisakTretmana();
		listica.add(tt.findBynazivTretmana(imeTretmana).getId());
		tu.findBynazivUsluge(nazivUsluge).setspisakTretmana(listica);
		tu.saveChanges(tu.findBynazivUsluge(nazivUsluge));
	}
	
	public void changeUslugaTip(String nazivUsluge, ArrayList<Integer> lista) {
		tu.findBynazivUsluge(nazivUsluge).setspisakTretmana(lista);
		tu.saveChanges(tu.findBynazivUsluge(nazivUsluge));
	}
	
	public void removeAllTipUsluga(String imeTipa) {
		for(Map.Entry<Integer, UslugeTretmana> u : tu.getAllUsluge().entrySet()) {
			ArrayList<Integer> listica = u.getValue().getspisakTretmana();
			listica.remove(tt.findBynazivTretmana(imeTipa).getId());	
			u.getValue().setspisakTretmana(listica);
		}
		tu.saveData();
	}
	
	public void removeUslugaTip(String nazivUsluge, String imeTipa) {
		ArrayList<Integer> listica = tu.findBynazivUsluge(nazivUsluge).getspisakTretmana();
		listica.remove(tt.findBynazivTretmana(imeTipa).getId());
		tu.findBynazivUsluge(nazivUsluge).setspisakTretmana(listica);
		tu.saveChanges(tu.findBynazivUsluge(nazivUsluge));
	}
	
	public void changeNazivUsluge(String nazivUsluge, String newNaziv) {
		tu.findBynazivUsluge(nazivUsluge).setNazivUsluge(newNaziv);
		tu.saveChanges(tu.findBynazivUsluge(newNaziv));
	}
	
	public void removeUsluga(String nazivUsluge) {
		ArrayList<Integer> listica = tu.findBynazivUsluge(nazivUsluge).getspisakTretmana();
		int id = tu.findBynazivUsluge(nazivUsluge).getId();
		tu.remove(tu.findBynazivUsluge(nazivUsluge));
		
		
		HashMap<Integer, TipTretmana> mapa = tt.getAllTipovi();//remove tipovi in the category
		
		//remove booked
		for(Integer i : listica) {
			for(Map.Entry<Integer, ZakazaniTretman> z : zt.getAllZakazani().entrySet()) {
				if(z.getValue().getTipTretmanaID() == i) {
					
					kfm.findByKorIme(kfm.getAllKlijenti().get(z.getValue().getKlijentID()).getKorIme()).removeIstorijaKupovine(z.getValue().getCijena());
					zt.remove(z.getValue());
				}
			}
			cj.remove(mapa.get(i));
			tt.remove(mapa.get(i));
		}
		
		
		
		for(Map.Entry<Integer, Kozmeticar> k : fm.getAllKozmeticari().entrySet()) {
			ArrayList<Integer> l = k.getValue().getSpisakUsluga();
			Integer size = l.size();
			for(int i = 0; i < l.size(); i++) {
				if(l.get(i) == id) {	
					l.remove(i);
				}
			}
			if(l.size() != size) {
				fm.findByKorImeK(k.getValue().getKorIme()).setSpisakUsluga(l);
				fm.saveChanges(fm.findByKorImeK(k.getValue().getKorIme()));				
			}
			
		}
		
		//remove zakazani tretmani
		
		
	}
	
	public void printAllUsluge() {
		tt.loadData();
		for(Map.Entry<Integer, UslugeTretmana> usluge : tu.getAllUsluge().entrySet()) {
			String lista = "";
			for(Integer i: usluge.getValue().getspisakTretmana()) {
				lista += tt.getAllTipovi().get(i).getnazivTretmana() + ",";
			
			}
			System.out.println("Naziv usluge: " + usluge.getValue().getNazivUsluge() + " Lista tretmana: " + lista);
		}
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public HashMap<Integer, ZakazaniTretman> getAllZakazani(){
		return zt.getAllZakazani();
	}
	
	
	public void addZakazaniTretman(String imeKozmeticar,String klijentIme, LocalDateTime vrijeme, String tretmanIme) {		
		zt.addZakazaniTretman(new ZakazaniTretman(fm.findByKorImeK(imeKozmeticar).getId(), kfm.findByKorIme(klijentIme).getId(), tt.findBynazivTretmana(tretmanIme).getId(), cj.getCijena(tt.findBynazivTretmana(tretmanIme)), ZakazaniTretman.STANJE.ZAKAZAN, vrijeme));
		kfm.findByKorIme(klijentIme).addIstorijaKupovine(cj.getCijena(tt.findBynazivTretmana(tretmanIme)));
		kfm.saveChanges(kfm.findByKorIme(klijentIme));
	}	
	
	public void ZTChangeKlijent(LocalDateTime vrijeme, String korImeKlijenta) {
		zt.findByVrijeme(vrijeme).setKlijentID(kfm.findByKorIme(korImeKlijenta).getId());
		zt.saveChanges(zt.findByVrijeme(vrijeme));
	}
	
	public void ZTChangeKozmeticar(LocalDateTime vrijeme, String korImeKozmeticat) {
		zt.findByVrijeme(vrijeme).setKozmeticarID(fm.findByKorImeK(korImeKozmeticat).getId());
		zt.saveChanges(zt.findByVrijeme(vrijeme));
	}
	
	public void ZTChangeTretman(LocalDateTime vrijeme, String nazivNovogTT) {
		zt.findByVrijeme(vrijeme).setTipTretmanaID(tt.findBynazivTretmana(nazivNovogTT).getId());
		zt.findByVrijeme(vrijeme).setCijena(cj.getCijena(tt.findBynazivTretmana(nazivNovogTT)));
		zt.saveChanges(zt.findByVrijeme(vrijeme));
	}
	
	public void printAllZT() {
		for (Map.Entry<Integer, ZakazaniTretman> t : zt.getAllZakazani().entrySet()) {
			System.out.println("Tretman:" + tt.getAllTipovi().get(t.getValue().getTipTretmanaID()).getnazivTretmana() + " Klijent:" + kfm.getAllKlijenti().get(t.getValue().getKlijentID()).getIme() + " " + kfm.getAllKlijenti().get(t.getValue().getKlijentID()).getPrezime() + " Kozmeticar: " + fm.getAllKozmeticari().get(t.getValue().getKozmeticarID()).getIme() + " " + fm.getAllKozmeticari().get(t.getValue().getKozmeticarID()).getPrezime() + " Stanje:" + t.getValue().getStanje() + " Cijena:" + t.getValue().getCijena() + " Vrijeme:" + t.getValue().getVrijeme());
		}
	}
	
	public int getBrojIzvedenihTretmana(int kozmeticarID) {
		int broj = 0;
		for(Map.Entry<Integer, ZakazaniTretman> z : zt.getAllZakazani().entrySet()) {
			if(z.getValue().getKozmeticarID() == kozmeticarID) {
				broj++;
			}
		}
		return broj;
	}
	
	public double getCijenaIzvedenihTretmana(int kozmeticarID) {
		double cijena = 0;
		for(Map.Entry<Integer, ZakazaniTretman> z : zt.getAllZakazani().entrySet()) {
			if(z.getValue().getKozmeticarID() == kozmeticarID) {
				cijena += z.getValue().getCijena();
			}
		}
		return cijena;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------
	public HashMap<Integer, Double> getAllCijene(){
		return cj.getCjenovnik();
	}
	
	public HashMap<String, Double> getAllCjeneNazivi(){
		HashMap<String, Double> novaLista = new HashMap<>();
		
		for(Map.Entry<Integer, Double> cjene : cj.getCjenovnik().entrySet()) {
			novaLista.put(tt.getAllTipovi().get(cjene.getKey()).getnazivTretmana(), cjene.getValue());
		}
		return novaLista;
	}
	
	public void addCijena(String nazivTretmana, double cijena) {
		cj.addCijena(tt.findBynazivTretmana(nazivTretmana), cijena);
		tt.findBynazivTretmana(nazivTretmana).setCijena(cijena);
		tt.saveChanges(tt.findBynazivTretmana(nazivTretmana));
	}
	
	//isto kao add
	public void changeCijena(String nazivTretmana, double novaCijena) {
		cj.addCijena(tt.findBynazivTretmana(nazivTretmana), novaCijena);
		tt.findBynazivTretmana(nazivTretmana).setCijena(novaCijena);
		tt.saveChanges(tt.findBynazivTretmana(nazivTretmana));
	}
	
	public double getCijena(String nazivTretmana) {
		return (cj.getCijena(tt.findBynazivTretmana(nazivTretmana)));
	}
	
	public void removeCjena(String nazivTretmana) {
		cj.remove(tt.findBynazivTretmana(nazivTretmana));
		//tt.remove(tt.findBynazivTretmana(nazivTretmana));
	}
	
	public void printCjenovnik() {
		for(Map.Entry<Integer, Double> cjene : cj.getCjenovnik().entrySet()) {
			System.out.println("Naziv: " + tt.getAllTipovi().get(cjene.getKey()).getnazivTretmana() + "  Cijena: " + cjene.getValue());
		}
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------

	public void addKozmetickiSalon(String nazivSalona, String pocetak, String kraj) {
		ks.addKozmetickiSalon(new KozmetickiSalon(nazivSalona, pocetak, kraj));
	}
	
	public void removeKozmetickiSalon(String nazivSalona) {
		ks.remove(ks.findByNaziv(nazivSalona));
	}
	
	public void printKS() {
		System.out.println(ks.getAllSaloni().get(0));
	}
	
	public void KSchangeIme(String staroIme, String novo) {
		ks.findByNaziv(staroIme).setImeSalona(novo);
		ks.saveChanges(ks.findByNaziv(novo));
	}
	
	public void changeOpeningTime(String nazivSalona, String hourMinute) {
		ks.findByNaziv(nazivSalona).setOpeningTime(hourMinute);
		ks.saveChanges(ks.findByNaziv(nazivSalona));
	}
	
	public void changeClosingTime(String nazivSalona, String hourMinute) {
		ks.findByNaziv(nazivSalona).setClosingTime(hourMinute);
		ks.saveChanges(ks.findByNaziv(nazivSalona));
	}	
	
	/*
	zt.printAll();
	
	
	
	System.out.println("\nPosle dodjele: ");
	ZakazaniTretman z1 = new ZakazaniTretman(4, 1, 0, 300,ZakazaniTretman.STANJE.IZVRŠEN);
	z1.setDatum(LocalDate.now());
	zt.addZakazaniTretman(z1);*/



	
}
