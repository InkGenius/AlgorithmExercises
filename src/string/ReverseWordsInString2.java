package string;

public class ReverseWordsInString2 {

	public void reverseWords(char[] s) {
		// 逆转整个字符串
		reverse(s, 0, s.length);
		// i 指向单词的开始，j指向单词结束的下一个字符
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				// 逆转单个单词
				reverse(s, i, j);
				i = j + 1;
			}
		}
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
		String s = "the sky is blue";
		String s2 = " 1";
		ReverseWordsInString1 progarm = new ReverseWordsInString1();
		System.out.println(progarm.reverseWords(s));
		System.out.println(progarm.reverseWords(s2));
	}
}
