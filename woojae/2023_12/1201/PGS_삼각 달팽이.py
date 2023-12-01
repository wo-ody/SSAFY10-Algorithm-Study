def solution(n):
    slug = [[0] * n for _ in range(n)]
    y, x = -1, 0 
    num = 1

    for i in range(n):
        for _ in range(i, n):  # 하, 좌, 좌상의 반복적인 움직임을 수행하며 각 움직임에서 움직이는 횟수는 n에서 0까지 -1씩 갱신 
            if i % 3 == 0:
                y += 1
            elif i % 3 == 1:
                x += 1
            elif i % 3 == 2:
                y -= 1
                x -= 1

            slug[y][x] = num 
            num += 1
    
    return [num for i in slug for num in i if num != 0]
