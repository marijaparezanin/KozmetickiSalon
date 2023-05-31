package customTableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import datamanager.DataManager;
import usluge.ZakazaniTretman;


public class ZakazaniTretmanTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private List<ZakazaniTretman> data;
//this.getKlijentID() + "," + this.getKozmeticarID() + "," + this.getStanje() + "," + this.getVrijeme() + "," + this.getCijena();

    private String[] columnNames = {"Klijent", "Kozmeticar", "Naziv tretmana", "Stanje", "Vrijeme", "Cijena"};
    DataManager dm;
    
    public ZakazaniTretmanTableModel(List<ZakazaniTretman> dataList, DataManager dm) {
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
    	ZakazaniTretman person = data.get(row);

        switch (column) {
            case 0:
                return dm.getAllKlijenti().get(person.getKlijentID()).getKorIme();
            case 1:
                return dm.getAllKozmeticari().get(person.getKozmeticarID()).getKorIme();
            case 2:
            	return dm.getAllTipovi().get(person.getTipTretmanaID()).getnazivTretmana();
            case 3:
            	return person.getStanje();
            case 4:
                return person.getVrijeme();
            case 5:
            	return person.getCijena();
            default:
                return null;
        }
    }

}
