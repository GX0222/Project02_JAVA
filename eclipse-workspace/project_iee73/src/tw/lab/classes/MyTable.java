package tw.lab.classes;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private MyModel myModel;
	private FoodDB foodDB;
	
	public MyTable () {
		try {
			foodDB = new FoodDB();
			foodDB.queryDB();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		myModel = new MyModel();
		setModel(myModel);
		myModel.setColumnIdentifiers(foodDB.getHeader());
	}
	
	public void delData() {
		int n = getSelectedRow();
		System.out.println(n);
		if(n>=0) {
			try {
				foodDB.delRow();
				repaint();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public void moveNewRow() {
		foodDB.moveNewRow();
		repaint();
	}
	
	private class MyModel extends DefaultTableModel{

		@Override
		public int getRowCount() {
			return foodDB.getRows();
		}

		@Override
		public int getColumnCount() {
			return foodDB.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return foodDB.getData(row, column);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			boolean isEditable = true;
			if(column == 0) isEditable = false;
			return isEditable;
		}

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			System.out.println(aValue);
			foodDB.updateDB(row, column, (String)aValue);
			repaint();
		}
		
		

		
		
	}
}
