package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBUtil;
import VO.AdminVO;

    public class AdminDAO { 		
    	public AdminVO getAdmin(int id) throws Exception{
    		String dml ="select * from Admin "
    		           +"where id = ?"; 

		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    AdminVO retval = null;
	   
	    try{
		con = DBUtil.getConnection();
		pstmt = con.prepareStatement(dml);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if(rs.next()){
                  retval = new AdminVO(rs.getInt(1), rs.getString(2), rs.getBoolean(3));         
        
        }
	    }catch(SQLException se){
	    	System.out.println(se);
	    }catch (Exception e) {
	    	System.out.println(e);
	    }
          finally {
        	  try {
        		  if(rs!=null)rs.close();
        		  if(pstmt!= null) pstmt.close();
        		  if(con!=null)con.close();
        	  }catch(SQLException se) {
        	  }
          }
	    return retval;
	}
}    		  
