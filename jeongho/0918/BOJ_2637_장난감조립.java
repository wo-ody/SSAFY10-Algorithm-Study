package algorithm2023.sep.day18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 존잘 정호
// 장난감 조립을 이제 푸네 ㅎㅎ
// 공쥬는 저번준가 풀었던 거 같은디 ㅎㅎ
// 오늘 점심은 뭐 먹을꺼야 ?
// 나는 어제 돈까스를 먹었거둥 ?
// 근데 또 먹고 싶어 !
// 명지에 오스루 라는 돈까스 징 ~~짜 맛있때 !
// 근데 여기 8시까지 주문 마감이어서 ,,,,
// 평일에 갈꺼면 호다다다다닫ㄱ 달려가야해 ... ㅎ
// 나 초밥도 먹고 시퍼 !
// 스타필드에 그 회전초밥집 있는데 거기 완전 맛집이도라 ~~~~
// 근데 확실히 키보드가 보글보글 이니까
// 치는게 행복하네 ㅎㅎㅎ
// 나도 티몬으로 사야하는디 ~~~~~~~~~~~~
// 하나만 사줄랭 ? ㅎㅎ
// 우리 싸머니 받았쟈나 ~~~
// 보글보글 보글 보글 ~~~~~~~~~~~~~~~~~
// ㅓㅇ렁니ㅏㅓㄹ니아러댜랑러ㅑ ㄷ저란을댜ㅓ리야ㅓ리냐ㅓㄹㄷ쟐ㄴ이ㅏㄹ니아ㅓㄹ니얼재댤지ㅏ푼이ㅏㄹㄴㅇ
// 이럳쟈렁나ㅣㄹㅈ디ㅑㄹㅇ니렁나ㅓㄹ댜루아러알댜룽리ㅑㅁ너리ㅏ으르댤알냗ㄹㅇ
public class BOJ_2637_장난감조립 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int N, M, indegree[];
	static ArrayList<ArrayList<Part>> adjList = new ArrayList<>();
	
	static class Part{
		int num, cnt;

		public Part(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
		
	}

	public static void main(String[] args) throws Exception {
	
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i= 0;i<=N;i++) {
			adjList.add(new ArrayList<>());
		}
		indegree= new int[N+1];
		boolean[] isBasic = new boolean[N+1];
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			isBasic[X]=true;
			adjList.get(X).add(new Part(Y,K));
			indegree[Y]++;
		}
		int[] ans = new int[N+1];
		ans[N] = 1;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		
		q.add(N);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(Part p : adjList.get(cur)) {
				ans[p.num]+=p.cnt*ans[cur];
				if(--indegree[p.num]==0) {
					q.add(p.num);
				}
			}
		}
		
		for(int i =1;i<=N;i++) {
			if(!isBasic[i]) {
				System.out.println(i+" "+ans[i]);
			}
		}
	}
}
