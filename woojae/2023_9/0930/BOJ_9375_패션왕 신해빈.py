from collections import defaultdict

class main:
    def __init__(self):
        self.t = int(input())
        self.n = 0
        self.name = self.category = ""
        self.dict = None
        self.answer = 0

    def solve(self):
        for _ in range(self.t):
            self.n = int(input())
            self.dict = defaultdict(list)
            self.answer = 1
            for _ in range(self.n):
                self.name, self.category = input().split()
                self.dict[self.category].append(self.name)

            for i in self.dict.values():
                self.answer *= len(i) + 1
                # 주어진 TC를 예시로 각 카테고리별 선택할 수 있는 의상의 수를 집합으로 표현하면 다음과 같다.
                # {{hat}, {turban}, {null]} -> 같은 종류의 의상은 하나만 선택할 수 있으므로 주어진 길이, 그리고 입지 않은 경우도 포함
                # {{sunglasses}, {null}}
                # 이를 전체 집합으로 표현하면 아래와 같다.
                # {{hat, sunglasses}, {hat, null}, {turban, sunglasses}, {turban, null], {null, sunglasses}, {null}}
                # -> {{hat, sunglasses}, {hat}, {turban, sunglasses}, {turban], {sunglasses}, {null}}
                # 여기서 알몸인 상태 -> 즉 공집합을 빼줘야 하므로 마지막에 전체 원소의 개수 -1을 해줘야 한다.

            print(self.answer - 1)

problem = main()
problem.solve()
