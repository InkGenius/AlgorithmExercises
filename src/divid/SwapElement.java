package divid;

import java.util.Scanner;

public class SwapElement {

	public static int bableSort(int[] a, int n) {
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				if (a[j - 1] > a[j]) {
					int temp;
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
					res ++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNext()) {
			n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			System.out.println();
			System.out.println(bableSort(a,n));
		}
	}

}
