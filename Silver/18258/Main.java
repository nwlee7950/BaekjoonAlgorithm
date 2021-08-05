import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {		
		Queue<Integer> queue = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int last = 0;
		
		for(int i = 0; i < num; i++) {
			String[] str = br.readLine().split(" ");
			if(str[0].equals("push")) {
				queue.offer(Integer.parseInt(str[1]));
				last = Integer.parseInt(str[1]);
			}else if(str[0].equals("pop")) {
				if(queue.isEmpty())
					bw.write("-1" + "\n");
				else
					bw.write(queue.poll() + "\n");
			}else if(str[0].equals("size")){
				bw.write(queue.size() + "\n");
			}else if(str[0].equals("empty")) {
				if(queue.isEmpty())
					bw.write("1" + "\n");
				else
					bw.write("0" + "\n");
			}else if(str[0].equals("front")) {
				if(queue.isEmpty())
					bw.write("-1" + "\n");
				else
					bw.write(queue.peek() + "\n");
			}else if(str[0].equals("back")) {
				if(queue.isEmpty())
					bw.write("-1" + "\n");
				else
					bw.write(last + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}