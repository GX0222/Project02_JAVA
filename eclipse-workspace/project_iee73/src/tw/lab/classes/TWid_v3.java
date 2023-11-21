package tw.lab.classes;

public class TWid_v3 {
	private String id;
	public static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";

	public TWid_v3() {
		this((int) (Math.random() * 2) == 0);
	}

	public TWid_v3(boolean isMale) {
		this(isMale, (int) (Math.random() * 26));
	}

	public TWid_v3(int area) {
		this((int) (Math.random() * 2) == 0, area);
	}

	public TWid_v3(boolean isMale, int area) {
		String c1 = letters.substring(area, area + 1);
		StringBuilder sb = new StringBuilder(c1);
		sb.append(isMale ? "1" : "2");
		for(int i=0;i<7;i++) {
			sb.append((int)(Math.random()*10));
		}
		for (int i =0;i<10;i++) {
			if(isRightID(sb.toString()+i)) {
				id = sb.toString()+i;
				break;
			}
		}
	}
	
	
	public String getID () {
		return id;
	}
	
	

	private TWid_v3(String id) {
		this.id = id;
	}
	
	public static TWid_v3 creatTWid(String id) {
		if (isRightID(id)) {
			return new TWid_v3(id);
		}else {
			return null;
		}
	}
	

	
	
	
	public static boolean isRightID(String id) {
		// 1. length = 10
		// 2. 1=> A-Z
		// 3. 2=> 1 or 2
		// 4. 3 ~ 10 => 0 ~ 9

		String num = "0123456789";
		boolean isRight = false;

		if (id.matches("[A-Z][12][0-9]{8}")) {
			int a12 = letters.indexOf(id.charAt(9)) + 10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;

			String s1 = id.substring(1, 2);
			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(id.substring(2, 3));
			int n3 = Integer.parseInt(id.substring(3, 4));
			int n4 = Integer.parseInt(id.substring(4, 5));
			int n5 = Integer.parseInt(id.substring(5, 6));
			int n6 = Integer.parseInt(id.substring(6, 7));
			int n7 = Integer.parseInt(id.substring(7, 8));
			int n8 = Integer.parseInt(id.substring(8, 9));
			int n9 = Integer.parseInt(id.substring(9, 10));

			int sum = a1 * 1 + a2 * 9 + n1 * 8 + n2 * 7 + n3 * 6 + n4 * 5 + n5 * 4 + n6 * 3 + n7 * 2 + n8 * 1 + n9 * 1;

			isRight = sum % 10 == 0;
		}
		return isRight;
	}

}
