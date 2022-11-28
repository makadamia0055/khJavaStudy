package day26;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex02_ClientMain {

	public static void main(String[] args) {
		/* 서버에 연결을 요청하고 연결이 되면 
		 * exit를 입력하기 전까지 문자열을 서버에 전송함
		 * */
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(5001));
			sendMessage(scan, socket);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void sendMessage(Scanner scan, Socket socket) throws IOException {
		String str = "";
		while(!str.equals("exit")) {
			if(!socket.isConnected()) {
				socket.connect(new InetSocketAddress(5001));
			}
			System.out.print("전송할 문자열: ");
			str = scan.nextLine();
			OutputStream os = socket.getOutputStream();
			byte[] byteBuffer = str.getBytes("UTF-8");
			os.write(byteBuffer);
			os.flush();
			
		}
	}

	

}
