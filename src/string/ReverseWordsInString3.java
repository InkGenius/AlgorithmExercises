package string;

public class ReverseWordsInString3 {
	
	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		// j 指向单词结尾的后一位，字符串截取是左闭右开
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			// 如果当前是空格则 j 指向该位置，说明单词不包含该位置
			if (s.charAt(i) == ' ') {
				j = i;
			// 如果当前位置是字符串开始字符，或者该位置前一个位置是空格，则
			// 认为这是一个单词的开始位置，截取该单词添加到逆转字符串
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				// 如果逆转字符串不为空，则需要添加单词间空格
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(i, j));
			}
		}
		return reversed.toString();
	}

	public static void main(String[] args) {
		String s = "the sky is blue";
		String s2 = " 1";
		ReverseWordsInString1 progarm = new ReverseWordsInString1();
		System.out.println(progarm.reverseWords(s));
		System.out.println(progarm.reverseWords(s2));
	}
}
