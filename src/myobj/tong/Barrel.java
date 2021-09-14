package myobj.tong;

public class Barrel {
	boolean[] forked;
	int size;
	int fireBtn;
	int com;

	boolean game_over;

	public Barrel(int size) {
		this.size = size;       //pirateGame에서 생성했던 인스턴스  
		this.forked = new boolean[size];
		this.fireBtn = (int) (Math.random() * size);
		this.game_over = false;
	}

	public boolean checkGameOver() {
		return game_over;
	}

	public boolean fork(int slot) {
		if (forked[slot]) {
			System.out.println("이미 찔렀던 곳 입니다. 다른 곳을 골라주세요");
			return false;
		}
		if (slot == fireBtn) {
			game_over = true;
		}
		forked[slot] = true;
		return true;
	}
	
	public int comRan() {
		return com = (int)(Math.random() * size);		
	}

}











