package tw.labs.lab01;

import tw.lab.classes.Bike;

public class class14 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
//		System.out.println(b1.speed);
//		System.out.println(b1.boo);
//		System.out.println(b1.myArr[0]);
		b1.upSpeed();
		b1.upSpeed();
		b1.upSpeed();
//		System.out.println(b1.speed);
		b1.downSpeed();
//		System.out.println(b1.speed);
		
		
		for (double i = b1.getSpeed(); i <= 10.0; b1.upSpeed()) {
			i = b1.getSpeed();
			System.out.println(i);
		}
	}

}
