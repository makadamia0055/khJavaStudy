package day26;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex04_ServerMain {

	public static void main(String[] args) {
		/* 클라이언트가 연결을 요청하면 연결을 하고, 연결이 종료되기 전까지
		 * 클라이언트가 전송한 문자열을 계속 출력함.
		 */
		ServerSocket serversocket = null;
		
		try {
			serversocket = new ServerSocket();
			serversocket.bind(new InetSocketAddress(5001));
			while(true) {
				System.out.println("[연결 대기중]");
				Socket socket = serversocket.accept();
				System.out.println("[연결 완료] 접속 아이피 :"+ socket.getRemoteSocketAddress());
				Client c = new Client(socket);
				c.read();
				c.send();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

}
