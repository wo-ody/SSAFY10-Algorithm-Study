class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.arr = [i for i in map(int, input().split())]
        self.visited = [False] * self.n
        self.answer = [0] * self.m

    def solve(self):
        self.arr.sort()
        self.perm(0, 0)

    def perm(self, cnt, cur):
        if cnt == self.m:
            print(*self.answer)
            return
        for i in range(cur, self.n):
            self.answer[cnt] = self.arr[i]
            self.perm(cnt + 1, i)  # cnt 0 -> 1 -> .. m 도달 후, 다시 0인 시점으로 돌아와 cursor 변경


problem = main()
problem.solve()