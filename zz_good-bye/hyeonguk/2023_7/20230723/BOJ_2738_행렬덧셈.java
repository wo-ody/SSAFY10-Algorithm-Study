import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[N][M];
		int[][] arr2 = new int[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr1[i][j] = Integer.parseInt(tmp.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			StringTokenizer tmp = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr2[i][j] = Integer.parseInt(tmp.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr1[i][j]+arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		br.close();
	}
}
