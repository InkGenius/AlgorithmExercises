package backtracking;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int f;
	int sum;
	int step;

	Node(int step, int sum, int f) {
		this.f = f;
		this.sum = sum;
		this.step = step;
	}
}

public class LoadingProblemBFS {
	private static int n, c, ret;
	private static int[] weights = new int[31];
	private static int[] remain = new int[31];

	static void bfs(int step) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, remain[0]));
		int sum;
		while (!q.isEmpty()) {
			Node current = q.poll();
			sum = current.sum;
			step = current.step;
			if (step == n)
				break;
			if (sum + weights[step] <= c) {
				ret = Math.max(ret, sum + weights[step]);
				q.offer(new Node(step + 1, sum + weights[step], sum + remain[step]));
			}
			q.offer(new Node(step + 1, sum, sum + remain[step] - weights[step]));
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			n = scanner.nextInt();
			c = scanner.nextInt();

			for (int i = 0; i < n; i++) {
				weights[i] = scanner.nextInt();
			}
			remain[n] = 0;
			for (int i = n - 1; i >= 0; i--)
				remain[i] = remain[i + 1] + weights[i];
			ret = 0;
			bfs(0);
			System.out.println(ret);
		}
	}

}
