package tw.labs.lab01;

import java.util.Scanner;

public class lab_9981_01 {

	public static void main(String[] args) {
		for (;;) {
			System.out.println("請輸入3或4:");
			Scanner scanner = new Scanner(System.in);
			int a = scanner.nextInt();
			switch (a) {
			case 3:
				input3();
				break;
			case 4:
				input4();
				break;
			default:
				System.out.println("請輸入3或4!!!!");
				break;
			}
		}
	}

	static void input3() {
		System.out.println("============================");
		for (int i = 1; i <= 7; i += 3) {
			for (int x = 1; x <= 9; x++) {
				System.out.printf("|  ");
				System.out.printf("%d x %d = %2d\t", i, x, (i * x));
				System.out.printf("|  ");
				System.out.printf("%d x %d = %2d\t", i + 1, x, ((i + 1) * x));
				System.out.printf("|  ");
				System.out.printf("%d x %d = %2d\t", i + 2, x, ((i + 2) * x));
				System.out.println("|");

			}
			System.out.println("============================");
		}
	}

	static void input4() {
		System.out.println("===================================");
		for (int i = 2; i <= 6; i += 4) {
			for (int x = 1; x <= 9; x++) {
				System.out.printf("|  ");
				System.out.printf("%d x %d = %2d\t", i, x, (i * x));
				System.out.printf("%d x %d = %2d\t", i + 1, x, ((i + 1) * x));
				System.out.printf("|  ");
				System.out.printf("%d x %d = %2d\t", i + 2, x, ((i + 2) * x));
				System.out.printf("|  ");
				System.out.printf("%d x %d = %2d\t", i + 3, x, ((i + 3) * x));
				System.out.println("|");

			}
			System.out.println("===================================");
		}
	}

}
