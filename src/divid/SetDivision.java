package divid;

import java.util.Scanner;

public class SetDivision {

	static long calculateSet(int n, int m) {
		if (m == 0 || m > n)
			return 0;
		else if (n == m || m == 1 || n == 1)
			return 1;
		else
			return calculateSet(n - 1, m - 1) + m * calculateSet(n - 1, m);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNext()) {
			int result = 0;
			n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				result += calculateSet(n, i);
			}
			System.out.println(result);
		}
	}
}
