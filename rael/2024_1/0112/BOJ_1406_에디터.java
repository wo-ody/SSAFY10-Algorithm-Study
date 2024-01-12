import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            leftStack.push(s.charAt(i));
        }
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            if (c == 'P') {
                leftStack.push(command.charAt(2));
            } else if (c == 'L' && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            } else if (c == 'D' && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            } else if (c == 'B' && !leftStack.isEmpty()) {
                leftStack.pop();
            }
 
        }
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb.toString());
 
    }
 
}
