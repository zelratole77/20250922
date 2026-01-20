'''
# 파이썬의 형변환(type casting)
1. 마치 변신 로봇과 같습니다. 데이터라는 부품들이 서로 결합하기 위해 같은 모양(자료형)으로 옷을 갈아입는
과정이죠. 
2. 핵심개념
    끼리끼리법칙 :  파이썬은 아주 깐깐한 관리자입니다. 유형이 같아야만 더하기(+) 연결할 수 있다는
    원칙을 고수합니다.
    - 숫자 + 숫자 = 산술 연산  ex) 25 + 27 ==> 52
    - 문자 + 문자 = 문자 연결  ex) "안녕" + "하세요" = "안녕하세요"
    - 숫자 + 문자 = X 에러 발생!!  관리자가 말이 안 통하쟎아 라며 화를 냅니다.
    ==> 모 - 형 - 결 - 합
    모양을 맞춰야
    형(자료형)이 같아야
    결합(연산/연결)이
    합격이다!!
3. 형변환 함수 4인방
    1) int() : 딱딱한 정수 - 소수점을 버리고 정수로 변신 - 정수기(찌꺼기 제거)    
    2) float() : 부드러운 실수 - 소수점을 버리고 정밀하게 변신 - 돋보기(자세히 보기)
    3) str() : 말하는 문자 - 숫자를 따옴표 속에 가두어 문자로 변수 - 마이크(말하기용)
    4) bool() : 참/거짓 스위치 - 존재 유무에 따라 True/False로 변신 - 전등 스위치

'''
# 숫자 문자열 연산 : 사용자가 입력한 값은 무조건 문자열 입니다. 계산하려면 숫자로 바뀌야 합니다.
ageStr = "25"
nextYearAge = int(ageStr) + 1 # 정수로 변환 후 계산
print(f'내년 나이:{nextYearAge}')
# 숫자를 문장 중간에 넣고 싶을 땐 문자로 바꿔야 합니다.
score = 100
result = "내 점수는 "+ str(score) + "점입니다!!"
print(result)
'''
ex1) 당신은 편의점 아르바이트생입니다. 손님이 구매한 물건의 이름과 가격을 합쳐서 하나의 문자열로
출력합니다. 변수로 물건명(문자열)과 가격(정수형)을 설정 및 할당하고 두 변수를 + 연산자를 사용하여
삼각김밥의 가격은 1200원입니다. 라는 문자을 만들어 출력하세요
ex2) 친구의 태어난 연도를 입력받아 올해 나이를 계산해주는 프로그램을 만드세요
     올해변수 설정, 태어난 연도를 input으로 처리하여 할당,  최종적으로 올해의 나이 계산 후 출력
'''
item = "삼각김밥"
price = 1200
result = item+"의 가격은 "+str(price)+"원입니다."
print(result)

# thisYear = 2026
# bithYear = input("태어난 연도를 입력하세요:")
# age = thisYear - int(bithYear)
# print(f"당신의 나이는 {age}세입니다")

# float() 문자열을 실수로 변환하거나 정수를 실수로 변환할 대, 주로 사용된다.
piStr = "3.14159"
piNum = float(piStr)  # 문자열 ==> 실수로 변환
print(f'원주율 : {piNum}, 타입:{type(piNum)}')
score = 95
floatScore = float(score) # 95 ==> 95.0
print(f"정밀 점수:{floatScore}")
# 나눗셈 결과 확인 : 파이썬에서 나눗셈(/)의 결과는 자동으로 float이 되지만, 명시적으로 형변환을
# 하여 결과의 성격을 고정할 수 있다.
total = 100
count = 3
avg = float(total/count) # 가독성을 높여 주는 효과..
print(f"평균:{avg:.2f}") # 소수점 둘째 자리까지..
# bool() 참/거짓스위치 - 데이터가 있는지 아니면 비었는지 판별하는 판독기
# 원리 : 파이썬에서 0, 빈문자(""), None은 전등이 꺼진 상태(False)로 봅니다. 그 외의 모든 데이터는
# 전등이 켜진 상태(True)입니다.
userId = "" # 아무것도 입력 안합
isInput = bool(userId)
print(f"입력 여부:{isInput}")
# 숫자의 존재 여부(재고 관리) : 재고가 0개이면 False, 1개라도 있으면 True로 처리할 수 있습니다.
stock = 0
isAvailable = bool(stock)
print(f'구매 가능 상태:{isAvailable}')
# 비교 연산의 결과 : 우리가 흔히 쓰이는 비교문은 내부적으로 bool형변환을 거칩니다.
myMoney = 5000
breadPrice = 3000
canBuy = myMoney>=breadPrice
print(f"빵을 구매할 수 있나요? {canBuy}")
# ex1) 카페의 오늘 총 매출액은 50000원이고 손님은 7명일 때, 변수를 할당하고, 한명당 평균 결제 금액을
#      float형으로 나타내되 소수점 둘째 자리까지 출력하세요.
totalSales = 50000
customerCnt = 7
avgPrice = float(totalSales/customerCnt)
print(f'''오늘 총매출액:{totalSales}원
방문한 손님수:{customerCnt}명      
1인당 평균 결제 금액:{avgPrice:.2f}원''')
# ex2) 비밀번호 입력 확인 시스템(bool) 사용자가 로그인하려고 합니다. 입력창에 비밀번호를
#      입력했는지 확인하는 기능을 만드세요.
#      input() 비밀번호 입력!!     입력 여부 출력 
'''
password = input("비밀번호를 입력하세요")
isEntered = bool(password)
print(f"비밀 번호 입력 여부:{isEntered}")
'''
# ex3) 택배상자 무게 체크   상자의 무게가 15.8kg, 제한 무게가 15.0kg  비교 연산자를
#      처리한 결과 변수를 설정하고 이 상자는 무게를 초과했나요? @@@ 로 출력되게 하세요.
weight = 15.8
limit = 15.0
isOverWeight = weight > limit
print(f'''현재 상자 무게 : {weight}kg
제한 한계치 무게 : {limit}kg
이 상자는 무게를 초과했나요? : {isOverWeight}
''')




