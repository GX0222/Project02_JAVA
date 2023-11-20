package tw.labs.lab01;

public class class11 {

	public static void main(String[] args) {
		// 多維陣列
		int[][] a = new int[3][4];

		int[][] b = new int[3][];
		b[0] = new int[3];
		b[1] = new int[4];
		b[2] = new int[5];

//		System.out.println(b.length);

		for (int i = 0; i < b.length; i++) {
			for (int k = 0; k < b[i].length; k++) {
				System.out.print(b[i][k] + "  ");
			}
			System.out.println();
		}
		System.out.println("====");

		// for-each
		for (int[] v : b) {
			for (int vv : v) {
				System.out.print(vv+"  ");
			}
			System.out.println();
		}

	}

}
