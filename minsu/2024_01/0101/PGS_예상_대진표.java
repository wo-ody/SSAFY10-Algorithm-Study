class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // 한 게임에 들어있을 때 까지 반복
        while(a != b) {
			a = (a / 2) + (a % 2); //짝수면 나누기 2, 홀수면 나누기 2 + 1
			b = (b / 2) + (b % 2);
			
			answer++; //게임 수 증가
		}

        return answer;
    }
}
