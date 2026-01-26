'''
a07_object.a06_method의 Docstring
# 파이썬에서 메서드 활용
1. 메서드란?
    1) 객체(물건) 뒤에 붙어있는 전용 리모컨 버튼
        함수(function) : 혼자 돌아다니는 마법사(print(), len())
        메서드(method) : 특정 물건(데이터)에 딱 붙어서 작동하는 기능, 반드시 점(.)을 찍어서 나옵니다.
    2) Object(물건/주어).(작동버튼) + Action(동작/동사) 
        ex) 사람이 사는곳을 변경하다. p01.setLoc("서울")
2. 단계별 연습
    1) 메서드 기본 기능
    2) 필드값과 메서드 처리(상호 영향)
    3) 필드값, 생성자, 메서드 처리(클래스 구성 요소들 간의 연계 부분 처리..)
'''
class Person:
    # 메서드1 : 메서드 호출시 매개변수 없이 처리
    def greet(self):
        print("안녕하세요~~")
    # 메서드2 : 메서드에 지역변수 전달 처리
    def callOthers(self, name):
        print(name,"님 반갑습니다.")
    # 메서드3 : 메서드의 데이터를 리턴처리
    def retData(self, price1, price2):
        print("#합산값 리턴 메서드#")
        return  price1+price2
    # 메서드4 : 전역변수 할당 처리(변경)
    def setData(self, name):
        self.name = name
    # 메서드5 : 전역변수 리턴 처리
    def getData(self):
        return self.name  

p1 = Person()
p1.greet()
p1.callOthers("마길동")
ret01 = p1.retData(2500,3000)
print("리턴된 데이터:", ret01)
p1.setData("김길동")
print("전역변수 리턴 데이터:", p1.getData())
# ex) Product 클래스 선언하여,  
#     1. 물건명(필드)값 할당하는 메서드 선언
#     2. 물건명(필드값) 출력하는 메서드 선언
#     3. 가격과 갯수를 받아서 총계를 리턴하는 메서드 선언
class Product:
    def setProductName(self, name):
        self.__name = name  # private 해서 직접 접근 불가..
    def getProductName(self):
        return self.__name  # getProductName()으로 간접적으로 접근 처리..    
    def totAll(self, price, cnt):
        return price*cnt
    

prod1 = Product()
prod1.setProductName("사과")
#print("저장된 물건명:", prod1.name)
print("저장된 물건명 리턴값으로 가져오기:", prod1.getProductName())
print("매개변수로 받아 리턴 처리하는 내용:",  prod1.totAll(3000,5))
# ex1) 필드/메서드 혼합
# 좋아요 누르기 클래스(InstragramPost)
# 필드값을 author(self.author)  메서드 setAuthor로 저장처리
# click_like() 호출될 때마다 @@@님 좋아요를 클릭해서 현재 좋아요 : 5 입력...  필드값 likes 선언 증가.
class InstragramPost:
    def __init__(self):
        self.likes=0    # self.likes 를 증가 시키기 위해서 필드(클래스 전역변수 필요)
    def setAuthor(self, author):
        self.author = author
        print("author 저장 메서드:", self.author)
    def click_like(self):
        self.likes +=1
        print(f"{self.author}님 좋아요를 클릭해서 현재 좋아요 : {self.likes}")    
ins01 = InstragramPost()  # def __init__(self): self.likes=0 
ins01.setAuthor("홍길동")
ins01.click_like()
ins01.click_like()
ins01.click_like()

#ex1) 맛있는 피자 주문(Pizza)
# 피자 가게 주문 시스템입니다.
# 생성자(__init__)를 통해서 피자 종류(name), 사이즈(size), 토핑(topping)을 입력받아 저장하고,
# sendPrizza() 메서드를 통해서 위 종류,사이즈, 토핑 내용을 출력하면서 배달 합니다.  처리..
class Pizza:
    def __init__(self, name, size, topping):
        self.name = name
        self.size = size
        self.topping = topping
    def sendPrizza(self):
        print("# 주문 및 배달 내용 #")
        print("종류:", self.name)
        print("크기:", self.size)
        print("토핑:", self.topping)
p1 = Pizza("페페로니","L","치즈추가")
p1.sendPrizza()
# ex2) 보일러 온도 조절(필드/메서드 혼합)]
# class명 Boiler  필드  현재온도(temp),
#  temp_up() 온도를1도 올립니다. temp_down() 온도를 1조 내립니다.
#  show_status() 현재 보일러 온도는 @@도 입니다.

class Boiler:
    def __init__(self):
        self.temp = 0
    def temp_up(self):
        print("현재 온도를 1도 올립니다.")    
        self.temp +=1
    def temp_down(self):
        print("현재 온도를 1도 내립니다.")    
        self.temp -=1        
    def show_status(self):
        print(f"현재 보일러 온도는 {self.temp}도 입니다. ")    
b1 = Boiler()
b1.temp_up()
b1.temp_up()
b1.temp_up()
b1.temp_down()
b1.show_status()




