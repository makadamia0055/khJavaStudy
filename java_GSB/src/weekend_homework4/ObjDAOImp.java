package weekend_homework4;

import java.sql.Connection;
import java.sql.Statement;

public class ObjDAOImp implements ObjDAO{

	@Override
	public boolean deleteObj(Object obj, String obj_num) {
		String sql = "delete from ? where ? = ?";
		sql.replaceFirst("?", obj.getClass().getSimpleName());
		sql.replaceFirst("?", obj.getClass().getDeclaredFields()[0].getName());
		sql.replaceFirst("?", obj_num);
		System.out.println(sql);
//		Connection con = new Connection();
//		Statement stmt = con.createStatement();
//		stmt.execute(sql);
//		
		
		
		
		
		
		return false;
	}
	
}
