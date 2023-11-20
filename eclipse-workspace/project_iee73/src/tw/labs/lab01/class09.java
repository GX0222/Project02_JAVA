package tw.labs.lab01;

public class class09 {
	public static void main(String[] args) {
		// 用純變數計算，骰100次骰子的點數次數
		int p0, p1, p2, p3, p4, p5, p6;
		p0 = p1 = p2 = p3 = p4 = p5 = p6 = 0;
		for (int i = 1; i <= 100; i++) {
			int roll = (int) (Math.random() * 6 + 1);
			switch (roll) {
			case 1:
				p1++;
				break;
			case 2:
				p2++;
				break;
			case 3:
				p3++;
				break;
			case 4:
				p4++;
				break;
			case 5:
				p5++;
				break;
			case 6:
				p6++;
				break;
			default:
				p0++;
			}
		}
		System.out.printf("1:%d, 2:%d, 3:%d, 4:%d, 5:%d, 6:%d, err:%d", p1, p2, p3, p4, p5, p6, p0);
	}
}
