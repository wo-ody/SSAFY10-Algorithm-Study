class Solution {
    public String solution(String code) {
        String ret = "";
        char[] arr = code.toCharArray();
        int len = arr.length;
        int mode = 0;
        for (int idx = 0; idx < len; idx++) {
            if (arr[idx] == '1') {  // 현재 code 값이 1일때
                mode = (mode == 0) ? 1 : 0;  // 현재 mode 값에 따라 mode 값 갱신
                continue;
            }
            if (idx % 2 == mode)  // 현재 code 값이 1이 아닐때 idx가 mode와 같다면(짝수일 땐 나머지가 0, 홀수일 땐 1)
                ret += arr[idx];  // ret의 마지막에 해당 값 추가
        }
        return ret.equals("") ? "EMPTY" : ret;  // 빈 문자열 여부 확인 후, 리턴 값 선택
    }
}
