class main:
    def __init__(self):
        self.n = int(input())
        self.m = int(input())
        self.s = input()
        self.answer = self.cur = self.cnt = 0

    def solve(self):
        while self.cur < self.m:
            if self.s[self.cur:self.cur + 3] == "IOI":  # 현재 커서 기준으로 3개씩 검사
                self.cnt += 1  # IOI의 수 갱신
                self.check()  # 찾아낸 IOI의 수를 검사해서 Pn이 만들어졌는지 검사
                self.cur += 2  # 기본적으로 3개의 문자열의 검사가 끝났으므로 2칸 이동
                # 3칸을 이동하지 않고 2칸을 이동하는 이유는 마지막 I에서 다시 IOI가 시작될 수 있기 때문
            else:
                self.cnt = 0  # IOI를 못 찾은 경우 처음부터 다시 검사해야 하므로 IOI의 수 초기화
                self.cur += 1  # 어디가 시작점인지 모르므로 한 칸씩 이동

        print(self.answer)

    def check(self):
        if self.cnt == self.n:  # n = cnt = IOI, 2n = 2cnt = IOIOI, 3n = 3cnt = IOIOIOI ...
            self.answer += 1  # n에 대응하는 IOI를 찾았다면 정답 갱신
            self.cnt -= 1  # 연속적인 IOI가 나온 경우, 마지막 I가 새로운 문자열의 시작하는 I가 되므로 이전에 계산한 값은 제외


problem = main()
problem.solve()
