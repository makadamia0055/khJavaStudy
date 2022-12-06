package day32;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_Server {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket.bind(new InetSocketAddress(5001));
			while(true) {
			Socket socket= serverSocket.accept();
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			System.out.println("[연결 완료]"+ isa.getAddress());
			sendOutput(socket);
			}
		}catch(Exception e) {
			
		}

	}

	private static void sendOutput(Socket socket) throws IOException {
		OutputStream os = socket.getOutputStream();
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		byte[] byteBuffer = str.getBytes("UTF-8");
		os.write(byteBuffer);
		os.flush();
		os = null;
		
	}
	private static void receiveInput(Socket socket) throws IOException {
		InputStream is = socket.getInputStream();
		byte[] byteBuffer = new byte[1024];
		int readInt = is.read(byteBuffer);
		String str = new String(byteBuffer, 0, readInt, "UTF-8");
		System.out.println(str);
		is = null;
		
	}

}
