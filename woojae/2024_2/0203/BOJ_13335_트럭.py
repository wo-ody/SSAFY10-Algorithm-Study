from collections import deque


class Main:
    def __init__(self):
        self.n, self.w, self.l = map(int, input().split())  # 트럭의 수, 다리의 길이, 다리의 최대 하중
        self.trucks = list(map(int, input().split()))

    def solve(self):
        answer = 0
        waiting = deque(self.trucks)  # 큐 -> 대기중인 트럭
        bridge = deque(0 for _ in range(self.w))  # 다리
        wait_sum = 0

        while waiting:  # 다리를 지나야 하는 트럭이 남아있다면
            wait_sum -= bridge.popleft()  # 다리의 맨 앞이 트럭이라면 빠져나와야 함
            if wait_sum + waiting[0] > self.l:  # 현재 다리에 실린 무게와 앞으로 들어올 트럭의 무게의 합이 초과된다면
                bridge.append(0)
            else:
                truck = waiting.popleft()  # 대기중인 트럭을 빼서
                wait_sum += truck  # 무게 갱신
                bridge.append(truck)  # 다리에 트럭 추가
            answer += 1  # 모든 동작이 끝나면 항상 1초가 소요

        answer += self.w  # 다리에 남은 트럭들이 다리를 빠져나가는 시간은 다리의 길이만큼 소요됨
        print(answer)


problem = Main()
problem.solve()
