import math

def solution(routes):
    answer = 0
    routes.sort(key=lambda x: x[1]) # 진출 기준 정렬
    cctv = -math.inf

    for route in routes:
        if cctv < route[0]:  # 마지막으로 설치된 카메라가 진입 차량을 찍지 못 하는 위치라면
            answer += 1  # 추가 설치
            cctv = route[1]  # 위치 갱신 -> 진출에 설치해야 더 많은 범위를 커버 가능
    
    # 문제 애매함 -> 설치된 지역 이전 지역은 촬영 범위에 속해야 함
    return answer
