class Main:
    def __init__(self):
        self.n, self.target = map(int, input().split())
        self.arr = list(map(int, input().split()))
        self.answer = 0

    def dfs(self, temp, idx):
        if idx == self.n:
            return
        if temp+self.arr[idx] == self.target:
            self.answer += 1
        self.dfs(temp+self.arr[idx], idx+1)
        self.dfs(temp, idx+1)

    def solve(self):
        self.dfs(0, 0)
        print(self.answer)


problem = Main()
problem.solve()
