'''
a07_object.a09_oneAndList의 Docstring
# 객체지향의 1:다관계
1. 부모 객체가 자식 객체들을 담을 리스트를 주머리로 가지고 있다는 개념입니다.
2. 가장 직관적인 마트와 상품예제로 개념을 잡고, 버스와 승객문제로 연습해봅니다.

'''
# 하나의 마트(1)에는 여러 개의 상품(N)이 진열됩니다.
# 1. 작은 부품(N) : 상품
class Product:
    def __init__(self, name, price):
        self.name = name
        self.price = price
# 2. 큰 그릇(1) : 마트
class Mart:
    def __init__(self, name):
        self.name = name
        self.products = [] # 중요! 상품들을 담을 빈 리스트(장바구니) 준비
    # 마트에서 진열할 상품을 하나씩 설정하는 부분..
    def add_product(self, product):
        self.products.append(product) # 리스트에 객체를 하나씩 입고함..
        print(f"{self.name}에 물건 {product.name}  입고되었습니다.")    
    # 전체 물전 리스트..
    def show_all(self):
        print(f"# {self.name}에서 판매하는 물건 목록 #")    
        for pro in self.products:
            print(f'상품명:{pro.name}/가격:{pro.price}')
# 마트 객체 생성
happyMart = Mart("행복마트")
# 상품 생성
p1 = Product("노트북",1000000)
happyMart.add_product(p1)
happyMart.add_product(Product("마우스", 50000))
happyMart.show_all()
# ex) Passenger 승객  name 속성,   
#     Bus  number(버스번호), passenger_list(승객 태울 리스트)
#          ride() 승객체를 태운다.    show_info() 버스 번호와 버스에 태운 승객 명단.
#                