'''
# 가변형 매개변수(Variable Arguments)
1. 함수나 메서드 등에서 매개변수가 선언된 수 만큼 전달하는 것이 일반적이지만, 상황과 프로그래밍
   처리에 따라 가변적인 처리가 필요로 할 때가 발생하는 데 이때 사용하는 것이 가변형 매개변수이다.
2. 파이썬에서 *(별표), **(묶음 packing/unpacking)으로 가변형 매개변수로 사용하는 경우로 사용한다.
    1) *args : 원 스타 - 마법 자루 - 튜플(Tuple) - 별이 하나면, 순서대로 몽땅 자루에 담아라
    2) **kwargs : 투 스타 - 택배 상자 - 딕셔너리(Dict) - 별이 두개면, 이름표(key)를 붙여서 상자에 담아라
3. *args : 위치 가변 매개변수(Magic Bag)
    1) 입력값이 몇 개가 들어올지 모를 때 사용합니다. 들어오는 모든 값들을 순서대로 묶어서 튜플로 만들어줍니다
    2) 키워드 : 순서 중요, 개수 무제한, 튜플
    3) 주의 : args는 변수명일 뿐(국룰), 핵심을 *입니다.
'''
def sum_all(*numbers):
    # numbers는 이제 (1,2,3) 같은 튜플이 됩니다.
    total = 0
    for num in numbers:
        total += num
    return total
print("합산1:", sum_all(1,2,3))
print("합산2:", sum_all(7,9,10,20,30))
# 샌드위치 주문(고정 매개변수를 포함한 가변 매개변수)
def make_sandwich(bread, *ingredients):
    # bread는 고정, 나머지는 ingredients 튜플로 가변
    print(f"빵 : {bread}")
    print("재료 추가:", ingredients)

make_sandwich("통밀빵","햄","치즈")
make_sandwich("일반빵","햄","치즈","양상추","토마토")
# ex1) 무한 곱셈기 : 입력된 숫자가 몇 개든 상관없이 모두 곱한 결과를 돌려주는 multply_all 함수를 
#   만들세요 (for문과 *args를 사용)
def multply_all(*nums):
    result = 1 # 곱셈이니까 0이 아니라 1로 시작함!!
    for n in nums:
        result = result *n  # 누적 곱셈
    return result
print(multply_all(2,3,4))
print(multply_all(1,2,3,4,5))
# ex2) 팀명과 팀원출력 처리 함수 : 고정으로 팀명을 선언하고, 나머지는 팀원을 구성 및 출력하게 하는
#       함수를 선언하고 호출하세요  make_team 함수..
def make_team(t_name, *members):
    print("팀명:", t_name)
    print("팀원:", members)
make_team("자바열공팀", "홍길동","김길동","신길동")    
make_team("파이썬좋아팀", "오길동","하길동","마길동","김현정")   

'''
4 **kwargs : 키워드 가변 매개변수(Labeled Box)
    1) 값만 주는 게 아니라 이름=값 형태로 줄 때 사용합니다. 들어온 값들을 딕션너리형태로 만들어줍니다.
    2) 키워드 : 이름표(key), 순서 상관없음, 딕션너리
    3) kwargs는  keyword arguments의 줄임말이고 변수로 지정하면 됩니다.
'''
def create_char(**info):
    # info는 {'name':'전사', 'level':5} 같은 딕셔너리가 됨
    print("캐릭터 정보:", info)
    for key, val in info.items():
        print(key,end="\t")
        print(val)
create_char(name="전사", level=5, weapon="검")
create_char(name="궁수", hp=3000, weapon="사냥활", mp=200)