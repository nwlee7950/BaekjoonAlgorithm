import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
    public static class Edge implements Comparable<Edge>{
	   int start, end, weight;
	   
	   Edge(int start, int end, int weight){
		   this.start = start;
		   this.end = end;
		   this.weight = weight;
	   }
	   
	@Override
	public int compareTo(Edge o) {
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
      String[] str = br.readLine().split(" ");
      int N = Integer.parseInt(str[0]);
      int M = Integer.parseInt(str[1]);
      parent = new int[N+1];
      int ans = 0;
      int lastOne = 0;
      List<Edge> li = new ArrayList<Edge>();
      
      for(int i = 0; i < M; i++) {
    	  str = br.readLine().split(" ");
    	  int start = Integer.parseInt(str[0]);
    	  int end = Integer.parseInt(str[1]);
    	  int weight = Integer.parseInt(str[2]);
    	  
    	  li.add(new Edge(start, end, weight));
      }
      
      Collections.sort(li);
      
      for(int i = 1; i <= N; i++) {
    	  parent[i] = i;
      }
      
      for(int i = 0; i < M; i++) {
    	  Edge ed = li.get(i);
    	  if(!isOk(ed.start, ed.end)) {
    		  union(ed.start, ed.end);
    		  ans += ed.weight;
    		  lastOne = ed.weight;
    	  }
      }
      System.out.println(ans - lastOne);
   }
}