package tw.ken.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

public class BradUtils {
	public static String loadView(String view) throws Exception {
		String viewFolder = "D:\\資展_EEIT73\\MyGit\\Project02_JAVA\\eclipse-workspace\\web\\src\\main\\webapp\\Views\\";
		File viewFile = new File(viewFolder + view + ".html");
		BufferedReader reader = new BufferedReader(new FileReader(viewFile));
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		reader.close();

		return sb.toString();
	}

	public static String calc(String x, String y, String op) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			switch (op){
			case "1": return "" + (intX + intY);
			case "2": return "" + (intX - intY);
			case "3": return "" + (intX * intY);
			case "4": return (intX / intY) + "..." + (intX % intY);
			}
			return "Err";
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String createScore() {
		return ""+(int)(Math.random()*100);
	}
	
	public static int nextPage (String page, String pages) {
		int intPage = Integer.parseInt(page);
		int intPages = (int)Double.parseDouble(pages);
		if (intPage < intPages) {
			intPage++;
		}
		return intPage;
	}
	
	public static LinkedList<HashMap<String, String>> parseGift(String json) {
		LinkedList<HashMap<String, String>> data = new LinkedList<>();
		JSONArray jsonArr = new JSONArray(json);
		for (Object object : jsonArr) {
		JSONObject jsonObject = (JSONObject)object;
		HashMap<String, String> row = new HashMap<>();
		row.put("name", jsonObject.getString("Name"));
		row.put("tel", jsonObject.getString("ContactTel"));
		row.put("city", jsonObject.getString("County"));
		row.put("town",jsonObject.getString("Township"));
		
		data.push(row);
		}
		
		return  data;
	}
}
