package tw.labs.lab01;

public class lab_Poker_v2 {

	public static void main(String[] args) {
		// 洗牌 do-while

		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		boolean isRepeat;
		int temp;
		for (int i = 0; i < poker.length; i++) {
			do {
				temp = (int) (Math.random() * 52);
				isRepeat = false;
				for (int k = 0; k < i; k++) {
					if (temp == poker[k]) {
						isRepeat = true;
						break;
					}
				}
			} while (isRepeat);

			poker[i] = temp;
			System.out.println(poker[i]);

		}
		System.out.println("=======");
		System.out.println(System.currentTimeMillis() - start);
	}

}
