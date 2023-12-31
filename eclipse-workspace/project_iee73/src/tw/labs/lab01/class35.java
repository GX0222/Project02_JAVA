package tw.labs.lab01;

public class class35 {

	public static void main(String[] args) {
		Bird bird = new Bird();
		try {
			bird.setLeg(5);
		} catch (Exception e) {
			System.out.println("ERROR");
		}
		System.out.println("-----");
		test1(bird);
	}

	static void test1(Bird bird) {
		try {
			test2(bird);
			System.out.println("test1():OK");
		} catch (Exception e) {
			System.out.println("test1():err");
			return;
		} finally {// 不管如何 return 之前都要做
			System.out.println("finally");
		}
		System.out.println("test1():finish");
	}

	static void test2(Bird bird) throws Exception {
		bird.setLeg(3);
	}

}

class Bird {
	int leg;

	void setLeg(int num) throws Exception {
		if (num >= 0 && num <= 2) {
			leg = num;
		} else {
			throw new Exception();
		}
	}
}
