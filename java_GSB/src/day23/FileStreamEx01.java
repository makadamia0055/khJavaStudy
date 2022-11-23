package day23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx01 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		
		try {
		fos = new FileOutputStream("text.txt");
		char ch = '\u0000';
		for(int i = 0 ; i < 200; i ++) {
			System.out.print(ch);
			fos.write(ch);
			++ch;
		}
		
		fis = new FileInputStream("test.txt");
		int num;
		for(int i = 0 ; i < 200; i ++) {
			num = fis.read();
			System.out.print((char)num + " ");
		}
		 // 입력하는 문자에 따라 데이터 손실 생김
		}catch(FileNotFoundException e) {
			// 폴더가 없을 경우에 대한 예외처리
			// 파일이 없을 경우 만들지만 폴더가 없으면 못만듦.
			System.out.println("파일을 찾지 못했습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				fis.close();
			 //메소드가 끝나더라도 실행되게. 그리고 또 예외처리 해줘야함.
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
		
	}

}
