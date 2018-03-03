package cc;

import cp.Loggable;

public class Main {
	@Loggable
	static public<T> T slave(T f) {
		System.out.println("[Slave] ... " + f);
		return f;
	}
	
	@Loggable
	static public<T> T butler(T a, T b) {
		System.out.println("[Butler] Lord, " + a + b);
		slave(a);
		slave(b);
		return a;
	}

	static public Integer hello() {
		System.out.printf("Hello\n");
		return 10;
	}
	public static void main(String[] args) {
		Integer t = slave(30);
		Integer h = butler(10, 20);
		String str = butler("a", "bstr");
		System.out.printf("%s %s %s\n", t, h, str);
	}
}
