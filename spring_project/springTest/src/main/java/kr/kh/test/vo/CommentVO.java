package kr.kh.test.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
	private int co_num;
	private String co_content;
	private Date co_register_date;
	private Date co_update_date;
	private int co_ori_num;
	private String co_me_id;
	private int co_bo_num;
	
}
