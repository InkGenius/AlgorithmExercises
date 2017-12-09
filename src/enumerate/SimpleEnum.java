package enumerate;

import java.util.Scanner;

public class SimpleEnum {
	
	int search(int times, int res, int nextMove, int changes,int st , int en, int n ,int m,int dis[]){
		if(times == n - 2){
			return res;
		}
		
		if(changes > m || en > n){
			return Integer.MIN_VALUE;
		}
		
		if(nextMove == 1){
			en++;
		}else{
			st = en;
			en++;
		}
		
		int disCur = dis[en] - dis[st];
		if(disCur < res){
			res = disCur;
		}
		return Math.max(search(times + 1,res, 1 ,changes + 1,st,en,n,m,dis), search(times + 1,res, 0 ,changes,st,en,n,m,dis));
	}
	
	public static void main(String[] args) {
		int dis[] = new int[1005];
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){  
			int n = sc.nextInt();
			int m = sc.nextInt();
			int min = Integer.MAX_VALUE;
			for (int i = 2; i <= n; i++) { 
				int val = sc.nextInt();
				if(val < min){
					min = val;
				}
				dis[i] = val + dis[i - 1]; // sum[i]表示1到i石头的间距
			}
			SimpleEnum es = new SimpleEnum();
			int res = es.search(1,Integer.MAX_VALUE,1,1,1,2,n,m,dis);
			int res2 = es.search(1,Integer.MAX_VALUE,0,0,1,2,n,m,dis);
			System.out.println(Math.max(res, res2));
		}
	}
}
