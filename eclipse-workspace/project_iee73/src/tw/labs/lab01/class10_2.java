package tw.labs.lab01;

public class class10_2 {
	public static void main(String[] args) {
		// 作弊
		int[] p = new int[7];
		for (int i = 1; i <= 9999999; i++) {
			int roll = (int) (Math.random() * 9 + 1);
			if (roll < 1 || roll > 9) {
				p[0]++;
			} else if (roll > 6) {
				p[(roll - 3)]++;
			} else {
				p[roll]++;
			}
		}

		for (int i = 1; i < 7; i++) {
			System.out.printf("數字%d出現%d次\n", i, p[i]);
		}
		System.out.printf("發生%d次錯誤", p[0]);
	}
}
