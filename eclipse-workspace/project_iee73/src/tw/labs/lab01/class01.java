package tw.labs.lab01;

public class class01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 	塊狀
		 *  		註解
		 */       
		
		/**
		 * 		Java Doc
		 */
		
		// byte, short, int, long
		// byte 2^8 => 256 => -128 ~ 127
		byte var1;    //  [a-zA-Z$_][a-zA-Z0-9$_]*
		byte $_$ = 123, 變數 = -88;
		System.out.println($_$);
		System.out.println(變數);
		// System.out.println(var1);
		
		// short 2^16 => 65536 => -32768 ~ 32767
		// int 2^32 => 42億多 => 4G
		// long 2^64
		
		byte var2 = 1, var3 = 2;
		int var4 = var2 + var3;    // byte, short, int 計算過後暫存在 => int
		byte a = 127;
		a++;
		System.out.println(a);
		byte b = 127;
		b += 3;
		System.out.println(b);
		byte c = 127;
		byte d;
		// d = c + 1;

	}

}
