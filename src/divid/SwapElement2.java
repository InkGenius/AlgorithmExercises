package divid;

import java.util.Scanner;

public class SwapElement2 {
	static int a[] = new int[200005];
	static int b[] = new int[200005];
	static long sum;

	static void merge(int low, int mid, int high) {
		int aIndex = low;
		int aEnd = mid;
		int bIndex = mid + 1;
		int bEnd = high;
		int k = low;

		for (int i = low; i <= high; i++)
			b[i] = a[i];

		while (aIndex <= aEnd && bIndex <= bEnd) {
			if (b[aIndex] <= b[bIndex]) {
				a[k++] = b[aIndex++];
			} else {
				a[k++] = b[bIndex++];
				sum += aEnd - aIndex + 1;
			}
		}
		while (aIndex <= aEnd) {
			a[k++] = b[aIndex++];
		}

		while (bIndex <= bEnd) {
			a[k++] = b[bIndex++];
		}

	}

	static void mergeSort(int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			sum = 0;
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			mergeSort(0, n - 1);
			System.out.println(sum);
		}
	}
}
