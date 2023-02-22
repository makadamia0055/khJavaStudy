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
		
		return btDao.selectWholeType();
	}
	
	
}
