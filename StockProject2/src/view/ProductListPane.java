package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ProductModel;


public class ProductListPane  extends JPanel{
	public ProductListPane(){
		
	JTable table = new JTable(new ProductModel());
	add(new JScrollPane(table));
	}
}
