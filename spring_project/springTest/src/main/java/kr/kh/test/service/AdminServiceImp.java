package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.AdminDAO;
import kr.kh.test.vo.BoardTypeVO;

@Service
public class AdminServiceImp implements AdminService{
	@Autowired
	AdminDAO btDao;

	@Override
	public ArrayList<BoardTypeVO> selectWholeType() {
		final int adminAuthority = 9;
		return btDao.selectWholeType(adminAuthority);
	}

	@Override
	public boolean insertBoardType(BoardTypeVO bTVO) {
		if(!checkVO(bTVO)) {
			return false;
		}
		
		if(btDao.insertNewType(bTVO)!=0) {
			
			return true;
		}else {
			System.out.println("넣기오류");
			return false;
		}
	}

	private boolean checkVO(BoardTypeVO bTVO) {
		if(bTVO==null||bTVO.getBt_name()==null||bTVO.getBt_type()==null) {
			System.out.println("객체오류");
			return false;
		}
		if(bTVO.getBt_name().equals("")) {
			System.out.println("공백이름");
			return false;
		}
		if(!(bTVO.getBt_type().equals("일반")||bTVO.getBt_type().equals("이미지"))){
			System.out.println("타입오류");
			return false;
		}
		if(!(bTVO.getBt_r_authority()==1||bTVO.getBt_r_authority()==0||bTVO.getBt_r_authority()==9)) {
			System.out.println("읽권오류");
			return false;
		}
		if(!(bTVO.getBt_w_authority()==1||bTVO.getBt_w_authority()==9)) {
			System.out.println("쓰권오류");
			return false;
		}
		if(btDao.selectTypeByName(bTVO.getBt_name())!=null) {
			System.out.println("중복이름");
			return false;
		}
		return true;
	}
	
	
}
