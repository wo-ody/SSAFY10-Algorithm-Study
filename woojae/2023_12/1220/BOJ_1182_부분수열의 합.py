class Main:
    def __init__(self):
        self.n, self.target = map(int, input().split())
        self.arr = list(map(int, input().split()))
        self.answer = 0

    def dfs(self, temp, idx):
        if idx == self.n:
            return
        if temp+self.arr[idx] == self.target:  # 이전까지 합산된 값 + 지금 선택된 값
            self.answer += 1
            # 리턴을 하지 않는 이유는 추후 나타날 값들에 의해 target과 일치하는 부분 수열이 나올 수 있으므로
            # 즉 일반적인 조합의 코드라면 몇 개를 선택할지 지정하고 지정된 숫자만큼 선택했을 때 합을 확인하면 되는데 반해
            # 해당 코드는 모든 조합을 다 찾아야 하므로 타겟이 일치한다고 해서 함수를 종료하면 안 됨
        self.dfs(temp+self.arr[idx], idx+1)
        self.dfs(temp, idx+1)

    def solve(self):
        self.dfs(0, 0)
        print(self.answer)


problem = Main()
problem.solve()
