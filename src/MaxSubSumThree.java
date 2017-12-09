import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// O(n * log2N)
public class MaxSubSumThree {

	 static int MaxSubSequence(int[] array, int left, int right) {
		// 递归出口
		if (left == right) {
			if (array[left] > 0)
				return array[left];
			else
				return 0;
		}

		// 递归求出左半部分和右半部分的最大子序列和
		int center = (left + right) / 2;
		int maxLeftSum = MaxSubSequence(array, left, center);
		int maxRightSum = MaxSubSequence(array, center + 1, right);
		
		// 求中间部分最大子序列和
		int maxLeftBorderSum = 0;
		int leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += array[i];
			if (leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}

		int maxRightBorderSum = 0;
		int rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++) {
			rightBorderSum += array[i];
			if (rightBorderSum > maxRightBorderSum) {
				maxRightBorderSum = rightBorderSum;
			}
		}
		int maxLeftRightSum = maxLeftBorderSum + maxRightBorderSum;
		int maxSubSum = 0;
		maxSubSum = maxLeftSum > maxRightSum ? maxLeftSum : maxRightSum;
		maxSubSum = maxSubSum > maxLeftRightSum ? maxSubSum : maxLeftRightSum;
		return maxSubSum;
	}

	public static void test(String pathname, int num) throws IOException{
		File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
        BufferedReader br = new BufferedReader(reader);
        String ans = "";  
        String line = "";
        while ((line = br.readLine()) != null) {  
            ans += line;
        }
        String[] strs = ans.split("\\s+");
        int intData[] = new int[num+1];
        for(int i=0;i < strs.length;i++){
        	intData[i] = Integer.parseInt(strs[i]);
        }
        long startTime=System.currentTimeMillis();   //获取开始时间  
        int res = MaxSubSequence(intData,0,num);
        long endTime=System.currentTimeMillis(); //获取结束时间  
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");   
		System.out.println(res);
	}
	public static void main(String[] args) throws IOException {
		int a[] = { 1, -2, 3, 5, -3, 2 };
		int b[] = { 0, -2, 3, 5, -1, 2 };
		int c[] = { -9, -2, -3, -5, -3 };
		int res = MaxSubSequence(a, 0,5);
		System.out.println(res);
		res = MaxSubSequence(b, 0,5);
		System.out.println(res);
		res = MaxSubSequence(c, 0,4);
		System.out.println(res);
//		
//		String pathname = "testcase100.txt";
//		test(pathname,100);
		String pathname = "testcase1000000.txt";
		test(pathname,1000000);
	}
}
