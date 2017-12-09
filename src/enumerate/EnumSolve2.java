package enumerate;

import java.util.Scanner;

public class EnumSolve2 {
	
	int search(long value, int n ,int m,int dis[],int min){
		if(value == 0){
			return min;
		}
		
		String binary = Long.toBinaryString(value);
		char[] chars = binary.toCharArray();
		int ones = 0;
		boolean isEnd = false;
		int minDis = Integer.MAX_VALUE;
		int st = 1, en = 2;
		
		for(int j = 0;j < chars.length;j++){
			if(chars[j] == '1'){ // 移除石头
				ones ++;
				if(ones > m){ // 检查1的个数，是否大于m
					isEnd = true;
					break;
				}
				en++; // 移除石头，重新计算石头
			}else{ 
				// 不移除石块
				st = en;
				en++;
			}
			
			if(en > n){
				isEnd = true;
				break;
			}
			int disCur = dis[en] - dis[st];
			if(disCur < minDis){
				minDis = disCur;
			}
		}
		if(!isEnd){
			return Math.max(minDis, search(value - 1 , n , m, dis,min));
 		}else{
			return search(value - 1 , n , m, dis,min);
		}
	}
	
	int search2(int times, int res, int nextMove, int changes,int st , int en, int n ,int m,int dis[]){
		if(times == n - 2){
			return res;
		}
		
		if(changes > m){
			return Integer.MIN_VALUE;
		}
		
		if(nextMove == 1){
			en++;
		}
		
		int disCur = dis[en] - dis[st];
		if(disCur < res){
			res = disCur;
		}
		
		if(nextMove == 0){
			st = en;
			en++;
		}
		return Math.max(search2(times + 1,res, 1 ,changes + 1,st,en,n,m,dis), search2(times + 1,res, 0 ,changes,st,en,n,m,dis));
	}
	
	public static void main(String[] args) {
		int dis[] = new int[1005];
		Scanner sc = new Scanner(System.in);
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
		EnumSolve2 es = new EnumSolve2();
		int bits = n - 2; 
		long total = (int) (Math.pow(2, bits)) - 1;
		int res = es.search2(0,Integer.MAX_VALUE,1,1,1,2,n,m,dis);
		int res2 = es.search2(0,Integer.MAX_VALUE,0,0,1,2,n,m,dis);
		int res3 = es.search(total,n,m,dis,min);
		System.out.println(Math.max(res, res2));
		System.out.println(res3);
	}
}
