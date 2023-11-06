class Main:
    def __init__(self):
        self.n = int(input())
        self.cord = [list(map(int, input().split())) for _ in range(self.n)]
        self.stack = [0]
        self.answer = 0

    def solve(self):
        for i in self.cord:
            height = i[1]
            if self.process(height):  # 새로운 건물이 있다면 처리 후 다음 건물의 정보를 받아옴
                continue
            while self.stack and self.stack[-1] > height:  # 들어온 건물의 층이 현재 건물보다 낮다면
                self.stack.pop()  # 들어오니 건물의 층이 높아질 때까지 정보 제거
            self.process(height)  # 정보 제거가 완료된 시점에서의 건물의 층이 들어온 건물의 층보다 높다면 다시 처리
        print(self.answer)

    def process(self, height):  # 메인 로직 -> 중복된 코드 방지를 위해 별도의 메서드로 분리
        if self.stack[-1] < height:  # 현재 들어온 값보다 더 큰 값을 만나면 새로운 건물로 간주
            self.stack.append(height)
            self.answer += 1
            return True


problem = Main()
problem.solve()
