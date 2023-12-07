package tw.ken.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BradUtils {
	public static String loadView(String view) throws Exception {
		String viewFolder = "D:\\資展_EEIT73\\MyGit\\Project02_JAVA\\eclipse-workspace\\web\\src\\main\\webapp\\Views\\";
		File viewFile = new File(viewFolder + view + ".html");
		BufferedReader reader = new BufferedReader(new FileReader(viewFile));
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			sb.append(line+"\n");
		}
		reader.close();

		return sb.toString();
	}
}
