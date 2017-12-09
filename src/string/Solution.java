package string;

public class Solution {

	public String reverseWords(String s) {
		if (s == null)
			return null;
		char[] a = s.toCharArray();
		int n = a.length;
		
		// 逆转整个字符串
		reverse(a, 0, n - 1);
		for(int i=0;i<a.length;i++){
			System.out.println(" a[" + i +"] = " + a[i] + " ");
		}
		System.out.println(a);
		// 逆转每个单词
		reverseWords(a, n);
		// 清除空格
		return cleanSpaces(a, n);
	}
	private void reverseWords(char[] a, int n) {
		int i = 0, j = 0;
		while (i < n) {
			while (i < j || (i < n && a[i] == ' ')){
				i++; // 跳过空格
			}
			while (j < i || (j < n && a[j] != ' ')){
				j++; // 跳过非空格
			}
			reverse(a, i, j - 1); // 逆转单词
		}
	}
	// 去除前导空格，尾随空格和多空格
	private String cleanSpaces(char[] a, int n) {
		int i = 0, j = 0;
		while (j < n) {
			while (j < n && a[j] == ' ')
				j++; // 跳过空格
			while (j < n && a[j] != ' ')
				a[i++] = a[j++]; // 保留非空格
			while (j < n && a[j] == ' ')
				j++; // 跳过空格
			if (j < n)
				a[i++] = ' '; // 只保留一个空格
		}
		return new String(a).substring(0, i);
	}
	// 逆转 a[]中的 a[i] 到 a[j]
	private void reverse(char[] a, int i, int j) {
		while (i < j) {
			char t = a[i];
			a[i++] = a[j];
			a[j--] = t;
		}
	}

	public static void main(String[] args) {
		String s = "  the sky is blue  ";
//		String s2 = " 1";
		Solution progarm = new Solution();
		System.out.println(progarm.reverseWords(s));
//		System.out.println(progarm.reverseWords(s2));
	}
}
