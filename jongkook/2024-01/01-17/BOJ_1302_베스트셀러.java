package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ_1302_베스트셀러 {
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int n = 0; n < num; n++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        String str = "";
        for(String key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                str = key;
            }
        }
        System.out.println(str);

    }
}
