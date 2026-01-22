'''
# 파이썬에서 사용되는 내장 함수.
1. 프로그램 내부적으로 선언이 되어 호출하여, 바로 사용할 수 있는 함수를 내장함수라고 한다.
2. 지금까지 print(), input(), range(), type(), str(), int(), float(), bool()등은 이와 같은
    내장함수에 속한다고 할 수 있다.
3. 계산식에서 주로 사용되는 내장 함수
    sum() : 합산 처리
    max() : 최대치
    min() : 최소치
    abs() : 절대값 처리
    round(변수,자리수) : 해당 변수이 소숫점 자리까지 반올리 처리..
4. 기타 기능 함수
    sorted() : 리스트형 데이터를 내림차순/오름차순으로 정렬 처리
    zip() : 여러리스트 데이터를 묶어서 처리할 때 사용.. key/value형식으로 짝꿍 만들 때
    enumerate() : 순서대로 번호표를 붙이기 처리할 때 사용
    any()/all() : 조건들이 하나라도 맞는지(any) 혹은 전부 맞는지(all) 검사할 때
    filter() : 특정 조건에 맞는 데이터만 쏙쏙 골라내는 기능
    map() : 모든 데이터에 똑같은 작업(함수)을 한 번에 적용 처리기능
    dir() : 이 객체가 어떤 기능(메서드)을 가졌는지 목록을 보여줌
    id() : 컴퓨터 메모리 속에 저장된 실제 위치를 확인한다.        

'''
# 수학적 통계 처리
numbers = [ cnt for cnt in range(5)]
print(numbers)
# 계산하고 비교하기 sum, max, min, abs
print("합산:", sum(numbers))
print("최대값:", max(numbers))
print("최소값:", min(numbers))
print("절대값:", abs(-50))
# ex1) 어느반 학생 5명의 수학 점수가 아래와 같을 때, 내장함수를 활용하여
#  평균 점수를 구하는 코드를 작성하세요
scores = [85,95,78,90,88]
# 총계값과 현재의 갯수를 나눔..
totPoint = sum(scores)
scoCnt = len(scores)
avg = totPoint/scoCnt
print(f'총계:{totPoint}, 건수:{scoCnt}, 평균:{avg:.2f}')

# ex2) 보물 상자의 비밀번호는 주어진 숫자 리스트에서 가장 큰 숫자와 가장 작은
# 숫자를 더한 값입니다. 비밀번호를 출력하는 코드를 완성해 보세요.
vault_nums = [23, 7, 56, 12, 99, 4, 31]
maxVal = max(vault_nums)
minVal = min(vault_nums)
pwd = maxVal+minVal
print(f'최대값:{maxVal}, 최소값:{minVal}, 비밀번호:{pwd}')
#  정렬 처리와 다듬기(sorted, round)
data = [3,1,4]; data2=['홍길동','김길동','마길동']
print(sorted(data))  # 오름 차순 정렬
print(sorted(data, reverse=True)) # 내림 차순 정렬
print(sorted(data2))  # 오름 차순 정렬
print(sorted(data2, reverse=True)) # 내림 차순 정렬
# 소수점 반올림
pi = 3.14159
print(round(pi,2))
# ex1) 달리기 시합에 참여한 선수들의 기록(초)이 리스트에 담겨 있습니다.
#   가장 빠른 순서 1~3등을  출력하세요..
records = [12.5, 11.8, 13.2, 11.2, 12.1]
list1 = sorted(records)
print("오른차순정렬:",list1)
print(f"가장 빠른 1~3등:{list1[:3]}")
# ex2) 아래는 수학 퀴즈의 점수이다.  가장 좋은 점수 3명을 함수를 이용해서 추출
#  하여, 평균을 소수점 2자리로 출력하세요.
points = [75, 90, 81, 64, 83, 72]
list2 = sorted(points, reverse=True)
rank3 = list2[:3]
print(f'''최상위 3명 점수:{rank3}
최상위3명 평균점수:{sum(rank3)/len(rank3):.2f}''')
# 짝 짓고 번호 매기기(zip, enumerate)
# 여러 데때, 필수적인 함수..
# zip은 두개 또는 그 이이터를 동시에 다룰 상의 데이터를 짝짓기를 처리해준다.
names = ["Tom", "Jerry"]
points = [100,85]
paired1 = zip(names, points)
print("zip처리1:",paired1) 
paired2 = list(paired1)
print("리스트 처리:", paired2)  # () 튜플 - 고정형 배열데이터 컬렉션
# ex1) zip()은 두 개 이상의 리스트도 묶을 수 있습니다. 아래 상품명, 가격, 재고 수량
# 리스트를 하나로 묶어 튜플리스트로 만들어 보세요..
items = ['삼각김밥','바나나우유', '컵  라  면']
prices = [1200, 1700, 1500]
stock = [10,5,20]
products = list(zip(items, prices, stock))
print(products)
for prods in products:   # 가장 밖의 리스트(가변형 배열)
    for prod in prods:   # 내부의 튜플(고정형 배열)
        print(prod,end="\t")
    print()



