package backtracking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ChessNode{
	int x,y,g;
	public ChessNode(int x,int y,int g){
		this.x = x;
		this.y = y;
		this.g= g; 
	}
}
public class KnightRiding {
	
	static boolean[][] visited;
	// 下一步可能的坐标点，有8中选择
	static int moveX[] = {1,1,-1,-1,2,2,-2,-2};
	static int moveY[] = {2,-2,2,-2,1,-1,1,-1};
	
	static int bfs(int dX,int dY){
		visited= new boolean[1005][1005];
		Queue<ChessNode> queue = new LinkedList<>();
		queue.add(new ChessNode(0,0,0));
		int min = Integer.MAX_VALUE;
		while(!queue.isEmpty()){
			ChessNode node = queue.poll();
			if(visited[node.x][node.y])
				continue;
			visited[node.x][node.y] = true;
			 for (int i=0; i < 8; i++){
		            int nextX = node.x + moveX[i];
		            int nextY = node.y + moveY[i];
		            if(nextX == dX && nextY == dY){
		            	min = min > node.g + 1 ? node.g + 1:min;
		            	continue;
		            }
		            if((nextX >= 0 && nextY>=0 && nextX <= 500 && nextY <= 500) && (!visited[nextX][nextY])){
		                queue.add(new ChessNode(nextX,nextY,node.g + 1));
		            }
		        }
		}
		if(min == Integer.MAX_VALUE){
			return -1;
		}
		return min;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x,y;
		
		while (scanner.hasNext()) {
			x = scanner.nextInt();
			y = scanner.nextInt();
	        System.out.println(bfs(x,y));
		}
	}
}
