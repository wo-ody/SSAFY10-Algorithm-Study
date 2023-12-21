class Main:
    def __init__(self):
        self.s = input()
        self.t = input()

    def solve(self):
        while len(self.t) != len(self.s):  # 완성된 t를 기준으로 원점으로 돌리기
            if self.t[-1] == 'A':  # 문자열 뒤에 A를 추가한다.
                self.t = self.t[:-1]
            else:  # 문자열을 뒤집고 뒤에 B를 추가한다.
                self.t = self.t[:-1]
                self.t = self.t[::-1]

        print(1 if self.t == self.s else 0)


problem = Main()
problem.solve()

