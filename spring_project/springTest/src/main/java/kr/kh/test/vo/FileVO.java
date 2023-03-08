package kr.kh.test.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {
	private int fi_num;
	private String fi_ori_name;
	private String fi_name;
	private int fi_bo_num;
	
	public FileVO(int fi_bo_num, String fi_ori_name, String fi_name) {
		this.fi_bo_num = fi_bo_num;
		this.fi_ori_name = fi_ori_name;
		this.fi_name = fi_name;
	}
}
