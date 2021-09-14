package qiuz.guess;

import java.util.Comparator;

public class GuessNumPlay{
	
	String name;
	long timeTaken;
	int getTheRight; 
	
	public GuessNumPlay(String name, int getTheRight, long timeTaken) {
		this.name = name;
		this.getTheRight = getTheRight;
		this.timeTaken = timeTaken;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(long timeTaken) {
		this.timeTaken = timeTaken;
	}

	public int getGetTheRight() {
		return getTheRight;
	}

	public void setGetTheRight(int getTheRight) {
		this.getTheRight = getTheRight;
	}

	

}
