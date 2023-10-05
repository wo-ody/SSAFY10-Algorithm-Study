class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] str1_arr = str1.toCharArray();  // 문자열을 배열로 변환, Python의 list(문자열)과 동일
        char[] str2_arr = str2.toCharArray();
        int total_len = str1.length() + str2.length();  // 결과물 문자열의 전체 길이
        char[] temp = new char[total_len];  // 새로운 문자 배열 생성
        
        for (int i = 0; i < total_len / 2 ; i++)  // 결과적으로 길이가 str1 = str2이며 해당 길이만큼 반복하면 됨
        {
            temp[i * 2] = str1_arr[i];  // 인덱스에 2를 곱해주지 않으면 다음 인덱스에 값이 겹쳐짐
            temp[i * 2 + 1] = str2_arr[i];
        }
        answer = new String(temp);  // 문자 배열을 하나의 문자열로 변환 , Python의 ''.join(문자열)
        return answer;
    }
}
