import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][3];
		int[][] dp_max = new int[N + 1][3];
		int[][] dp_min = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());

			dp_max[i][0] = Math.max(dp_max[i - 1][0], dp_max[i - 1][1]) + map[i][0];
			dp_max[i][1] = Math.max(dp_max[i - 1][0], Math.max(dp_max[i - 1][1], dp_max[i - 1][2])) + map[i][1];
			dp_max[i][2] = Math.max(dp_max[i - 1][1], dp_max[i - 1][2]) + map[i][2];

			dp_min[i][0] = Math.min(dp_min[i - 1][0], dp_min[i - 1][1]) + map[i][0];
			dp_min[i][1] = Math.min(dp_min[i - 1][0], Math.min(dp_min[i - 1][1], dp_min[i - 1][2])) + map[i][1];
			dp_min[i][2] = Math.min(dp_min[i - 1][1], dp_min[i - 1][2]) + map[i][2];
			
		} 
		
		System.out.println(Math.max(dp_max[N][0], Math.max(dp_max[N][1], dp_max[N][2]))+" "+Math.min(dp_min[N][0], Math.min(dp_min[N][1], dp_min[N][2])));
	}
}