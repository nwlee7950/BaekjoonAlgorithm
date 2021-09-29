import java.io.*;
import java.util.*;

public class Main {
    static int N, M, MAX;
    static int[][] map, map2;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static class Virus{
    	int r, c;
    	
    	Virus(int r, int c){
    		this.r = r;
    		this.c = c;
    	}
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
    	N = Integer.parseInt(str[0]);
    	M = Integer.parseInt(str[1]);
        map = new int[N][M];
        map2 = new int[N][M];
    	for(int i = 0; i < N; i++) {
    		str = br.readLine().split(" ");
    		for(int j = 0; j < M; j++) {
    			map[i][j] = Integer.parseInt(str[j]);
    		}
    	}
    	MAX = Integer.MIN_VALUE;
    	DFS(0);
    	System.out.println(MAX);
    }
    
    private static void DFS(int cnt) {
		if(cnt == 3) {
			BFS();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					DFS(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
    
	private static void BFS() {
		Queue<Virus> q = new LinkedList<Virus>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map2[i][j] = map[i][j];
				if(map[i][j] == 2)
					q.add(new Virus(i, j));
			}
		}
		while(!q.isEmpty()) {
			Virus cur = q.remove();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if(map2[nr][nc] == 0) {
						map2[nr][nc] = 2;
						q.add(new Virus(nr, nc));
					}
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map2[i][j] == 0)
					count++;
			}
		}
		MAX = Math.max(MAX, count);
	}
}