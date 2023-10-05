package BOJ17281;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//타자의 조합을 순열로 (완탐)
//1번 선수는 4번 타자로 고정
public class Main {
	static int N, ans;
	static int player[][];			//선수 목록
	static boolean select[];		//타자 선택 여부(for 순열)
	static int order[];				//타순 결정
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		player = new int[N+1][10];		//0,0은 더미
		select = new boolean[10];		//0은 더미
		order = new int[10];			//0은 더미
		
		//1번 선수는 4번 타자로 고정
		select[4] = true;
		order[4] = 1;
		
		
		//선수 배열 입력
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans=0;
		perm(2);	//2번 타자부터 시작
		
		System.out.println(ans+"\n");
	}
	
	//순열
	public static void perm(int idx) {
		//기저조건 (9명을 넘어가면)
		if(idx > 9) {
			//complete code
			play();
			return;
		}
		
		//2번 주자부터 선택
		for(int i=1; i<=9; i++) {
			//선택된 애면 pass
			if(select[i]) continue;
			
			//풀이
			select[i] = true;
			order[i] = idx;
			perm(idx+1);
			select[i] = false;
		}
	}
	
	//야구 경기
	public static void play() {
		int score = 0;
		int start = 1;		//이닝에서 처음 시작하는 타자(다음 이닝에 이어져야 하므로)
		boolean[] base;		//홈, 1루, 2루, 3루
		
		for(int i=1; i<=N; i++) {
			int outCnt=0;		//아웃된 수 (3번 아웃은 3진 아웃)
			base = new boolean[4];		//베이스 초기화
			
			outer: while(true) {
				for(int j=start; j<=9; j++) {
					int hitter = player[i][order[j]];		//j번째 타자
					
					switch(hitter) {
					//out
					case 0:
						outCnt++;
						break;
					//안타
					case 1:
						for(int k=3; k>=1; k--) {
							//베이스 현황 보기
							if(base[k]) {
								//3루면 홈으로
								if(k==3) {
									score++;
									base[k] = false;
									continue;
								}
								
								//1,2면 1루씩 옮긴다. (원래 자리 비워주기!)
								base[k] = false;
								base[k+1] = true;
							}
						}
						//홈에서 1루로!
						base[1] = true;	
						break;
					//2루
					case 2:
						for(int k=3; k>=1; k--) {
							//베이스 현황 보기
							if(base[k]) {
								//3루, 2루면 홈으로
								if(k==3 || k==2) {
									score++;
									base[k] = false;
									continue;
								}
								
								//1루면 3루로 (원래 자리 비워주기!)
								base[k] = false;
								base[k+2] = true;
							}
						}
						//홈에서 2루로!
						base[2] = true;	
						break;
					//3루
					case 3:
						for(int k=3; k>=1; k--) {
							//베이스 현황 보기
							if(base[k]) {
								score++;
								base[k] = false;
							}
						}
						//홈에서 3루로!
						base[3] = true;	
						break;
					//홈런
					case 4:
						score++;
						for(int k=3; k>=1; k--) {
							//베이스 현황 보기
							if(base[k]) {
								score++;
								base[k] = false;
							}
						}
						break;
					}
					
					//아웃 카운트가 3개일 경우
					if(outCnt == 3) {
						start = j+1;	//다음 타자 세팅
						if(start == 10) start = 1;
						break outer;
					}
				}
				//타자를 1로 초기화
				//전부 안타를 쳐서 아웃되지 않으면 무한루프 이므로 다시 9까지 갔으면 다시 세팅
				start = 1;
			}
		}
		ans = Math.max(ans, score);
	}
}
