'''
a07_object.a12_oneAndMuti의 Docstring
# 1대다관계 Review
1. 하나의 객체(1)가 다른 종류의 객체 여러 개(N)를 포함하거나 관리하는 관계입니다.
    파이썬에서는 주로 리스트(list) 타입의 인스턴스 변수를 사용하여 구현합니다.
2. 포켓몬 트레이터(1)와 몬스터볼(N)을 상상해 보세요!
    지우(Trainer)는 가방 안에 파카츄, 파이리, 꼬부기 등 여러 마리의 포켓몬(Pokemon)을 가지고 다닙니다.
    여기서 지우는 1, 포켓몬들은 N입니다. 지우가 명령을 내리면 가방 속의 포켓몬 리스트를 뒤져서 하나씩 꺼내는 것이죠..
3. 핵심 키워드
    1) 리(List) : 1:N의 핵심은 무조건 리스트 [] 변수 선언!! - 생성자에 반드시 선언
    2) 추(Add/Append) : 관계를 맺으려면 리스트에 대상을 추가해야 함
    3) 반(Loop) : N개를 처리하려면 무조건 반복문(for)을 돌려야 함..
    # 1대 다는 리스트를 만들고, 추가하고, 반복하여야 한다!(리! 추! 반!)
'''
# 조장과 조원들(1대N 관계)
# 조원들을 만들 단일 클래스 선언  단일 클래스 ==> 리스트안에 append될 때 다중 객체 리스트로 발전
class Member:
    def __init__(self, name):
        self.name = name
# 조원들과 함께 하는 하나의 단일 객체은 조장 선언, 이 조장은 조원들 리스트를 할당핧 필드를 가지고 있다.
class TeamLeader:
    def __init__(self, name):
        self.name = name
        self.members = [] # 리스트:N을 담을 공간

    def add_member(self, member):
        print(member.name, " 조원이 추가 되었습니다. ")    
        self.members.append(member) # 추가 전역변수 list형태의 self.members에 append()메서드를 통해서 하나씩 추가.
        print(f"현재 조원 총 {len(self.members)}명 입니다")  # 조원이 총수를 len() 배열의 크기로 표현함.
    
    def roll_call(self):
        print(f'### {self.name} 조장의 점호 ###')
        for m in self.members: # for 단위객체 in 리스형객체:
            print(f'조원 : {m.name}')   # 단위객체.필드  : 단위객체안에 있는 속성필드

# 1:N에서 1객체인 조장 객체 생성..
leader = TeamLeader("김철수(조장)")
m1 = Member("영희(조원1)")
leader.add_member(m1) # 참조변수로 조원 추가
leader.add_member(Member("민수(조원2)")) # 바로 객체를 생성하면서 핧당처리..
leader.add_member(Member("길동(조원3)"))
leader.roll_call()
# ex) Pizza 피자도우(1) - 피자종류, 피자가격,  토핑리스트 , Topping 토핑(N) 토핑명,가격
#     add_topping() - 토핑 추가,  calcu_bill() 피자와 토핑정보와 함께 전체가격 (피자 + 토핑(for) 가격합산)
class Topping:
    def __init__(self, name, price):
        self.name = name
        self.price = price

class Pizza:
    def __init__(self, name, price):
        self.name = name
        self.price = price
        self.toppings = []
    def add_topping(self, topping):
        self.toppings.append(topping)    
        print(f"피자에 {topping.name}맛이 추가되었습니다. 현재 토핑 갯수:{len(self.toppings)}개")

    def  calcu_bill(self):
        print(f"### {self.name}피자(기본:{self.price:,}원)의 가격 ###")
        tot_pay = self.price
        for t in self.toppings:
            print(f"{t.name}맛 토핑({t.price:,}원)")
            tot_pay +=t.price
        print(f"총 피자 가격:{tot_pay:,}원")
my_pizza = Pizza("치즈 클러스트", 18000)
my_pizza.add_topping(Topping("페페로니",1500))
my_pizza.add_topping(Topping("올리브",1000))
my_pizza.add_topping(Topping("치즈",1300))
my_pizza.calcu_bill()



