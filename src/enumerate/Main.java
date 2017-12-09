package enumerate;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int L = scan.nextInt(), n = scan.nextInt(), m = scan.nextInt();
		int a[] = new int[n + 2];
		a[0] = 0;
		a[n + 1] = L;
		for (int i = 1; i <= n; i++)
			a[i] = scan.nextInt();
		Arrays.sort(a);
		int sum = 0, count = 0, ans = 1;// sum用来累计距离
		for (int l = 1, r = L, mid = (l + r) >> 1; l <= r; mid = (l + r) >> 1, sum = 0, count = 0)// mid代表当前假设的答案
		{
			for (int i = 1; i < n + 2; i++)
				if ((sum += a[i] - a[i - 1]) <= mid)
					count++;// 如果sum累加了下一段距离a[i]-a[i-1]也小于mid，就count+1，表示去掉靠后的石头
				else
					sum = 0;// 否则清零，从下一个石头开始计算（这计算的是至少要去掉几个石头）
			if (count <= m)
				ans = l = mid + 1;// 如果要去掉的石头少于m个~~说明mid取的不够大，即使等于m个也不代表找到答案了，因为mid是假设的距离，有可能不存在这样长度为mid的距离
			else
				r = mid - 1;
		}
		System.out.println(ans);// 区间的左端
	}
}
