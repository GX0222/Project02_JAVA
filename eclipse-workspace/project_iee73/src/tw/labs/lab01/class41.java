package tw.labs.lab01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;

public class class41 {

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/rise.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/rise.jpg");

			int b;
			while ((b = fin.read()) != -1) {
				fout.write(b);
			}

			fout.flush();
			fout.close();
			fin.close();
			System.out.println("Done" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
