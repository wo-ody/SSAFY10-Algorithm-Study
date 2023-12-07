import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String first = "";
    static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        first = br.readLine();

        for (int i = 0; i < N-1; i++) {
            String s = br.readLine();

            HashMap<Character,Integer> left = new HashMap<>();
            HashMap<Character,Integer> right = new HashMap<>();

            make_hashMap(left,first);
            make_hashMap(right,s);

            Set<Character> sss = right.keySet();
            for(Character c : right.keySet()){
                if(left.containsKey(c)){
                    int left_cnt = left.get(c);
                    int right_cnt = right.get(c);
                    int min_value = Math.min(left_cnt,right_cnt);

                    left.put(c, left_cnt - min_value);
                    right.put(c, right_cnt - min_value);
                }
            }

            int left_size = 0;
            int right_size = 0;
            for(Integer n : left.values()) left_size += n;
            for(Integer n : right.values()) right_size += n;

            // left, right 확인
            if(left_size == right_size){
                if(left_size == 0 || left_size == 1) result++;
            }
            else if(left_size + right_size == 1) result++;
        }

        System.out.println(result);
    }

    static void make_hashMap(HashMap<Character,Integer> map, String str){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(map.containsKey(c)){
                int cnt = map.get(c);
                map.put(c,cnt + 1);
            }
            else{
                map.put(c,1);
            }
        }
    }
}
