package tw.labs.lab01;

import java.util.Arrays;

public class lab_Poker_v3 {

	public static void main(String[] args) {
		// 洗牌大鍋炒，發給四個人

		long start = System.currentTimeMillis();
		int num = 52;
		int[] poker = new int[num];
		int temp;
		
		for (int i = 0; i < poker.length; i++) {
			poker[i] = i + 1;
		}

		for (int i = num - 1; i > 0; i--) {
			temp = (int) (Math.random() * (i) - 1);
			poker[i] += poker[temp];
			poker[temp] = poker[i] - poker[temp];
			poker[i] = poker[i] - poker[temp];
		}	
		
		for (int v : poker) {
			System.out.println(v);
		}
		System.out.println("=======");

		int[][] players = new int[4][13];
		
		for (int i = 0; i < num; i++) {
			players[i % 4][i / 4] = poker[i];
		}

		
		String [] lunch ={"黑桃","紅心","方塊","梅花","黑桃"};
		String [] value = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		
		for (int[] v : players) {
			Arrays.sort(v);
			for (int vv : v) {
				System.out.printf("|%s %s\t",lunch[vv/13],value[vv%13]);
			}
			System.out.println();
		}

		System.out.println("=======");
		System.out.println(System.currentTimeMillis() - start);
	}

}
