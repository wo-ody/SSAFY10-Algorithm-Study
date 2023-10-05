class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        char[] my = my_string.toCharArray();
        char[] overwrite = overwrite_string.toCharArray();
        int len = overwrite.length;
        for (int i = s; i < s + len; i++)
        {
            my[i] = overwrite[i - s];
        }
        String answer = new String(my);
        return answer;
    }
}
