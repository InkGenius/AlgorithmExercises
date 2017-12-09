package meeting;

public class MaxSumDP {

	public static int maxSubArray(int[] A) {
		int maxEndingHere = A[0], maxSoFar = A[0];
		for (int i = 1; i < A.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
	
	
	public static void main(String[] args) {
		int[] a = { 2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(a));
	}
}
