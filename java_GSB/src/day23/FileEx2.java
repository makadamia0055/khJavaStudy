package day23;

import java.io.File;
import java.io.IOException;

public class FileEx2 {

	public static void main(String[] args) {
		File file = new File("D:/test2/test"); // 상대 경로 - 프로젝트 밑에 생성
		
		if(file.mkdir()) {
			System.out.println("폴더가 생성되었습니다.");
		}else {
			System.out.println("폴더 생성에 실패하였습니다.");
		} // 1. 이미 만들어진 폴더이거나 
			// 2. 상위 폴더가 없는 경우 실패
		
		if(file.mkdirs()) {
			System.out.println("경로상 모든 폴더들이 생성되었습니다.");
		}else {
			System.out.println("이미 폴더들이 있습니다.");
		}
		if(file.isDirectory())
			System.out.println("폴더명 : " + file.getName());
		
		if(file.isFile())
			System.out.println("파일명 : " + file.getName());
		
		
		if(file.delete()) {
			System.out.println("폴더가 삭제되었습니다.");
			// 해당 경로의 폴더만 삭제됨. 즉 상위폴더는 그대로
		}else {
			System.out.println("없는 폴더 입니다.");
		} 
		
		
	}

}
