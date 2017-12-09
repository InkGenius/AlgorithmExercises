package enumerate;

import java.util.Scanner;

public class S1 {
	static int dis[] = new int[1005];
	static int n;
	static int m;

	static boolean Validate(int d) {
		int k = m; // �����Ƴ���ʯͷ��Ŀ
		int st = 1; // ��ʾ�����ʯͷ
		for (int en = 2; en <= n;) { // ��ʾ��β��ʯͷ
			int disCur = dis[en] - dis[st]; // st��enʯͷ�ļ��
			while (disCur < d) { // ��ʱ�����Ƴ��� en ��ʯͷ
				k--; // �Ƴ���ǰʯͷ
				en++; // ������һ��ʯͷ
				if (en > n || k < 0)
					return false; // d����С�����
				disCur = dis[en] - dis[st];
			}
			st = en; // �������
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
		for (int i = 2; i <= n; i++) { // a[i]��ʾi-1��iʯͷ�ļ�࣬�±��1��ʼ
			a[i] = sc.nextInt();
			dis[i] = a[i] + dis[i - 1]; // sum[i]��ʾ1��iʯͷ�ļ��
		}
		int lb = 0, ub = 1000 * 1000 +5; // �����Ͻ�
		while (lb < ub) {
			int mid = (lb + ub) / 2;
			if (Validate(mid))
				lb = mid; // �����½�
			else
				ub = mid - 1; // �����Ͻ�
		}
		System.out.println(lb);
	}
}
