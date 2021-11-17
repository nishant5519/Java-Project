package sorting;

public class SortColor {

	public static void main(String[] args) {
		int[] array = { 2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2,
				1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0,
				1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2,
				1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2 };
		int[] result = sortColors(array);
		for (int r : result) {
			//System.out.print(r + ",");
		}
		System.out.println("apple".compareTo("banana"));

	}

	public static int[] sortColors(int[] A) {
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;

		for (int a : A) {
			if (a == 0)
				count0++;
			if (a == 1)
				count1++;
			if (a == 0)
				count2++;
		}

		for (int i = 0; i < A.length; i++) {
			if (count0 > 0) {
				A[i] = 0;
				count0--;
			} else if (count1 > 0) {
				A[i] = 1;
				count1--;
			} else if (count2 > 0) {
				A[i] = 2;
				count2--;
			}
		}

		return A;
	}

}
