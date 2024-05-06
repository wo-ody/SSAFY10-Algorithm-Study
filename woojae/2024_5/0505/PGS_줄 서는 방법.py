def solution(n, k):
    arr = [i for i in range(1, n + 1)]
    answer = []

    while arr:
        x = math.factorial(n - 1)
        a = (k - 1) // x
        answer.append(arr.pop(a))

        k %= x
        n -= 1

    return answer
