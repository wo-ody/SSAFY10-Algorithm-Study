import java.io.*;
import java.util.*;
 
public class BOJ_1051_숫자 정사각형 {
    static int N,M, ans=Integer.MIN_VALUE;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        int len = Math.min(N, M);
        
        while(len > 1) {
            for(int i=0; i<= N-len; i++) {
                for(int j=0; j<=M-len; j++) {
                    int num = map[i][j];
                    if(num==map[i][j+len-1] && num == map[i+len-1][j] && num == map[i+len-1][j+len-1]) {
                        System.out.println(len*len);
                        return;
                    }
                }
            }
            len--;
        }
        
        System.out.println(len*len);
        
    }
 
}
