import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798_세로읽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] A = new char[5][];
		for (int i = 0; i < 5; i++) {
			A[i] = br.readLine().toCharArray();
			
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				try {
					System.out.print(A[j][i]);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

}