package tw.labs.lab01;

public class lab_Poker_v1 {

	public static void main(String[] args) {
		// 洗牌
		
		long start = System.currentTimeMillis();
		int[] poker = new int[52];
		for (int i = 0; i < poker.length; i++) {
			int temp = (int) (Math.random() * 52);

			boolean isRepeat = false;
			for (int k = 0; k < i; k++) {
				if (temp == poker[k]) {
					isRepeat = true;
					break;
				}
			}

			if (!isRepeat) {
				poker[i] = temp;
				System.out.println(poker[i]);
			} else {
				i--;
			}

		}
		System.out.println("=======");
		System.out.println(System.currentTimeMillis() - start);
	}

}
