import sys
input = lambda: sys.stdin.readline().rstrip()


class Main:
    def __init__(self):
        self.n, self.k = map(int, input().split())
        self.scores = [float(input()) for _ in range(self.n)]

    def solve(self):
        self.scores.sort()
        print('%.2f' % (sum(self.scores[self.k:self.n-self.k]) / (self.n-self.k*2)+0.00000001))

        for i in range(self.k):
            self.scores[i] = self.scores[self.k]
            self.scores[-i-1] = self.scores[-1-self.k]

        print('%.2f' % (sum(self.scores) / self.n+0.00000001))


problem = Main()
problem.solve()
