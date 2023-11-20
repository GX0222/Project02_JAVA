package tw.labs.lab01;

public class class10 {
	public static void main(String[] args) {
		// 用陣列計算，骰100次骰子的點數次數
		int[] p = new int[7];
		for (int i = 1; i <= 666666; i++) {
			int roll = (int) (Math.random() * 6 + 1);
			if (roll == 0 || roll > 6) {
				p[0]++;
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
