class Main:
    def __init__(self):
        self.n, self.m = map(int, input().split())

    def comb(self, num: list):
        if len(num) == self.m:
            print(*num)
            return
        for i in range(1, self.n+1):
            num.append(i)
            self.comb(num)
            num.pop()  # 해당 숫자에 대한 처리가 끝났으면 리스트에서 제거

    def solve(self):
        for i in range(1, self.n+1):
            temp = [i]  # 새로운 숫자가 돌 때마다 리스트 초기화 해주지 않으면 이전 값이 그대로 이어짐
            self.comb(temp)


problem = Main()
problem.solve()
