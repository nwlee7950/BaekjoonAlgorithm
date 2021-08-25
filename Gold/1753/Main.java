import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static class Edge{
		int vertex;
		int weight;
		Edge(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringBuilder sb = new StringBuilder();
	   
	      String[] str = br.readLine().split(" ");
	      int V = Integer.parseInt(str[0]);
	      int E = Integer.parseInt(str[1]);
	      int start = Integer.parseInt(br.readLine()) - 1;
	      List<Edge>[] adj = new ArrayList[V];
	      for(int i=0; i<V; i++)
	    	  adj[i] = new ArrayList<Edge>();
	      
	      for(int i=0; i<E; i++) {
	    	  str = br.readLine().split(" ");
	    	  int from = Integer.parseInt(str[0]) - 1;
	    	  int to = Integer.parseInt(str[1]) - 1;
	    	  int weight = Integer.parseInt(str[2]);
	    	  
	    	  adj[from].add(new Edge(to, weight));
	      }
		//dijkstra준비
		//확보된 정점을 체크할 배열
		boolean[] check = new boolean[V];
		//거리를 기록할 배열
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		for(int i = 0; i < V; i++) {
			//이번에 확보할 정점을 찾는다.
			//check되지 않았으면서(아직 미확보)
			//dist값이 젤 작은 정점의 번호를 찾자.
			int min = Integer.MAX_VALUE;
			int index = -1;
			for(int j = 0; j < V; j++) {
				if(!check[j] && min > dist[j]) {
					min = dist[j];
					index = j;
				}
			}
			//찾아진 정점이 없다는 것은 더이상 경로가 존재하지 않음
			if( index == -1 )
				break;
			//확보로 체크하고
			check[index] = true;
			//확보된 정점으로부터 확보되지않은 정점으로 경로가 존재한다면 거리 갱신
			
			//이 정점으로부터 모든 경로를 탐색
			for(Edge next : adj[index]) {
				//이미 확보된 곳으로 가는 경로는 패스
				if( check[next.vertex] )
					continue;
				//이미 알려진 경로가, 확보된 정점으로부터 가는 거리보다 길면 갱신
				if( dist[next.vertex] > dist[index] + next.weight )
					dist[next.vertex] = dist[index] + next.weight;
			}
		}
		for(int i = 0; i < V; i++) {
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
}