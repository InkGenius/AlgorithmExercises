package divid;

import java.util.Scanner;

public class MarsCurrency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p, n;

		while (sc.hasNext()) {
			int[] f = new int[1000001];
			f[0] = 1;
			p = sc.nextInt();
			n = sc.nextInt();
			for (int i = 1; i <= n / p; i++) {
				f[i] = (f[i - 1] + f[i / p]) % 20080607;
			}
			System.out.println(f[n / p]);
		}
	}

}
