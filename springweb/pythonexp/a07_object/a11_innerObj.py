'''
a07_object.a11_innerObj의 Docstring
# 내장 객체
1. 파이썬은 설치만 하면 바로 쓸 수 있는 강력한 도구들(내장 모듈)이 이미 안에
    가득 들어 있습니다.
2. 실무에서 자주 쓰이는 여러가지 내장 객체와 그 안에 기능 메서드를 확인하자.

# math : 수학 천재 계산기
1. 더하기 빼기 수준을 넘어, 올림/내림, 팩토리얼, 삼각함수 등 공학용 계산기 기능을 제공합니다.
2. 핵심 키워드 : ceil(올림), floor(내림), factorial(팩토리억), pi(원주율)
'''
import math   # 내장 모듈을 사용할 때, 선언..
# 1. 원주율
print(f'원주율 : {math.pi:.5f}')
# 2. 올림과 내림(성적 처리할 때 유용)
score = 95.7
print("올림:", math.ceil(score))
print("내림:", math.floor(score))
# 3. 팩토리어(5! = 5*4*3*2*1)
print("5팩토리어:", math.factorial(5))
# 참고 : round(데이터, 자리수)  내장 함수로 처리.
# ex1) 이삿짐 센터에서 박스를 나를려고 합니다. 총 147개의 박스가 있고, 엘리베이터에서는 한 번에 최대 8개 박스만 실을 수 있습니다.
#  모든 박스를 올기려면 엘리베이터는 총 몇 번 움직여야 할까요?
total_boxes = 147
capacity = 8
print(f'총 이동 횟수:{math.ceil(total_boxes/capacity)}번')
# ex2) 주머니에 50,000원이 있습니다. 시장에서 개당 3,800원 하는 수제 햄버거를 친구들에서 사주려고 합니다.
#  가진 돈으로 살수 있는 총 햄버거의 갯수는?
my_money = 50000
burger_price = 3800
print(f'살 수 있는 햄버거:{math.floor(my_money/burger_price)}')
# random : 예측불허의 행운(게임 필수)
# 1. randint(정수형 램덤), choice(하나뽑기), shuffle(섞기)
# 주사위 굴리기(1~6)
import random
dice = random.randint(1,6)
print("주사위 결과", dice)
# ex1) 0~100점 사이 임의의 점수를 출력하고, 60점 이상이면 합격 그외 불합격도 출력..
ranPt = random.randint(0,100)
print(f"점수:{ranPt}, {'합격' if ranPt>=60 else '불합격'}")
# 점심메뉴고르기 (리스트 중 하나 선택)
menu = ['김치찌개','돈까스','짜장면']
print("오늘의 점심메뉴:", random.choice(menu))
# ex2) 가위, 바위, 보를  배열로 선언하고 임의의 가위/바위/보 출력
games = ['가위','바위','보']
print("가위! 바위! 보!  선택:", random.choice(games))
# 카드 섞기(원본을 뒤죽박죽으로 만듦)
cards = [1,2,3,4,5]
random.shuffle(cards)
print("섞인 카드:", cards)
# ex3) 카드 2,3,4....J,Q,K,A (문자열로 설정) 카드를 섞은 후 1번째부터 7번째 출력하세요.
#      ◆ ♥ ♣ ♠ 
cards = []
nums = ["A","2","3","4","5","6","7","8","9","10","J","Q","K"]
shapes = ["◆","♥","♣","♠"]
for num in nums:
    for shape in shapes:
        cards.append(shape+num)
print(cards)   
random.shuffle(cards)
print("카드 7장 :", cards[:7])     
'''
# datetime : 시간의 마법사
1. 현재 시간을 찍거나(로그), "크리스마스까지 며칠 남았지?" 같은 날짜 계산을 할 때 씁니다.
2. now():현재, timedelta():시간 차이 계삭, strftime(여럭가지 문자열 형식으로 출력..)
'''
from datetime import datetime, timedelta
# 1. 지금 몇시?
now = datetime.now()
print("기본 현재 시간 출력:", now)
# 2. format 지정해서 출력.
print(now.strftime("%Y/%m/%d %H:%M:%S"))
'''
# 포맷 형식
1. %Y : 4자리 연도(2026)
2. %m : 앞에 0을 포함 월(01)
3. %d : 앞에 0을 포함 일(09) 
4. %A : 전체 요일 이름(Tuesday)
5. %H : 24시간 형식

'''

# 3. timedelta 시간 차이 계산
#   100일 뒤 기념일 계산하기  days=100
future = now + timedelta(days = 100)
#   

print("100일 후 날짜:", future)
'''
# datetime 객체의 기타 속성
1. weekday(요일 확인):월요일(0)부터 일요일(6)까지 숫자로 요일 index를 반환
2. datetime(년도, 월,일) : 기본은 현재 날짜와 시간인데, 매개변수로 지정한 날짜를 처리할 수 있다.
3. date() 는 날짜만, time() 시간 정보만 깔끔하게 보여준다.
'''
# ex1) 위 기능 메서드를 이용해서 자신의 생년월일을 datetime으로 설정하고 그날이 무슨 요일이었는지
# 를 출력해보자(weekday() 활용..) weeks=['월',......'일'] 설정 후 요일처리..
weeks = ['월','화','수','목','금','토','일']
print(now, now.weekday(), weeks[ now.weekday()])
birthday = datetime(2001,1,27)
print(birthday, weeks[birthday.weekday()]+"요일")
'''
# os : 컴퓨터 관리자(파일/폴드)
1. 파이썬이 윈도우/맥 운영체제(OS)에게 명령을 내립니다. "폴더 만드어!", "이 파일 삭제해!",
    "지금 어디야!?" 등을 수행합니다.
2. 핵심 키워드 : getcwd(현재 위치), listdir(파일 목록), mkdir(폴더 생성)
    위 내용으로 os운영체제에서 콘솔명령으로 처리하는 내용을 파이썬 명령어로 접근해서
    파일관련 내용을 처리할 수 있다.
'''
import os
# 1. 나 지금 어디에 있지?(경로 확인)
current_path = os.getcwd()
print(f"현재 위치:{current_path}")
# 2. 내 가방(폴드)에 뭐 들어 있지(파일 목록 조회)
files = os.listdir(current_path)
print(f"파일 목록 :{files}")
# 3. 폴더 만들기(없으면 만들기)
target_folder = "test_folder"
if not os.path.exists(target_folder):
    os.mkdir(target_folder) 
    print("새 폴더를 만들었습니다.")
else :
    print("이미 폴더가 있습니다.")    
# ex1) 새로 만들어지 test_folder에 .py 로 끝나는 파일 3개, .txt로 끝나는 파일 3개를 만들고
#   해당 폴드에 있는 파일명을 리스트로 출력하되 .py로 끝나는 파일만 추가하여 출력하세요
#   hints   파일.endswith(".py") .py로만 끝나는 파일 bool True 처리.
files2 = os.listdir(current_path+"\\"+target_folder)
print(files2)
for fname in files2:
    if fname.endswith("py"):
        print(fname)

'''
# time : 잠깐 멈춤의 미학
1. 프로그램을 잠깐 재우거나(sleep), 실행 속도를 측정할 때 사용합니다. datetime과는
다르게 흐르는 시간(초 단위)에 집중합니다.
2. 핵심 키워드 sleep(멈춤), time(현재 시간값)
'''
import time
print("3초 뒤에 폭발합니다!!")
# 1. 1초씩 카운트 다운 (프로그램을 1초간 재움)
print("### 카운트 다운 ###")
for cnt in range(3, 0, -1):
    print(f'{cnt}....{time.time()}')
    time.sleep(1) # 1초 대기
print("펑!!!")
# ex)위성발사준비  1 ~ 10초   10초 후에 발사!!









