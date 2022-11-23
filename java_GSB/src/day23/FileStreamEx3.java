package day23;

import java.io.*;


public class FileStreamEx3 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			fis = new FileInputStream("text.txt");
			fos = new FileOutputStream("text.txt");
			dis = new DataInputStream(fis);
			dos = new DataOutputStream(fos);
			
			String name = "홍길동";
			int age = 10;
			double pi = 3.14;
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(pi);
			
			
			name = dis.readUTF();
			age = dis.readInt();
			pi = dis.readDouble();
			// 입력해준 패턴을 맞춰줘야함
			System.out.println(age +" "+ name + " " + pi);
			
			dos.writeUTF("임꺽정");
			dos.writeUTF("2000-02-02");
			
			
			
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료되었습니다.");
		
	}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
				dis.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
