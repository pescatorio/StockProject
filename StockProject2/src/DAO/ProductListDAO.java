package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBUtil;
import VO.ProductVO;

public class ProductListDAO {
	
	
	public ArrayList<ProductVO>getProductList(){
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String pl = "select * from product ";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO pvo = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(pl);
			rs = pstmt.executeQuery();
			while(rs.next()){
				pvo = new ProductVO(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5));
				list.add(pvo);
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
		return list;
	}//getProductList
	
	
	public ArrayList<String> getColumnName(){
		ArrayList<String>columnName = new ArrayList<String>();
		String sql = "select * from product";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			
			for(int i=1; i<=cols; i++){
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
	
	}	
	public ProductListDAO(){}
}
