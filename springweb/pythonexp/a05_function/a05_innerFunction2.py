'''
# 여러가지 내장 함수들..
1. any()/all()
    여러 개의 조건(iterable)을 한꺼번에 검사할 때 사용합니다.
    - any():하나라도 True이면 True반환(논리합 OR와 유사)
    - all(): 모두 True여야 True반환(논리곱 AND와 유사)
'''
# 리스트 요소 검사
nums = [1,2,3,0]
print(any(nums)) # True(0이 아닌 숫자가 있으므로)
print(all(nums)) # False(0이 False 취급 되므로)
# 조건문 활용
flags = [True, True, True]
if all(flags):  # 모두 True일 때, True 처리
    print("모든 조건이 충족되었습니다.")

# 해당 데이터 중 마이너스값이 있는지 여부를 확인 하는 내용
nums = [10,20,30,-5]
ckList = [n<0 for n in nums]  # 해당값이 0이하 이면 True 그외 False
print(ckList)
print("마이너스값 있는지 여부:", any(ckList))
print("마이너스값 있는지 여부:", any(n<0 for n in nums)) 
# 컴프리핸션 없이도 처리 지원(any, all)

# 빈문자열이 있는지 확인하는 내용
words = ['apple','strawberry','banana']
print("모두 공백없는 데이터인지?", all(words))

# ex1) 놀이공원의 한 놀이기구는 탑승객 모두의 키가 140cm 이상이어야 출발할 수 있습니다.
# all()을 사용하여 이 그룹이 탑승 가능한지 판별하는 코드를 작성(for 구문 사용 필요)
heights = [150,142,138,160,155]
ckAll = all(height>=140 for height in heights)
print("모두가 140이상인지 여부:", ckAll)
# ex2) 선생님이 학생들의 숙제 제출현황을 확인합니다. 리스트에 학생들의 이름이 들어있는데,
# 이름이 빈 문자열인 경우 숙제를 내지 않는 것으로 간주합니다. any()를 사용하여 숙제 안 낸 사람이
# 한명이라도 있는지 확인해 보세요..
submission = ['민수','영희', '', '철수']
noSubmitCk = any(name=="" for name in submission)
print("한명이라도 과제 제출 안했는지?:", noSubmitCk)

# filter() : 조건을 걸러내서 처리 - 거름망  특정 조건에 맞는 데이터만 쏙쏙 골라낸다.
# 기본 형식: filter(한개씩처리할함수, 배열데이터)
# 사전에 배열안에 단위 데이터를 처리할 함수를 선언한다. 이 함수는 매개변수로 특정한 데이터가 왔을 때,
# True/False로 처리해준다. 그렇게 모든 데이터를 함수로 처리 후, 해당 함수에 의해 True일 때만,
# 적용하여 데이터를 다시 만들어준다.
# 홀수 리턴 함수..
def getOdd(n):
    return n%2==1
nums = [1,2,3,4,5,6]
new_nums = list(filter(getOdd, nums))
print(new_nums)
# ex) 아래 가격 중에 3000이상인 데이터만 filter()하여 처리한 결과 리스트를만드세요
prices =[1000,4000, 7000, 2000, 5000]
def over3000(price):
    return price>=3000;
new_prices = list(filter(over3000, prices))
print(new_prices)
# 람다함수와 filter 함수 적용 예제
# 짝수만 거르기
nums = [1,2,3,4,5]
evens = list(filter( lambda x:x%2==0 ,nums ))
print(evens)
# 5글자 이상인 단어만 가져오기..
words = ['apple', 'cat', 'bananas', 'dog']
long_words = list(filter(lambda s: len(s)>=5, words))
# filter( 적용할함수return True/False, 적용할리스트)
print(long_words)

# ex) 마트 장바구니 정리  아래 가격을 filter/람다함수를 이용해서 1000원 초과
#    가격만 다시 new_prices로 만들어 출력하세요..
prices = [1000,2500,3000,500, 1500]
new_prices = list(filter(lambda x:x>1000,prices))
print("1000원 초과 물건 가격:",new_prices)
'''
# map : 컨베이어 벨트(Mass Processing)
1. 리스트의 모든 요소를 꺼내서 특정 함수를 일괄 적용한 후 그 결과를 다시 모아줍니다.
2. 똑같은 부품들을 컨베이어 벨트에 올리면, 기계가 지나가며 모두 똑같은 색을 칠해주는 공장
3. 원본을 유지하고 작업 결과만 새롭게 만들어 냅니다.
'''
# list의 모든 가격을 10%인상하여 새로운 가격리스트를 만들 때..
prices =  [1000,2500,3000,500, 1500]
new_prices = list(map(lambda x: int(x*1.1), prices))
print('10%인상된 최종 가격:',new_prices)
# 점수 리스트를 입력받아 해당 점수에  5점씩 더 하여 출력 처리
points = [ 75,85, 95, 45, 80]
plus_points = list(map(lambda x: x+5, points))
print(plus_points)

# dir : 객체의 속성 살펴보기
# 어떤 함수를 쓸 수 있는지 기억나지 않을 때 아주 유용합니다.
sample = [1,2]
print(dir(sample))
# id() : 컴퓨터 메모리 속에 저장된 실제 위치 확인..
# 1. 객체가 컴퓨터 메모리(ram)상의 어느 위치에 저장되어 있는지 고유한 정수 값을 반환합니다.
# 2. 똑같은 가방이 두 개 있어도 주인의 집 주소는 다르듯, 데이터의 고유 식별 번호로 확인하는 것을 말한다.
# 3. 데이터의 주민등록증과 같은 의미로 절대 변하지 않는 유일 주소를 확인할 수 있다.
a = '홍길동'
b = 25
c = [1,2,3]
d = c
f = [1,2,3]
print(id(a))
print(id(b))
print(id(c))
print(id(d))
print(id(d)==id(f))
d.append(4)
print("데이터 c:",c)



























