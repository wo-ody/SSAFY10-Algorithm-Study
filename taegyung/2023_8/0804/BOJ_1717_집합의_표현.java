package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의_표현 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringTokenizer st;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i; // 초기화
		}
//		Node[] nodeList = new Node[n + 1];
//		for (int i = 0; i <= n; i++) {
//			nodeList[i] = new Node(i);
//		}
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (command == 0) {
				// TODO 합집합
				// 결국 같은 집합인지 아닌지를 확인해야한다.
//				if (nodeList[a])
//				int aRoot = find_root(nodeList[a]);
//				int bRoot = find_root(nodeList[b]);
//				if (aRoot == bRoot)
//					continue;
//				nodeList[aRoot].parent = nodeList[bRoot]; // 합친다.
//				if (find_root(a) == find_root(b))
				int aRoot = find_root(a);
				int bRoot = find_root(b);
				parent[aRoot] = bRoot;
			} else if (command == 1) {
				// TODO 둘 다 포함되어 있는지

//				int aRoot = find_root(nodeList[a]);
//				int bRoot = find_root(nodeList[b]);
				int aRoot = find_root(a);
				int bRoot = find_root(b);
				if (aRoot == bRoot)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}

	}

	static int find_root(int node) {
		if (node == parent[node])
			return node; // 루트 발견
		return parent[node] = find_root(parent[node]);
	}

	// 분리 집합
	static class Node {
		int value;
		Node parent;

		Node(int value) {
			this.value = value;
			this.parent = this;
		}
	}

//	static int find_root(Node node) {
//		if (node.parent.value == node.value) { // 루트노드 발견
//			return node.value;
//		}
//		return find_root(node.parent);
//	}
//	static class Tree {
//		
//	}
}
