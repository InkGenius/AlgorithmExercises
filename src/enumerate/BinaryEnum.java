package enumerate;

import java.util.Scanner;

public class BinaryEnum {

	static boolean ok(int val, int n, int m, int[] sum) {
		int k = m; // �����Ƴ���ʯͷ��Ŀ
		int st = 1; // ��ʾ�����ʯͷ
		for (int en = 2; en <= n;) // ��ʾ��β��ʯͷ
		{
			int d = sum[en] - sum[st]; // st��enʯͷ�ļ��
			while (d < val) {
				en++; // ����Ҫ��ȥʯͷ
				k--; // ��ȥһ��ʯͷ
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
			for (int i = 2; i <= n; i++) { // a[i]��ʾi-1��iʯͷ�ļ�࣬�±��1��ʼ
				a[i] = sc.nextInt();
				sum[i] = a[i] + sum[i - 1];
			}
			int l = 0, r = 1000 * 1000 + 5;
			// ���һ������������
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
