package tw.lab.classes;

public class TWid {
	private String id;

	public static boolean isRightID(String id) {
		// 1. length = 10
		// 2. 1=> A-Z
		// 3. 2=> 1 or 2
		// 4. 3 ~ 10 => 0 ~ 9
		String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
		String num = "0123456789";
		boolean isRight = false;
		if (id.length() == 10) {
			if (letters.indexOf(id.charAt(0)) >= 0) {
				if (id.charAt(1) == '1' || id.charAt(1) == '2') {
					for(int i=2;i<=9;i++) {
						if (num.indexOf(id.charAt(i))<0) {
							isRight = false;
							break;
						}
						else {
							isRight = true;
						}
					}
				}
			}
		}
		return isRight;
	}

}
