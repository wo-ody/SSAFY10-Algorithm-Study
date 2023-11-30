class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        int temp = 0;
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");

        if(answer.length() == 0 ) {
            answer = "aaa"; 
        } else if(answer.length() > 15) {
            answer = answer.substring(0, 15);
        } else if(answer.length() > 0 && answer.length() < 3) {
            temp = answer.length();
            //concat함수를 사용하면 새로운 인스턴스를 생성하기 때문에 성능면에서는 떨어지는듯
            while(temp < 3) {
                answer += answer.substring(answer.length()-1);
                temp++;
            }
        }
        
        answer = answer.replaceAll("^[.]|[.]$", "");
        //길이가 3글자가 안된다면 마지막 문자를 3글자가 될 때까지 for문으로
        return answer;
    }
}
