package tw.labs.lab01;

import java.io.File;
import java.io.FileOutputStream;

public class class38 {

	public static void main(String[] args) {
		try {
			String mesg = "Hello 大中天\n";
			FileOutputStream fout = new FileOutputStream("dir1/file1.txt", true);
			fout.write(mesg.getBytes());
			fout.flush();
			fout.close();
			System.out.println("Ok");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
