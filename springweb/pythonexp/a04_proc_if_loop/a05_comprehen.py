'''
# 리스트 컴프리헨션
1. 파이썬을 파이썬답게 만드는 가장 강력한 도구입니다.
2. 데이터를 압축하는 공정으로 이해하는 것을 말한다.
3. 리스트 안에서 코드를 실행하여 즉석에서 새로운 리스트를 제조하는 기법입니다.
4. 기본 형식
    [변수 for in range() if 조건문]
    1) for in range() 구문에 의한 만들어진 데이터를 변수에 할당하여 리스트로 만드는 것을 말한다.
    2) if 조건문이 있으면 for 구문에서 만들어진 데이터 중에 필터링하여 리스트를 만든다.
'''
# 0부터 4까지 리스트 만들기
nums = [x+1 for x in range(5)] # 1 2 3 4 5 리스트배열 생성
print("컴프리핸션에 의해 만들어진 배열:", nums)
nums = [x for x in range(10) if x%2 == 0] # 0 1 2 3 4 리스트배열 생성
print("조건 컴프리핸션에 의해 만들어진 배열:", nums)
# ex1) 10~50까지 5의 배수로 된 리스트 컴프리핸션을 만들고 출력하세요..
arry = [y for y in range(10,51,5) if y%5==0]
print(arry)
# 데이터 변경 : 가공해서 담기 (표현식 활용)
# 꺼낸 데이터를 그대로 담지 않고 수술(연산)를 해서 담습니다.
str_nums = [f'NO.{x}' for x in range(1,6)]
print(str_nums)
# ex) 1000~5000까지 가격을 위 for in 구문을 통해서 출력하되 문자열 
#  물건1:1000  물건2:2000, 물건3:3000.. ...
price_info = [f'물건{cnt} : {cnt*1000:,}원' for cnt in range(1,6)]
print(price_info)

names = ['Alice',"Bob","Charlie","David"]
# 이름의 길이가 5글자 이상이고 대문자로 바꿔서 새로운 리스트 만들기..
vip_list = [name.upper() for name in names if len(name)>=5]
print(vip_list)
# ex) lion, tiger, cat, dog, hippo 배열을 선언하고, 이름 길이가 4글자 이상인 것만 대문자로
#     변환해서 출력하세요.
animals = ['lion','tiger','cat','dog','hippo']
escaped = [a.upper() for a in animals if len(a)>=4]
print(escaped)
# 특정한 글자가 포함되어 있는 경우 리스트 처리
fruits = ['사과','포도','딸기','자두','망고포도']
# if '포함되는 문자열' in 변수  : 변수에 포함되는 문자열이 있으면 True
sales_items = ['세일!!'+ f for f in fruits if '포' in f]
print(sales_items)





