import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class test {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    Integer n = q.poll();
                    if(n == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(n).append('\n');
                    }
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    Integer num = q.peek();
                    if(num == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(num).append('\n');
                    }
                    break;
                case "back":
                    Integer n2 = q.peekLast();
                    if(n2 == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(n2).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
