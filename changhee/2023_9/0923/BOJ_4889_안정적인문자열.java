import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int tc=1;
        while(true){
            String input = br.readLine();
            if(input.charAt(0)=='-') break;

            Stack<Character> stack= new Stack<>();
            char[] arr = input.toCharArray();
            int n = arr.length;

            for(int i =0; i<n; i++){
                if(stack.isEmpty()){
                    stack.push(arr[i]);
                    continue;
                }

                if(stack.peek()=='{' && arr[i]=='}'){
                    stack.pop();
                }else{
                    stack.push(arr[i]);
                }
            }

            int result=0;
            while(!stack.isEmpty()){
                char op1= stack.pop();
                char op2= stack.pop();
                if(op1==op2){
                    result++;
                }else{
                    result+=2;
                }
            }
            if(!stack.isEmpty()) result+=stack.size()/2;
            answer.append(tc++).append(".").append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }
}
