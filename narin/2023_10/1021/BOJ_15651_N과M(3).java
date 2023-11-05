import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] result;
    private static StringBuilder sb;

    private static void comb(int index, int count){

        if(count==M){

            for(int r: result){
                sb.append(r+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =1; i<=N; i++){
            result[count] = i;
            comb(i, count+1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        comb(1, 0);

        System.out.println(sb);
    }
}
