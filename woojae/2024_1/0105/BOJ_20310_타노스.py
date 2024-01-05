class Main:
    def __init__(self):
        self.s = input()
        self.check = [True] * len(self.s)
        self.answer = ''

    def solve(self):
        zero = self.s.count('0') // 2
        one = self.s.count('1') // 2
        cnt_zero = cnt_one = 0

        for i in range(len(self.s)):
            if self.s[i] == '1':
                cnt_one += 1
                self.check[i] = False
            if cnt_one == one:
                break

        for i in range(len(self.s)-1, -1, -1):
            if self.s[i] == '0':
                cnt_zero += 1
                self.check[i] = False
            if cnt_zero == zero:
                break

        for i in range(len(self.s)):
            if self.check[i]:
                self.answer += self.s[i]

        print(self.answer)


problem = Main()
problem.solve()
