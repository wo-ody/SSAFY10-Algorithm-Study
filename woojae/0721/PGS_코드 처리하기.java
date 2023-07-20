class Solution {
    public String solution(String code) {
        String ret = "";
        char[] arr = code.toCharArray();
        int len = arr.length;
        int mode = 0;
        for (int idx = 0; idx < len; idx++) {
            if (mode == 0) {
                if (arr[idx] == '1') {
                    mode = 1;
                    continue;
                }
                else {
                    if (idx % 2 == 0) {
                        ret += arr[idx];
                    }
                }
            }
            else {
                if (arr[idx] == '1') {
                    mode = 0;
                    continue;
                }
                else {
                    if (idx % 2 != 0) {
                        ret += arr[idx];
                    }
                }
            }
        }
        return ret.equals("") ? "EMPTY" : ret;
    }
}
