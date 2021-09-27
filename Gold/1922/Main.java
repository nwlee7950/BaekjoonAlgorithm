import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
    public static class Computer implements Comparable<Computer>{
	   int start, end, weight;
	   
	   Computer(int start, int end, int weight){
		   this.start = start;
		   this.end = end;
		   this.weight = weight;
	   }
	   
	@Override
	public int compareTo(Computer o) {
		return this.weight - o.weight;
	}
   }
    
    private static void union(int start, int end) {
    	start = find(start);
    	end = find(end);
    	if(start != end)
    		parent[end] = start;
    }

    private static boolean isOk(int start, int end) {
    	start = find(start);
    	end = find(end);
    	if(start == end)
    		return true;
    	else
    		return false;
    }

    private static int find(int start) {
    	if(parent[start] == start)
    		return start;
    	else
    		return parent[start] = find(parent[start]);
    }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int M = Integer.parseInt(br.readLine());
      parent = new int[N+1];
      int ans = 0;
      List<Computer> li = new ArrayList<Computer>();
      
      for(int i = 0; i < M; i++) {
    	  String[] str = br.readLine().split(" ");
    	  int start = Integer.parseInt(str[0]);
    	  int end = Integer.parseInt(str[1]);
    	  int weight = Integer.parseInt(str[2]);
    	  
    	  li.add(new Computer(start, end, weight));
      }
      
      Collections.sort(li);
      
      for(int i = 1; i <= N; i++) {
    	  parent[i] = i;
      }
      
      for(int i = 0; i < M; i++) {
    	  Computer com = li.get(i);
    	  if(!isOk(com.start, com.end)) {
    		  union(com.start, com.end);
    		  ans += com.weight;
    	  }
      }
      System.out.println(ans);
   }
}