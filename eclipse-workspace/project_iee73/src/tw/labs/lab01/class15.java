package tw.labs.lab01;

import tw.lab.classes.Bike;
import tw.lab.classes.Scooter;

public class class15 {

	public static void main(String[] args) {
		
		Bike b1 = new Bike();
		Scooter s1 = new Scooter();
		
		b1.upSpeed();b1.upSpeed();b1.upSpeed();
		s1.changeGear(2);
		s1.upSpeed();s1.upSpeed();s1.upSpeed();
		
		System.out.println(b1.getSpeed());
		System.out.println(s1.getSpeed());

	}

}
