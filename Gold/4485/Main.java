import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map, dist;
	static int min;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node implements Comparable<Node>{
		int r, c;
		int cost;
		
		Node(int r, int c, int cost){
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
			@Override
			public int compareTo(Node o) {
				return this.cost <= o.cost? -1 : 1;
			}
		}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0)
				break;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(str[j]);
				}
			}
			sb.append("Problem " + tc++ + ": " + dijkstra()).append("\n");
		}
		System.out.println(sb);
	}

	private static int dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		dist[0][0] = map[0][0];
		pq.add(new Node(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				
				if(dist[nr][nc] > dist[current.r][current.c] + map[nr][nc]) {
					dist[nr][nc] = dist[current.r][current.c] + map[nr][nc];
					pq.add(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
		
		
		return dist[N-1][N-1];
	}
}