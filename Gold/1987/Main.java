import java.io.*;

public class Main {
	static int R, C;
	static int MAX;
	static char[][] arr;
	static boolean[] visit;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		arr = new char[R][C];
		visit = new boolean[26];
		MAX = Integer.MIN_VALUE;
		
		for(int i=0; i<R; i++) {
			String str2 = br.readLine();
			for(int j=0; j<str2.length(); j++)
				arr[i][j] = str2.charAt(j);
		}
		dfs(0, 0, 0);
		System.out.println(MAX);
	}
	private static void dfs(int x, int y, int count) {
		if(x < 0 || y < 0 || x >=R || y >= C)
			return;
		if(visit[arr[x][y] - 'A']) {
			MAX = Math.max(MAX, count);
			return;
		}
		for(int i=0; i<4; i++) {
			visit[arr[x][y] - 'A'] = true;
			int nx = x + dx[i];
			int ny = y + dy[i];
			dfs(nx, ny, count+1);
			visit[arr[x][y] - 'A'] = false;
		}
		
	}
}