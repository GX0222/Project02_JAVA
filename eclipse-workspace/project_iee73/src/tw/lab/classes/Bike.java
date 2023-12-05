package tw.lab.classes;

import java.io.Serializable;

public class Bike implements Serializable {                    // 沒寫父類別，預設 extends Object
//	private double speed;            // 私人，僅限本class
	protected double speed;         // 保護，繼承的可以用
//	public boolean boo;
//	public int[] myArr = new int[4];

	public void upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.4;
	}

	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.5;
	}
	
	public double getSpeed() {
		return speed;
	}
	
}
