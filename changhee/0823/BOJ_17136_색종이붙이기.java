/*
 *  08.23 김창희
 *  BOJ_17136_색종이붙이기
 *
 *  [풀이]
 *  1. 색종이가 있는 모든 위치를 리스트로 저장해서 색종이가 있는 부분에 대해서만 함수를 실행한다.
 *  2. 1 에서 5까지 종이를 사용한 개수를 가지는 배열을 만들어 5부터 1순으로 색종이붙이기를 시도한다.
 *  3. 이미 붙여있으면 넘어가고 붙일수있으면 재귀로 계속 넘긴다.
 *  4. 인덱스가 리스트 사이즈에 도달하면 최소값을 찾고 함수를 종료한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n = 10, answer = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] v;
	static int[] paper = { 0, 0, 0, 0, 0, 0 };
	static Deque<Node> attachPaper = new ArrayDeque<>();
	static List<Node> point = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[n][n];
		v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					point.add(new Node(i, j));
			}
		}
		setPaper(0, 0);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	public static void setPaper(int x, int count) {
		if (answer < count)
			return;
		if (x == point.size()) {
			answer = Math.min(answer, count);
			return;
		}

		Node node = point.get(x);
		if (v[node.x][node.y]) {
			setPaper(x + 1, count);
		} else {
			for (int i = 5; i > 0; i--) {
				if (isPossible(node.x, node.y, i) && paper[i] < 5) {
					attach(node.x, node.y, i);
					paper[i]++;
					setPaper(x + 1, count + 1);
					paper[i]--;
					cut(node.x, node.y, i);
				}
			}
		}

	}

	public static void attach(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				v[i][j] = true;
			}
		}
	}

	public static void cut(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				v[i][j] = false;
			}
		}
	}

	public static boolean isPossible(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i >= n || j >= n || map[i][j] == 0 || v[i][j])
					return false;
			}
		}
		return true;
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
