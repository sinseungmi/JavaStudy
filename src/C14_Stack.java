
public class C14_Stack {
	
	static int i = 0;

	public static void main(String[] args) {
		a();
		//stackoverflow();
	}
	public static void stackoverflow() {
		System.out.println(i++);
		stackoverflow();
	}

	public static void a() {
		b();
	}
	public static void b() {
		b_1();
		c();
	}
	public static void b_1() {
		b_2();
	}
	public static void b_2() {
		System.out.println("hi b_2");
	}
	public static void c() {
		System.out.println("hi c");
	}
}
