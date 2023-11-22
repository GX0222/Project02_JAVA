package tw.labs.lab01;

import tw.lab.classes.class211;

public class class24 {

	public static void main(String[] args) {
//		class241 obj1 = new class241();   抽象類別不能用來宣告
		class241 obj1 = new class242();
		class241 obj2 = new class241() {void m2(){}};  
		    // 抽象類別可以直接把抽象的部分實作，用來宣告
		class211 obj3 = new class211() {public void m1() {}};
		    // 介面也可以把它實作然後用來宣告
	}

}

abstract class class241 {
	void m1() {}
	abstract void m2();
}

class class242 extends class241 {
	void m2() {}
}

class class243 extends class241 {
	void m2() {}
}















