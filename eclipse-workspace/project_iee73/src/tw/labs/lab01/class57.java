package tw.labs.lab01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class class57 {

	public static void main(String[] args) {

		for (;;) {
			try {
				ServerSocket server = new ServerSocket(9999);
				Socket socket = server.accept();

				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(isr);

				String line = reader.readLine();
				StringBuffer sb = new StringBuffer();
				while ((line != null)) {
					sb.append(line+"\n");
				}

				InetAddress ip = socket.getInetAddress();

				reader.close();
				server.close();

				System.out.println(ip.getHostAddress() + ":" + line);
				if(sb.toString().contains("quit")) {
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
