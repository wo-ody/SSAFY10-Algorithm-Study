import sys
input = lambda: sys.stdin.readline().rstrip()


class Main:
    def __init__(self):
        self.a = self.b = self.c = 0
        self.dp = [[[0] * 21 for _ in range(21)] for _ in range(21)]  # 문제에서 0과 20이 넘을 때의 범위를 한정했으므로

    def w(self, a, b, c):
        if a <= 0 or b <= 0 or c <= 0:
            return 1
        if a > 20 or b > 20 or c > 20:
            return self.w(20, 20, 20)
        if self.dp[a][b][c]:  # 위 유효 범위를 위배되지 않았을 때
            return self.dp[a][b][c]
        if a < b < c:
            self.dp[a][b][c] = self.w(a, b, c-1) + self.w(a, b-1, c-1) - self.w(a, b-1, c)
        else:
            self.dp[a][b][c] = self.w(a-1, b, c) + self.w(a-1, b-1, c) + self.w(a-1, b, c-1) - self.w(a-1, b-1, c-1)
        return self.dp[a][b][c]

    def solve(self):
        while True:
            self.a, self.b, self.c = map(int, input().split())
            if self.a == self.b == self.c == -1:
                break
            print(f'w({self.a}, {self.b}, {self.c}) = {self.w(self.a, self.b, self.c)}')


problem = Main()
problem.solve()
