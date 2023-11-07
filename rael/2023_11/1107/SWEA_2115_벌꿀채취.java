package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2115_벌꿀채취 {
	static int T, N, M, C;
	static int map[][];
	static int res, maxHoney;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			//초기 값 초기화
			res = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			//입력받기
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//풀이
			solve();
			
			sb.append("#").append(t)
			  .append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	static void solve() {
		int max1 = 0, max2 = 0;		//각 일꾼의 최대 벌꿀 채취량
		
		//벌꿀 채취 왼쪽 위부터 시작
		for(int i=0; i<N; i++) {
			//일꾼 2가 이어받아서 M만큼 탐색할 거기 때문에 범위 줄여준다.
			for(int j=0; j<=N-M; j++) {
				//초기값 초기화
				maxHoney=0;
				//일꾼 1 벌꿀 채취 레쭈고
				getMaxHoney(i, j, 0, 0, 0);		//현재 좌표, 탐색한 벌통 수, 채취한 꿀, 얻은 이득
				max1 = maxHoney;
				
				//일꾼 2 벌꿀 채취 고고(겹치면 안 되니까 그거 주의해서!)
				maxHoney=0;
				max2 = 0;		//일꾼 1 값 변했으니까 다시 초기화
				//일꾼 1이 딴 벌꿀 보다 다음 벌꿀 따기
				for(int j2=j+M; j2<=N-M; j2++) {
					getMaxHoney(i, j2, 0, 0, 0);
					max2 = Math.max(max2, maxHoney);
				}
				
				//일꾼 2는 다른 행에서 벌꿀을 얻을 수도 있다.
				for(int i2=i+1; i2<N; i2++) {
					for(int j2=0; j2<=N-M; j2++) {
						getMaxHoney(i2,j2,0,0,0);
						max2 = Math.max(max2, maxHoney);
					}
				}
				
				//두 일꾼이 모두 꿀을 수확했다면 최대값 비교
				res = Math.max(res, max1+max2);
			}
		}
	}
	
	static void getMaxHoney(int y, int x, int cntHouse, int cntHoney, int profit) {
		//채취한 꿀이 채취 제한량을 넘었다면 종료
		if(cntHoney > C) return;
		//벌통을 모두 채웠다면 최대 이익 갱신
		if(cntHouse == M) {
			maxHoney = Math.max(profit, maxHoney);
			return;
		}
		
		//위의 경우 모두 아니라면 벌통 선택/비선택 진행
		getMaxHoney(y,x+1,cntHouse+1,cntHoney+map[y][x],profit+(map[y][x]*map[y][x]));	//선택
		getMaxHoney(y,x+1,cntHouse+1,cntHoney,profit);		//비선택(벌통은 왜 선택?->연속되어야 하므로)
		
		
	}
}
