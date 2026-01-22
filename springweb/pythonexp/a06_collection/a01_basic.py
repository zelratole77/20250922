'''
# 데이터 저장소 컬렉션
1. [],(),{}의 형태로 데이터를 담는 저장 구조 형식을 말한다.
2. 종류
    1) 리스트(list) : 여행용 배낭 - 순서 O, 수정 O, 중복 O - 네모난 배낭엔 뭐든 넣고 뺀다
    2) 튜플(tuple) : 박물관 전시관 - 순서 O, 수정 x, 중복 O - 둥근 유리관은 눈으로만 보세요
    3) 딕션너리(dict) : 사물함(라커) - 키(Key):값(Value) - 열쇠(Key)가 있어야 물건을 찾지
    4) 세트(set) : 마법의 거름망 - 순서 x, 중복 x - 중복된 건 다 걸러낸다.
3. 형변환
    위 컬렉션은 해당 키워드에 의해서 형변환 처리할 수 있다.    
'''
# 리스트 : 만능 여행용 배낭
# 1. []로 수정 가능한 배낭으로 append(넣기), remove(삭제), sort(순서처리) 등 마음대로 할 수 있다.
# 튜플(tuple) : 봉인된 타임캡슐
# 1. 리스트와 거의 같지만, 한번 만들면 절대 내용을 바꿀 수 없습니다.
# 2. 특징 : 소괄호 사용(, - 콤마로 구분), 수정불가(Immutable), 읽기 전용
# 3. 볼 수 있지만(indexing), 만지거나 바꿀 수 없습니다. 중요한 설정값(좌표, 비밀번호 등)을 보호할 때
#   또는 빠르게 로딩해야 할 때 사용된다.
pos = (100,200)
print(pos[0], pos[1]) # 읽기 전용
# pos[0] =50   TypeError: 'tuple' object does not support item assignment
# ex1) 박물관에 보관된 보물들의 이름이 담긴 treasures 튜플을 선언하고, 2번째 유물을 출력하세요
#  석탑, 금관, 백자, 청자
treasures = ('석탑','금관','백자','청자')
print(treasures[1])
#treasures[1] = '등잔'
a = (1,2,3) 
b = 1,2,3  # 
c = (5) # 
d = 5, # 
print("a", type(a))
print("b", type(b))
print("c", type(c))
print("d", type(d))
x, y, z = 10, 20, 30
# 튜플형식이기에 x = 10, y = 20, z = 30
print(x)
print(y)
print(z)
# 튜플데이터가 리스트로 형변환이 일어나면서 할당.
listTrea = list(treasures)  
listTrea.append('금속 칼날')
print(listTrea) # 형변환이 일어나면 추가할 다면 변경이 가능하고,
tupeTrea = tuple(listTrea) # 다시 원래대로 tuple타입으로 형변환 처리가 가능하다.
#tupeTrea[0] = '변경'
# ex) 튜플데이터로 아메리카노, 라떼, 모카커피 를 설정한 후, 리스트로 변경해서 메뉴를 추가한 후,
#     다시 튜플데이터로 변경하여 데이터를 출력하세요.
tupleCoffees = "아메리카노","라떼","모카커피"
listCoffees = list(tupleCoffees)
listCoffees.append('카푸치노')
print(listCoffees)
tupleCoffees = tuple(listCoffees)
print(tupleCoffees)








