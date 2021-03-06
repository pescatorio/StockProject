package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import VO.ProductVO;
import DAO.ProductListDAO;

public class ProductModel extends AbstractTableModel{
	Object[][]data;
	Object[]columnName;

	ProductListDAO pdao = new ProductListDAO();
	ProductVO pvo;
	ArrayList<String> title;
	ArrayList<ProductVO>list;
	
	public ProductModel(){
		title =pdao.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();
		list = pdao.getProductList();
		int rowCount =list.size();
		
		data = new Object[rowCount][columnCount];
		for(int index = 0;index<rowCount;index++){
			pvo = list.get(index);
			data[index][0]=pvo.getProduct_id();
			data[index][1]=pvo.getProduct_name();
			data[index][2]=pvo.getManufacturer_id();
			data[index][3]=pvo.getPrice_number();
			data[index][4]=pvo.getStock();
		}
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		if(columnName==null){
			return 0;
		}else{
			return columnName.length;
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(data==null){
			return 0;
		}else{
			return data.length;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}	
	public String getColumnName(int column){
		return (String)columnName[column];
	}
}
