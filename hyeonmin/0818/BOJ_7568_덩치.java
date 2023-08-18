import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] people = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken());	//키
			people[i][1] = Integer.parseInt(st.nextToken());	//몸무게
		}
		for (int i = 0; i < N; i++) {
			int ans = 1;
			
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					ans++;
				}
			}
			bw.write(ans + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
