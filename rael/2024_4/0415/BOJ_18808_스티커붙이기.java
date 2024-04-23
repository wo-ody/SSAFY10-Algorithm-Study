import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18808_스티커붙이기 {
	static int N, M, K, ans=0;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];
		for (int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
            int[][] sticker = new int[r][c];
			for (int i=0; i<r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<c; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			find(sticker);
		}
		
		System.out.println(ans);
	}

	static void find(int[][] sticker) {
		int r = sticker.length;
		int c = sticker[0].length;
		
		for (int d=0; d<4; d++) {
			if(d != 0) sticker = rotate(sticker, r, c);
			r = sticker.length;
			c = sticker[0].length;

            //맵을 훑으며 붙일 공간 찾기
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (i+r > N || j+c > M)
						break;

					if (put(i, j, r, c, sticker)) {
						return;
					}
				}
			}
		}
	}

	static boolean put(int y, int x, int r, int c, int[][] sticker) {
        //붙일 수 있는지 확인
		for (int i=y; i<y+r; i++) {
			for (int j=x; j<x+c; j++) {
				if (map[i][j] && sticker[i-y][j-x] == 1)
					return false;
			}
		}

        //붙일 수 있다면 ans에 반영
		for (int i=y; i<y+r; i++) {
			for (int j=x; j<x+c; j++) {
				if(sticker[i-y][j-x] == 1) {
					map[i][j] = true;
					ans++;
				}
			}
		}

		return true;
	}

    // 90도 회전
	static int[][] rotate(int[][] sticker, int r, int c) {
		int[][] rotSticker = new int[c][r];

		for (int i=0; i<r; i++)
			for (int j=0; j<c; j++)
            rotSticker[j][r-i-1] = sticker[i][j];

		return rotSticker;
	}
}
