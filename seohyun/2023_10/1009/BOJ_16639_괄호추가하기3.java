import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] number;
    static char[] op;

    static int[] tgt_op;
    static boolean[] visited;

    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N/2][2];
        op = new char[N/2];

        String str = br.readLine();
        
        if(N == 1) {
            System.out.println(str);
            return;
        }

        int op_idx = 0;
        for (int i = 0; i < N; i++) {
            if(i % 2 != 0) {
                op[op_idx] = str.charAt(i);
                number[op_idx][0] = str.charAt(i-1) - '0';
                number[op_idx][1] = str.charAt(i+1) - '0';
                op_idx++;
            }
        }

        tgt_op = new int[N/2];
        visited = new boolean[N/2];

        perm(0);

        System.out.println(result);


    }
    static int cal(int a, int b, char op){
        int result = 0;
        switch (op){
            case '-' :
                result =  a - b;
                break;
            case '+' :
                result =  a + b;
                break;
            case '*' :
                result =  a * b;
                break;
        }

        return result;
    }
    static int simulation(){
        boolean[] visited = new boolean[N/2];
        int[] values = new int[N/2];

        values[tgt_op[0]] = cal(number[tgt_op[0]][0],number[tgt_op[0]][1],op[tgt_op[0]]);
        visited[tgt_op[0]] = true;

        for (int i = 1; i < N/2; i++) {
            int idx = tgt_op[i];
            // 0 일때
            if (idx == 0) {
                if (visited[idx + 1]) {
                    values[idx] = cal(number[idx][0], values[idx + 1], op[idx]);
                    int tidx = idx + 1;
                    if(tidx >= N/2) continue;
                    while(visited[tidx]) {
                        values[tidx++] = values[idx];
                        if(tidx >= N/2) break;
                    }
                } else {
                    values[idx] = cal(number[idx][0], number[idx][1], op[idx]);
                }
                visited[idx] = true;
            }
            // N/2 일때
            else if (idx == N / 2 - 1) {
                if (visited[idx - 1]) {
                    values[idx] = cal(values[idx - 1],number[idx][1], op[idx]);
                    int tidx = idx -1;
                    if(tidx < 0) continue;
                    while(visited[tidx]) {
                        values[tidx--] = values[idx];
                        if(tidx < 0) break;
                    }
                } else {
                    values[idx] = cal(number[idx][0], number[idx][1], op[idx]);
                }
                visited[idx] = true;
            } else {
                if (visited[idx - 1] && !visited[idx + 1]) {
                    values[idx] = cal(values[idx - 1], number[idx][1], op[idx]);
                    int tidx = idx -1;
                    if(tidx < 0) continue;
                    while(visited[tidx]) {
                        values[tidx--] = values[idx];
                        if(tidx < 0) break;
                    }
                } else if (!visited[idx - 1] && visited[idx + 1]) {
                    values[idx] = cal(number[idx][0], values[idx + 1], op[idx]);
                    int tidx = idx + 1;
                    if(tidx >= N/2) continue;
                    while(visited[tidx]) {
                        values[tidx++] = values[idx];
                        if(tidx >= N/2) break;
                    }
                } else if (!visited[idx - 1] && !visited[idx + 1]) {
                    values[idx] = cal(number[idx][0], number[idx][1], op[idx]);
                } else {
                    values[idx] = cal(values[idx - 1], values[idx + 1], op[idx]);
                    int tidx = idx -1;
                    if(tidx < 0) continue;
                    while(visited[tidx]) {
                        values[tidx--] = values[idx];
                        if(tidx < 0) break;
                    }
                    tidx = idx + 1;
                    if(tidx >= N/2) continue;
                    while(visited[tidx]) {
                        values[tidx++] = values[idx];
                        if(tidx >= N/2) break;
                    }
                }
                visited[idx] = true;
            }
        }

        return values[tgt_op[N/2-1]];
    }

    static void perm(int cnt){
        if(cnt == N/2){
            result = Math.max(result, simulation());
            //System.out.println(result);
            return;
        }

        for (int i = 0; i < N/2; i++) {
            if(visited[i]) continue;
            tgt_op[cnt] = i;
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }

    }
}
