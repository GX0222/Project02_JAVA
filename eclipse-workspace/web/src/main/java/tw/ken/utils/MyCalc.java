package tw.ken.utils;

public class MyCalc {
	private int x, y;
	private String op;

	public MyCalc(String x, String y, String op) throws Exception {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
		this.op = op;
	}

	public String calcu(String op) {
		switch (op) {
		case "1": {
			return plus() + "";
		}
		case "2": {
			return minus() + "";
		}
		case "3": {
			return mult() + "";
		}
		case "4": {
			return div() + "";
		}
		default:
			System.out.println("calcu err");
			return " ";
		}
	}

	public int plus() {
		return x + y;
	}

	public int minus() {
		return x - y;
	}

	public int mult() {
		return x * y;
	}

	public String div() {
		int v1 = x / y;
		int v2 = x % y;
		return String.format("%d.....%d", v1, v2);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
