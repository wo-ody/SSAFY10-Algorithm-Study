import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	static int N;
	static int P[] = new int[1001];
	static int D[] = new int[1001];	// 수익

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		for (int i = 1; i <= N; i++)
		{
			
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= i; j++)
			{
				D[i] = Math.max(D[i], D[i-j] + P[j]);
			}
		}
		
		System.out.println(D[N]);
	}
}
