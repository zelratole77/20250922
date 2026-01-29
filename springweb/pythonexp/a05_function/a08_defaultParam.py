'''
# 디폴트 매개변수(Default parameter)
1. 함수를 호출할 때 인자를 매번 다 입력하지 않아도 되게 해주는 아주 친절한 기능입니다.
2. 기본 형식
    1) 함수를 정의할 때 매개변수에 미리 기본값을 할당해두는 방식입니다.
    2) 기본값(Default Value) :  인자가 전달되지 않았을 때 대신 사용되는 값
    3) 필수 매개변수 : 값이 반드시 전달되어야 하는 변수 (앞쪽에 위치)
    4) 선택적 매개변수 : 기본값이 설정되어 생략 가능한 변수(뒤쪽에 위치)
    5) 순서의 제약 : def func(필수, 선택=값) 형태여야 하면, def func(선택=값, 필수)는 문법 오류입니다.

'''
# 카페 주문 시스템 : 손님이 메뉴만 말하고 사이즈를 말하지 않으면 자동으로 Regular 사이즈로 주문을 받습니다.
def order_coffee(menu, size="Regular"):
    print(f'{menu} : ({size} 사이즈) 한 잔 준비하겠습니다. ')

order_coffee("아메리카노")
order_coffee("카페라떼", "Large")
# 캐릭터의 이름은 꼭 지어야 하지만, 레벨은 처음엔 무조건 1부터 설정하거나 설정한 레벨부터 진행할 때
# 그외 매개변수는 순서대로 입력하여야 하지만, key=value 전달할 때는 순서 상관없이 처리가 된다.
def create_char(name, level=1, job="초보자"):
    print(f"캐릭터 생성! [이름:{name}, 레벨:{level}, 직업:{job}]")
create_char("전사킹") 
create_char("마법사", 40, "고급자")
create_char("마법사", job="중급자")
'''
# ex1) 아래 조건에 맞는 함수 say_hello를 작성하고 호출해 보세요
    조건1 : name은 필수입력입니다.
    조건2 : msg는 기본값이 반가워요 입니다.
    호출 예시1 : say_hello('지수') ==> 지수님, 반가워요! 출력
    호출 예시2 : say_hello("민수","오랜만이야") ==> 민수님, 오랜만이야 출력
# ex2) 할인 가격 계산기
    물건 가격과 할인율을 입력받아 최종 가격을 계산하는 함수를 만드세요
    조건1 : price(가격)는 필수 입력입니다.
    조건2 : discount(할인율)는 기본값이 0.1(10%)입니다.
    결과값 : price *(1-discount)를 계산하여 출력하세요..
    도전 : 10000원짜리 물건을 할인율 입력 없이 호출했을 때 얼마가 나오는지 확인해 보세요..
'''
def say_hello(name, msg="반가워요"):
    print(f'{name}님, {msg}')
say_hello("지수")
say_hello("민수","오랜만이야!")

def calculate_price(price, discount=0.1):
    final_price = price * (1 - discount)
    print(f'최종 가격은 {final_price} 원입니다')

# 10,000원짜리 물건, 할인율 입력 없이 호출(기본 10% 적용)
calculate_price(10000)
# 20,000원짜리 물건, 30%할인 적용 시
calculate_price(20000, 0.3)



