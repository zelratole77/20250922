'''
# 파이썬의 기본 데이터 유형
1. 가장 기본이 되는 정수, 실수, 문자열, 불리언이 뿌리 자료형입니다.
    1) 정수형(Integer)
        숫자를 표현하는 가장 기본적인 형태
        int : -5, 0, 100처럼 깔끔하게 떨어지는 수
    2) 실수형(Float)
        소수점이 있는 데이터 유형 3.14, -0.0001
    3) 문자열(String)
        텍스트 데이터입니다. 파이썬에서 이건 글자야!!라고 알려주기 위해 반드시 보호막(따옴표)가 필요합니다.
        '데이터', "데이터"형식을 사용합니다.
    4) 불리언(Boolean)
        오직 True(참) 아니면 False(거짓), 두가지 상태만 가지는 자료형입니다.
        첫글자는 반드시 대문자여야 합니다.(True/False)
        전등 스위치처럼 켜짐(True)과 꺼짐(False)만 존재합니다. 주로 나이가 20살 이상인가? 같은
        질문에 답할 때 사용합니다.
    # 위 기본 유형에 대한 데이터 유형을 확인하는 함수가 type()이라는 함수입니다.
'''
isPythonFun = True # bool
isRaining = False 
var01 = 80
var02 = 70
isOver = var01>var02 # 비교연산 결과
var03 =  '홍길동'
var04 = 3.14
print(f'''{isPythonFun} - {type(isPythonFun)}
{var01} - {type(var01)}
{isOver} - {type(isOver)}
{var03} - {type(var03)}
{var04} - {type(var04)}''')
'''
# ex) 카페에서 주문을 받는 키오스크의 데이터를 관리하고자 한다.
1. 주문메뉴를 할당할 수 있는 변수 : 아이스 아메리카노
2. 커피한잔 4500을 저장할 수 있는 변수
3. 주물할 갯수 3을 저장할 수 있는 변수
4. 가격과 갯수를 곱한 결과를 저장하는 변수
5. 포장여부를 결정하는 불리언 값을 저장하는 변수
위 내용을 변수를 선언할당 및 출력하세요.
'''
menuName = "아이스 아메리카노"
price = 4500
orderCount = 3
totalPrice = price*orderCount
isTakeout = True
print(f'''주문메뉴:{menuName}
단가:{price}원
주문수량:{orderCount}개
총비용:{totalPrice}원
포장여부:{isTakeout}
''')