package tw.labs.lab01;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class class56 {

	public static void main(String[] args) {
		String msg = "quit";
		try (Socket client = new Socket(InetAddress.getByName("10.0.104.159"), 9999);
				OutputStream out = client.getOutputStream();
				BufferedOutputStream bout = new BufferedOutputStream(out);) {
			bout.write(msg.getBytes());
			bout.flush();
//			bout.close();
			System.out.println("Send Ok");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
