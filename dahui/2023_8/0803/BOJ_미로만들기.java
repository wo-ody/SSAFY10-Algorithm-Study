import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int num;
	static char[] charArr;
	static char road = '.';
	static char wall = '#';
	static char[][] map = new char[100][100];
	//남 서 북 동  ++오른쪽 회전 , --왼쪽회전
	static int[] dy = { 1, 0, -1, 0};
	static int[] dx = { 0, -1, 0, 1};
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		charArr = new char[num];
		String str = br.readLine();

		for(int i=0; i<num; i++) {
			charArr[i] = str.charAt(i);
		}
		
		int startY = 50;
		int startX = 50;
		
		map[startY][startX] = road;
		
		maze(startY, startX); //지도 만들기
		
		printMaze(); //벽 채우기
		System.out.println(sb);
		
	}
	
	static void maze(int Y, int X) {
		int nowDir = 0; //처음 방향은 남쪽
		int ny = Y;
		int nx = X;
		
		for(int i=0; i<num; i++) {
			char dir = charArr[i];

			if(dir == 'R') {
				if(nowDir == 3) { //방향 바꾸기
					nowDir = 0;
				} else {
					nowDir++;
				}
				
			} else if(dir == 'L') {
				if(nowDir == 0) { //방향 바꾸기
					nowDir = 3;
				} else {
					nowDir--;
				}
				
			} else { //F
				ny += dy[nowDir];
				nx += dx[nowDir];
				
				map[ny][nx] = road;
			}
		}
		
	}
	
	static void printMaze() {
		int minY = 99;
		int minX = 99;
		int maxY = 0;
		int maxX = 0;
		int tempX, tempY = 0;
		
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] == road) {
					tempY = i;
					tempX = j;
					
					maxY = Math.max(maxY, tempY);
					maxX = Math.max(maxX, tempX);
					minY = Math.min(minY, tempY);
					minX = Math.min(minX, tempX);
				}
			}
		}
	
		
		for(int i=minY; i<=maxY; i++) {
			for(int j=minX; j<=maxX; j++) {
				if(map[i][j] != road) {
					map[i][j] = wall;
				}
				
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}

	}
	
}
