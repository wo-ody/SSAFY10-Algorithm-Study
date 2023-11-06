n = int(input())
arr = sorted(list(map(int, input().split())))
answer = 2000000

for i in range(n):
    answer = min(answer, arr[i] + arr[-i-1])
print(answer)
