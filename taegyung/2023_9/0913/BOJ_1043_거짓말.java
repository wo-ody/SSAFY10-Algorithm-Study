package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말 {
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		parents = new int[N + 1];

		// truth 팀과 lie 팀이 있는데 얘네를
		// truth 먼저 퍼트려서 얘네가 들어가 있는 그룹은 다 truth;
		// 남은 애들 중에 false 만으로 이루어 질 수 있는 그룹의 갯수를 구하자
		int truth_cnt = Integer.parseInt(st.nextToken());

		int[] truth_member = new int[truth_cnt];

		for (int i = 0; i < truth_cnt; i++) {
			truth_member[i] = Integer.parseInt(st.nextToken());

		}

		ArrayList<int[]> party = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int people_cnt = Integer.parseInt(st.nextToken());
			party.add(new int[people_cnt]);
			for (int j = 0; j < people_cnt; j++) {
				party.get(i)[j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력은 다 받았고

		// 필요한게 union find 로 구현할 게 뭔가
		// 오케이 이미 확인 했다는걸 -1 로 하자

		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < truth_cnt; i++) {
			parents[truth_member[i]] = -1;
		}

//		for(int k = 0 ; k < M ; k ++)

		for (int k = 0; k < M; k++) {
			for (int i = 0; i < M; i++) {

//			boolean no_truth_party = true;
//			for(int j = 0 ; j < party.get(i).length ; j ++ ) {
//				if (parents[party.get(i)[j]] == -1)
//					no_truth_party = false;
//				
//				
//			}
//			for(int j = 0 ; j < party.get(i).length ; j ++ ) {
//				if (!no_truth_party) {
//					parents[party.get(i)[j]] = -1; // 전체를 -1로
//					
//				}
//			}

				for (int j = 0; j < party.get(i).length - 1; j++) {
					sum_parent(party.get(i)[j], party.get(i)[j + 1]);
				}

			}
		}

//		for (int i = 1; i <= N; i++) {
//		System.out.println(Arrays.toString(parents));
//		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (parents[party.get(i)[0]] != -1)
				cnt++;
		}
		System.out.println(cnt);
	}

	static void sum_parent(int n1, int n2) {
		int p1 = find_parent(n1);
		int p2 = find_parent(n2);

		if (parents[n1] == -1 || parents[n2] == -1) {
			parents[n1] = -1;
			parents[n2] = -1;
		} else {
			parents[p1] = p2; // 한쪽으로 몰아
		}
	}

	static int find_parent(int p) {
		if (parents[p] == -1)
			return -1;
		if (p == parents[p])
			return p;

		return parents[p] = find_parent(parents[p]);
	}

}
