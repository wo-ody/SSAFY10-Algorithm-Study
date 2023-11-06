class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.arr = [i for i in map(int, input().split())]
        self.visit = [False] * self.n
        self.answer = [0] * self.m

    def solve(self):
        self.arr.sort()
        self.perm(0)

    def perm(self, idx):
        if idx == self.m:
            print(*self.answer)
            return
        for i in range(self.n):
            if self.visit[i]:
                continue
            self.visit[i] = True
            self.answer[idx] = self.arr[i]
            self.perm(idx + 1)
            self.visit[i] = False


problem = main()
problem.solve()