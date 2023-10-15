import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            int num;

            switch (order) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    dq.offer(num);
                    break;
                case "pop":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append(1).append("\n");
                    } else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(dq.isEmpty()){
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
            }
        }

        System.out.println(sb);
    }

}
