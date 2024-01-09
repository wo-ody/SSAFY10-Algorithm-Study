import java.util.*;

class Solution {
    static char[] tgt = {'+', '-', '*'};
    static long answer = 0;
    
    static ArrayList<Long> number;
    ArrayList<Character> opt;
        
    public long solution(String expression) {     
        //0. 초기화
        number = new ArrayList<>();
        opt = new ArrayList<>();
        
        //1. 문자열에서 숫자 분리
        String num = "";
        for(int i=0; i<expression.length(); i++){
            //숫자일때만 추가
            char c = expression.charAt(i);
            if(c >= '0' && c <= '9')
                num += c;
            //아니면 기호
            else {
                //숫자 끝이므로 숫자 추가
                number.add(Long.parseLong(num));
                num = "";   //초기화
                opt.add(c);
            }
        }
        //마지막 숫자 넣어줘야함
        number.add(Long.parseLong(num));
        
        //2. 연산자 순서 정하기 -> 순열
        //연산자 순서에 따라 순서도 바뀌어야 함..!!
        perm(number, opt, 0);
        
        return answer;
    }
    
    //순서 변경 함수
    static public void swap(int a, int b){
        char temp = tgt[a];
        tgt[a] = tgt[b];
        tgt[b] = temp;
    }
    
    //3. 연산자 순서대로 계산하기 -> abs 할 것!
    //연산자 순서 정해주기
    static public void perm(ArrayList<Long> number, ArrayList<Character> opt, int idx){
        //기저조건: 연산자가 3개임
        if(idx == 3){
            //연산자 순서대로 연산 진행
            long res = Cal((ArrayList<Long>)number.clone(), (ArrayList<Character>)opt.clone());
            answer = Math.max(answer, res);
            return;
        }
        
        for(int i=idx; i<3; i++){
            swap(i, idx);   //순서 변경
            perm(number, opt, idx+1);
            swap(i, idx);   //원복
        }
    }
    
    //바뀐 연산자의 우선 순위에 따라 연산 진행
    static public long Cal(ArrayList<Long> number, ArrayList<Character> opt){
        //각 연산자 별로 진행해야 하므로 3개의 케이스
        for(int i=0; i<3; i++){
            //연산자 몇 개인지 모르니까 연산자 배열 돌면서 확인
            for(int j=0; j<opt.size(); j++){
                //연산자 순서대로 진행
                if(tgt[i] == opt.get(j)){
                    switch(tgt[i]){
                        case '+':
                            //연산한 숫자는 합쳐져야 하므로 list 내에서 합치는 걸로
                            number.add(j, number.remove(j)+number.remove(j));
                            break;
                        case '-':
                            number.add(j, number.remove(j)-number.remove(j));
                            break;
                        case '*':
                            number.add(j, number.remove(j)*number.remove(j));
                            break;
                    }
                    opt.remove(j);
                    j--; //연산자 하나 빼줬으니까 j도 하나 앞으로 옮겨주기
                }
            }
        }
        //모든 연산이 끝나면 1개의 숫자만 남는다.
        return Math.abs(number.get(0));
    }
}
