package weekend_homework4;

import java.sql.SQLException;

public interface ObjDAO {
	boolean deleteObj(Object obj, String obj_num) throws SQLException;
}
