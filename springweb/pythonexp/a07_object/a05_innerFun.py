'''
# 클래스 선언시, 사용되는 주요 내장 메서드 활용하기..
1. 이름 앞뒤에 언더바 두 개( __ )가 붙어 있는 던더(Dunder) 메서드라고 불립니다.
2. 대표적인 메서드(주요 메서드)
    1) __str__ (객체 소개 메서드) : 객체를 print(인스턴스)하거나 str()로 변환할 때 호출됩니다.
       객체의 정보를 사람이 읽기 좋은 문자열로 리턴해줍니다.
    2) __repr__(개발자를 위한 정확한 코드 형태 설명) 리스트 내부 출력, 디버깅
    3) __len__(객체의 구성요소중 list형의 데이터 갯수를 알려주는 처리) len(객체)
    4) __getitem__(자판기, 리스트처럼 인덱싱 순서로 꺼내기 처리  객체[0] 객체[key])
    5) __call__(콜, 미) 함수처럼 괄호로 바로 실행하기 객체()  
'''
class ChefBot:
    # 1. 생성자 : 요리 목록을 가지고 태어남
    def __init__(self, name, menus):
        self.name = name
        self.menus = menus
    # 2. 참조변수로 출력되는 내용 처리 : 고객에게 인사   참조변수
    def __str__(self):   
        return f"저는 {self.name}셰프입니다. 맛있는 요리를 대접할께요"
    # 3. 개발자용 데이터 확인.. [참조변수]
    def __repr__(self):
        return f"ChefBot[name='{self.name}', menu={self.menus}]"    
    # 4. 할수 있는 요리가 몇 개인인지(크기)   len(참조변수)
    def __len__(self):
        return len(self.menus)
    
    # 5. __call__ : 로봇을 부르면 바로 요리 시작   참조변수("처리할데이터")
    def __call__(self, food):
        print(f"지이익  {food}를 요리중입니다!!")

bot = ChefBot("고든램지",["스테이크","파스타","샐러드"])
print(bot.name, bot.menus)
print(bot) # 참조 변수 ==> __str__ 정의된 내용 호출..
print([bot]) # def __repr__(self): ==>  [ChefBot[name='고든램지', menu=['스테이크', '파스타', '샐러드']]]
print("메뉴의 갯수:",len(bot)) # def __len__(self): 처리..
bot("라면")
    

class Book:
    def __init__(self, title):
        self.title = title
    def __str__(self):
        return f"제목 : {self.title} 객체가 하나 생성이 되었습니다"
    


b1 = Book("파이썬 기초");b2 = Book("빅데이터 기초");
print(b1)
print(b2)
# ex) 쇼핑몰 장바구니 소개서
#    Cart 클래스를 만드세요
#    __init__에서 owner 주인 이름을  처리하세요
#    __str__를 사용하여 [주인이름]님의 장바구니입니다. 라고 출력되게 하세요..

class Cart:
    def __init__(self, owner):
        self.owner = owner
    
    def __str__(self):
        return f'{self.owner}님의 장바구니'

my_cart = Cart("철수")
print(my_cart)



