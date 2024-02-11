import java.util.*;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public int solution(int n, int k) {
        getBinary(n, k);
        return countPrime(sb.toString());
    }
    
    void getBinary(int n, int k){
        if(n <= 0) return;
        sb.insert(0,n % k);
        getBinary(n/k, k);
    }
    
    int countPrime(String str){
        char[] chrs = str.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char chr = chrs[i];
            if(chr == '0' && sb.length() != 0){
                if(isPrime(sb.toString())) count++;
                sb.setLength(0);
            }
            else if (chr != '0') sb.append(chr);
        }
        
        if(sb.length() != 0) if(isPrime(sb.toString())) count++;
        return count;
    }
    
    boolean isPrime(String primes){
        int len = primes.length();
        long number = Long.parseLong(primes);
        
        if(number < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++) if(number % i == 0) return false;
        
        return true;
    }
}
