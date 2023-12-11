/**
 * 7.26 김창희
 * BOJ_19238_스타트택시
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static HashMap<Integer, Node> hash = new HashMap<>(); // 유저마다 도착지 지정
	static int[][] map; // 벽과 길로 이루어진 map
	static int[][] startPoint; // user의 위치 저장
	static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };
	static Node start; // 함수 실행마다 변화하는 시작점 지정
	static int n, m, f;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()) + 1; // 인덱스계산 싫어..
		m = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		startPoint = new int[n][n];
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int point = 1;
		start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		
		// 출발지에는 한명씩만 있을수 있지만 도착지는 중복될수있기에 point마다 hashmap을 사용하여 도착지 저장
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			startPoint[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = point;
			hash.put(point, new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));
			point++;
		}

		// 가장 가까운 유저를 찾는것과 도착지로 이동하는것을 각각 다른 함수로 구현
		while (m-- > 0) {
			if (!findUser() || !driveToX()) {
				f = -1;
				break;
			}
		}

		System.out.println(f);
	}

	// 행과 열순으로 가장 가까운 유저를 선택한다. 유저에게 갈수없거나 연료가 부족하면 null반환
	public static boolean findUser() {
		PriorityQueue<Node> pq= new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.cost==o2.cost) {
					if(o1.x==o2.x) {
						return o1.y-o2.y;
					}
					return o1.x-o2.x;
				}
				return o1.cost-o2.cost;
			}
		});
		Queue<Node> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];

		q.offer(new Node(start.x, start.y, 0));
		v[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if(startPoint[node.x][node.y] > 0 ) pq.offer(node);

			vCheck(q, v, node);
		}

		// 찾은 user가 없거나 연료가 부족하면 null, 아니면 출발지 set하고 return node
		if (pq.isEmpty() || f < pq.peek().cost)
			return false;
		Node result = pq.poll();
		f -= result.cost;
		start = new Node(result.x, result.y, 0);
		return true;

	}

	// 출발지 point에 해당하는 도착지를 hashmap에서 가져와서 연산 시작, 출발지는 0으로 초기화할것
	public static boolean driveToX() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] v = new boolean[n][n];
		Node endPoint = hash.get(startPoint[start.x][start.y]);
		Node result = null;

		q.offer(new Node(start.x, start.y, 0));
		v[start.x][start.y] = true;
		startPoint[start.x][start.y] = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.x == endPoint.x && node.y == endPoint.y) {
				result = node;
				break;
			}

			vCheck(q, v, node);
		}

		if (result == null || result.cost > f)
			return false;
		f += result.cost;
		start = new Node(result.x, result.y, 0);
		return true;
	}

	private static void vCheck(Queue<Node> q, boolean[][] v, Node node) {
		for (int i = 0; i < 4; i++) {
			int nx = node.x + dx[i];
			int ny = node.y + dy[i];

			if (nx <= 0 || ny <= 0 || nx >= n || ny >= n)
				continue;

			if (!v[nx][ny] && map[nx][ny] == 0) {
				v[nx][ny] = true;
				q.offer(new Node(nx, ny, node.cost + 1));
			}
		}
	}

	static class Node {
		int x, y, cost;

		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
