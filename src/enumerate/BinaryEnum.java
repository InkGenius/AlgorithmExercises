package enumerate;

import java.util.Scanner;

public class BinaryEnum {

	static boolean ok(int val, int n, int m, int[] sum) {
		int k = m; // 可以移除的石头数目
		int st = 1; // 表示最初的石头
		for (int en = 2; en <= n;) // 表示结尾的石头
		{
			int d = sum[en] - sum[st]; // st与en石头的间距
			while (d < val) {
				en++; // 必须要移去石头
				k--; // 移去一个石头
				if (en > n || k < 0)
					return false;
				d = sum[en] - sum[st];
			}
			st = en;
			en++;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[] = new int[1005];
		int sum[] = new int[1005];
		int n, m;
		while(sc.hasNext()){  
			n = sc.nextInt();
			m = sc.nextInt();
			for (int i = 2; i <= n; i++) { // a[i]表示i-1到i石头的间距，下标从1开始
				a[i] = sc.nextInt();
				sum[i] = a[i] + sum[i - 1];
			}
			int l = 0, r = 1000 * 1000 + 5;
			// 最后一个满足条件的
			while (l < r) {
				int mid = (l + r + 1) / 2;
				if (ok(mid, n, m, sum))
					l = mid;
				else
					r = mid - 1;
			}
			System.out.println(l);
        }  
	}
}
