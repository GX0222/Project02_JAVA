package tw.labs.lab01;

import tw.lab.classes.TWid_v3;

public class class19 {					// 驗證TWid

	public static void main(String[] args) {
		TWid_v3 myId = TWid_v3.creatTWid("A123456789");
		if(TWid_v3.isRightID("A123456789")) {
			System.out.println("OK");
		}else {
			System.out.println("X");
		}
		System.out.println(myId.getID());
		
	}

}
