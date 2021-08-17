import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main{
	static class Point implements Comparable<Point>{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Main.Point p) {
			if(this.x > p.x)
				return 1;
			else if(this.x == p.x) {
				if(this.y > p.y)
					return 1;
			}
			return -1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Point[] pa = new Point[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			pa[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(pa);
		for(int j=0; j<pa.length; j++) {
			sb.append(pa[j].x + " ").append(pa[j].y).append("\n");
		}
		System.out.print(sb);
	}
}