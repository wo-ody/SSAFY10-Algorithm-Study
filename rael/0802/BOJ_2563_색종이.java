import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//0802 BOJ_2563_색종이
public class Main {
	static int paperSize = 100;		//도화지 사이즈
	static int colorSize = 10;		//색종이 사이즈
	static boolean[][] paper;
	static int[][] xy;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//색종이의 수
		int N = Integer.parseInt(br.readLine());
		paper = new boolean[paperSize][paperSize];
		
		//색종이 입력
		xy = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				xy[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int l=xy[i][1]; l<colorSize+xy[i][1]; l++) {
				for(int m=xy[i][0]; m<colorSize+xy[i][0]; m++) {
					paper[l][m] = true;
				}
			}
		}
		
		int cnt=0;
		for(int i=0; i<paperSize; i++) {
			for(int j=0; j<paperSize; j++) {
				if(paper[i][j]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
