import java.io.*;
import java.util.StringTokenizer;

public class Main{
	static int n, r, c, size, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    r = Integer.parseInt(st.nextToken());
	    c = Integer.parseInt(st.nextToken());
	    size = (int)Math.pow(2, n);
	    count = 0;
	    solve(r, c, size);
		System.out.println(count);
	}
	private static void solve(int x, int y, int size) {
		if(size == 1) {
			return;
		}
		
		if(x < size/2 && y < size/2)
			solve(x, y, size/2);
		else if(x < size/2 && y >= size/2) {
			count += size*size/4;
			solve(x, y - size/2, size/2);
		}
		else if(x >= size/2 && y < size/2) {
			count += (size*size/4) * 2;
			solve(x-size/2, y, size/2);
		}
		else {
			count += (size*size/4) * 3;
			solve(x-size/2, y-size/2, size/2);
		}
	}
}