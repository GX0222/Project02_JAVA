package tw.labs.lab01;

import java.io.InputStream;
import java.util.Scanner;

public class class02 {

	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
//		int a = scanner.nextInt();
//		int b = scanner.nextInt();
//		int r = a + b;
//		System.out.println("a:"+a);
//		System.out.println("b:"+b);
//		System.out.printf("%d + %d = %d", a, b, r);
		
		System.out.printf("請輸入a = ");
		int a = scanner.nextInt();
		System.out.printf("請輸入b = ");
		int b = scanner.nextInt();
		int r1 = a + b;
		int r2 = a - b;
		int r3 = a * b;
		int r4 = a / b;
		int r5 = a % b;
		System.out.printf("%d + %d = %d\n", a, b, r1);
		System.out.printf("%d - %d = %d\n", a, b, r2);
		System.out.printf("%d x %d = %d\n", a, b, r3);
		System.out.printf("%d / %d = %d\n", a, b, r4);
		System.out.printf("%d 除以 %d 的餘數 = %d\n", a, b, r5);
		
	}
	
}
