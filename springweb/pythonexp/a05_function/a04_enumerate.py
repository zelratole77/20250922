'''
# 내장 함수 enumerate()
1. 이 함수는 파이썬에서 반복문을 사용할 때 가장 많이 사랑받는 도구 중 하나입니다.
    열거하다라는 사전적 의미 그대로, 데이터에 자동으로 번호를 매겨주는 아주 똑똑한 비서같은 존재죠.
2. 개요
    enumerate() 는 파이썬의 내장함수로 리스트, 튜플, 문자열과 같은 반복 가능한(Iterable)객체를 입력
    으로 받습니다. 이 함수는 데이터의 값만 넘겨주는 것이 아니라, 현재 몇 번째 순서인지를 나타내는
    인덱스(Index)를 값과 함께 묶어서 돌려줍니다.
3. 이해를 돕기 위한 내용
    여러분은 지금 마라톤 대회의 진행 요원입니다. 선수들이 한 명씩 결승선을 통과하고 있어요
    단순 for문 : 철수 들어왔다!, 영희 들어왔다! 민수 들어왔다. (이름만 외침)
    enumerate 사용 : 1등 철수, 2등 영희, 3등 민수 (순위와 이름을 같이 외침)

    단순히 이름만 아는 것보다, 그 선수가 몇 번째로 들어왔는지(인덱스)를 동시에 아는 것이 훨씬
    정보 가치가 높겠죠?
    enumerate는 바로 그 등수 표지만을 들고 서 있는 도우미입니다.
4. 핵심 기능 및 속성
    1) 튜플 반환 : 각 반복마다 (인덱스, 요소값) 형태의 튜플을 생성합니다.
    2) 언패킹(Unpacking) : for i, value in enumerate(data): 와 같이 두개의 변수로 바로 나누어
        받을 수 있습니다.
    3) 시작 번호 저장(start 인자) : 컴퓨터는 0부터 세는 걸 좋아하지만, 사람은 1부터 세는 걸 좋아하죠.
        enumerate(data, start=1) 처럼 시작 숫자를 마음대로 바꿀 수 있습니다.
'''
idols = ['뉴진스', '아이브', '에스파']
for rank, name in enumerate(idols, start=1):
    print(f'현재 차트 {rank}위: {name}')
# ex1) 카페에 온 손님 리스트가 있습니다. enumerate를 사용하여 대기 번호가 현재 5번부터 시작한다고
#     하여, 해당 손님이 대기번호와 이름을 아래와 같이 출력하세요
#    @@번 손님: @@@님, 주문하신 커피 나왔습니다.
customers = ['민수', '철수','영희', '하니']
for cnt, cust in enumerate(customers, start=5):
    print(f"대기번호:{cnt}번, 이름:{cust}")
# ex2) 학생이 제출한 답안 리스트와 실제 정답 리스트가 있습니다. enumerate를 활용해서 틀린 문제가
#  몇 번 문제인지 번호를 출력해보고, 총점을 소숫점 1자리로 출력해보세요
student_answers = ['A','C','B','D','A']
correct_answers = ['A','B','B','D','A']
# 출력  1번 정답 
#       2번 오답
#      ..   
#      총 @@문제중 @@ 정답 @@ 오답   점수 @@@
tot_an = len(student_answers)
tot_cor = 0
for idx, st_an in enumerate(student_answers):
    eval = "오답"
    if st_an == correct_answers[idx]:
        eval = "정답"
        tot_cor +=1
    print(f'{idx+1}번 {eval}')   
tot_pt = tot_cor/tot_an*100
print(f'총 {tot_an} 문항 중 {tot_cor}개 정답, {tot_an-tot_cor}개 오답, 점수:{tot_pt:.1f}점')    




