package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import VO.MyOrderVO;
import DAO.MyOrderDAO;

public class MyOrderTableModel extends AbstractTableModel{

	Object[][] data;
	Object[] columnName;
	
	MyOrderDAO mdao = new MyOrderDAO();
	MyOrderVO mvo = new MyOrderVO();
	ArrayList<String> title;
	ArrayList<MyOrderVO> list;
	
	public MyOrderTableModel(){
		title = mdao.getColumnName();
		title.add("price*order_number");
		
		columnName = title.toArray();
		int columnCount = title.size();	
		list = mdao.getMyOrdertotal();
		int rowCount = list.size();
		
		data = new Object[rowCount][columnCount];	
		for(int index = 0;index<rowCount;index++){
			
			mvo = list.get(index);
			int tmpPrice_number = Integer.parseInt(mdao.getPrice_numberFromProductTable(mvo.getProuct_id()));
			data[index][0]=mvo.getOrder_id();
			data[index][1]=mvo.getProuct_id();
			data[index][2]=mvo.getManufacturer_id();
			data[index][3]=mvo.getOrder_number();
			data[index][4]=mvo.getOrder_date();
			data[index][5]=tmpPrice_number*mvo.getOrder_number();
		}
		
	}
	
	@Override
	public int getColumnCount() {
		if(columnName==null){
			return 0;
		}else{
			return columnName.length;
		}
	}

	@Override
	public int getRowCount() {

		if(data==null){
			return 0;
		}else{
			return data.length;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
		
	}
	public String getColumnName(int column){
		return (String)columnName[column];
	}

}
