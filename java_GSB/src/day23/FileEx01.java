package day23;

import java.io.File;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) {
		File file = new File("C:/Usersuser2\\Downloads\\test.txt"); // 상대 경로 - 프로젝트 밑에 생성
		try {
		if(file.createNewFile()) {
			System.out.println("파일이 생성되었습니다.");
		}else {
			System.out.println("파일 생성에 실패하였습니다.");
		}
		}catch(IOException e) {
			System.out.println("IOException이 발생하였습니다.");
		}
	}

}
