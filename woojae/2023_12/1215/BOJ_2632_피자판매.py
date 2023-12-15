class Main:
    def __init__(self):
        self.target = int(input())
        self.a, self.b = map(int, input().split())
        self.a_pizza = [int(input()) for _ in range(self.a)]
        self.b_pizza = [int(input()) for _ in range(self.b)]
        self.answer = None

    def num_of_cases(self, pizza, pieces):
        for i in range(len(pizza)):  # 한 판의 피자 기준 피자 조각 인덱스
            size = 0
            for piece in range(1, len(pizza)):  # 선택된 인덱스의 피자를 시작으로 조각 선택 -> 피자는 연속적으로 선택해야 함
                size += pizza[(i + piece) % len(pizza)]  # 선택된 조각들의 사이즈 합, 피자는 순환 형태이므로 모듈러 연산 사용
                if size > self.target:  # 목표를 벗어나는 피자일 경우 다음 피자 탐색
                    break
                pieces[size] += 1

    def solve(self):
        a_total = sum(self.a_pizza)
        b_total = sum(self.b_pizza)
        a_pieces = [0 for _ in range(max(self.target, a_total)+1)]  # 피자 조각으로 고유 크기를 만들 수 있는 경우의 수
        b_pieces = [0 for _ in range(max(self.target, b_total)+1)]
        a_pieces[0], a_pieces[a_total] = 1, 1  # 피자 조각을 모두 고르지 않는 경우, 모두 고르는 경우
        b_pieces[0], b_pieces[b_total] = 1, 1

        self.num_of_cases(self.a_pizza, a_pieces)
        self.num_of_cases(self.b_pizza, b_pieces)

        self.answer = sum([a_pieces[i] * b_pieces[self.target-i] for i in range(self.target+1)])
        print(self.answer)


problem = Main()
problem.solve()
