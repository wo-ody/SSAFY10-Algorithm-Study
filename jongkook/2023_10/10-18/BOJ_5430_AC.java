import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> dq = new ArrayDeque<>();
    static int T;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            String command = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            char[] data = new char[temp.length() - 2];
            for(int d =0; d < temp.length() - 2; d++) data[d] = temp.charAt(d+1);
            StringTokenizer st = new StringTokenizer(new String(data), ",");

            while(st.hasMoreTokens()) dq.addLast(Integer.parseInt(st.nextToken()));
            boolean dir = true;
            for(int c = 0; c < command.length(); c++){
                char mission = command.charAt(c);
                switch (mission) {
                    case 'R':
                        dir = !dir;
                        break;
                    // true 라면 정방향
                    // false 라면 역방향
                    case 'D':
                        if(dir) dq.pollFirst();
                        else dq.pollLast() ;
                        break;
                }
            }

            if(dq.isEmpty()) sb.append("error").append("\n");
            else if (dir){
                sb.append("[");
                while(dq.size() != 1) sb.append(dq.pollFirst()).append(",");
                sb.append(dq.pollFirst()).append("]").append("\n");
            }
            else{
                sb.append("[");
                while(dq.size() != 1) sb.append(dq.pollLast()).append(",");
                sb.append(dq.pollLast()).append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
