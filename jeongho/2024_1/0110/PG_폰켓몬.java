package algorithm2024.jan.day09;

import java.util.HashSet;
import java.util.Set;

public class PG_폰켓몬 {


    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int N = nums.length;
        int cnt = 0;
        loop:
        for(int p : nums)
        {
            if(!set.contains(p)){
                cnt++;
                set.add(p);
                if(cnt==N/2) break loop;
            }
        }
        return cnt;
    }
}
