import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public int solution(int n, int k) {
        // n을 k진수로 만든 함수
        getBinary(n, k);
        // n을 k진수로 만든 값을 sb에 저장 후 로직수행
        return countPrime(sb.toString());
    }
  
    // k진수로 만드는 함수
    void getBinary(int n, int k){
        // n이 0이 되면 재귀 종료 
        if(n <= 0) return;
        // 문자열 제일 앞자리에 n을 k로 나눈 나머지를 삽입
        sb.insert(0,n % k);
        // n을 k로 나눈 값으로 다시 재귀 돌림
        getBinary(n/k, k);
    }
    
    int countPrime(String str){
        char[] chrs = str.toCharArray();
        // 문자열 내부에서 소수가 몇개인지 찾기
        int count = 0;
        // 여기서 sb는 함수 내부에서 사용할 sb
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char chr = chrs[i];
            // 0을 만났을 때
            // sb.length() 가 0이라면 에러가 발생하기 때문에 추가적으로 조건 기입
            if(chr == '0' && sb.length() != 0){
                // 해당 문자열이 소수인가 아닌가를 판단하여 count를 ++
                if(isPrime(sb.toString())) count++;
                // sb 초기화
                sb.setLength(0);
            }
            // 0을 만나지 않았을 때 문자열에 삽입
            else if (chr != '0') sb.append(chr);
        }

        // 0을 만날때만 문자열을 체크하기 때문에
        // sb에 값이 남아있을 수 있음
        // 마지막으로 체크하고 소수판별
        if(sb.length() != 0) if(isPrime(sb.toString())) count++;
        return count;
    }
    
    boolean isPrime(String primes){
        int len = primes.length();
        // 1번이랑 11번 테스트 케이스라 런타임 에러가 뜬 원흉
        // n을 k진수로 만든 값이 int의 범위를 넘어갈 수 있기 때문
        // long으로 바꾸고 해결
        // 데이터 범위를 확실히 체크하자... ㅠㅠ
        long number = Long.parseLong(primes);
        
        if(number < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++) if(number % i == 0) return false;
        
        return true;
    }
}
