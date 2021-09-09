import java.io.*;

public class Main{
	static int n;
	static int[] count;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		count = new int[2];
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		solve(0, 0, n);
		for(int j=0; j<2; j++) {
			System.out.println(count[j]);
		}
	}

	private static void solve(int r, int c, int size) {
		if(isOk(r, c, size)) {
			count[map[r][c]] += 1;
			return;
		}
		int new_size = size/2;
		
		solve(r, c, new_size);
		solve(r+new_size, c, new_size);
		solve(r, c+new_size, new_size);
		solve(r+new_size, c+new_size, new_size);
	}
	private static boolean isOk(int r, int c, int size) {
		int cur_num = map[r][c];
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(cur_num != map[i][j])
					return false;
			}
		}
		return true;
	}
}