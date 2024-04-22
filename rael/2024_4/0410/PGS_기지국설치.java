class Solution {
    public int bsearch(int begin, int end, int w) {
        int res = (end - begin + 1) / (2 * w + 1);
        if((end - begin + 1) % (2 * w + 1) > 0) res++;
        return res;
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int begin = 1;
        for(int i = 0; i < stations.length; i++) {
            if(begin < stations[i] - w)
                answer += bsearch(begin, stations[i] - w - 1, w);
            begin = stations[i] + w + 1;
        }
        if(stations[stations.length - 1] + w < n)
            answer += bsearch(stations[stations.length - 1] + w + 1, n, w);
        return answer;
    }
}
