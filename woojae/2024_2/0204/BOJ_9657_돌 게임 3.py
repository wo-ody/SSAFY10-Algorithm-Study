class Main:
    def __init__(self):
        self.n = int(input())
        self.dp = [''] * 1001

    def solve(self):
        self.dp[1], self.dp[2], self.dp[3], self.dp[4] = 'SK', 'CY', 'SK', 'SK'

        for s in range(5, self.n+1):
            self.dp[s] = 'CY' if self.dp[s-1] == self.dp[s-3] == self.dp[s-4] == 'SK' else 'SK'

        print(self.dp[self.n])


problem = Main()
problem.solve()
