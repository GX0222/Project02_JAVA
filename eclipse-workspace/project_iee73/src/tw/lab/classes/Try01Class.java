package tw.lab.classes;

public class Try01Class {
	
	private static String newID;
	
	public Try01Class() {
		creatID(true);
	}

	public static String creatID(boolean Male) {

		String area = "ABCDEFGHJKLMNPQRSTUVXYWZIO";

		int areaNum = (int) (Math.random() * 26 + 1);

		StringBuilder sb = new StringBuilder();
		sb.append(area.substring(areaNum, areaNum + 1));
		sb.append(Male ? 1 : 2);
		
		for (int i=0;i<8;i++) {
			sb.append((int)(Math.random()*9+1));
		}
		
		 newID = sb.toString();

		return newID;
	}
	
	public static String getID () {
		return newID;
	}
}
