package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068_트리 {
	// 부모를 저장해두는게 나을까 자식을 저장하는게 나을까
	// 부모는 Node 하나면 되지만 자식은 Node 배열을 선언해야한다.
	// 근데 부모를 저장하게 되면 자식을 먼저 알고 있는 상태에서 백트래킹으로 넘어가야함
	// 이건 말이 안맞음
	// 그니까 결국 자식 배열을 갖고 있어야하는 것 같음

	public static class Node {
		ArrayList<Node> children = new ArrayList<>();

		int value;

		Node(int value) {
			this.value = value;
		}

	}

	static Node root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Node[] nodes = new Node[N];

		st = new StringTokenizer(br.readLine());
		// 노드들을 배열에 집어넣기
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);

		}
		// 노드들에 children 넣어주기

		for (int i = 0; i < N; i++) {
			String s = st.nextToken();
			if (s.equals("-1")) {
				root = nodes[i];
			} else {
				nodes[Integer.parseInt(s)].children.add(nodes[i]); // 부모의 자식 배열리스트에 추가
			}

		}

		int delNode = Integer.parseInt(br.readLine());

		if (delNode == root.value) {
			System.out.println(0);
		} else {
			System.out.println(traversal_and_delete(root, nodes[delNode]));
		}
		// TODO root부터 탐색하면서 내려가면서 자식 배열에서 지울 노드를 발견하면 -> del하고
		// 자식 배열노드가 아무것도 없으면 cnt +=1
		// 재귀로 다녀도 될 것 같네
	}

	public static int traversal_and_delete(Node cNode, Node targetNode) {
		if (cNode.children.contains(targetNode)) { // 지우기
			cNode.children.remove(targetNode);
		}
		if (cNode.children.size() == 0) {
			return 1;
		} else {
			int cnt = 0;

			for (int i = 0; i < cNode.children.size(); i++) {
				cnt += traversal_and_delete(cNode.children.get(i), targetNode);
			}
			return cnt;
		}
	}
}
