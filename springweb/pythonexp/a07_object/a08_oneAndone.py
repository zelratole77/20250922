'''
a07_object.a08_oneAndone의 Docstring
# 1:1관계(one-to-one Relationship)
1. 1:1관계란, 두 개의 서로 다른 클래스(객체)가 짝꿍처럼 서로 연결되어 있는 상태를 말합니다.
   하나의 객체가 다른 객체이 정보를 변수(속성)로 가지고 있는 형태입니다.
   1) 객체 A 하나는 객체 B 하나 하고만 연결됩니다.
   2) 클래스 안에 __init__ 메서드에서 다른 클래스의 인스턴스(실체)를 변수에 저장합니다.
2. 파일럿과 로봇(The piolot & mecha)
    1) 거대한 로봇(mecha)이 있고, 그 안에 조정사(pilot)가 탑승합니다.
        - 로봇(CLASS a)껍데기입니다. 혼자서는 움직일 수 없거나 의미가 약합니다.
        - 파일럿(CALSS b) 로봇을 조종하는 핵심입니다.
        - 1:1연결 : 로봇 한 대에는 파일럿 한 명만 탈 수 있습니다.(파일럿이 로봇의 머리 부분에 꼭
            들어가는 장면을 상상하세요)
        ex) 로봇.조종석 = 파일럿
            로봇 객체 안에 파일럿 객체가 변수로 저장되는 것입니다.
'''
# 1. 파일럿 클래스(운전자)
class Pilot:
    def __init__(self, name, skill):
        self.name = name
        self.skill = skill
    def show(self):
        print(f"{self.skill}기술을 가진 로봇 조정사 {self.name}님 출력 완료!!")
# 2. 로봇 클래스(기체)
class Robot:
    def __init__(self, model_name):
        self.model_name = model_name
        self.cockpit = None   # 처음에는 조종석이 비어 있음(데이터 언어의 null 같은 역할 None)
    # 조정석(cockpit)에 조정사가 타는 기능(1:1 연결)    
    def board(self, pilot_obj):
        self.cockpit = pilot_obj # 외부에서 온 파일럿 객체를 내 변수에 저장!!
        print(f"로봇 시스템 : {self.cockpit.name} 파일럿이 {self.model_name}에 탑승했습니다!!")

pi01 = Pilot("강철", "로켓펀치")
giant_robot = Robot("자이언트-x")
giant_robot.board(pi01)
# ex1) Passport(필드로 나라명-nation),  
#      Traveler(이름과 여권 설정), 
#          setPassport(여권) : 여권을 발급받다 (@@가 @@ 여행의 여권을 발급받다)
class Passport:
    def __init__(self,nation):
        self.nation = nation
class Traveler:
    def __init__(self, name):
        self.name = name
        self.passport = None
    def setPassport(self, passport):
        self.passport = passport
        print(f"{self.name} {self.passport.nation} 여행의 여권을 발급받다")
# 1. 여권만들기
ticket = Passport("프랑스")        
man = Traveler("홍길동")
man.setPassport(ticket)

