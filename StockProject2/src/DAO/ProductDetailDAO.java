package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;
import VO.ProductVO;

public class ProductDetailDAO {
	public ProductVO AddProduct(ProductVO pvo) throws Exception{
		String dml = "insert into product (product_id,product_name,manufacturer_id,price_number,stock) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		ProductVO retval = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, pvo.getProduct_id());
			pstmt.setString(2, pvo.getProduct_name());
			pstmt.setInt(3,pvo.getManufacturer_id());
			pstmt.setString(4,pvo.getPrice_number());
			pstmt.setString(5,pvo.getStock());
			
			int i = pstmt.executeUpdate();
			retval = new ProductVO();
			/*retval.setStock(i+"");*/
		}catch(SQLException e){
			System.out.println("e=["+e+"]");
		}catch(Exception e){
			System.out.println("e="+e+"]");
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e){
				
			}
		}
		return retval;
	}//AddProduct
	
	public ProductVO getProduct(int product_id) throws Exception{
		String dml = "SELECT * FROM product where product_id = ?";
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO retval = null;
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
}
