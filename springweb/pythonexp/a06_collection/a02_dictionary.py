'''
# 딕션너리(Dictionary)
1. 파이썬에서 데이터를 저장하는 가장 강력한 방법 중 하나가 딕션너리라고 할 수 있다.
2. 딕션너리는 키(key)와 값(value)이 한 쌍으로 이루어진 자료구조입니다. 마치 진짜 국어사전에서 사과라는
    단어(key)를 찾으면 그에 대한 설명(value)이 나오는 것과 똑같은 원리입니다.
3. 기본 형식 
    {"키":"값"}
    1) 쌍(Pair) : 데이터는 항상 key, value 형태로 쌍을 이룹니다.
    2) 유(Unique) : 열쇠(key)는 중복될 수 없습니다. (우리 집 열쇠가 옆집 열쇠랑 같으면 안 되듯이)
    3) 변(Mutable)  : 값(value)은 언제든지 수정하거나 변경할 수 있습니다.
        key가 같은 내용으로 추가하면 기존의 key에 새로운 값이 할당처리 즉 수정이 일어난다
        key가 없는 내용으로 추가하면 새로운 key/value이 생성된다.
'''
# 선언 {키1:값1, 키2:값2}
my_dict = {"이름":"제미니", "나이":20}
# 데이터의 접근(키를 이용)
print(my_dict['이름'])
# 새로운 데이터 추가
my_dict['사는곳'] = '수원'
# 기본 키의 값 변경
my_dict['나이'] = 25
print(my_dict)
# ex) 사용자(user)로 id, level을 초기에 선언하여 딕션너리를 만든 후,
#      point 키로 새로운 속성 추가, 결과 확인, level을 현재 레벨보다 1향상하고 전체 데이터 확인.
user = {'id':'python_fan', 'level':5}
# 새로운 속성추가.
user['point'] = 150
print(user)
user['level'] = user['level'] + 1
print(user)
'''
# 딕션너리에서 제공 되는 객체 포함 메서드
1. .keys() : 이름표(key)들만 쏙 뽑아오기
2. .values() : 내용물(value)들만 쏙 뽑아오기
3. .items() : 이름표와 내용물을 쌍으로 뽑아오기.
'''
print("user.keys()", user.keys(), type(user.keys()) )
print("user.values()", user.values(), type(user.values()) )
print("user.items()", user.items(), type(user.items()) )
for key in user.keys():
    print("user의 키:", key)
for val in user.values():
    print("user의 값:", val)
for key, val in user.items():
    print(f"user의 키:{key}, user의 값:{val}")
for key in user:
    print(f"user의 키:{key}, user의 값:{user[key]}")    



