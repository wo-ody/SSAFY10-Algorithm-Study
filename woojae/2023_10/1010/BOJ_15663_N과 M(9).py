class main:
    def __init__(self):
        self.n, self.m = map(int, input().split())
        self.data = list(i for i in map(int, input().split()))
        self.visited = [False] * self.n
        self.answer = [0] * self.m
        self.check = dict()

    def solve(self):
        self.data.sort()
        self.perm(0)

    def perm(self, cur):
        if cur == self.m:
            if not self.check.get(str(self.answer), 0):  # 문자열로된 리스트 키가 딕셔너리에 없다면 0을 반환해서 추가해줌
                self.check[str(self.answer)] = 1  # 키로 리스트를 추가할 수 없어서 문자열로 변환함
            else:  # 0이 아닌 값을 반환하면 있다는 의미 -> 중복된다는 소리이므로 종료
                return
            print(*self.answer)  # 종료되지 않았다면 해당 값 출력
            return
        for i in range(self.n):
            if self.visited[i]:
                continue
            self.visited[i] = True
            self.answer[cur] = self.data[i]
            self.perm(cur+1)
            self.visited[i] = False


problem = main()
problem.solve()