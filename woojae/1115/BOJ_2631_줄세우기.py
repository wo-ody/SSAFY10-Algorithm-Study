class Main:
    def __init__(self):
        self.n = int(input())
        self.arr = [int(input()) for _ in range(self.n)]
        self.check = [1] * self.n  # 초기 값은 자기 자신

    def solve(self):
        for i in range(self.n):
            for j in range(i):  # 끝나는 범위를 증가시키며 갱신
                if self.arr[j] < self.arr[i] and self.check[i] < self.check[j] + 1:  
                    # 기준값(i: 끝값)이 더 크고 해당 지점(j) 기준으로 가장 긴 수열 + 기준값이 기준값까지의 수열보다 길다면 
                    # 예를 들어, 3 -> 6은 6의 시점에서 2, 5 -> 6은 5의 경우 이미 3을 내포하고 있기 때문에 자기 자신을 포함하면 
                    # 3 -> 6보다 5를 채택하여 3 -> 5 -> 6의 수열을 만들어 증가 수열의 길이를 갱신하는 것이 이득이다.
                    self.check[i] = self.check[j] + 1  # 수열 길이 갱신

        print(self.n - max(self.check))  # 최장증가수열의 원소들은 자리를 바꿀 필요가 없는 녀석들이므로 나머지 녀석들만 이동시키면 됨


problem = Main()
problem.solve()
