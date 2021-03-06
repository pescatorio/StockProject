package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBUtil;
import VO.ManufacturerVO;

public class ManufacturerListDAO {
	public void ManufacturerListregiste(ManufacturerVO mvo) throws Exception {
		String dml = "insert into manufacturer (manufacturer_id, manufacturer_phonenumber,"
				+ " manufacturer_name) values (?,?,?) "; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ManufacturerVO retval= null;
		
		try{
			con=DBUtil.getConnection();
			pstmt=con.prepareStatement(dml);
			
			pstmt.setInt(1,mvo.getManufacturer_id());
			pstmt.setString(2, mvo.getManufacturer_phonenumber());
			pstmt.setString(3, mvo.getManufacturer_name());
			
			int status=pstmt.executeUpdate();
			
			
		}catch(SQLException e){
			System.out.println("e=["+e+"]");
		}catch(Exception e){
			System.out.println("e=["+e+"]");
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e){
				
			}
		}
	}
}
