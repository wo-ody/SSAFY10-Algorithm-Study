class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        if(arr.length == 1) return arr[0]; //원소가 한 개인 경우 바로 출력

        int g = gcd(arr[0], arr[1]); //처음 두 원소의 최대공약수
        answer = (arr[0] * arr[1]) / g; //처음 두 원소의 최소공배수

        /*  
        원소의 개수가 3개 이상인 경우
        앞의 두 원소의 최소 공배수와 다음 원소의 최소 공배수를 구하며
        배열의 끝까지 반복
        */ 
        if(arr.length > 2) { 
            for(int i = 2; i < arr.length; i++) {
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }

        return answer;
    }

    //최대 공약수
    private static int gcd(int a, int b) {
        int r = a % b;
        if(r == 0) return b;
        else return gcd(b, r);
    }
}
