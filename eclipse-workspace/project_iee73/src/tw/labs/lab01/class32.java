package tw.labs.lab01;

import java.util.LinkedList;

public class class32 {

	public static void main(String[] args) {
		LinkedList<String> Llist = new LinkedList<String>();
		Llist.add(0, "大中天"); // 0
		Llist.add(0, "Peter"); // 1
		Llist.add(0, "Tony"); // 1
		Llist.add(0, "RuWen");
		System.out.println(Llist.size());
		System.out.println(Llist);
		for (int i = 0; i < Llist.size(); i++) {
			System.out.println(Llist.get(i));
		}
		System.out.println("==========");
		for (String name : Llist) { // for-each
			System.out.println(name);
		}

	}

}
