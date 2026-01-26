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
# 점심메뉴고르기 (리스트 중 하나 선택)
menu = ['김치찌개','돈까스','짜장면']
print("오늘의 점심메뉴:", random.choice(menu))
# 카드 섞기(원본을 뒤죽박죽으로 만듦)
cards = [1,2,3,4,5]
random.shuffle(cards)
print("섞인 카드:", cards)



