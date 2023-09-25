package algorithm2023.sep.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2166_다각형의면적 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	static ArrayList<Node> nodeList = new ArrayList<>();
	
	static class Node{
		long x,y;

		public Node(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		for(int i =0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long y = Long.parseLong(st.nextToken());
			nodeList.add(new Node(x,y));
		}
		double ans = 0.0;
		for(int i = 1;i<N-1;i++) {
			ans+=shoelace(nodeList.get(i), nodeList.get(i+1));
		}
		
		System.out.printf("%.1f",Math.abs(ans));
		
	}
	
	static double shoelace(Node b, Node c) {
		Node a= nodeList.get(0);
		
		
		
		return ((a.x*b.y + b.x*c.y + c.x*a.y) - (b.x*a.y+c.x*b.y+a.x*c.y))/2.0;
	}
}
