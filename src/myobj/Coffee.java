package myobj;

public class Coffee {

	private static class CoffeeCode {  //내부 클래스는 외부 클래스의 멤버와 같이 간주됨.외부 클래스의 멤버변수와 같은 성질을 갖는다
		int code;
		String name;

		private CoffeeCode(int code, String name) {
			this.code = code;
			this.name = name;
		}

	}

	private static class OriginCode {
		int code;
		String name;

		private OriginCode(int code, String name) {
			this.code = code;
			this.name = name;
		}

	}

	// 각 인스턴스가 다른 값을 가지지않도록!
//	private static String[] origin_names = { "콜롬비아", "브라질", "에티오피아", "케냐", "인도" };
//	private static String[] coffee_names = {"아메리카노","카페라떼","카페모카","카라멜 마끼야또"};

	public final static CoffeeCode AMERICANO = new CoffeeCode(0, "아메리카노");
	public final static CoffeeCode CAFE_LATTE = new CoffeeCode(1, "카페라떼");
	public final static CoffeeCode CAFE_MOCHA = new CoffeeCode(2, "카페모카");

	public final static OriginCode Colombia = new OriginCode(0, "콜롬비아");
	public final static OriginCode Brazil = new OriginCode(1, "브라질");
	public final static OriginCode Ethiopia = new OriginCode(2, "에티오피아");

	CoffeeCode coffee;
	int price;
	int caffeine;
	OriginCode origin;

	boolean hot;

	public Coffee(CoffeeCode coffee, int price, int caffeine, OriginCode origin) {
		this.coffee = coffee;
		this.price = price;
		this.caffeine = caffeine;
		this.origin = origin;
		this.hot = true;

	}

	public String getCoffeeName() {
		return coffee.name;
	}

	public int getCoffeeCode() {
		return coffee.code;
	}

	public String getOriginNameName() {
		return null;
	}

	public static void main(String[] args) {

		//coffee.origin_names = new String[] { "한국", "중국", "일본", "러시아" };
		Coffee coffee = new Coffee(Coffee.AMERICANO, 1500, 10, Coffee.Brazil);
		Coffee coffee1 = new Coffee(Coffee.CAFE_LATTE, 1800, 15, Coffee.Ethiopia);
		Coffee coffee2 = new Coffee(Coffee.CAFE_MOCHA, 2500, 20, Coffee.Colombia);
		Coffee coffee3 = new Coffee(Coffee.CAFE_MOCHA, 3500, 25, Coffee.Brazil);
	}

}

//outer class에는 protected와 private을 사용할 수 없다
//만약 TodayCoffee를 인스턴스화하고 싶다면 TodayCoffee를 따로 파일을 하나만들어서 public class로 만들어야한다
//class TodayCoffee는 public class의 보조 클래스 같은 개념이라서 얘를 인스턴스 시킬 순 없다
class TodayCoffee{
	
	//inner class에는 모든 접근 제어자를 사용할 수 있다
	protected class InnerClass{
		
	}
	
	protected class InnerClass2{
		
	}
	
}



