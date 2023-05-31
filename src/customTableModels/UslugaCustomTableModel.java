package customTableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import datamanager.DataManager;
import usluge.UslugeTretmana;

public class UslugaCustomTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private List<UslugeTretmana> data;
    private String[] columnNames = {"Naziv usluge", "Tipovi Tretmana"};
    private DataManager dm;
    
    public UslugaCustomTableModel(List<UslugeTretmana> dataList, DataManager dm) {
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
    	UslugeTretmana person = data.get(row);

        switch (column) {
            case 0:
                return person.getNazivUsluge();
            case 1:
            	String lista = "";
            	for(String i: dm.getListaTretmana(person.getNazivUsluge())) {
            		lista += i + ", ";
            	}
                return lista;
            default:
                return null;
        }
    }

}
