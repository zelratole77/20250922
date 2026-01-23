'''
# 필드(field)
1. 클래스가 붕어빵 틀이라면 필드(field)는 그 안에 들어가는 앙금이나 반죽 같은
    상태 데이터를 말합니다.
    1) 클래스는 객체를 만들기 위한 설계도
    2) 필드는 클래스 내부에서 정의된 변수, 객체의 속성(이름, 나이, 색상 등)을 저장합니다.
    3) 인스턴스(instance) : 설계도(클래스)를 통해 실제로 만들어진 객체(붕어빵)
2. class(선언), self(나 자신의 필드라는 표시), __init__(필드 초기화 설정.)    
'''
class Character:
    def __init__(self, name, job):
        self.name = name  # 필드 1: 이름
        self.job = job    # 필드 2: 작업

p1 = Character("전사킹", "기사")
print(f'캐릭터:{p1.name}, 직업:{p1.job}')

# ex) 스마트폰 정보 클래스를 선언하고 브랜드와 가격이라는 필드를 선언하되, 가격은 디플트 값 100설정
# 하게 클래스를 만들고, phone1, phone2 참조변수로 객체 생성, 필드값을 출력하세요.
class SmartPhone:
    def __init__(self, brand, price=100):
        self.brand = brand
        self.price = price

phone1 = SmartPhone("삼성", 120)
phone2 = SmartPhone("애플")
print(f"{phone1.brand}폰은 {phone1.price}만원")
print(f"{phone2.brand}폰은 {phone2.price}만원")
'''
# 클래스 안에 공유 변수 활용
1. 클래스 안에서 변수를 만들 때는 꼭 앞에 self를 붙여야 합니다. 이것을 이 변수는 이 객체의 고유한 필드
야!라고 도장을 꽝 찍는 것과 같습니다. 이 규칙만 기억해도 파이썬 클래스의 절반을 마스터한 것입니다.
2. 다음은 클래스 필드(공유 변수)를 말하는데 모드 객체가 똑같이 공유해야 한느 정보(예:회사명, 게임
    서버 등)는 클래스 바로 아래에 적습니다.
'''
class Car:
    while_count=4  # 클래스 필드(모든 차는 바퀴가 4)
    def __init__(self,name):
        self.name = name # 인스턴스 필드(차마다 이름은 다름)


car1 = Car("그랜저")
car2 = Car("소나타")
Car.while_count = 5   # 이 클래스를 사용하는 모든 객체에 영향 미침..
#car1.while_count = 7  # 각 객체의 변수에 영향을 미침..
print(f"자동차 {car1.name}의 바퀴수는 {car1.while_count}") 
# 공통변수를 효과적으로 활용  모든 객체는 while_count를 공유한다.
print(f"자동차 {car2.name}의 바퀴수는 {car2.while_count}")
'''
ex) 스타크래프트 유닛 업그레이드
공격력 업그레이드를 하면 모든 유닛의 공격력이 한꺼번에 올라가야 합니다.
1. Marine 클래스를 만드세요
2. 모든 마린이 공유하는 attack_boost라는 클래스 필드를 만들고 처음엔 0을 넣으세요
3. 인스턴스 필드로 name을 만드세요
4. 마린 2마리(생성자로 초기화 마린1호, 마린2호..)를 만들고 
    Marine.attack_boost+=1 1로 업그레이드한 뒤 두 마린의 업그레이드 상태를 줄력하세요.


'''
class Marine:
    attack_boost = 0 # 클래스 필드(공용 업그레이드)

    def __init__(self, name):
        self.name = name

m1 = Marine("마린1호")    
m2 = Marine("마린2호")    
print(f'이름: {m1.name}, 공력레벨:{m1.attack_boost}')
print(f'이름: {m2.name}, 공력레벨:{m2.attack_boost}')
Marine.attack_boost +=1
print(f'이름: {m1.name}, 공력레벨:{m1.attack_boost}')
print(f'이름: {m2.name}, 공력레벨:{m2.attack_boost}')

m1.attack_boost +=1
print(f'이름: {m1.name}, 공력레벨:{m1.attack_boost}')
print(f'이름: {m2.name}, 공력레벨:{m2.attack_boost}')

Marine.attack_boost +=1
print(f'이름: {m1.name}, 공력레벨:{m1.attack_boost}')
print(f'이름: {m2.name}, 공력레벨:{m2.attack_boost}')
