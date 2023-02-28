package kr.kh.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

import kr.kh.spring.vo.FileVO;

public class UploadFileUtils {
	public static boolean removeFile(String uploadPath, String fileName) {
		fileName = fileName.replace("/", File.separator);
		File file = new File(uploadPath + fileName);
		if(file.exists()) {
			return file.delete();
		}
		return false;
		
		
	}
	
	//서버에 파일을 업로드하고 업로드된 경로와
	public static String uploadFile(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
		//UUID를 생성(36자리의 랜덤 문자열 생성)(32의 문자와 -4개)
		//8-4-4-4-12
		UUID uid = UUID.randomUUID();
		//originalName = 원본 파일명
		// savedName : 서버에 저장될 파일명
		String savedName = uid.toString() +"_" + originalName;
		// savedPath : 서버에 저장할 경로 -년/월/일 구조로
		// uploadPath : 저장할 서버 폴더 위치
		String savedPath = calcPath(uploadPath);
		// 빈 파일 생성 : 서버에 업로드 될 빈파일을 생성
		File target = new File(uploadPath + savedPath, savedName);
		// 복사를 해서 서버에 업로드
		FileCopyUtils.copy(fileData, target);
		// 서버에 업로드된 파일의 경로와 파일명
		// /2023/02/27/uuid_img.jpg
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		return uploadFileName;
	}
	
	// uploadPath 안에 업로드한 날짜를 기준으로 펄더가 없으면 생성, 있으면 건너뛰고
	// 날짜 경로를 만들어주는 메소드
	private static String calcPath(String uploadPath) {
		// 현재 날짜 정보를 가져옴
		Calendar cal = Calendar.getInstance();
		// \\2023
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		// \\2023\\02
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		// \\2023\\02\\27
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
 
	}
	// 가변인자 ... 배열로 받기 때문에 향상된 for문으로 값에 접근 가능
	private static void makeDir(String uploadPath, String... paths) {
		// datePath를 기준으로 폴더가 존재하면 폴더를 만들 필요가 없음.
		if(new File(paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			// 경로에 폴더가 존재하지 않으면 폴더를 생성
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	private static String makeIcon(String uploadPath, String path, String fileName)
        	throws Exception{
		// uploadPath의 \\를 / 로 바꿔주는 메소드
		String iconName = path + File.separator + fileName;
		return iconName.replace(File.separatorChar, '/');
	}
}
