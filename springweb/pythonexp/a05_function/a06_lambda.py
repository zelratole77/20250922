'''
# 람다(Lambda) 함수
1. 코딩의 효율을 극대화해 주는 아주 매력적인 도구이다.
2. 람다 함수는 이름이 없는 일회용 익명 함수입니다.
    보통 def로 함수를 선언하면 메모리에 이름을 등록하고 계속 불러 쓰지만, 람다는 딱 한 줄로 
    필요한 순간에 쓰고 사라지는 포스트잇 같은 함수입니다.
3. 람다의 핵심 속성 
    1) 단일행(단) : 오직 한 줄로만 작성합니다.
    2) 익명성(익) : 이름이 없습니다.
    3) 일회성(일) : 한 번 쓰고 버리는 용도로 최적화되어 이씃ㅂ니다.
    # 비유
    def : 식당 예약(정식 절차, 이름 있음, 언제든 다시 방문)
    lambda : 편의점 도시락(빠름, 이름 몰라도 됨, 먹고 바로 쓰레기 통으로)
4. 기본 형식
    lambda 매개1, 매개2: 리턴데이터;

    앞에는 입력받을 재료(매개변수 선언)를 쓰고,
    콜론(:) 뒤에는 그 재료로 만들 결과를 씁니다.
    return 키워드를 쓰지 않아도 자동으로 결과값을 반환합니다.
'''
# 일반함수
def add(x, y):
    return x+y
rs1 = add(5,8); print("일반함수결과:",rs1)
add2 = lambda x, y:x + y 
rs2 = add2(3, 5); print("람다함수 결과:", rs2)
# ex) 람다형식으로 물건가격과 갯수를 받아 총계를 처리하게 하고, 해당 함수를 호출하여 출력하게 하세요..
totProd = lambda price, cnt : price*cnt
print("람다함수 호출:", totProd(3000, 4))
# 즉시, 선언과 호출 처리..
# 람담함선언(넘길데이터1, 넘길데이터2...)
result = (lambda x, y: x**y)(2,10)
print("결과 데이터:", result)
# 조건부 결과 반환(삼항 연자 결합)
# 점수를 넣으면 합격/불합격을 알려주는 판독기..
pass_fail = lambda score:"합격" if score>=60 else "불합격"
print("결과1", pass_fail(85))
print("결과2", pass_fail(55))
# 딕션너리에 함수 담기(switch문 효과)
# 파이썬에는 switch case 문이 없는데, 람다를 딕션너리에 담으면 메뉴판처럼 골라 쓰는 기능을 아주
# 깔끔하게 만들 수 있습니다.
# 연산 메뉴판 만들기
cal = {
    "더하기":lambda x, y:x + y,
    "곱하기":lambda x, y:x*y,
    "제곱":lambda x,y:x**y
}
print(cal['더하기'](10,20))
print(cal['곱하기'](15,2))
# ex1) 짝수/홀수 판별기   숫자 하나를 받아서 짝수이면 "Even" 홀수면 Odd를 반환하는 람다 함수
#      check_num을 만들고 숫자 7을 넣어 결과를 출력하세요
check_num = lambda no: "짝수" if no%2==0 else "홀수"
print(check_num(7))
# ex2) 환율계산기(매개변수데이터까지 바로 처리) 원화(KRW)를 입력하면 달러(USD)로 환경해주는 람다
#      함수(1달러 1400원)를 만들고, 바로 매개변수로 26000원을 입력했을 때, 결과를 확인해주세요
print((lambda krw:f'{krw/1400:.3f} 달라')(2800))
print((lambda krw:f'{krw/1400:.3f} 달라')(1400))
print((lambda krw:f'{krw/1400:.3f} 달라')(10000))

# ex3) 간단한 인사 생성자 : 이름과 성별(M,F)를 인자로 받아, 남성이면 Hello, MR, @@@ 여성이면
#      Hello. Ms. @@@를 반환하는 람다 함수 greet를 만들고 호출해보세요
greet = lambda name, gender:"Hello, MR,"+name if gender=='M' else "Hello. Ms."+name
print(greet("홍길동","M"))
print(greet("오영희","F"))



