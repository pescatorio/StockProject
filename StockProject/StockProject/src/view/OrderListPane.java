package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.MyOrderTableModel;

public class OrderListPane extends JPanel{

	public OrderListPane(){
		JTable table = new JTable(new MyOrderTableModel());
		add(new JScrollPane(table));
	}
}
