package net.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639_이진_검색_트리 {
	/*
	 * 왼쪽 서브 트리에 있는 모든 키는 노드의 키보다 작다 오른쪽 서브 트리에 있는 모든 키는 노드의 키보다 크다. 결국 작은건 왼쪽 , 큰건
	 * 오른쪽으로 정리하는거네
	 * 
	 * 전위 -> 루트,왼쪽,오른쪽 후위 -> 왼, 오 , 루
	 * 
	 * 전위 순회 결과가 주어졌을 때, 후위 순회한 결과를 구하라
	 * 
	 * 전위로 이진탐색트리를 구할 수 있나? 하나의 수열이 하나의 트리만 나오는게 아니니까 전위탐색 결과는 특정지을 수 있겠다.
	 * 
	 * 루 - 왼 - 오 //순서니까 제일 처음이 루트 - 인건 확실하다.
	 * 
	 * 루트보다 이후 나오는 숫자가 작다 -> 왼쪽 루트보다 이후 나오는 숫자가 크다 -> 오른쪽
	 * 
	 */

	public static class Node {
		Node left, right;
		int key;

		Node(int key) {
			this.key = key;
//			this.left.parent = this;
//			this.right.parent = this;
		}
	}

	static Node root;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int keyRoot = Integer.parseInt(br.readLine());
			root = new Node(keyRoot);

			while (true) {
				int key = Integer.parseInt(br.readLine()); // 더 없으면 벗어날 것
				Node tmpNode = new Node(key);
				// TODO 나중에 탐색을 재귀로 해보자
				Node curNode = trav(tmpNode, root); // 아마 저장해야할 위치까지 가 있을거
//				while (curNode != null) {
//					if (tmpNode.key > curNode.key) {
//						curNode = curNode.right; // 오른쪽으로 계속 가보자
//					} else {
//						curNode = curNode.left;
//					}
//				} // 결국 나오고 나면 마지막단까지 들어가 있을 것이다.

//				curNode = curNode.parent;
				if (tmpNode.key > curNode.key) {
					curNode.right = tmpNode;
				} else {
					curNode.left = tmpNode;
				}
			}
			// 저장 잘 됐나?

		} catch (Exception e) {
//			e.printStackTrace();
		}
		traversal(root);
		// 확인해보자

	}

	static Node trav(Node cNode, Node compare) {
		if (compare.key < cNode.key && compare.right == null || compare.key > cNode.key && compare.left == null) {
			return compare;
		} else if (compare.key < cNode.key) {
			return trav(cNode, compare.right);
		} else
			return trav(cNode, compare.left);

	} // 대충 된 것 같은

	static void traversal(Node cNode) {
		if (cNode.left != null)
			traversal(cNode.left);
		if (cNode.right != null)
			traversal(cNode.right);
		System.out.println(cNode.key);
	}
}
