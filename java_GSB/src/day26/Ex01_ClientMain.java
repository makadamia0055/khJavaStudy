package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ex01_ClientMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Socket socket = null;
		
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(5001));
			System.out.println("[연결 완료]");
			//Output 스트림 연결
			sendOutput(socket, scan);
			printInput(socket);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void printInput(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		byte [] bytebuffer = new byte[1024];
		int readCount = is.read(bytebuffer);
		String str = new String(bytebuffer, 0, readCount, "UTF-8");
		System.out.println(str);
	}

	private static void sendOutput(Socket socket, Scanner scan) throws IOException {
		OutputStream os = socket.getOutputStream();
		//보내려는 문자열 byte 배열로 변환
		System.out.println("채팅을 입력해주세요.");
		String str = scan.nextLine();
		byte [] bytes = str.getBytes("UTF-8");
		// 전송
		os.write(bytes);
		os.flush();
	}

}
