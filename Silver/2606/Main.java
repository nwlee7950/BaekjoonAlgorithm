import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] adj;
	static boolean[] visit;
	static int count = 0;
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	adj = new int[N+1][N+1];
    	visit = new boolean[N+1];
    	
    	for(int i=0; i<M; i++) {
    		int from = sc.nextInt();
    		int to = sc.nextInt();
    		adj[from][to] = adj[to][from] = 1;
    	}
    	bfs(1);
    	System.out.println(count);
    }

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visit[start] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
				for(int i=1; i<=N; i++) {
					if(adj[current][i] != 0 && visit[i] == false) {
						q.add(i);
						visit[i] = true;
						count++;
					}
				}
		}
	}

}