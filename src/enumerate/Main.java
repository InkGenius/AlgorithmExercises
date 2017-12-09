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
		int sum = 0, count = 0, ans = 1;// sum�����ۼƾ���
		for (int l = 1, r = L, mid = (l + r) >> 1; l <= r; mid = (l + r) >> 1, sum = 0, count = 0)// mid����ǰ����Ĵ�
		{
			for (int i = 1; i < n + 2; i++)
				if ((sum += a[i] - a[i - 1]) <= mid)
					count++;// ���sum�ۼ�����һ�ξ���a[i]-a[i-1]ҲС��mid����count+1����ʾȥ�������ʯͷ
				else
					sum = 0;// �������㣬����һ��ʯͷ��ʼ���㣨������������Ҫȥ������ʯͷ��
			if (count <= m)
				ans = l = mid + 1;// ���Ҫȥ����ʯͷ����m��~~˵��midȡ�Ĳ����󣬼�ʹ����m��Ҳ�������ҵ����ˣ���Ϊmid�Ǽ���ľ��룬�п��ܲ�������������Ϊmid�ľ���
			else
				r = mid - 1;
		}
		System.out.println(ans);// ��������
	}
}
