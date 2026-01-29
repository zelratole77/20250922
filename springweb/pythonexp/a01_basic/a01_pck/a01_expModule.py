class Product:
    def __init__(self, name, price, cnt):
       self.name = name
       self.price = price
       self.cnt = cnt
    def __str__(self):
       print("# 물건(Product) 객체 #")
       print(f'물건명:{self.name}')
       print(f'가격:{self.price}')
       print(f'갯수:{self.cnt}')

def showMsg():
    print("메시지 : 안녕하세요!!!")

fname="바나나"