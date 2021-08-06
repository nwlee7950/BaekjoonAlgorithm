import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Top> tops = new Stack<Top>();
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		
		for(int i=1; i<=n; i++) {
			int h = Integer.parseInt(str[i-1]);
			
			while(!tops.isEmpty()) {
				if(tops.peek().height < h)
					tops.pop();
				else {
					bw.write(tops.peek().idx + " ");
					break;
				}
			}
			if(tops.isEmpty())
				bw.write(0 + " ");
			tops.add(new Top(i, h));
		}
		bw.flush();
		br.close();
		bw.close();
	}
	public static class Top{
		int idx, height;
		
		Top(int idx, int height){
			this.idx = idx;
			this.height = height;
		}
	}
}