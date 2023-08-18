/*
 *  08.18 김창희
 *  BOJ_17135_캐슬디펜스
 *
 *  [풀이]
 *  1. 조합을 통해 3명의 궁수를 배치할 수 있는 경우를 구한다
 *  2. 조합을 구할때 마다 문제 조건에 맞게 적들을 공격한다
 *  3. 조합을 구할때 마다 새로운  map을 생성하지 않고 방문 배열로 처리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, d, answer,INF=Integer.MAX_VALUE;
	static int[] archer = new int[3];
	static int[][] map;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		setArcher(0, 0);
		System.out.println(answer);

	}

	public static void setArcher(int start, int depth) {
		if (depth == 3) {
			answer = Math.max(answer, attack());
			return;
		}
		for (int i = start; i < m; i++) {
			archer[depth] = i;
			setArcher(i + 1, depth + 1);
		}
	}

	public static int attack() {
		int result = 0;
		boolean[][] v= new boolean[n][m];
		for(int i =0; i<n; i++) {
			
			int[][] attackPoint = {{INF,INF,INF},{INF,INF,INF},{INF,INF,INF}};
			
			for(int x= 0; x<d; x++) {
				
				int nx = n-i-x-1;
				if(nx<0) break;
				
				for(int y=0; y<m; y++) {
					if(map[nx][y]==0 || v[nx][y]) continue;
					
					for(int a = 0; a<3; a++) {
						int dist = getDist(n-i, archer[a], nx,y);
						if(dist > d) continue;
						
						if(attackPoint[a][2]==dist &&attackPoint[a][0]>nx && attackPoint[a][1]>y) {
							attackPoint[a][0]= nx;
							attackPoint[a][1] = y;
						}
						
						else if(attackPoint[a][2]>dist) {
							attackPoint[a][0]= nx;
							attackPoint[a][1] = y;
							attackPoint[a][2] = dist;
						}
					}
				}
			}
			
			for(int a =0; a<3; a++) {
				int x= attackPoint[a][0];
				int y= attackPoint[a][1];
				int dist = attackPoint[a][2];
				if(dist!=INF && map[x][y] > 0 && !v[x][y]) {
					v[x][y] = true;
					result++;
				}
			}
		}
		
		return result;
	}

	public static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}
