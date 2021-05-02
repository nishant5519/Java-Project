package recursion;

/*Given a positive integer N, representing number of people in the room. Person 1 has 10 FINGERS. 
Person 2 has 11 FINGERS.Person 3 has 10, Person 4 has 11 fingers and this pattern goes on.
Write a recursive function that returns total number of fingers in the room, if N is given as input. */

public class TotalFingersInTheRoom {

	public static void main(String[] args) {
		System.out.println(getTotalFingersCount(2));
	}

	static int getTotalFingersCount(int N) {
		/*
		 * Initial approach was wrong if (N == 0) return 0;
		 * 
		 * if (N % 2 == 1) return 10;
		 * 
		 * if (N % 2 == 0) return 11; return 10 + getTotalFingersCount(N - 1);
		 */

		if (N == 0)
			return 0;

		if (N % 2 == 1)
			return 10 + getTotalFingersCount(N - 1);
		else
			return 11 + getTotalFingersCount(N - 1);
	}

}
