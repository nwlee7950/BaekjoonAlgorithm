import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
    static boolean[][][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int[] hx = {-1, -2, -1, -2, 1, 2, 1, 2};
    static int[] hy = {-2, -1, 2, 1, -2, -1, 2, 1};
    static int K, N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        
        String[] str = br.readLine().split(" ");
        M = Integer.parseInt(str[0]);
        N = Integer.parseInt(str[1]);
        
        map = new int[N][M];
        visit = new boolean[N][M][K+1];
        
        for(int i=0; i<N; i++) {
        	str = br.readLine().split(" ");
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(str[j]);
        	}
        }
        System.out.println(solve(0, 0));
    }

	public static int solve(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y, 0, 0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == N-1 && p.y == M-1)
				return p.depth;
			
			if(p.jump < K) {
				for(int i=0; i<8; i++) {
					int jumpX = p.x + hx[i];
					int jumpY = p.y + hy[i];
					
					if(!isOk(jumpX, jumpY, p.jump+1))
						continue;
					
					visit[jumpX][jumpY][p.jump + 1] = true;
					q.add(new Point(jumpX, jumpY, p.depth+1, p.jump+1));
		
				}
			}
			
			for(int i=0; i<4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if(!isOk(nextX, nextY, p.jump))
					continue;
				visit[nextX][nextY][p.jump] = true;
				q.add(new Point(nextX, nextY, p.depth+1, p.jump));			
			}
		}
		return -1;
	}
	
	public static boolean isOk(int x, int y, int k) {
		if(x < 0 || x >= N || y < 0 || y >= M)
			return false;
		
		if(map[x][y] == 1)
			return false;
		
		if(visit[x][y][k] == true)
			return false;
		
		return true;
	}
	
	public static class Point{
		int x;
		int y;
		int depth;
		int jump;
		
		Point(int x, int y, int depth, int jump){
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.jump = jump;
		}
	}
}