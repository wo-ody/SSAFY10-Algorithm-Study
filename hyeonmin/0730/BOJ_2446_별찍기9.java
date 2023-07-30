import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2446_별찍기9 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		// 1 3 5 7 9         (2n-1) , n = 1 2 3 4 5
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < i; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < 2*(N-i)-1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N-1; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < 2*i+1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
