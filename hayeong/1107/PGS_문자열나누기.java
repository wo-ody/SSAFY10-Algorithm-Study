public class 문자열나누기 {

    public int solution(String s) {
        int answer = 0;
        char first = ' ';
        int sCnt = 0;
        int dCnt = 0;
        for(char c : s.toCharArray()){
            if(first == ' '){
                first = c;
                sCnt++;
                continue;
            }

            if(first != c){
                dCnt++;
            } else sCnt++;

            if(sCnt == dCnt){
                answer++;
                first = ' ';
                sCnt = 0;
                dCnt = 0;
            }

        }
        if(first != ' ') answer++;
        return answer;
    }
}
