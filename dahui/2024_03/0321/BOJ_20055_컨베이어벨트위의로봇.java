import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	static ArrayList<Node> belt = new ArrayList<>();
	//내구도 0인 벨트 수, 올리는 칸 Idx, 내리는 칸 Idx
	static int cnt, up, down, N, K, ans, NN;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		NN = 2*N;
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < NN; i++) {
			int hp = Integer.parseInt(st.nextToken());
			belt.add(new Node(hp, 0));
		}
		up = 0;
		down = N-1;
		simulation();
		System.out.println(ans);
	}

	public static void simulation() {
		while (true) {
			ans++; //단계 올리기
			//회전
			up = (up + NN - 1) % NN;
			down = (down + NN - 1) % NN;
			//로봇이 내리는 위치라면 즉시 내리기
			Node n = belt.get(down);
			n.robot_cnt = 0;

			//로봇 이동
			moveRobot();

			//로봇 올리기 - 올릴 때 내구도 감소, 내구도가 1 이상이여야 올릴 수 있음
			n = belt.get(up);
			if (n.hp >= 1) {
				n.robot_cnt++; //로봇 수 늘리고
				n.hp--; //내구도 감소
				if (n.hp == 0) cnt++; //내구도 0이라면 0인 칸 수 올리기
			}
			if (cnt >= K)
				return;
		}
	}
	// 로봇 이동하기 - 다음칸에 로봇이 없고 내구도가 1이상이면 이동가능,
	// 가장 먼저 올라간 로봇 부터
	public static void moveRobot() {
		int idx = (down+NN-1)%NN;
		for (int i = 0; i < N; i++) {
			Node now = belt.get(idx);
			Node next = belt.get((idx+1)%NN);
			if (now.robot_cnt > 0 && next.robot_cnt == 0 && next.hp >= 1) {
				now.robot_cnt--;
				next.hp--;
				if (next.hp == 0) cnt++;
				next.robot_cnt++;
				if ((idx+1)%NN == down) next.robot_cnt = 0;
			}
			idx = (idx+NN-1)%NN;
		}
	}
	public static class Node {
		int hp;
		int robot_cnt;
		public Node (int hp, int robot_cnt) {
			this.hp = hp;
			this.robot_cnt = robot_cnt;
		}
	}
}



