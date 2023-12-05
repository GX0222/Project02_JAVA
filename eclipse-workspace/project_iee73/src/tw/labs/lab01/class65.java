package tw.labs.lab01;

import tw.lab.classes.BCrypt;

public class class65 {

	public static void main(String[] args) {
		String passwd = "123456";
		String hashPW = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hashPW);
		
		if(BCrypt.checkpw("123456", hashPW)) {
			System.out.println("OK");
		}else {
			System.out.println("X");
		}
	}

}
