package divid;

import java.util.Scanner;

public class BigK {
	static int a[] = new int[1000005];
	
	public static int partition(int[] a,int start,int end){
		int privok = a[start];
		
		int i = start;
		int j = end;
		while(i < j){
			while(j > i && a[j] >= privok){
				j--;
			}
			swap(a,j,i);
			while(i < j && a[i] <= privok){
				i++;
			}
			swap(a,j,i);
		}
		return i;
	}
	
	public static void swap(int[] a,int i,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static int qSort(int[] a,int low,int high,int k){
		if(low < high){
			int privok = partition(a,low,high);
			if (privok == k)
				return a[privok];
			else if (privok > k)
				return qSort(a, low, privok - 1, k);
			else
				return qSort(a, privok + 1, high, k);
		}else{
			return a[low];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, k;
		while (sc.hasNext()) {
			n = sc.nextInt();
			k = sc.nextInt();
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			System.out.println(qSort(a, 0, n - 1, n - k));
		}
	}
}
