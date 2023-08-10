import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] fibonacci0 = new int[41];
            int[] fibonacci1 = new int[41];
            fibonacci0[0] = 1;
            fibonacci0[1] = 0;
            fibonacci1[0] = 0;
            fibonacci1[1] = 1;
            for(int k = 2; k <= N; k++){
                fibonacci0[k] = fibonacci0[k-1] + fibonacci0[k-2];
                fibonacci1[k] = fibonacci1[k-1] + fibonacci1[k-2];
            }
            System.out.println(fibonacci0[N] + " " + fibonacci1[N]);
        }
    }
}