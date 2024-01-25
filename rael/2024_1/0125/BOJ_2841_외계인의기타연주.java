import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N, P, answer;    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);
        
        Stack<Integer>[] stack = new Stack[7];
        for (int i = 1; i < 7; i++) {
            stack[i] = new Stack<Integer>();
        }
    
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int line = Integer.parseInt(input[0]);    // 줄 번호
            int fret = Integer.parseInt(input[1]);  // 플랫 번호
            
            while (!stack[line].isEmpty()) {
                // 스택에 들어있는 fret보다 입력받은 fret이 큰 경우 push
                if (stack[line].peek() < fret) {
                    stack[line].push(fret);
                } 
                // 스택에 들어있는 fret보다 입력받은 fret이 작은 경우 pop
                else if (stack[line].peek() > fret){
                    stack[line].pop();
                } else {
                    break;
                }
                answer += 1;
            }
            
            // 해당 줄의 스택이 비어있는 경우
            if (stack[line].isEmpty()) {
                stack[line].push(fret);
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
