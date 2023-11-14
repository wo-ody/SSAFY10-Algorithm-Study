class Main:
    def __init__(self):
        self.str1 = input()
        self.str2 = input()
        self.answer = 0

    def solve(self):
        check = [0] * max(len(self.str1), len(self.str2))

        for i in range(len(self.str1)):
            lcs = 0  # 비교 문자가 바뀔 때마다 가장 긴 공통부분 수열 길이 초기화
            for j in range(len(self.str2)):
                if lcs < check[j]:  # 현재 가장 긴 공통부분 수열의 길이 기록
                    lcs = check[j]
                elif self.str1[i] == self.str2[j]:
                    check[j] = lcs + 1

        print(max(check))


problem = Main()
problem.solve()
