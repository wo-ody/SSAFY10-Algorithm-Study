import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            while (!s.isEmpty() && s.peek() <= tmp) {
                s.pop();
            }
            s.push(tmp);
//            System.out.println(s.size()-1);
            result += s.size() - 1;

        }

        System.out.println(result);

    }
}
