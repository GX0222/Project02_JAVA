package tw.labs.lab01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class class53 {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("google.com");
			System.out.println(ip.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println(e);
		}

	}

}
