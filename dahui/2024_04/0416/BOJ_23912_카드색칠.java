import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24912_카드색칠 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] card = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = true;

        if (N == 1) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) System.out.println(1);
            else System.out.println(num);
        }else {
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                card[i] = num;
                if (i!=0) if (card[i-1] == card[i] && card[i] != 0) flag = false;
            }

            if (flag) {
                if (card[0] == 0) {
                    if (card[1] == 1) card[0] = 2;
                    else card[0] = 1;
                }
                sb.append(card[0]).append(" ");

                for (int i = 1; i < N-1; i++) {
                    if (card[i] == 0) {
                        if (card[i-1] == 0 && card[i+1] == 0) {
                            card[i] = 1;
                        }else if((card[i-1] == 1 && card[i+1] == 2) ||
                                (card[i-1]== 2 && card[i+1] == 1)) card[i] = 3;
                        else if((card[i-1] == 3 && card[i+1] == 2) ||
                                (card[i-1]== 2)) card[i] = 1;
                        else card[i] = 2;
                    }
                    sb.append(card[i]).append(" ");
                }

                if (card[N-1] != 0) sb.append(card[N-1]);
                else {
                    if (card[N-2] == 1) sb.append(2);
                    else sb.append(1);
                }

            } else sb.append(-1);
            System.out.println(sb);
        }
    }
}
