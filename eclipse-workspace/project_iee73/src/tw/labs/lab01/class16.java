package tw.labs.lab01;

import tw.lab.classes.Scooter;

public class class16 {

	public static void main(String[] args) {
		String s1 = new String();
		byte[] b1 = { 97, 98, 99, 100, 65, 66, 67, 68 };
		String s2 = new String(b1);
		String s3 = new String(b1, 1, 2);
		Scooter s4 = new Scooter("white");
		System.out.println(s4);
//		System.out.println(s4.getColor());
		System.out.println(b1);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

	}

}
