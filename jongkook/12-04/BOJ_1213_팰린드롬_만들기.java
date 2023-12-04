package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1213_팰린드롬_만들기 {
    static char center;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        String str = br.readLine();
        Stack<Character> first = new Stack<>();
        Stack<Character> last = new Stack<>();

        // 문자열의 길이가 짝수일 때는 알파벳이 무조건 짝수여야한다.
        // 문자열의 길이가 홀수일 때는 알파벳이 하나만 홀수여야한다.

        for(int s = 0; s < str.length(); s++){
            char c = str.charAt(s);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);

        for(char key : map.keySet()){
            System.out.println("key: " + key + " value: " + map.get(key));
        }

        // 짝수라면
        if(str.length()%2 == 0){
            if(isEven(map)){
                for(char c : map.keySet()){
                    for(int n = 0; n < map.get(c)/2; n++){
                        first.push(c);
                        last.push(c);
                    }
                }
            }
            else{
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        else {
            if(isOdd(map)){
                for(char c : map.keySet()){
                    for(int n = 0; n < map.get(c)/2; n++){
                        first.push(c);
                        last.push(c);
                    }
                }
                first.push(center);
            }
            else{
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        while(!last.isEmpty()){
            first.push(last.pop());
        }
        for(char c : first) System.out.print(c);

    }
    static boolean isEven(HashMap<Character, Integer> map){
        for (char c : map.keySet()) {
            if(map.get(c)%2 != 0) return false;
        }
        return true;
    }

    static boolean isOdd(HashMap<Character, Integer> map){
        boolean valid = false;
        for (char c : map.keySet()) {
            if(map.get(c)%2 != 0){
                if(valid) return false;
                valid = true;
                center = c;
            }
        }
        return true;
    }
}
