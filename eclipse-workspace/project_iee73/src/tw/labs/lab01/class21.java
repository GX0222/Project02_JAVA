package tw.labs.lab01;

import tw.lab.classes.*;

public class class21 {

	public static void main(String[] args) {
		class21a cl21a = new class21a();
		class21b cl21b = new class21b();
//		cl21a.m1();
//		cl21b.m1();
		test1(cl21a);
	}
	
	static void test1(class211 x) {
		x.m1();
	}

}

class class21a implements class211{
	public void m1 () {
		System.out.println("class21a:m1()");
	}
}


class class21b implements class211{
	public void m1 () {
		System.out.println("class21b:m1()");
	}
}

