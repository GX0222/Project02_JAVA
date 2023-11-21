package tw.labs.lab01;

public class class17 {

	public static void main(String[] args) {
		String s1 = "MonsterHunter";
		System.out.println("MonsterHunter".charAt(2));
		String s2 = "MonsterHunter";
		String s3 = new String("MonsterHunter");
		String s4 = new String("MonsterHunter");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		System.out.println("---");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s3.equals(s4));

	}

}
