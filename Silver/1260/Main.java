import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int V;
	static int[][] adj;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	V = sc.nextInt();
    	adj = new int[N+1][N+1];
    	visit = new boolean[N+1];
    	
    	for(int i=0; i<M; i++) {
    		int from = sc.nextInt();
    		int to = sc.nextInt();
    		adj[from][to] = adj[to][from] = 1;
    	}
    	dfs(V);
    	sb.append("\n");
    	Arrays.fill(visit, false);
    	bfs(V);
    	System.out.println(sb);
    }

	private static void bfs(int from) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(from);
		visit[from] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current).append(" ");
				for(int i=1; i<=N; i++) {
					if(adj[current][i] != 0 && visit[i] == false) {
						q.add(i);
						visit[i] = true;
					}
				}
		}
	}

	private static void dfs(int from) {
		visit[from] = true;
		sb.append(from).append(" ");
		for(int i=1; i<=N; i++) {
			if(adj[from][i] != 0 && visit[i] == false) {
				dfs(i);
			}
		}
	}
}