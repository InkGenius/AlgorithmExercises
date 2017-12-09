package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SummationCombination {
	static int n, sum, dep;
	static int[] a;
	static int[] s;
	static int[] remain;
	static boolean isFindAtLeastOne = false;
	static ArrayList<String> list = new ArrayList<String>();
	static void dfs(int pos, int total) {
		if (total > sum){
			return;
		}
		if (pos == n) {
			if (sum == total) {
				isFindAtLeastOne = true;
				String res = "";
				for (int i = 0; i < dep; i++) {
					res += s[i] + " ";
				}
				// 去重
				if(!list.contains(res)){
					list.add(res);
					System.out.println(res);
				}
			}
			return;
		}else{
			if(total + remain[pos] < sum){
				return;
			}
		}
		s[dep++] = a[pos];
		dfs(pos + 1, total + a[pos]);
		dep--;
		dfs(pos + 1, total);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			sum = scanner.nextInt();
			
			a = new int[n];
			s = new int[n];
			remain = new int[n];
			
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			Arrays.sort(a);
			remain[n - 1] = a[n - 1];
			for (int i = n - 2; i >= 0; i--){
				remain[i] = remain[i + 1] + a[i];
			}
			dep = 0;
			isFindAtLeastOne = false;
			dfs(0, 0);
			if (!isFindAtLeastOne) {
				System.out.println("-1");
			}
		}
	}
}
