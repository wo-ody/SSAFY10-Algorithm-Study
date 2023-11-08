def convert_data(string_time):  # 문자열 시간 정수로 변환
    h, m = map(int, string_time.split(":"))
    return h * 60 + m

def solution(book_time):  # 부르트포스 -> 시간 매우 간당간당
    convert_time = []
    for s, e in book_time:
        convert_time.append([convert_data(s), convert_data(e)])
    
    last_time = max(convert_time, key=lambda x: x[1])[1] + 10  # 청소 시간 포함
    table = [[False] * last_time]  # 마지막 퇴실 시간 및 청소 시간을 기준으로 타임 테이블 생성
    convert_time.sort()  # 빠른 입실 시간 순으로 예약 정보 정렬
    
    for s, e in convert_time:
        for time in range(s, e + 10):  # 청소 시간이 포함된 기준으로
            num = 0  # 현재 시간대에 예약된 객실 수
            for i in range(len(table)):  # 현재 필요한 객실들을 모두 확인 
                if table[i][time]:  # 해당 객실의 해당 시간에 예약이 있다면
                    num += 1  # 예약된 객실 수 갱신
            if num == len(table):  # 예약된 객실의 수가 현재 확보한 객실의 수와 같다면
                table.append([False] * last_time)  # 새로운 객실 확보
            table[num][time] = True  # 해당 시간대에 예약 정보 반영
            
    answer = len(table)  # 최종 확보된 객실의 수
    return answer
