import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//50년 후 인접한 세칸 or 네 칸에 바다가 있는 땅은 바다가 됨
//지도 밖도 바다로 취급
//50년 후의 지도의 크기 -> 모든 섬을 포함하는 가장 작은 직사각형
//출력 - 지도

public class BOJ_5212_지구온난화 {
	static int R, C;
	static char[][] map; //원본
	static char[][] changeMap; //바뀐 지도
	static char land = 'X';
	static char sea = '.';
	//하상좌우
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int minX, minY, maxX, maxY; //가장 바깥의 섬을 구할 좌표
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		changeMap = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				changeMap[i][j] = map[i][j];
			}
		}
		
		afterFifty(); //50년 후 땅 -> 바다
		reduction(); //맵을 줄일 좌표 가져오기
		printMap(); //맵 출력하기
		
	}
	
	static void afterFifty() {
		int ny = 0;
		int nx = 0;
		
		for (int i = 0; i < R; i++) {
			for(int j=0; j<C; j++) {
				int cnt = 0;
				for(int k=0; k<4; k++) {
					ny = i;
					nx = j;
					ny += dy[k];
					nx += dx[k];
					if(ny < 0 || nx < 0 || ny >= R || nx >= C) { //맵을 벗어나도 바다로 인식
						cnt++;
						continue;
					}
					if(map[ny][nx] == '.') {
						cnt ++;
						continue;
					}
				}
				
				if( cnt == 3 || cnt == 4) {
					changeMap[i][j] = '.';
				}
			}
		}
	}
	
	static void reduction() {
		minY = R;
		minX = C;
		int tempY = 0;
		int tempX = 0;
		for (int i = 0; i < R; i++) {
			for(int j=0; j<C; j++) {
				
				if(changeMap[i][j] == 'X') {
					tempY = i;
					tempX = j;
					
					maxY = Math.max(maxY, tempY);
					maxX = Math.max(maxX, tempX);
					minY = Math.min(minY, tempY);
					minX = Math.min(minX, tempX);
				}
				
			}
		}
	}
	
	static void printMap() {
		for (int i = minY; i <= maxY; i++) {
			for(int j = minX; j<= maxX; j++) {
				sb.append(changeMap[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
