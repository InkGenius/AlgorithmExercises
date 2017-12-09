import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

// O(n^2)
public class MaxSubSumTwo {

	static int MaxSubSequence(int A[], int N) {
		
		int maximum = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = i; j < N; j++) {
				sum += A[j];
				if (sum > maximum)
					maximum = sum;
			}
		}
		return maximum;
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
        int res = MaxSubSequence(intData,num);
        long endTime=System.currentTimeMillis(); //获取结束时间  
        System.out.println("程序运行时间： "+(endTime - startTime)+"ms");   
		System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		int a[] = {1,-2,3,5,-3,2};
		int b[] = {0,-2,3,5,-1,2};
		int c[] = {-9,-2,-3,-5,-3};
		int res = MaxSubSequence(a,6);
		System.out.println(res);
		res = MaxSubSequence(b,6);
		System.out.println(res);
		res = MaxSubSequence(c,5);
		System.out.println(res);
		
//		String pathname = "testcase100.txt";
//		test(pathname,100);
		String pathname = "testcase1000000.txt";
		test(pathname,1000000);
	}

}
