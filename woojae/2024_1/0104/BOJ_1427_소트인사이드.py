n = list(map(int, input()))
n.sort(reverse=True)
answer = ""
for i in n:
    answer += str(i)
print(answer)
