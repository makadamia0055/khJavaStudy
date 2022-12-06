package day27;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_Client {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("localhost",5001));
			// 위에서 서버 아이피주소/도메인 이름 삭제하면 localhost로 적용
			System.out.println("[연결 성공]");
			send(socket, "맘모스쌈바돼지");
			receive(socket);
			
			
		}catch(Exception e) {
			
		}

	}
	
	public static void receive(Socket socket) {
		Thread t = new Thread(()->{
			InputStream is = null;
			try {
				is = socket.getInputStream();
				byte[] byteBuffer  = new byte[1024];
				
				while(true) {
					int readCount = is.read(byteBuffer); 
					
					if(readCount==-1)
						break;
					String str = new String(byteBuffer, 0, readCount, "UTF-8");
					int index = str.indexOf(",");
					
					String name = str.substring(0, index);
					String message = str.substring(index+1);
					
					System.out.println(name+">"+message);
				}
				is.close();
				
			}catch(Exception e) {
				
				
			}finally {
				try {
					if(socket !=null&&!socket.isClosed()) {
						socket.close();
						
					}
					
					System.out.println("[클라이언트 종료]");
					}catch(Exception e2) {
						System.out.println("클라이언트 소켓 닫기 실패");
					}
			}
		});
		t.start();
	}
	
	public static void send(Socket socket, String name) {
		Thread t  = new Thread(()-> {
			Scanner scan = new Scanner(System.in);
			try {
				OutputStream os = socket.getOutputStream();
				while(true) {
					String str = scan.nextLine();
					if(str.equals("exit")) {
						break;
					}
					str = name+", "+str;	
					byte[] bytes = str.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}
				
			}catch(Exception e) {
				
			}finally {
				System.out.println("종료");
				try {
					if(socket!= null&& !socket.isClosed())
						socket.close();
				}catch(Exception e) {
					
				}
			}
		});
		t.start();
	}
	
	
}
