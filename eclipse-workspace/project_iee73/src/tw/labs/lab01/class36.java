package tw.labs.lab01;

import java.io.File;
import java.io.FileFilter;

public class class36 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		File f1 = new File("./dir3");
		if(!f1.exists()) {
			f1.mkdir();
		}
		else {
			System.out.println("exsit");
		}
		System.out.println("-----");
		File f2 = new File("dir2/file1.txt");
		File f3 = new File("dir3/file2.txt");
		if(f2.renameTo(f3)) {
			System.out.println("ok");
		}else {
			System.out.println("X");
		}
	}

}
