package meeting;

public class MaxSum2 {

	static int maxSum(int[] a, int n) {
		int maximum = Integer.MIN_VALUE;
		int sum;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				if (sum > maximum) {
					maximum = sum;
				}
			}
		}
		return maximum;
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSum(a, a.length));
	}
}
