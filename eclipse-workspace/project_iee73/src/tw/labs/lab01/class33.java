package tw.labs.lab01;

import java.util.HashMap;

public class class33 {

	public static void main(String[] args) {
		 HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("name", "Brad");
		 map.put("gender", false);
		 map.put("age", 22);
		 map.put("weight", 80.8);
		 
		 System.out.println(map.get("name"));

	}

}
