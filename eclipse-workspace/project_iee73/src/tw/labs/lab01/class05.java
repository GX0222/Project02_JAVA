package tw.labs.lab01;

import java.util.Scanner;

public class class05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入年份:");
		int InPutYear = scan.nextInt();
		if (InPutYear % 4 == 0) {
			if (InPutYear % 100 == 0) {
				if (InPutYear % 400 == 0) {
					System.out.println("閏年");
				} else {
					System.out.println("不是閏年");
				}
			} else {
				System.out.println("閏年");
			}
		} else {
			System.out.println("不是閏年");
		}
	}
}