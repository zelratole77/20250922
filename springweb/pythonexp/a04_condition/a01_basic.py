'''
# 조건문 처리
1. 파이썬에서 사용하는 특징적인 조건문 반복형태에 사용하는 block지정 방식과
    기본적인 조건문 형식을 사용해봅시다.
2. 파이썬 블럭(block)처리 방식
    1) 코드를 의미 있는 덩어리로 묶는 방식은 대부분 언어에서는 {} 중괄호 블럭을 사용하지만, 파이썬에서는
    들어쓰기(indent)를 활용한다.
    2) 즉, 같은 간격으로 줄이 맞춰진 코드는 한 가족입니다. 한 명이라도 줄을 못 맞추면 파이썬은 넌
    어느 가족이니?라고 물으며 에러를 냅니다.
    3) 콜론(:)은 자, 이제부터 새로은 가족(블럭)이 시작된다!라고 선언하는 출입문입니다.
3. 기본형식
    1) if 
    if 조건문 :
        처리할내용1
        처리할내용2  ==> 같은 블럭안에는 동일 indent(들어쓰기처리) - 필수
    else :
        처리할내용3
        처리할내용4
    2) if elif
    if 조건문1 :
        처리내용1
    elif 조건문2 :
        처리내용2
    else :
        처리내용3
4. 핵심 코드
    1) 콜론(:) - 조건식 끝에는 반드시 콜론(:)을 찍는다.(문이 열린다는 신호)
    2) if(만약에) - 조건이 시작됨을 알립니다.
    3) elif(그게 아니라 만약에) - 첫번째 조건이 아닐 때, 다른 조건을 확인합니다.(else if의 줄임말)
    4) else(그것도 아니라면) - 앞의 모든 조건에 해당하지 않을 때 실행됩니다.        
'''
# 나이에 따른 입장 가능 여부 판단
age = 15
if age>=12:
    print("놀이기구에 탑승할 수 있습니다.")
else:
    print("조금 더 커서 오세요.")
# 점수에 따른 등급(elif 활용)
score = 85
if score>=90:
    print("A등급입니다.")
elif score>=80:    
    print("B등급입니다.")
else:
    print("재시험 대상입니다.")    
# ex1) 임의의 숫자를 할당하고 짝수인지 홀수인지 판별(%활용)하여 출력하세요.
ranNum = 7
if ranNum%2==0:
    print("짝수입니다.")
else :
    print("홀수입니다.")    

# ex2) 온도에 따른 냉난방기 처리 25도 이상일 때 에어컨 가동  10미만일때 히터 가동 그외는 외출하기
#      좋은 날씨...    
temp = 25
if temp>=25:
    print("에어컨 가동")
elif temp<10:
    print("히터 가동")
else:
    print("외출하기 좋은 날씨입니다!!")

# 파이썬에 사용되는 데이터유형(int, float, bool, str), 논리연산자(and, or, not) 적절하게 활용해서
# 조건문 처리 예제..
# ex1) 게임 서버에 입장하려면 레벨이 15이상이거나, 유료 멤버심(is_vip)이 True이어야 합니다.
# 변수 2개를 선언하고 입장 가능시 환영합니다. 아니면 레벨이 부족합니다. 출력
level = 12
is_vip = True
if level >= 15 or is_vip:
    print("환영합니다.")
else :
    print("레벨이 부족하거나 유료멤버십이 아니네요!!")    
# ex2) 자율 주행 주차센터(float, bool)
#      차량이 주차할 때, 장애물과의 거리가 0.5m 이하이면서 후방 카메라가 True(있을 때) 삐 경고음 울리게
#      그 외는 안전합니다. 처리..
distance = 0.42
camera_on = True
if distance <= 0.5 and camera_on:
    print("위험! 장애물 감지")
else:
    print("안정합니다")

# ex3) 테마파트 야간 할인(int, str, bool)
#   할인 조건 : 나이가 65에 이상이거나, 현재 시작(hour) 20시 이후여야 합니다.
#   단 자유이용권 소지여부가 False인 사람만 새로 구매시 할인됩니다.
#   할인 적용 대상입니다.// 일반 가격입니다.
age = 25
hour = 21
has_ticket = False
if( age>=65 or hour >= 20) and not has_ticket:
    print("할인 적용 대상입니다.")
else :
    print("일반 가격입니다.")    

# ex4) 비상벨 시스템
#    보안 시스템이 켜져 있지 않거나, 창문이 열려 있으면 비상벨이 울립니다.
#    security_on = True, window_open=True
#    비상! 보안 확인 요청 //  평온한 밤입니다.
security_on = True; window_open=True
if not security_on or window_open:
    print("비상 보안 확인 요망")
else:
    print("평온한 밤입니다.")    

# ex5) 우주선 발사 조건
#    우주선은 기상 악화가 아니어야 하고, 동시에 연료가 100% 이거나 보조 엔지니이 정상이어야 발사됩니다.
#    발상 가능시  우주선 발사 그외 발사 중지...
bad_weather = False  # 날씨가 나쁘지 않음.
fuel = 80  # 연료가 80% 충전
sub_engine =  True   # 보조 엔진 정상 작동..
if not bad_weather and (fuel == 100 or sub_engine):
    print("우주선 발사")
else :
    print("발사 중지!!")    

