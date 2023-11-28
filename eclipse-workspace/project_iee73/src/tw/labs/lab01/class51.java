package tw.labs.lab01;

public class class51 {

	public static void main(String[] args) {
		Class511 obj1 = new Class511();
		Class512 obj2 = new Class512();
		obj1.setDaemon(false);
		obj2.setDaemon(false);
		obj1.start();
		obj2.start();
	}

}

class Class511 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("A:" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}

class Class512 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("B:" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}