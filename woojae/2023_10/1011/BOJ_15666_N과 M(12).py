class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.data = list(set(i for i in map(int, input().split())))  # 집합 자체에 중복은 먼저 제거돼야함
        self.visited = [False] * self.n
        self.answer = [0] * self.m

    def solve(self):
        self.data.sort()
        self.n = len(self.data)
        self.perm(0, 0)

    def perm(self, cur, pick_num):
        if pick_num == self.m:
            print(*self.answer)
            return
        for i in range(cur, self.n):
            self.answer[pick_num] = self.data[i]
            self.perm(i, pick_num+1)


problem = main()
problem.solve()
