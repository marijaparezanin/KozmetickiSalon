package customTableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import korisnik.Menadzer;

public class MenadzerCustomTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Menadzer> data;
    private String[] columnNames = {"KorIme", "Lozinka", "Ime", "Prezime", "pol", "Broj telefona","Adresa", "Plata", "Plata osnova", "Staz", "NSS", "Bonus", "Obrisan"};

    public MenadzerCustomTableModel( List<Menadzer> dataList) {
        this.data = dataList;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Menadzer person = data.get(row);
        
        switch (column) {
            case 0:
                return person.getKorIme();
            case 1:
                return person.getLozinka();
            case 2:
                return person.getIme();
            case 3:
                return person.getPrezime();
            case 4:
            	if(person.getPol().equals("musko")) {
            		return "musko";
            	}
            	else if(person.getPol().equals("zensko")){
            		return "zensko";
            	}
            	else {
            		return person.getPol();
            	}
            case 5:
                return person.getTelefon();
            case 6:
                return person.getAdresa();
            case 7:
                return person.getPlata();
            case 8:
                return person.getplataOsnova();
            case 9:
                return person.getStaz();
            case 10:
                return person.getNivo();
            case 11:
            	if(person.getBonus()) {
            		return "da";
            	}
            	else {
            		return "ne";            		
            	}
            case 12:
            	if(person.isIzbrisan()) {
            		return "da";
            	}else {
            		return "ne";
            	}
            default:
                return null;
        }
    }


}