package myinterface;

import myobj.remote.AirconditionRemocon;
import myobj.remote.TelevisionRemocon;


//인터페이스를 통해 결합도가 낮은 코드를 작성할 수 있다 (결합도란? 다른 모듈에 의존하는 정도)
public class TestRemocon {
	
	public static void main(String[] args) {
		test(new AirconditionRemocon());
		test(new TelevisionRemocon());
	}
	
	public static void test (Remocon remocon) {
		remocon.power();
		remocon.up(1);
		remocon.down(1);
		remocon.change();
	}

}
