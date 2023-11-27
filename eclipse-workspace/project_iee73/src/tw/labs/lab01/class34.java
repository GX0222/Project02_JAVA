package tw.labs.lab01;

public class class34 {

	public static void main(String[] args) {
		int a = 10, b = 0;
		int[] c = { 1, 2, 3, 4 };
		System.out.println("Brad");
		try {
			System.out.println(a / b);
			System.out.println("-----");
			System.out.println(c[4]);
		} catch (ArithmeticException e) {
			System.out.println("Oops!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("XXXXXXX");
		} catch (RuntimeException e) {
			System.out.println("ERROR");
		}

		System.out.println("Finish");
	}

}
