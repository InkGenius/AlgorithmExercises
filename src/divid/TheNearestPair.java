package divid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Point {
	double x, y;
}

class SortByX implements Comparator<Point> {
	public int compare(Point o1, Point o2) {
		return (int) (o1.x - o2.x);
	}
}

class SortByY implements Comparator<Point> {
	public int compare(Point o1, Point o2) {
		return (int) (o1.y - o2.y);
	}
}

public class TheNearestPair {
	static Point[] p = new Point[100005];
	static int[] a = new int[100005]; // 保存筛选的坐标点的索引

	static double dis(Point a, Point b) {
		return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}

	static double closest(int low, int high) {
		if (low + 1 == high)
			return dis(p[low], p[high]);
		if (low + 2 == high)
			return Math.min(dis(p[low], p[high]), Math.min(dis(p[low], p[low + 1]), dis(p[low + 1], p[high])));
		int mid = (low + high) >> 1;
		double ans = Math.min(closest(low, mid), closest(mid + 1, high));
		int i, j, cnt = 0;
		for (i = low; i <= high; ++i)
		{
			if (p[i].x >= p[mid].x - ans && p[i].x <= p[mid].x + ans)
				a[cnt++] = i;
		}
		Arrays.sort(a, 0, cnt);
		for (i = 0; i < cnt; ++i) {
			for (j = i + 1; j < cnt; ++j) {
				if (p[a[j]].y - p[a[i]].y >= ans)
					break;
				ans = Math.min(ans, dis(p[a[i]], p[a[j]]));
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNext()) {
			n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = new Point();
				p[i].x = sc.nextInt();
				p[i].y = sc.nextInt();
			}
			Arrays.sort(p, 0,n, new SortByY());
			double d = closest(0, n - 1);
			String s=String.format("%.2f",d);
			System.out.println(s);
		}
	}
}
