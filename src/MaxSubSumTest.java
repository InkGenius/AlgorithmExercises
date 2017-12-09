import java.util.Random;

public class MaxSubSumTest {
	// O(n^3)
	static int MaxSubSequenceOne(int A[]) {
		long startTime=System.currentTimeMillis();   
		int maximum = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += A[k];
				}
				if (sum > maximum)
					maximum = sum;
			}
		}
        long endTime=System.currentTimeMillis(); //获取结束时间  
        System.out.println("O(n^3)程序运行时间： "+(endTime - startTime)+"ms ,结果为：" + maximum);   
		return maximum;
	}
    // O(n^2)
	static int MaxSubSequenceTwo(int A[]) {
		long startTime=System.currentTimeMillis(); 
		int maximum = 0;
		for (int i = 0; i < A.length; i++) {
			int sum = 0;
			for (int j = i; j < A.length; j++) {
				sum += A[j];
				if (sum > maximum)
					maximum = sum;
			}
		}
		long endTime=System.currentTimeMillis(); //获取结束时间  
        System.out.println("O(n^2)程序运行时间： "+(endTime - startTime)+"ms ,结果为：" + maximum);   
		return maximum;
	}
	// O(n * log2N)
	static int MaxSubSequenceThree(int[] array){
		long startTime=System.currentTimeMillis(); 
		int maximum = MaxSubSequenceRecursive(array,0,array.length - 1);
		long endTime=System.currentTimeMillis(); //获取结束时间  
        System.out.println("O(n * log2N)程序运行时间： "+(endTime - startTime)+"ms ,结果为：" + maximum);   
		return maximum;
	}
	
	static int MaxSubSequenceRecursive(int[] array, int left, int right) {
		// 递归出口
		if (left == right) {
			if (array[left] > 0)
				return array[left];
			else
				return 0;
		}

		// 递归求出左半部分和右半部分的最大子序列和
		int center = (left + right) / 2;
		int maxLeftSum = MaxSubSequenceRecursive(array, left, center);
		int maxRightSum = MaxSubSequenceRecursive(array, center + 1, right);
		
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

	// O(n)
	static int MaxSubSequenceFour(int A[]) {
		long startTime=System.currentTimeMillis(); 
		int maximum = 0;
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (sum < 0) {
				sum = 0;
			}else if(sum > maximum){
				maximum = sum;
			}
		}
		long endTime=System.currentTimeMillis(); //获取结束时间  
        System.out.println("O(n)程序运行时间： "+(endTime - startTime)+"ms ,结果为：" + maximum);   
		return maximum;
	}
	
	public static void main(String[] args) {
		// 测试 数据量 100
		int[] arr100 = new int[100];
		Random rand = new Random();
		for(int i = 0;i< 100;i++){
		    arr100[i] = rand.nextInt((100 - -50) + 1) + -50;
		}
		// 测试 数据量 10000
		int[] arr10000 = new int[10000];
		for(int i = 0;i< 10000;i++){
		    arr10000[i] = rand.nextInt((100 - -50) + 1) + -50;
		}
		// 测试 数据量 100000
		int[] arr100000 = new int[100000];
		for(int i = 0;i< 10000;i++){
		    arr100000[i] = rand.nextInt((100 - -50) + 1) + -50;
		}
		// 测试 数据量 1000000
		int[] arr1000000 = new int[1000000];
		for(int i = 0;i< 1000000;i++){
		    arr1000000[i] = rand.nextInt((100 - -50) + 1) + -50;
		}
		System.out.println("测试数据量为100：");
		MaxSubSequenceOne(arr100);
		MaxSubSequenceTwo(arr100);
		MaxSubSequenceThree(arr100);
		MaxSubSequenceFour(arr100);
		System.out.println("测试数据量为10000：");
		MaxSubSequenceOne(arr10000);
		MaxSubSequenceTwo(arr10000);
		MaxSubSequenceThree(arr10000);
		MaxSubSequenceFour(arr10000);
		System.out.println("测试数据量为100000：");
		MaxSubSequenceOne(arr100000);
		MaxSubSequenceTwo(arr100000);
		MaxSubSequenceThree(arr100000);
		MaxSubSequenceFour(arr100000);
		System.out.println("测试数据量为1000000：");
		MaxSubSequenceOne(arr1000000);
		MaxSubSequenceTwo(arr1000000);
		MaxSubSequenceThree(arr1000000);
		MaxSubSequenceFour(arr1000000);
	}

}
