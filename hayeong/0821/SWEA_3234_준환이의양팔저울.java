import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3234_준환이의양팔저울 {
    static int N, ans;
    static int[] src;
    static int[] tgt;
    static boolean selected[];
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<= T; t++){
            // 입력 및 초기화
            ans = 0;
            N = Integer.parseInt(br.readLine());
            src = new int[N];
            tgt = new int[N];
            selected = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                src[i] = Integer.parseInt(st.nextToken());
            }

            // 각 순열을 구함
            perm(0);
            // 정답 출력
            sb.append("#").append(t).append(" ").append(ans).append('\n');

        }
        System.out.println(sb.toString());
    }

    static void perm(int tgtIdx){
        if(tgtIdx == N){
            // complete code;
            // 정해진 순서에 대해 양팔 저울 어느쪽에 추를 올릴 수 있는지 개수 세기
            subset(0, 0, 0);
            return;
        }
        for(int i = 0; i<N; i++){
            if(selected[i]) continue;
            tgt[tgtIdx] = src[i];
            selected[i] = true;
            perm(tgtIdx +1);
            selected[i] = false;
        }
    }

    static void subset(int idx, int left, int right){
        if(left < right) return; // 만약 오른쪽이 더 무거우면 답이 될 수 없음

        if(idx == N){ // 추를 모두 올렸다면, 오른쪽이 더 가벼운 무게로 모든 추를 올린 것이므로
            ans++; // 정답개수를 세어주고 리턴
            return;
        }
        // 왼쪽에 추를 올림
        subset(idx+1, left+tgt[idx], right);
        // 오른쪽에 추를 올림
        subset(idx+1, left, right+tgt[idx]);
    }
}
