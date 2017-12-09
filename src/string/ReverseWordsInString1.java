package string;

public class ReverseWordsInString1 {

	public String reverseWords(String s) {
		StringBuilder reversed = new StringBuilder();
		String[] arr = s.trim().split("\\s+");
		for(int i = arr.length -1;i >= 0; i--){
			if (reversed.length() != 0) {
				reversed.append(' ');
			}
			reversed.append(arr[i]);
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
