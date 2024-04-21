package algorithm2024.jan.day16;

import java.util.*;

class PGS_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i : lost){
            set.add(i);
        }
        for(int i : reserve){
            set.add(i);
        }
        System.out.println(set);
        boolean[] v = new boolean[n+1];
        n -= set.size();

        Arrays.sort(reserve);
        Arrays.sort(lost);

        int cnt = 0;
        loop:
        for(int i = 0;i<reserve.length;i++){
            if(v[reserve[i]])continue;
            cnt++;
            v[reserve[i]] = true;
            for(int j= 0;j<lost.length;j++){
                if(lost[j]==reserve[i]){
                    continue loop;
                }
            }
            for(int j= 0;j<lost.length;j++){
                if(Math.abs(reserve[i]-lost[j])==1&&!v[lost[j]]){
                    cnt++;
                    v[lost[j]] = true;
                    continue loop;
                }
            }

        }

        return cnt+n;
    }
}
