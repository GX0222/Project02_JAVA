package tw.labs.lab01;

public class class07 {

	public static void main(String[] args) {
		// loop
		int a = 0;
		for (printText(); a <= 10; printLine()) {
			System.out.println(a++);
		}

	}
	
	static void printText() {
		System.out.println("Text");
	}
	
	static void printLine() {
		System.out.println("--------");
	}

}
