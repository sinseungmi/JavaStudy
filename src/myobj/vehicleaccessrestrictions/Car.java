package myobj.vehicleaccessrestrictions;

public class Car {
	
	static String Excludedvehicles;
	static int vehicleNumber;

	public Car(int vehicleNumber, String Excludedvehicles) {
		this.vehicleNumber = vehicleNumber;
		this.Excludedvehicles = Excludedvehicles;
		
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public String getExcludedvehicles() {
		return Excludedvehicles;
	}

}
