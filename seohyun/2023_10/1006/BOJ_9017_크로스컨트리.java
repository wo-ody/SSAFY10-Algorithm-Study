package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_9017_크로스컨트리 {
	static int T,N;
	static int[] team;
	
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			team = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) team[i] = Integer.parseInt(st.nextToken());
			
			// 함수 시작
			sb.append(simulation()).append("\n");
		}
		System.out.println(sb);
	}
	
	static int simulation() {
		HashMap<Integer, Integer> team_cnt = new HashMap<>();
		HashMap<Integer, Node> team_score = new HashMap<>();
		
		
		// ( 팀번호 : 명수 ) 만들어주기
		for (int i = 0; i < N; i++) {
			if(team_cnt.containsKey(team[i])) {
				int cnt = team_cnt.get(team[i]);
				team_cnt.put(team[i], cnt + 1);
			}
			else {
				team_cnt.put(team[i], 1);
			}
		}
		
		// 점수 매기기
		int[] score = new int[N];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if(team_cnt.get(team[i]) == 6) {
				score[i] = cnt++;
			}
			else {
				score[i] = -1;
			}
		}
		
		// HashMap(팀번호, (점수, 갯수, 5번째)) 정렬
		for (int i = 0; i < N; i++) {
			if(score[i] == -1) continue;
			if(team_score.containsKey(team[i])) {
				Node cur = team_score.get(team[i]);
				if(cur.cnt < 4) {
					team_score.put(team[i], new Node(cur.score + score[i], cur.cnt + 1, cur.fifth));
				}
				else if(cur.cnt == 4) {
					team_score.put(team[i], new Node(cur.score, cur.cnt + 1, score[i]));
				}
			}
			else {
				team_score.put(team[i], new Node(score[i],1,0));
			}
		}
		
		// 정렬
		ArrayList<Node> arr = new ArrayList<>();
		for(int team_num : team_score.keySet()) {
			Node cur = team_score.get(team_num);
			arr.add(new Node(team_num,cur.cnt,cur.score,cur.fifth));
		}
		
		Collections.sort(arr, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.cnt == o2.cnt) return o1.fifth - o2.fifth;
				return o1.cnt - o2.cnt;
			}
		});
		
		return arr.get(0).team;
		
	}
	
	static class Node{
		int team;
		int score, cnt, fifth;
		
		Node(int team, int score, int cnt, int fifth){
			this.team = team;
			this.score = score;
			this.cnt = cnt;
			this.fifth = fifth;
		}
		
		Node(int score, int cnt, int fifth){
			this.score = score;
			this.cnt = cnt;
			this.fifth = fifth;
		}
	}

}
