package tw.labs.lab01;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class class54 {

	public static void main(String[] args) {
		String mesg = "Hi Hi";
		byte[] data = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(data, data.length
					, InetAddress.getByName("10.0.104.209"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("Sended");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
