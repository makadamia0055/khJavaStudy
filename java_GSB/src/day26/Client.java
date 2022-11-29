package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	private Socket socket;

	public Client(Socket socket) {
		this.socket = socket;
	}

	public void send() {
		Scanner scan = new Scanner(System.in);
		Thread t = new Thread(()->{
			try {
			OutputStream os = socket.getOutputStream();
			while(true) {
				System.out.print("전송할 문자열: ");
				String str = scan.nextLine();
				if(str.equals("exit"))
					break;
				byte[] byteBuffer = str.getBytes("UTF-8");
				os.write(byteBuffer);
				os.flush();
			}
			
			}catch(Exception e) {
				
			}
		});
		t.start();
		
	}
	
	public void read() {
			Thread t = new Thread(() -> {
				try {
				InputStream is = socket.getInputStream();
				while (true) {
					byte[] byteBuffer = new byte[1024];
					int readInt = is.read(byteBuffer);
					if(readInt ==-1)
						break;
					String str = new String(byteBuffer, 0, readInt, "UTF-8");
					System.out.println("상대 :"+ str);
					
					}
					
									
				}catch(Exception e) {
					System.out.println("클라이언트가 접속을 종료했습니다.");
				}
			});
			t.start();
		

	}

}
