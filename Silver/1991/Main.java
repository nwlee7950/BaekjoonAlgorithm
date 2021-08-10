import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	char data;
	Node left;
	Node right;
	
	Node(char data){
		this.data =data;
	}
}


public class Main {
	static Node rootNode;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			char[] ch = br.readLine().toCharArray();
			add(ch[0], ch[2], ch[4]);		
		}
		dfsByPre(rootNode);
		sb.append("\n");
		dfsByMid(rootNode);
		sb.append("\n");
		dfsByEnd(rootNode);
		System.out.print(sb);
	}
	
	static void add(char a, char b, char c){
		if(rootNode == null)
			rootNode = new Node(a);
		Node tempNode = findNode(a);
		
		if(b != '.') {
			tempNode.left = new Node(b);
		}
		if(c != '.') {
			tempNode.right = new Node(c);
		}
	}
	
	static Node findNode(char node) {
		Queue<Node> queue = new LinkedList();
		Node tempNode = null;
		queue.add(rootNode);
		while(!queue.isEmpty()) {
			tempNode = queue.poll();
			if(tempNode.data == node)
				break;
			if(tempNode.left != null)
				queue.add(tempNode.left);
			if(tempNode.right != null)
				queue.add(tempNode.right);
		}
		return tempNode;
	}
	static void dfsByPre(Node node) {
		if(node == (null))
			return;
		sb.append(node.data);
		dfsByPre(node.left);
		dfsByPre(node.right);
		
	}
	static void dfsByMid(Node node) {
		if(node == (null))
			return;
		
		dfsByMid(node.left);
		sb.append(node.data);
		dfsByMid(node.right);
		
	}
	static void dfsByEnd(Node node) {
		if(node == (null))
			return;
		dfsByEnd(node.left);
		dfsByEnd(node.right);
		sb.append(node.data);
	}
}