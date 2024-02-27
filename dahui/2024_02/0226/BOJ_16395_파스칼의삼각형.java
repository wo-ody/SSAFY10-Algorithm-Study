import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16395_파스칼의삼각형 {
    static int n,k;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] tri = new int[n+1][n+1];
        tri[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
            }
        }
        System.out.print(tri[n][k]);
    }
}
