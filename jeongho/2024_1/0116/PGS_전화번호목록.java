package algorithm2024.jan.day17;


import java.util.*;

public class PGS_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        //정렬해서 사용
        Arrays.sort(phone_book);
        HashSet<String> set = new HashSet<>();

        //접두어를 길이별로 모두 셋에 존재하는지 확인
        //존재한다면 answer 갱신하고 전체 loop 종료
        //존재하지 않으면 set에 넣고 다음 문자열 탐색
        loop:
        for(String s: phone_book){
            for(int i =1;i<=s.length();i++){
                String substr = s.substring(0,i);
                if(set.contains(substr)){
                    answer = false;
                    break loop;
                }
            }
            set.add(s);
        }

        return answer;
    }
}
