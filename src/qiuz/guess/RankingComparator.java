package qiuz.guess;

import java.util.Comparator;

public class RankingComparator implements Comparator<GuessNumPlay>{

	@Override
	public int compare(GuessNumPlay o1, GuessNumPlay o2) {
		if(o1.getTheRight < o2.getTheRight) {
			return -1;
		}else if (o1.getTheRight > o2.getTheRight) {
			return 1;
		}else {
			if(o1.timeTaken < o2.timeTaken) {
				return -1;
			}else if(o1.timeTaken > o2.timeTaken) {
				return 1;
			}else {
				return 0;
			}
					
		}
	}

}
