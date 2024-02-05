package algorithm2024.jan.day08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class PG_완주하지못한선수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //HashMap 사용 ( 동명이인이 존재하는 경우가 있으므로 등장횟수를 Value로 저장)
        Map<String, Integer> map = new HashMap<>();

        //participant 값을 map 에 삽입, 이미 존재하면 기존의 등장 횟수 +1 저장
        for (String s : participant) {
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }
        //completion 값을 보고 이미 존재하면 등장횟수 -1 저장, 등장횟수가 0이 되면
        //해당 선수가 모두 완주했다는 의미이므로 맵에서 삭제
        for (String s : completion) {
            int cnt = map.get(s);
            if(cnt==1){
                map.remove(s);
            }else{
                map.put(s,map.get(s)-1);
            }
        }
        //최종적으로 1명만 남게 되므로 iterator로 탐색 ( 어차피 1번만 탐색함 )
        for (String s : map.keySet()) {
            answer = s;
        }
        return answer;
    }
}
