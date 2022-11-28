package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_ServerMain {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
			while(true) {
				System.out.println("[연결 대기중]");
				Socket socket = serverSocket.accept(); //
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락 함]" + isa.getAddress());
				
				printInput(socket);
				sendOutpout(socket, scan);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
				
	}

	private static void sendOutpout(Socket socket, Scanner scan) throws IOException {
		OutputStream os = socket.getOutputStream();
		System.out.println("대답을 입력하세요");
		String str = scan.nextLine();
		byte[] bytes = str.getBytes("UTF-8");
		os.write(bytes);
		os.flush();
		os = null;
	}

	private static void printInput(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		byte[] byteBuffer = new byte[1024];
		//최대 버퍼 1024
		//최대 버퍼에서 몇개 썼는지 리턴
		int readCount = is.read(byteBuffer);
		String str = new String(byteBuffer, 0, readCount, "UTF-8"); //0번지부터 readCount개
		System.out.println(str);
		is = null;
	}

}
