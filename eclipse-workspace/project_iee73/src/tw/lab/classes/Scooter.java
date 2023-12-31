package tw.lab.classes;

public class Scooter extends Bike {
	private int gear;
	private String color;

	// 建構式(不寫回傳值)，物件初始化
	public Scooter() { // type1
		color = "black";
	}

	public Scooter(String color) { // type2，創造物件時給他顏色
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void upSpeed() {
		if (gear > 0) {
			speed = speed < 1 ? 1 : speed * 1.7 * gear;
		}
	}

	public void upSpeed(double args) { // overload
		if (args > 0 && args < 1) {
			speed = speed < 1 ? 1 : speed * (1 + args) * gear;
		}
	}

	public boolean changeGear(int gear) {
		if (gear >= 0 && gear <= 4) {
			this.gear = gear;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return color + ":" + gear + ":" + speed;
	}

}
