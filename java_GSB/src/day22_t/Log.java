package day22_t;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Log {
	private ArrayList<StudentLog> slogs = new ArrayList<StudentLog>();
	private String date;
	
	public Log(ArrayList<Student> stds, String date) {
		this.date = date;
		for(Student tmp : stds) {
			StudentLog slog = new StudentLog(tmp, null);
			slogs.add(slog);
		}
		
	}

}
