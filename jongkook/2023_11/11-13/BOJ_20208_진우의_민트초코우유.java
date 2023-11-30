import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int size, health, heal, map[][], max;
	static boolean[] visited;
	static ArrayList<Node> mint = new ArrayList<>();
	static Node home;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		size = Integer.parseInt(st.nextToken());
		health = Integer.parseInt(st.nextToken());
		heal = Integer.parseInt(st.nextToken());	
		
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < size; j++) {
				int elem = Integer.parseInt(st.nextToken());
				if(elem == 1) home = new Node(i, j);
				if(elem == 2) mint.add(new Node(i, j));
			}
		}
		visited = new boolean[mint.size()];
		for(int i = 0; i < mint.size(); i++) {
			Node current = mint.get(i);
			int distance = Math.abs(home.x - current.x) + Math.abs(home.y - current.y);
			if(distance <= health) recur(current, i, health - distance+heal, 1);			
		}
		System.out.println(max);
		
	}
	
	static void recur(Node cur, int idx, int hp, int count) {
		visited[idx] = true;
		for(int i = 0; i < mint.size(); i++) {
			if(visited[i]) continue;
			Node node = mint.get(i);
			int distance = Math.abs(node.x - cur.x) + Math.abs(node.y - cur.y);
			if(distance <= hp) recur(node, i, hp - distance + heal, count+1);			
		}
		
		int dist = Math.abs(cur.x - home.x) + Math.abs(cur.y - home.y);
		if(dist <= hp) max = Math.max(count, max);
		visited[idx] = false;
	}
	static class Node{
		int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
