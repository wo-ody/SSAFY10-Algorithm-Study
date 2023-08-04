import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16235_나무재테크 {
	
	static int N,M,K;
	static int[][] feed;
	static int[][] add_feed;
	static List<Integer>[][] map ;
	
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		feed = new int[N][N];
		add_feed = new int[N][N];
		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) Arrays.fill(feed[i], 5);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				add_feed[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			map[x][y].add(z); // 나이만 넣깅
		}
		
		// 초기 양분 5 채우기
		for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) feed[i][j] = 5;
		
		solve();
	}
	
	public static void spring_summer() {
		List<Integer>[][] tmp = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].size() == 0) continue;
				
				int origin_feed = feed[i][j];
				feed[i][j] = 0;
				
				// 나이 적은 순으로 정렬
				Collections.sort(map[i][j], new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o1 - o2;
					}
					
				});
				// 나이 증가해서 새로 넣기
				for (Integer age : map[i][j]) {
					if(origin_feed - age >= 0) {
						origin_feed -= age; // 자신의 나이만큼 양분 먹고
						tmp[i][j].add(age + 1); // 나이 1 증가
					}
					else {
						feed[i][j] += age / 2; // 죽은 나무 양분 바로 넣어주기
					}
				}
				feed[i][j] += origin_feed;
				
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[i][j];
			}
		}
		
	}
	
	public static void fall() {
		List<Integer>[][] tmp = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = new ArrayList<>(map[i][j]); // 객체 생성하면서 바로 깊은복사 수행
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				tmp[i][j] = Arrays.copyOf(map[i][j],map[i][j].size());
//			}
//		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].size() == 0) continue;
				for (Integer age : map[i][j]) {
					if(age % 5 == 0) {
						for (int k = 0; k < 8; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							tmp[nx][ny].add(1);
						}
					}
					
				}
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[i][j];
			}
		}
	}
	
	public static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				feed[i][j] += add_feed[i][j];
			}
		}
	}
	
	public static int get_tree() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += map[i][j].size();
			}
		}
		return cnt;
	}
	public static void solve() {
		for (int i = 0; i < K; i++) { // 
			spring_summer();
			fall();
			winter();
		}
		System.out.println(get_tree());
	}
	

}
