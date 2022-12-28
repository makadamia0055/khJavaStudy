package example.db.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentVO2 {
	private String num;
	private String name;
	private String professorNum;
	private int semester;
	private String state;
}
