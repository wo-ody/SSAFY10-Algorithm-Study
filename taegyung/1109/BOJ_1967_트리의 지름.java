import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 순회할 때 왼쪽,오른쪽의 합과 지금까지 확인한 지름의 max값을 저장하자
	 */

	static class Node {
		ArrayList<Node> children = new ArrayList<>();

		int weight_with_parent;

		int value;

		Node(int value) {
			this.value = value;
		}
	}

	static Node root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 노드의 수
		int N = Integer.parseInt(br.readLine());

		Node[] nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node(i); // 노드 생성
		}
		root = nodes[1];
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int par = Integer.parseInt(st.nextToken());
			int chi = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());

			nodes[par].children.add(nodes[chi]);
			nodes[chi].weight_with_parent = wei;

		}
		int[] answer = traversal(root);
//		for (int i = 0; i < 3; i++) {
//			System.out.println(answer[i]);
//		}

		System.out.println(answer[2]);
		// 저장은 완료
		// TODO 순회하면서 좌,우,현재까지의 max값을 리턴하는 함수
		// 아니지 자식에게서 올라온 노드중 max두개를 더한 값, max값 + 부모와의 weight, 현재까지의 max를 리턴
		// 이렇게 진행하면 자식에게서 올라오는 정보에서 [1]들을 비교해서 두개를 더한 값을 max와 비교한다.

	}

	public static int[] traversal(Node cNode) {
		int[] answer = new int[3];
		// 자식에게서 올라온 노드중 max 두개를 더한 값, max + 부모와의 weight ,현재까지의 max

		if (cNode.children.size() == 0) { // 자식이 없다면
			answer[0] = 0;
			answer[1] = cNode.weight_with_parent;
			answer[2] = 0;
//			return [0,0,0];
			return answer;
		} else {
			if (cNode.children.size() == 1) {
				int[] childResult = traversal(cNode.children.get(0));
				answer[0] = childResult[1];
				answer[1] = childResult[1] + cNode.weight_with_parent;
				answer[2] = Math.max(childResult[2], answer[0]);

				return answer;
			} else { // 자식이 둘 이상이다.

				int[] maxList = new int[2];
				maxList[0] = -1;
				maxList[1] = -1;
				for (int i = 0; i < cNode.children.size(); i++) {
					int[] tmpResult = traversal(cNode.children.get(i));

					answer[2] = Math.max(tmpResult[2], answer[2]);
					// 좌,우를 더한 값과 max를 비교해서 2에 넣는다.
//					for(int j = 0 ; j< 2; j++) {
					if (maxList[0] < tmpResult[1]) {
						if (maxList[1] < tmpResult[1]) {
							maxList[0] = maxList[1];
							maxList[1] = tmpResult[1]; // 이렇게하면 제일 큰 두개만 저장되진 않는다.
							// 뒤에 더 큰 수가 저장되게
						} else {
							maxList[0] = tmpResult[1];
						}
					}
					// 얘보다 작으면 저장할 필요 없다.

				}

				// 다 저장하고 나면 두개가 큰 수가 남게됨
				answer[0] = maxList[0] + maxList[1];
				answer[1] = maxList[1] + cNode.weight_with_parent;
				answer[2] = Math.max(answer[0], answer[2]);
				return answer;
			}
		}

	}
}
