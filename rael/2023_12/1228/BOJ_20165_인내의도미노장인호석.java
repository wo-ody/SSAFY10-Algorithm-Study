import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, cnt;
	static int dr[] = { 0, 0, 1, -1 };//오 왼 하 상
	static int dc[] = { 1, -1, 0, 0 };
	static int map[][];
	static char state[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		R = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		state = new char[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
				state[i][j] = 'S';
			}
		}
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int cr = Integer.valueOf(st.nextToken()) - 1;
			int cc = Integer.valueOf(st.nextToken()) - 1;
			int d = checkDir(st.nextToken().charAt(0));
			attack(cr, cc, d);
			st = new StringTokenizer(in.readLine(), " ");
			cr = Integer.valueOf(st.nextToken()) - 1;
			cc = Integer.valueOf(st.nextToken()) - 1;
			defense(cr,cc);
		}
		System.out.println(cnt);
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(state[i][j]+" ");
			}
			System.out.println();
		}
	}

	static int checkDir(char cs) {
		if (cs == 'E') {
			return 0;
		} else if (cs == 'W') {
			return 1;
		} else if (cs == 'S') {
			return 2;
		} else if (cs == 'N') {
			return 3;
		}
		return 0;
	}

	static void attack(int cr, int cc, int d) {
		if (state[cr][cc] == 'F') {
			return;
		} else {
			int size = map[cr][cc] - 1;
			state[cr][cc] = 'F';
			cnt++;
			while (size > 0) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					return;
				}
				if (state[nr][nc] == 'F') {
					size--;
					cr = nr;
					cc = nc;
					continue;
				}
				size--;
				state[nr][nc] = 'F';
				int newSize = map[nr][nc] - 1;
				cr = nr;
				cc = nc;
				cnt++;
				size = newSize > size ? newSize : size;
			}
		}
	}
	static void defense(int cr, int cc) {
		if(state[cr][cc]=='F') {
			state[cr][cc] = 'S';
		}else {
			return;
		}
	}
}
