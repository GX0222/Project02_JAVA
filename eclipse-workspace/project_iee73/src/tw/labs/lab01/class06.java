package tw.labs.lab01;

import java.util.Scanner;

public class class06 {

	public static void main(String[] args) {
//		int a = 3;
//		switch (a) { // 只可用 byte, short, int, char, String, Enum
//		case 1, 3, 5:
//			System.out.println("A");
//			break;
//		case 10:
//			System.out.println("B");
//			// break; // break省略的話，會印出B、C
//		case 100:
//			System.out.println("C");
//			break;
//		default:
//			System.out.println("X");
//		}

			// ================

			Scanner scan = new Scanner(System.in);
			int b = scan.nextInt();
			switch (b) {
			case 1, 3, 5, 7, 8, 10, 12:
				System.out.println("31 天");
				break;
			case 2:
				System.out.println("28 天");
				break;
			case 4, 6, 9, 11:
				System.out.println("30 天");
				break;
			}

		}

	}


