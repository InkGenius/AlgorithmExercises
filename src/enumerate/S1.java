package enumerate;

import java.util.Scanner;

public class S1 {
	static int dis[] = new int[1005];
	static int n;
	static int m;

	static boolean Validate(int d) {
		int k = m; // 可以移除的石头数目
		int st = 1; // 表示最初的石头
		for (int en = 2; en <= n;) { // 表示结尾的石头
			int disCur = dis[en] - dis[st]; // st与en石头的间距
			while (disCur < d) { // 此时可以移除第 en 个石头
				k--; // 移除当前石头
				en++; // 考虑下一个石头
				if (en > n || k < 0)
					return false; // d比最小距离大
				disCur = dis[en] - dis[st];
			}
			st = en; // 更新起点
			en++;
		}
		return true;
	}

	public static void main(String[] args) {
		int a[] = new int[1005];
		Scanner sc = new Scanner(System.in);
		int max = -1;
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 2; i <= n; i++) { // a[i]表示i-1到i石头的间距，下标从1开始
			a[i] = sc.nextInt();
			dis[i] = a[i] + dis[i - 1]; // sum[i]表示1到i石头的间距
		}
		int lb = 0, ub = 1000 * 1000 +5; // 距离上界
		while (lb < ub) {
			int mid = (lb + ub) / 2;
			if (Validate(mid))
				lb = mid; // 更新下界
			else
				ub = mid - 1; // 更新上界
		}
		System.out.println(lb);
	}
}
