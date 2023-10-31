package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BOJ_9935_문자열_폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String exp = br.readLine();
        Stack<Character> stack = new Stack<>();
        Stack<Character> wareHouse = new Stack<>();
        for(int c = 0; c < str.length(); c++){
            stack.add(str.charAt(c));
            if(stack.size() >= exp.length()){
                if(stack.get(stack.size()-1) == exp.charAt(exp.length()-1)){
                    for(int e = exp.length() - 1; e >= 0; e--){
                        char chr = stack.pop();
                        wareHouse.add(chr);
                        if(chr == exp.charAt(e)) continue;
                        while(!wareHouse.isEmpty()) stack.add(wareHouse.pop());
                    }
                }
                wareHouse.clear();
            }
        }
        if(!stack.isEmpty()) for(Character c : stack) sb.append(c);
        else {
            System.out.println("FRULA");
            return;
        }
        System.out.println(sb);
    }
}
