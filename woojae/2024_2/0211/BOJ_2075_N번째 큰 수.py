import heapq

class Main:
    def __init__(self):
        self.n = int(input())
        # self.table = [list(map(int, input().split())) for _ in range(self.n)]

    def solve(self):  # 한 번에 다 입력 받으면 메모리 초과
        heap = []

        for _ in range(self.n):  # 지속적으로 heap을 n만큼 유지하다보면 제일 큰 n개의 수로 구성됨
            for i in map(int, input().split()):
                if len(heap) < self.n:
                    heapq.heappush(heap, i)
                else:
                    if i > heap[0]:
                        heapq.heappop(heap)
                        heapq.heappush(heap, i)

        print(heap[0])  # 이때 heap의 최소값은 n번 째 큰 수가 됨


problem = Main()
problem.solve()
