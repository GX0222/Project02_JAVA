package tw.labs.lab01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class class37 {

	public static void main(String[] args) {
		try {
			File file = new File("dir3/file2.txt");
			FileInputStream fin = new FileInputStream(file);
			int len;
			byte[] buf = new byte[(int)file.length()];
			fin.read(buf);
			System.out.println(new String(buf));
			System.out.println(buf[0]);

			fin.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
