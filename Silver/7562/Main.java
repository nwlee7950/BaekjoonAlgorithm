import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
	static int N;
	static boolean[][] visit;
	static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc = 0; tc < T; tc++) {
    		N = Integer.parseInt(br.readLine());
    		map = new int[N][N];
    		visit = new boolean[N][N];
    		
    		String[] str = br.readLine().split(" ");
    		int startX = Integer.parseInt(str[0]);
    		int startY = Integer.parseInt(str[1]);
    		str = br.readLine().split(" ");
    		int endX = Integer.parseInt(str[0]);
    		int endY = Integer.parseInt(str[1]);
    		
    		bfs(startX, startY, endX, endY);
    	}
		System.out.println(sb);

    }
    private static void bfs(int startX, int startY, int endX, int endY) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(startX, startY, 0));
		visit[startX][startY] = true;
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			if(current.x == endX && current.y == endY) {
				sb.append(current.depth).append("\n");
				return;
			}
			
			for(int i=0; i<8; i++) {
				int tempX = current.x + dx[i];
				int tempY = current.y + dy[i];
				if(tempX >= 0 && tempX < N && tempY >= 0 && tempY < N) {
					if(!visit[tempX][tempY]) {
						q.add(new Node(tempX, tempY, current.depth+1));
						visit[tempX][tempY] = true;
					}
				}
			}
		}
		
	}
	static class Node{
    	int x;
    	int y;
    	int depth;
    	
    	Node(int x, int y, int depth){
    		this.x = x;
    		this.y = y;
    		this.depth = depth;
    	}
    }
}