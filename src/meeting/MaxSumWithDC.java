package meeting;

public class MaxSumWithDC {

	public static int maxSubArray(int[] A) {
		return maxSubArrayHelper(A, 0, A.length - 1);
	}

	private static int maxSubArrayHelper(int[] A, int L, int R) {
		if (L > R)
			return Integer.MIN_VALUE;
		
		int M = (L + R) / 2;
		int leftAns = maxSubArrayHelper(A, L, M - 1);
		int rightAns = maxSubArrayHelper(A, M + 1, R);
		
		int lMaxSum = 0;
		int sum = 0;
		for (int i = M - 1; i >= L; i--) {
			sum += A[i];
			lMaxSum = Math.max(sum, lMaxSum);
		}
		int rMaxSum = 0;
		sum = 0;
		for (int i = M + 1; i <= R; i++) {
			sum += A[i];
			rMaxSum = Math.max(sum, rMaxSum);
		}
		return Math.max(lMaxSum + A[M] + rMaxSum, Math.max(leftAns, rightAns));
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(a));
	}
}
