package myinterface;

import myobj.restaurant.KoreanRestaurant;
import myobj.restaurant.SnackBar;

public class RestaurantTest {
	
	static void test(Restaurant restaurant) {
		restaurant.calculate();
		restaurant.order();
		restaurant.servingCheck();
		restaurant.seatGuide();
	}

	public static void main(String[] args) {
		
		test(new KoreanRestaurant());
		test(new SnackBar());

	}

}
