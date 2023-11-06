class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.check = []

    def solve(self):
        self.dfs(1)

    def dfs(self, num):
        if len(self.check) == self.m:  # 탐색된 수들의 개수가 m이라면
            print(*self.check)
            return  # 탐색 종료

        for i in range(num, self.n + 1):  # 주어진 각 수에서 1 ~ n까지 모두 도는 것이 아니라 주어진 각 수(num) ~ n까지 돌아야 함
            self.check.append(i)  # 체크, 중복된 수가 필요하므로 visit 필요 없음
            self.dfs(i)  # 체크된 수부터 다시 탐색
            self.check.pop()  # 탐색완료 했으므로 값 제거


problem = main()
problem.solve()
