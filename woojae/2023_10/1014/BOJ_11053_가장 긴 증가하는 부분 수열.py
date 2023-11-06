class Main:
    def __init__(self):
        self.n = int(input())
        self.a = list(map(int, input().split()))
        self.dp = [1] * self.n

    def solve(self):
        for i in range(1, self.n):
            for j in range(i):  # 처음 값부터 i번째 값까지 증가하는 수열 탐색
                if self.a[j] < self.a[i]:
                    self.dp[i] = max(self.dp[i], self.dp[j]+1)  # i번째일 때 만들어지는 최대 길이 저장
                    # 이미 만들어진 길이가 최대면 자기자신 아니라면 현재 인덱스부터 i번째일 때 만들어지는 최대 길이 저장

        print(max(self.dp))


problem = Main()
problem.solve()
