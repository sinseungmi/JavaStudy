import java.util.Scanner;

public class C06_Polymorphism {
	
	/*
	 * 객체의 다형성
	 * 
	 * - 객체는 다향한 형태를 지닐 수 있다
	 * - 사과는 사과이기도 하고 과일이기도 하다
	 * - 과일은 과일이지만 사과는 아니다
	 * 
	 * 
	 * # 자식 클래스는 부모 클래스가 될 수 있다(업캐스팅)
	 * - 자식 클래스 타입이 부모 클래스타입이 되는 것을 업 캐스팅이라고한다
	 * - 업캐스팅된 객체는 자식 클래스에만 존재하던 것들을 모두 잊어버린다
	 * - 오버라이드된 메서드는 자식 클래스에서 구현한 내용이 실행된다
	 * 
	 * 
	 * # 부모 클래스는 자식 클래스가 될 수 없다(다운 캐스팅)
	 * - 하지만 예외적으로 업캐스팅되었던 인스턴스는 다시 원래 타입으로의 다운 캐스팅이 가능하다
	 * 
	 * 
	 * $ 부모에 있는 메서드는 상속 받은 자식이 무조건 쓸 수 있다 
	 * 
	 * */


	 public static void main(String[] args) {
         new Food(new PigMeat(), new Vege(), new Balsamic());
         
         Scanner sc = new Scanner(System.in);
         StringBuilder sb = new StringBuilder();
         String str1 = new String();
         
         MainMaterial main_mat = new MainMaterial();                                
         MainMaterial main_mat2 = new Tuna();
         //유지보수는 버전 업그레이드를 위해서 먼미래를 위해서,나중을 편하게 하기 위해 대비하는 것
         //만약에 new Tuna 변수 타입이 Mainmaterial이 아니라 Tuna였다면 나중에 new Tuna를 
         //다른 버전으로 바꿀 때 만들어 놓았던 메서드 등을 다 고쳐야한다.(매개변수 같은 것들을)
         
                                         
         doSomethingWithMainMaterial(new MainMaterial());
         doSomethingWithMainMaterial(new Meat());
         doSomethingWithMainMaterial(new Fish());
         doSomethingWithMainMaterial(new PigMeat());
         
         new Car(new Tire());
         new Car(new TireVer1());
         new Car(new TireVer2());
         
         Police police = new Police();
         police.sayHi();
         police.arrest("김강도");
         
         //person으로 업캐스팅 된 police는 체포할 수 없다
         Person person = police;
         Person person2 = new Person("전우치", 20, 30);
         
         
         //person.arrest();
         person.sayHi();
         
         //다운 캐스팅을 활용해 원래 기능 다시 사용하기 
         
         //원래 경찰이었던 인스턴스는 다운 캐스팅이 가능
         ((Police)person).arrest("김소매"); 
         
         //경찰이 아니었던 인스턴스는 다운 캐스팅이 불가능
         //((Police)person2).arrest("김도적");
         
	 }
 
 public static void doSomethingWithMainMaterial(MainMaterial mat) {
         
 }
}

class Car {
 Tire tire;
 
 public Car(Tire tire) {
         this.tire = tire;
 }
}

class Tire {}
class Tire2 {}

class TireVer1 extends Tire {}
class TireVer2 extends Tire {}

class Food {

 MainMaterial mainMat;
 SubMaterial subMat;
 Sauce sauce;
 
 public Food(MainMaterial mainMat, SubMaterial subMat, Sauce sauce) {
         this.mainMat = mainMat;
         this.subMat = subMat;
         this.sauce = sauce;
 }
 
}

class PorkCutlet extends Food{
 
 public PorkCutlet(PigMeat pig, SubMaterial subMat, Sauce sauce) {
         super(pig,subMat,sauce);
 }
 
}

//제일 높은 부모 클래스 (주재료, 부재료, 소스)
class MainMaterial {}
class SubMaterial {}
class Sauce {}

//주재료를 상속받은 클래스들 
class Fish extends MainMaterial {}
class Meat extends MainMaterial {}

//주재료를 상속받은 클래스를 상속받은 클래스
class PigMeat extends Meat {}
class Tuna extends Fish {}

//부재료를 상속받은 클래스들
class Vege extends SubMaterial {}
class Fruit extends SubMaterial {}

//소스를 상속받은 클래스들
class Salsa extends Sauce {}
class Balsamic extends Sauce {}
































