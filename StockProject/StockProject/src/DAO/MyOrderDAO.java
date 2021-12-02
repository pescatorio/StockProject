package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBUtil;
import VO.MyOrderVO;
import VO.ProductVO;


public class MyOrderDAO {

	public ProductVO getProductCheck(int product_id)throws Exception{
		String dml = "select * from product where product_id=?";
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO retval =  null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, product_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				retval = new ProductVO(rs.getInt(1),
						rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
			}
		}catch(SQLException se){
			System.out.println(se);
		}catch (Exception e) {
			System.out.println(e);
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se){
			}
			return retval;
		}
	}
	
	//order_id�� �Ű������� MyOrder�� ��ȯ�ϴ� �޼���
	public MyOrderVO getMyOrder(int order_id){
		String dml = "select * from myorder where order_id = ? ";
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyOrderVO retval =  null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, order_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				retval = new MyOrderVO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			}
		}catch(SQLException se){
			System.out.println("se=["+se+"]");
		}catch(Exception e){
			System.out.println("e=["+e+"]");
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e){
				
			}
		}
		return retval;
	}	//getMyOrder
	
	
	
	
	public MyOrderVO getOrder(int product_id,int manufacturer_id,int order_number){
		String dml = "insert into myorder(product_id,manufacturer_id,order_number,order_date,IsStocked) values(?,?,?,sysdate(),0)";	//isStocked�� �ֹ����� ��� 0ó��, �԰��� 1
		Connection con =null;
		PreparedStatement pstmt = null;
		MyOrderVO retval =  null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, product_id);
			pstmt.setInt(2, manufacturer_id);
			pstmt.setInt(3, order_number);
			int i = pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println("se=["+se+"]");
		}catch(Exception e){
			System.out.println("e=["+e+"]");
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e){
				
			}
		}
		return retval;
	}//getOrder
	
	//MyOrder�� list�� ��ȯ���ִ� �޼���
	public ArrayList<MyOrderVO>getMyOrdertotal(){
		ArrayList<MyOrderVO>list = new ArrayList<MyOrderVO>();
		String tml = "select * from MyOrder";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyOrderVO mvo = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();
			while(rs.next()){
				mvo=new MyOrderVO(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5));
				if(rs.getString(6).equals("0"))	//IsStocked�� 0�� ��쿡�� ����Ʈ�� �߰�
				list.add(mvo);
			}
		}catch(SQLException se){
			System.out.println(se);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se){
				
			}
		}
		return list;	//MyOrderVO�� ������Ʋ ��ȯ
	}//getMyOrdertotal
	
	public ArrayList<String> getColumnName(){
		ArrayList<String>columnName = new ArrayList<String>();
		String sql = "select * from MyOrder";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			
			for(int i=1;i<=cols-1;i++){	//IsStocked�� ������ ����Ʈ�� Object�� ����
				columnName.add(rsmd.getColumnName(i));
			}
		}catch(SQLException se){
			System.out.println(se);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se){
				
			}
		}
		return columnName;
	}//getColumnName
	//��ǰ�� ������ ��ȯ���ִ� �޼���
	public String getPrice_numberFromProductTable(int product_id){
		String dml = "select price_number from product where product_id=?";
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String retval =  null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, product_id);
			rs=pstmt.executeQuery();
			if(rs.next()){
				retval = rs.getString(1);
			}
		}catch(SQLException se){
			System.out.println(se);
		}catch (Exception e) {
			System.out.println(e);
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException se){
			}
			return retval;
		}
	}//getPrice_numberFromProductTable
	
	//isStocked�� �԰�ó�� �޼���
	public int isStocked(int order_id,String IsStocked){
		String dml = "update MyOrder SET IsStocked = ? WHERE order_id = ?";
		Connection con =null;
		PreparedStatement pstmt = null;
		int i =  0;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, IsStocked);
			pstmt.setInt(2, order_id);
			i = pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println("se=["+se+"]");
		}catch(Exception e){
			System.out.println("e=["+e+"]");
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e){
				
			}
		}
		return i;
	}
	
	//product�� ����� ��ȯ �޼���
	public String getProductStock(int product_id) throws Exception{
		String dml = "SELECT stock FROM product where product_id ="+product_id;
		Connection con =null;
		Statement stmt = null;
		ResultSet rs = null;
		String stock = null;
		try{
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			rs=stmt.executeQuery(dml);
			while(rs.next()){
				stock = rs.getString(1);
			}
			System.out.println("stock : "+stock);
		}catch(SQLException se){
			System.out.println(se);
		}catch (Exception e) {
			System.out.println(e);
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
			}catch(SQLException se){
			}
			return stock;
		}
	}
	
	//product�� ����� update�޼���
	public int setStock(int product_id,int stock){
		String dml = "update product SET stock = ? WHERE product_id = ?";
		Connection con =null;
		PreparedStatement pstmt = null;
		String tmpStock = stock+"";
		int i = 0;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, tmpStock);
			pstmt.setInt(2, product_id);
			i = pstmt.executeUpdate();
		}catch(SQLException se){
			System.out.println("se=["+se+"]");
		}catch(Exception e){
			System.out.println("e=["+e+"]");
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e){
				
			}
		}
		return i;
	}
	
	
	//�⺻������
	public MyOrderDAO(){
		
	}
}