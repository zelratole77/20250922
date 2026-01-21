'''
# 함수
1. 함수는 특정한 목적을 위해 미리 만들어진 기능 덩어리입니다. 마치 자판기처럼 넣는 값(입력)이 있으면,
    정해진 처리(프로세스)를 거쳐 결과(출력)를 돌려줍니다.
2. 함수의 기본형식
    1) 선언
    def 함수명(매개변수):
        처리할 프로세스/출력할 내용
        return 리턴할데이터
    2) 호출
    함수명(전달데이터)
    결과값처리변수 = 함수명(전달데이터)
    3) 핵심 구성 요소
        - 매개변수(Parameter):함수가 일을 하기 위해 받는 재료(동전, 버튼 번호)
        - 프로세스(Process) : 함수 내부에서 수행되는 작업(음료수를 고르고 떨어뜨림)
        - 리턴값(Return) : 작업을 마친 후 최종적으로 돌려주는 결과물(시원한 콜라)
'''
# 1. 매개변수만 있는 경우 : 칭찬 로봇
def compliment(name):
    print(f'{name}님, 오늘 코딩 실력이 정말 대단하시네요!!')

compliment('철수')
compliment('영희')
# 2. 매개변수 + 리턴값 : 세금 계산기
#    금액을 넣으면 10%부가세를 계산해서 돌려주는 함수
def get_tax(price):
    tax = price *0.1
    return tax
earnMoney = 10000
my_tax = get_tax(earnMoney)
print(f'수입:{earnMoney:,}원, 내야할 세금:{my_tax}원')
# ex1) hero_intro(매개1,매개2)라는 함수를 만들고, 영웅 이름과 초능력을 매개변수로 받아 
#   [이름]등장 [초능력]공격!을 출력하는 기능을 만듭니다. (리턴값 없음)
def hero_intro(name, power):
    print(f'{name}등장!! {power}공격!!')
hero_intro('아이언맨', '레이저')    
hero_intro('스파이더맨', '거미줄')    


# ex2) pizza_cost(매개1, 매개2) 함수를 만들고, 피자한판 가격과 판 수를 매개변수로 받아
#   총 가격을 계산합니다. 단, 단골 할인으로 총 가격에서 2000원을 뺀 금액을 리턴하세요.
def pizza_cost(price, count):
    total = (price*count)-2000
    return total;
final_pay = pizza_cost(15000, 3)
print(f"할인 적용된 최종 금액:{final_pay}")
