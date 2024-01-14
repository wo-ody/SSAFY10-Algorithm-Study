import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//스택구조에 쌓으면서 같은 단어를 만나면 지우는 식으로 진행
//최종적으로 스택이 비어 있다면 좋은 단어
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, ans;
    static Deque<Character> stack = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int length = s.length();
            //홀수인 경우는 짝이 맞을 수 없으니 그냥 넘어감
            if (length % 2 == 1)
                continue;
            char[] word = s.toCharArray();
            for (int j = 0; j < length; j++) {
                if (stack.isEmpty())//스택이 비어있는 경우는 그냥 스택에 넣음
                    stack.push(word[j]);
                else {
                    char temp = stack.pop();
                    if (temp != word[j]) {
                        stack.push(temp);
                        stack.push(word[j]);
                    }
                }
            }
            if (stack.isEmpty())
                ans++;
            stack.clear();
        }
        System.out.println(ans);
    }
}