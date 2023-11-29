package tw.labs.lab01;

import java.net.ServerSocket;
import java.net.Socket;

public class class57 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept();
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
