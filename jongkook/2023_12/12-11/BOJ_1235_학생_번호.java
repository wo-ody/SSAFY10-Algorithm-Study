package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1235_학생_번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = new String[n];
        for(int i = 0; i < n; i++) nums[i] = br.readLine();
        int res = 0;
        for(int i = nums[0].length()-1; i >= 0; i--){
            Set<String> set = new HashSet<>();
            for(int j = 0; j < n; j++){
                StringBuilder sb = new StringBuilder();
                for(int k = nums[0].length()-1; k >= i; k--) sb.append(nums[j].charAt(k));
                set.add(sb.toString());
            }
            if(set.size() == n){
                System.out.println(++res);
                return;
            }
//            System.out.println(set);
            res++;
        }
        System.out.println(res);
    }
}
