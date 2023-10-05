import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
    static int T, N, M;
    static int[][] memoi;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            memoi = new int[M+1][N+1];
            int ans = comb(M, N);
            sb.append(ans+"\n");
        }
        System.out.println(sb);
    }

    //거꾸로 끝->시작 구조이다.
    public static int comb(int srcIdx, int tgtIdx){
        //기저조건(시작에 도달)
        if(srcIdx == tgtIdx || tgtIdx == 0) 
            return memoi[srcIdx][tgtIdx] = 1;
        
        //풀이
        //만약 방문한 적 있으면 그대로 리턴
        if(memoi[srcIdx][tgtIdx] != 0) return memoi[srcIdx][tgtIdx];
        //아니라면 방문/비방문 모두 더해서 리턴
        return memoi[srcIdx][tgtIdx] = comb(srcIdx-1, tgtIdx) + comb(srcIdx-1, tgtIdx-1);
    }
}
