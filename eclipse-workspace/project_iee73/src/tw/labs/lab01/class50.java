package tw.labs.lab01;

public class class50 {

	public static void main(String[] args) {
		Class501 t1 = new Class501("A");
		Class501 t2 = new Class501("B");
		Class502 t3 = new Class502("C");
		Thread t4 = new Thread(t3);
		                               
		t1.start();
		t2.start();
		t4.start();
		System.out.println("main");
	}

}

class Class501 extends Thread {
	String name;
	Class501(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(name+":"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}

class Class502 implements Runnable {
	String name;
	Class502(String name){
		this.name = name;
	}
	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(name+":"+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}