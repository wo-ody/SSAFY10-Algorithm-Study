class Main:
    def __init__(self):
        self.n = int(input())
        self.comb = []
        self.num = list(range(10))
        self.result = []

    def solve(self):
        for i in range(1, 11):  # 10개의 수로 만들 수 있는 수의 조합을 모두 구함
            self.comb = [0 for _ in range(i)]
            self.combination(0, 0)

        print(sorted(self.result)[self.n] if len(self.result)-1 >= self.n else -1)  # 경우의 수보다 크다면 알 수 없음
        # 경우의 수와 n이 같을 때 n번째 값을 선택하면 인덱스 에러가 발생하기 때문에(마지막 인덱스는 길이보다 1 작으므로) -1을 해줌

    def combination(self, idx, target):
        if len(self.comb) == target:
            temp = list(map(str, reversed(self.comb)))  # 증가하는 수를 만들기 위해 역순 정렬 후 문자열 리스트로 변환
            temp = "".join(temp)  # 문자열로 이루어져 있어야 join 가능
            self.result.append(int(temp))  # 다시 정수로 변환 -> 모든 수들을 오름차순 정렬하기위해
            return
        if idx == 10:
            return
        self.comb[target] = self.num[idx]
        self.combination(idx + 1, target + 1)
        self.combination(idx + 1, target)


problem = Main()
problem.solve()
