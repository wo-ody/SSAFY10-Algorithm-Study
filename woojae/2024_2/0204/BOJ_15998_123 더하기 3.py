import sys
input = lambda: sys.stdin.readline().rstrip()


class Main:
    def __init__(self):
        self.t = int(input())
        self.test_case = [int(input()) for _ in range(self.t)]
        self.max_case = max(self.test_case)
        self.dp = [0] * (self.max_case+1)

    def solve(self):
        self.dp[1], self.dp[2], self.dp[3] = 1, 2, 4

        for i in range(4, self.max_case+1):
            self.dp[i] = (self.dp[i-3] + self.dp[i-2] + self.dp[i-1]) % 1000000009

        for i in self.test_case:
            print(self.dp[i])


problem = Main()
problem.solve()
