package tw.labs.lab01;

import java.util.Scanner;

public class lab_9981_v2 {

	public static void main(String[] args) {
		for (;;) {
			System.out.println("請輸入3或4:");
			Scanner scanner = new Scanner(System.in);
			int a = scanner.nextInt();
			switch (a) {
			case 3, 4:
				input3or4(a);
				break;
			default:
				System.out.println("請輸入3或4!!!!");
				break;
			}
		}
	}

	static void input3or4(int a) {
		for (int y = a - 2; y <= 10 - a; y += a) {
			System.out.println("================================");
			for (int x = 1; x <= 9; x++) {
				for (int i = y; i < y + a; i++) {
					System.out.printf("|\t");
					System.out.printf("%d x %d = %2d\t", i, x, (i * x));
				}
				System.out.printf("|");
				System.out.println();
			}
		}
		System.out.println("================================");
	}

}
