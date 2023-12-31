package tw.labs.lab01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class class59 {

	public static void main(String[] args) {
		
		try {
			// 讀檔案
			File source = new File("dir1/去背月球.png");
			byte[] buf = new byte[(int)source.length()];
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(source));
			bin.read(buf);
			bin.close();
			
			//連接TCP
			Socket client = new Socket(InetAddress.getByName("10.0.104.159"), 9999);
			
			BufferedOutputStream bout = new BufferedOutputStream(client.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
			System.out.println("Send Ok");
			client.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
