package customTableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import datamanager.DataManager;
import usluge.TipTretmana;

public class TipTretmanaCustomTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<TipTretmana> data;

    private String[] columnNames = {"Naziv tretmana", "Vrijeme Trajanja", "Cijena"};

    public TipTretmanaCustomTableModel(List<TipTretmana> dataList) {    	
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
        TipTretmana person = data.get(row);
        
        switch (column) {
            case 0:
                return person.getnazivTretmana();
            case 1:
                return person.getVrijemeTrajanja();
            case 2:
                return person.getCijena();
            default:
                return null;
        }
    }
}
