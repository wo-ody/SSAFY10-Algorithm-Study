class Main:
    def __init__(self):
        self.n = int(input())
        self.dp = [''] * 1001

    def solve(self):
        self.dp[1], self.dp[2], self.dp[3] = 'SK', 'CY', 'SK'

        for s in range(4, self.n+1):
            self.dp[s] = 'CY' if self.dp[s-1] == 'SK' or self.dp[s-3] == 'SK' else 'SK'

        print(self.dp[self.n])


problem = Main()
problem.solve()
