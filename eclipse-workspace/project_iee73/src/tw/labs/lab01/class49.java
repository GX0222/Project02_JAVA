package tw.labs.lab01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class class49 {

	public static void main(String[] args) {
		Class493 obj = new Class493();

		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/test49"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("-----");
		try {
			ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream("dir1/test49"));
			Class493 tt = (Class493)(oin.readObject());
			oin.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

class Class491 {
	Class491() {
		System.out.println("Class491");
	}
}

class Class492 extends Class491 {
	Class492() {
		System.out.println("Class492");
	}
}

class Class493 extends Class492 implements Serializable {
	Class493() {
		System.out.println("Class493");
	}
}