import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
    static boolean[][][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        
        map = new int[N][M];
        visit = new boolean[N][M][2];
        
        for(int i=0; i<N; i++) {
        	str = br.readLine().split("");
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(str[j]);
        	}
        }
        System.out.println(solve(0, 0));
    }

	public static int solve(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y, 1, false));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == N-1 && p.y == M-1)
				return p.depth;
			
			for(int i=0; i<4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
					continue;
				
				if(map[nextX][nextY] == 0 && !visit[nextX][nextY][p.used?1:0]) {
					visit[nextX][nextY][p.used?1:0] = true;
					q.add(new Point(nextX, nextY, p.depth+1, p.used));
				}
				
				if(map[nextX][nextY] == 1 && !p.used && !visit[nextX][nextY][1]) {
					visit[nextX][nextY][1] = true;
					q.add(new Point(nextX, nextY, p.depth+1, true));
				}			
			}
		}
		return -1;
	}
	
	public static class Point{
		int x;
		int y;
		int depth;
		boolean used;
		
		Point(int x, int y, int depth, boolean used){
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.used = used;
		}
	}
}