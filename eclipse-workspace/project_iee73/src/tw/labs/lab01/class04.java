package tw.labs.lab01;

public class class04 {

	public static void main(String[] args) {
		double temp = Math.random();
//			System.out.println(temp);
		int score = (int) (temp * 101);
//			System.out.println(score);
		String grade = "";
		boolean isPass = false;
		if (score >= 90) {
			System.out.printf("%d : %s", score, "Class A");
			grade = "A"; isPass = true;
		} else if (score >= 80) {
			System.out.printf("%d : %s", score, "Class B");
			grade = "B"; isPass = true;
		} else if (score >= 70) {
			System.out.printf("%d : %s", score, "Class D");
			grade = "C"; isPass = true;
		} else if (score >= 60){
			System.out.printf("%d : %s", score, "Class E");
			grade = "E"; isPass = true;
		}else {
			System.out.printf("%d : %s", score, "Class D");
			grade = "E"; isPass = false;
		}
		System.out.printf("\n%d\n%s\n%s", score, grade, isPass?"Pass":"Down");
	}

}
