package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1394_암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Integer> map = new HashMap<>();
        String part = br.readLine();
        for(int c = 0; c < part.length(); c++) map.put(part.charAt(c), c+1);
        String key = br.readLine();
        System.out.println(breakPassword(key, map));
    }
    static int breakPassword(String key, HashMap<Character, Integer> map){

        int len = key.length();
        int result = 0;

        for(int i = 0; i < len-1; i++){
            result += (int) Math.pow(map.size(),len-1-i) * map.get(key.charAt(i)) ;
        }
        return (result + map.get(key.charAt(len-1))) % 900528;
    }
}
