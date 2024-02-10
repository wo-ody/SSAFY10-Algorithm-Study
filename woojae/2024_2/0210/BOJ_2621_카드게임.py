class Main:
    def __init__(self):
        self.cards = [list(input().split()) for _ in range(5)]
        self.color = [i[0] for i in self.cards]
        self.number = [int(i[1]) for i in self.cards]
        self.color_cnt = {i[0]: 0 for i in self.cards}
        self.number_cnt = {int(i[1]): 0 for i in self.cards}
        self.answer = 0

    def cnt(self):
        for i in self.cards:
            self.color_cnt[i[0]] += 1
            self.number_cnt[int(i[1])] += 1

    def solve(self):
        self.cnt()
        temp_color = sorted(self.color_cnt.items(), key=lambda x: x[1])  # 카운팅 된 수 기준으로 오름차순
        temp_number = sorted(self.number_cnt.items(), key=lambda x: (x[1], x[0]))  # 카운팅된 수, 카드의 숫자 기준 오름차순

        for _ in range(8):
            if temp_color[-1][1] == 5 and sorted(self.number) == list(range(min(self.number), min(self.number) + 5)):
                self.answer = max(self.answer, 900 + max(self.number))
                break
            if temp_number[-1][1] == 4:
                self.answer = max(self.answer, 800 + temp_number[-1][0])
                break
            if temp_number[-1][1] == 3 and temp_number[-2][1] == 2:
                self.answer = max(self.answer, temp_number[-1][0] * 10 + temp_number[-2][0] + 700)
                break
            if temp_color[-1][1] == 5:
                self.answer = max(self.answer, 600 + max(self.number))
                break
            if sorted(self.number) == list(range(min(self.number), min(self.number) + 5)):
                self.answer = max(self.answer, max(self.number) + 500)
                break
            if temp_number[-1][1] == 3:
                self.answer = max(self.answer, temp_number[-1][0] + 400)
                break
            if len(temp_number) == 3 and temp_number[-1][1] == 2 and temp_number[-2][1] == 2:
                self.answer = max(self.answer, temp_number[-1][0] * 10 + temp_number[-2][0] + 300)
                break
            if temp_number[0][1] == 2 or temp_number[-1][1] == 2:
                if temp_number[0][1] == 2:
                    self.answer = max(self.answer, temp_number[0][0] + 200)
                elif temp_number[-1][1] == 2:
                    self.answer = max(self.answer, temp_number[-1][0] + 200)
                break
        if self.answer == 0:
            self.answer = max(self.answer, max(self.number) + 100)

        print(self.answer)


problem = Main()
problem.solve()
