class Main:
    def __init__(self):
        self.n = int(input())
        self.arr = list(map(int, input().split()))
        self.answer = 0

    def solve(self):
        check = dict()
        for i in self.arr:
            if i not in check:  # 수열이 가지고 있는 수들의 개수를 체크하기 위한 딕셔너리
                check[i] = 1

        high = 0
        for low in range(self.n):
            while high < self.n:
                if check[self.arr[high]] > 1:  # 중복되는 수가 있는 경우
                    break
                check[self.arr[high]] += 1
                high += 1
            self.answer += high - low  
            # 중복이 발생된 지점(high) - 현재 커서 -> -1을 안 해줘도 되는 이유는 이미 인덱스가 0부터 시작하기 때문
            check[self.arr[low]] -= 1
        print(self.answer)
        # 예제 2기준 첫 중복이 발견되는 시점에서 연속된 수를 뽑을 수 있는 경우의 수는 1, 12, 123 => 3개
        # high - low = 3


problem = Main()
problem.solve()
