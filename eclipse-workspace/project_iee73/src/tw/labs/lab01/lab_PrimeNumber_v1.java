package tw.labs.lab01;

public class lab_PrimeNumber_v1 {

	public static void main(String[] args) {
		// 1~100 質數
		for (int i = 2; i < 100; i++) {
			if (i == 2 || i == 3 || i == 5 || i == 7 || i == 11) {
				System.out.println(i + "  ");
			} else {
				boolean isPrime = true;
				for (int x = 2; x <= (i / 2 + 1); x++) {
					if (i % x == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) {
					System.out.println(i + "  ");
				}
			}
		}

	}

}
