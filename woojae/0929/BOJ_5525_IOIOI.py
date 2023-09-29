n = int(input())
m = int(input())
s = input()
answer = 0
low = high = 0

while high < m:
    temp = s[high:high+3]
    if temp == "IOI":
        high += 2
        if high - low == 2 * n:
            answer += 1
            low += 2
    else:
        high += 1
        low = high


print(answer)
