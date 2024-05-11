def solution(order):
    # 첫 컨테이너 벨트 = 큐
    # 보조 컨테이너 벨트 = 스택
    # 첫 -> 보조 -> 싣지 않음
    answer = 0
    order = deque(order)
    main_belt = deque(range(1, len(order) + 1))
    temp_belt = []

    while main_belt or temp_belt:
        if main_belt:  # 메인 컨테이너 벨트에 택배가 있을 경우
            if order[0] != main_belt[0]:  # 택배가 싣은 택배가 아니라면
                temp_belt.append(main_belt.popleft())  # 임시 컨테이너 벨트로 이동
            else:  # 맞다면
                order.popleft()  # 싣어야 할 택배 목록에서 택배 제거
                main_belt.popleft()  # 택배 제거
                answer += 1  # 싣은 택배 수 갱신
        else:  # 메인 벨트에 더 이상 택배가 없다면
            if order[0] != temp_belt[-1]:  # 위 종료 조건에 의해 임시 컨테이너 벨트에는 무조건 택배가 있는 상황
                break  # 그 상황에서 싣을 택배가 아니라면 더 이상 싣을 수 있는 택배들이 아니기 때문에 종료
        if temp_belt:  # 임시 컨테이너에 벨트에 택배가 있을 경우
            if order[0] == temp_belt[-1]:  # 택배가 싣을 택배라면
                order.popleft()  # 싣어야 할 택배 목록에서 택배 제거
                temp_belt.pop()  # 택배 제거
                answer += 1  # 싣은 택배 수 갱신

    return answer
