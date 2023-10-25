class Main:
    def __init__(self):
        self.n, self.m, self.l, self.k = map(int, input().split())
        self.cord = [list(map(int, input().split())) for _ in range(self.k)]
        self.answer = 0

    def solve(self):
        # 탐색 범위 지정 -> 좌표들은 모두 1사분면에 위치함
        # 다만 모든 좌표의 범위를 다 탐색할 수 없음
        # -> 주어진 좌표들을 기준으로 x의 좌표에 모든 y 좌표를 대입하여 좌표 조합을 생성하여 조합들만 탐색
        for x, _ in self.cord:  # 존재하는 x 좌표들에 대해서
            for _, y in self.cord:  # 존재하는 y 좌표들을 대입
                bounded_star = 0  # 좌표가 주어질 때마다 초기화
                for star_x, star_y in self.cord:  # 만들어진 조합의 범위 내에 별들이 있는지 확인
                    if x <= star_x <= x + self.l and y <= star_y <= y + self.l:  # 좌측하단 좌표 기준 트램펄린 전개 ↑→방향
                        # 별은 모서리에 부딪혀도 튕겨나감: <=
                        bounded_star += 1
                self.answer = max(self.answer, bounded_star)  # 가장 많이 튕겨낸 별의 수 갱신
                    
        print(self.k - self.answer)  # 튕겨내지 못한 별의 수


problem = Main()
problem.solve()
