package day23;

import java.io.*;

import lombok.Data;


public class FileStreamEx4 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try {
		
			fos = new FileOutputStream("text.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(new Student("홍길동", "1000-20-32"));
			oos.writeObject(new Student("공길동", "1100-22-32"));
			oos.writeObject(new Student("농길동", "1110-23-32"));
			
			// 이것도 동시에 하면 안되고 따로 따로 해야 됨..
			
			
			
			
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료되었습니다.");
		
	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				oos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			fis = new FileInputStream("text.txt");
			ois = new ObjectInputStream(fis);
			
			
			while(true) {
				Student std = (Student) ois.readObject();
				System.out.println(std);
			}
			
			
			
			
			
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료되었습니다.");
		
	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
@Data
class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1700858336115503227L;
	private String name;
	private String birthday;
	
	public Student(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
}

