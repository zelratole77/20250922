'''
# 반복문과 리스트 구문
1. 실무에서 가장 많이 쓰이는 데이터 처리형태로 숫자가 아니라 데이터 꾸러미(리스트)를 이용해서,
   반복문을 처리하는 것을 말한다.
2. 파이썬에서 [] 형태로 동적배열을 제공하고 있다. 
   list1 = [1000,2000,3000]
   list2 = ['사과','바나나','딸기']
3. 위 동적배열 list를 for문 안에 할당해서 하나씩 안에 있는 데이터를 뽑아서 처리할려면
    for 단위변수 in 리스트형데이터:
        단위변수
    ex) 
    for fruit in list2:
        print(fruit)  # 과일명을 하나씩 뽑아서 fruit에 할당하여 사용할 수 있다.
4. 활용
    1) 위 내용을 전역변수를 tot로 선언하여 전체 합산과 평균을 처리할 수 있을 뿐아니라.
    2) 최대값/최소값을 조건문과 함께 숫자형일 때는 처리가 가능하다.
'''
scores = [98, 92, 45, 60, 88, 95, 30]
total = 0
for score in scores:
    print(score, end = " ")
    total+=score
print(f'총점:{total}, 평균:{total/len(scores):.1f}')    
# ex) 물건의 가격 5개를 list로 선언하여  출력하세요..
#     이 물건의 평균가격도 출력해보세요
price_total=0
for price in [1000,3000,4000,2000,5000]:
    print(price, end=", ")
    price_total += price
print(f"물건의 평균가격:{price_total}")    
for fruit in ['사과','바나나','딸기']:
    print(fruit, end=",")
print()
# 반복문을 통해서 회원의 명단 입력 및 출력
'''
members = []
for cnt in range(1, 4):
    mem = input(f"{cnt}번째 회원의 아이디 입력:")
    members.append(mem)  # 동적배열이라는 append()라는 메서드를 통해서 추가할 수 있다.
print("# 회원 명단 #")    
print(members)
'''
# ex) 물건 3개의 구매 가격을 입력하여 prices []에 할당하고, 출력하세요..
'''
prices = []
for cnt in range(1, 4):
    prices.append(int(input(f'{cnt}번째 물건가격입력:')))
print("# 입력된 가격 리스트 #")
print(prices)
'''
'''
# 중첩 반복문의 이해(좌표과 격자 구조)
1. 반복문 안에 반복문이 들어가는 구조는 이미지 처리나 게임 맵 등을 다룰 때 필수적입니다.
2. 형식
    for 반복문:
       for 반복문:
'''
# 구구단 보물 찾기 2에서 9단까지 구구단 출력..
for grade in range(2,10):
    print(f'### {grade} 단 ###')
    for cnt in range(1, 10):
        total = grade*cnt
        if(total >= 25 and total <= 35):
            print(f'{grade} x {cnt} = {total}')
# 5 x 5 격자 출력
for grade in range(5):
    for cnt in range(5):
        print("#",end="")
    print()    