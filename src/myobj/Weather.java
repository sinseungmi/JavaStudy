package myobj;

public class Weather {
	public int cloud ;
	public String skyColor;
	boolean rain;
	
	public Weather(){
		this.skyColor = "하늘색";
	}
	
	public Weather(int cloudNum) {
		this.cloud = cloud;
	}
	
	
	public boolean fall(int cloud) {
		if (cloud > 100) {
			rain = true;
		}
		return rain;
	}
	
	public void skyCondition(String color) {
		skyColor = color;
		
		System.out.println("하늘 색깔은 " + skyColor + "색 입니다");
	}

}
