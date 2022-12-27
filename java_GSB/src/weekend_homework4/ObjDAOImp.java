package weekend_homework4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ObjDAOImp implements ObjDAO{
	Connection con ;
	ResultSet st;
	Statement stmt ;
	PreparedStatement pStmt;
	
	ObjDAOImp(Connection con) throws SQLException{
		this.con = con;
		if(con!=null) {
			stmt = con.createStatement();
		}
	}
	
	
	@Override
	public boolean deleteObj(Object obj, String obj_num) throws SQLException {
		String sql = "delete from ? where ? = ?";
		sql = sql.replaceFirst("[?]", obj.getClass().getSimpleName());
		sql = sql.replaceFirst("[?]", obj.getClass().getDeclaredFields()[0].getName());
		sql = sql.replaceFirst("[?]", obj_num);
		if(stmt.execute(sql)) {
			return true;
		}else {
			return false;
		}
		
	}
	
}
