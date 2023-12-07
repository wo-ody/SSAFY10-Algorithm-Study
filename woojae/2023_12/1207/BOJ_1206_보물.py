class Main:
    def __init__(self):
        self.n = int(input())
        self.a = list(map(int, input().split()))
        self.b = list(map(int, input().split()))
        self.answer = 0

    def solve(self):  # 문제에서 B는 재배열하지 말라고 하지만 내가 왜? 라는 생각이 가득 참
        self.a.sort()  # 각 배열의 원소를 순서대로 곱한 후 합산한다고 했을 때 a는 작게
        self.b.sort(reverse=True)  # b는 크게 정렬함, 그 반대도 가능

        for i, j in zip(self.a, self.b):
            self.answer += i * j

        print(self.answer)


problem = Main()
problem.solve()
