package tw.labs.lab01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;

public class class43 {

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		try {
			BufferedInputStream fin = new BufferedInputStream(new FileInputStream("dir1/rise.jpg"));
			BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream("dir2/rise.jpg"));

			int len,b;
			byte[] buf = new byte[4 * 1024];
			while ((b = fin.read()) != -1) {
				fout.write(b);
			}

			fout.flush();
			fout.close();
			fin.close();
			System.out.println("Done:" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
