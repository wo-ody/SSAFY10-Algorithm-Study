class Main:
    def __init__(self):
        self.n = int(input())
        self.wine = [int(input()) for _ in range(self.n)]
        self.dp = [0] * self.n

    def solve(self):
        self.dp[0] = self.wine[0]
        if self.n > 1:  # n이 최소 1이므로 조건을 달아주거나 처음부터 각 리스트의 크기를 최대로 잡아줘야 함
            self.dp[1] = self.wine[1] + self.wine[0]
        if self.n > 2:
            self.dp[2] = max(self.wine[2] + self.wine[1],
                             self.wine[2] + self.wine[0],
                             self.dp[1])
            # 3번째 와인에서의 경우의 수:
            # 현재 잔 + 이전 잔
            # 첫 잔 + 현재 잔
            # 첫 잔 + 두 번째 잔 -> 현재 잔 선택 안 함
        for i in range(3, self.n):
            self.dp[i] = max(self.wine[i] + self.dp[i-2],
                             self.wine[i] + self.wine[i-1] + self.dp[i-3],
                             self.dp[i-1])
            # 다음 잔 부터 위와 동일한 경우의 수를 고려
            # 현재 잔 + 이전 잔 안 고르기 -> dp[-2]
            # 현재 잔 + 현재-1 + 그 이전 잔들의 누적 -> dp[-3]
            # 현재 잔 안 고르기

        print(max(self.dp))  # 각 잔에서 선택하는 경우의 수가 항상 최대를 보장하지 않으므로 -> 마지막 잔을 고르는 것이 필수가 아니므로


problem = Main()
problem.solve()
