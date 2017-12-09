package backtracking;

import java.util.Scanner;

public class LoadingProblem {
	
	private static int n, c, ret;
	private static int[] weights = new int[31];
	private static int[] remain = new int[31];

	public static void dfs(int step, int max) {
		if (step == n) {
			ret = Math.max(ret, max);
		} else {
			if (max + remain[step] <= ret)
				return;
			if (max + weights[step] <= c)
				dfs(step + 1, max + weights[step]);
			dfs(step + 1, max);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			c = scanner.nextInt();

			for (int i = 0; i < n; i++) {
				weights[i] = scanner.nextInt();
			}
			remain[n] = 0;
			for (int i = n - 1; i >= 0; i--)
				remain[i] = remain[i + 1] + weights[i];
			ret = 0;
			dfs(0, 0);
			System.out.println(ret);
		}
	}
}
