package example.db.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO {
	private String st_num;
	private String st_name;
	private String st_pr_num;
	private int st_semester;
	private String st_state;
}
