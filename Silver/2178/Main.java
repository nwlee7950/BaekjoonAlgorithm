import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        
        map = new int[N][M];
        visit = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
        	str = br.readLine().split("");
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(str[j]);
        	}
        }
        visit[0][0] = true;
        solve(0, 0);
        System.out.println(map[N-1][M-1]);
    }

	public static void solve(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
					continue;
				
				if(visit[nextX][nextY] || map[nextX][nextY] == 0)
					continue;
				
				q.add(new Point(nextX, nextY));
				map[nextX][nextY] = map[p.x][p.y] + 1;
				visit[nextX][nextY] = true;
			}
		}
	}
	
	public static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}