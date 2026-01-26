'''
a07_object.a07_usingAll의 Docstring
# 모든 구성요소(필드/생성자/메서드)를 다 활용한 종합예제
1. 마치 아이언매 슈트를 조립하는 과정과 같습니다.
    1) 필드 : 슈트의 에너지, 미사일 갯수(상태)
    2) 생성자 : 슈트 착용시 초기 세팅(시동 켜기)
    3) 메서드 : 날아가기, 미사일 발사(동작)
    이것들을 종합적으로 활용할 때의 핵심과 주의 사항을 정리
2. 클래스를 설계할 때는 상태(state) ==> 초기화(init) ==> 동작(action)
    순서로 생각하면 절대 꼬이지 않습니다.
    1) 필드(field) - 기억/상태(배터리 잔량, 이름) - __init__ self..변수 - 데이터를 저장하고 유지함
    2) 생성자(constructor) - 탄생/세팅(공장 출고) - def __init__(self) - 필드값을 처음에 딱 한 번
        설정함
    3) 메서드(method) - 행동/기능(펀치, 충전) - def 동작(self) - 필드값을 변화시키거나 활용함
3. 종합 활용시 주이 사항
    1) self 빼먹지 않기 : 메서드 안에서 필드를 쓸 때는 무조건 self.변수 입니다. 그냥 변수라고
        쓰면 메서드 안에서 쓰다 버리는 임시변수(지역변수)가 됩니다.
    2) 순서의 중요성 : 메서드 (행동)를 실행하려면 반드시 생성자(탄생)가 먼저 실행되어야 합니다.
        (태어나지 않았는데 달리 수는 없으니까요!!)
    3) 데이터 보호 : 필드 값은 되도록 메서드를 통해서만 바꾸는 게 좋습니다.(예) hp를 깎을 때 0
        밑으로 안 내려가게 막는 조직등)
'''
# 기초 : 붕어빵 타이궅(데이터 저장과 출력)
# 가장 단순한 형태입니다. 생성자롤  값을 넣고, 메서드로 보여 주기만 합니다.
class FishBread:
    # 1. 생성자(재료 세팅)
    def __init__(self, flavor, price):
        self.flavor = flavor # 팥/슈크림(필드)
        self.price = price # 가격/필드
    # 2. 메서드(정보 보여 주기)
    def show_info(self):
        print(f"{self.flavor} 붕어빵은 {self.price}원 입니다.")
bread1 = FishBread("팥",1000)
bread1.show_info()
# 심화 : 스파트폰 배터리(상태 변화 로직)
# 이제 메서드가 필드값(battery)을 변경합니다. 조건문(if)을 넣어 0%미만이나 100% 초과를 막습니다.
class SmartPhone:
    # 1. 생성자: 새 폰은 배터리 100%
    def __init__(self, model):
        self.model = model
        self.battery = 100
    # 2. 메서드 : 유튜브 보기(배터리 감소)
    def watch_youtube(self):
        if self.battery >= 20:
            self.battery -= 20
            print(f"유뷰트 시청 중..(현재 배터리:{self.battery}%)")    
        else:
            self.battery = 0
            print("배터리 부족으로 꺼집니다.")   
    # 메서드: 게임하기(베터리 감소-30%)
    def play_game(self):
        if self.battery >= 30:
            self.battery -= 30
            print(f"게임 실행하는 중(현재 배터리:{self.battery}%)")
        else:
            self.battery = 0
            print("배터리 부족으로 꺼집니다.")   
    # 메서드 : 충전기(밖에서 usb충전 50% 충전처리)        
    def charge50(self):
        self.battery+=50
        if self.battery>100:
            self.battery=100
            print("충전 완료:(100%)")    
        else:
            print(f"현재 충전량:( {self.battery} %)")        

    # 3. 메서드 : 충전하기 (배터리 증가)
    def charge(self):
        self.battery = 100
        print(" 충전 완료:(100%)")

sm1 = SmartPhone("아이폰 15")
sm1.watch_youtube()
sm1.watch_youtube()
sm1.charge()
# 선언된 내용 호출//
