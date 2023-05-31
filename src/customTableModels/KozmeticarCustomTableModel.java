package customTableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import datamanager.DataManager;
import korisnik.Kozmeticar;

public class KozmeticarCustomTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Kozmeticar> data;
    private String[] columnNames = {"KorIme", "Lozinka", "Ime", "Prezime", "pol", "Broj telefona","Adresa","Spisak Usluga", "Plata", "Plata osnova", "Staz", "NSS", "Bonus", "Obrisan"};
    private DataManager dm;
    
    public KozmeticarCustomTableModel(List<Kozmeticar> dataList, DataManager dm) {
        this.data = dataList;
        this.dm = dm;
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
    	Kozmeticar person = data.get(row);

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
                return dm.getListaKozmeticar(person.getKorIme());
            case 8:
                return person.getPlata();
            case 9:
                return person.getplataOsnova();
            case 10:
                return person.getStaz();
            case 11:
                return person.getNivo();
            case 12:
            	if(person.getBonus()) {
            		return "da";
            	}
            	else {
            		return "ne";            		
            	}
            case 13:
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
