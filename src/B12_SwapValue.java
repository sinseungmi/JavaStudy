
public class B12_SwapValue {

	public static void main(String[] args) {
		
		int a = 10, b = 20;
		
		System.out.printf("a : %d, b : %d\n",a,b);
		
		int temp = a;
		a = b;
		b = temp;
		
		System.out.printf("a : %d, b : %d\n",a,b);

	}

}
