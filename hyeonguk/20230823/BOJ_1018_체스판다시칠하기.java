import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] chess;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chess = new char[N][M];

		for (int i = 0; i < N; i++) {
			chess[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				int startWhite = 0;
				int startBlack = 0;
				for(int a=i; a<i+8; a++) {
					for(int b=j; b<j+8; b++) {
						if((a+b)%2 == 0) {
							if(chess[a][b] != 'W') startWhite+=1;
							else startBlack+=1;
						}else {
							if(chess[a][b] != 'B') startWhite +=1;
							else startBlack+=1;
						}
					}
				}
				list.add(startWhite);
				list.add(startBlack);
			}
		}
		
		int size = list.size();
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<size; i++) {
			answer = Math.min(answer, list.get(i));
		}
		
		System.out.println(answer);
	}
}
