import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Node{
		int r, c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[M][N];
			visited = new boolean[M][N];
			
			int count = 0;
			
			for(int i = 0; i < K; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				map[row][col] = 1;
			}
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1) {
						count++;
						bfs(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(i, j));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int a = 0; a < 4; a++) {
				int nr = cur.r + dr[a];
				int nc = cur.c + dc[a];
				
				if(nr < 0 || nc < 0 || nr >= M || nc >= N)
					continue;
				if(visited[nr][nc] || map[nr][nc] == 0)
					continue;
				
				visited[nr][nc] = true;
				map[nr][nc] = 0;
				q.add(new Node(nr, nc));
			}
		}
		
	}
}