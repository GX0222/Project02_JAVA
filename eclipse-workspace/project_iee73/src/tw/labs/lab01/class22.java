package tw.labs.lab01;

public class class22 {

	public static void main(String[] args) {
		class221 obj1 = new class221();
		class221 obj2 = new class222();
//		obj2.m2();    因定義為221，所以看不到221沒有的功能
		class222 obj3 = new class222();
		obj3.m2();
		class222 obj4 = (class222) obj2;
		obj4.m2();
//		class222 obj5 = (class222) obj1;    會報型別傳亂失敗
		if(obj2 instanceof class222) {
			System.out.println("OK");
		}else {
			System.out.println("X");
		}
	}

}

///////////////////////////////////////////
class class221 {
	void m1() {
		System.out.println("221:m1");
	}
}

class class222 extends class221 {
	void m1() {
		System.out.println("222:m1");
	}

	void m2() {
		System.out.println("222:m2");
	}
}

class class223 extends class221 {
	void m1() {
		System.out.println("223:m1");
	}

	void m2() {
		System.out.println("223:m2");
	}

	void m3() {
		System.out.println("223:m3");
	}
}
