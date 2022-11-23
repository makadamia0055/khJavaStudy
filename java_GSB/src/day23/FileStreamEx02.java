package day23;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamEx02 {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("test.txt");
			
			char ch = '\u0000';
			for(int i = 0; i<200; i++) {
				fw.write(ch++);
				}
			
			
			fw.close();

			
			// 동시에 같이 읽고 쓰고 해버리면 오류가 뜸.
			// 그래서 하나 읽고 닫고 쓰고 닫고 해야되는듯.
			
			
			
			
			fr = new FileReader("test.txt");
			int num; 
			for(int i = 0; i<200; i++) {
				num = fr.read();
				System.out.print(num + " ");
			}
			
			
			
			
			
		}catch(IOException e){
			e.printStackTrace();
			
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
