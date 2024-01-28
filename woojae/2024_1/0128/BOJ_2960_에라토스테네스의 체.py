class Main:
    def __init__(self):
        self.n, self.k = map(int, input().split())
        self.checked = [True] * (self.n+1)
        self.cnt = 0

    def solve(self):
        for i in range(2, self.n+1):
            for j in range(i, self.n+1, i):
                if self.checked[j]:
                    self.checked[j] = False
                    self.cnt += 1
                    if self.cnt == self.k:
                        print(j)


problem = Main()
problem.solve()
