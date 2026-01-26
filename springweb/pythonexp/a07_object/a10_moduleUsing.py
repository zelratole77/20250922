'''
# 파이썬코드의 구조와 외부 모듈 활용하기.
1. 파이썬 코드의 구조
   1) 프로젝트(Project) : 백화점 건물 - 전체 프로그램이 들어있는 가장 큰 폴더(pythonexp)
   2) 패키지(package) : 매장/층(section) - 관련이 있는 파일들을 모아둔 폴드(sound, graphic)
   3) 모듈(Module) : 진열대(Shelf) - 실제 코드가 적혀있는 .py 파일( effect.py )
   4) 클래스/함수/변수 : 상품(Product) - 우리가 진짜로 꺼내 쓰고 싶은 기능( play.sound() )
   물건을 찾으려면 어떤 매장(패키지)의 ==> 어떤 진열대(모듈)에 있는 ==> 무슨 상품(객체/함수/변수) 인지
    주소를 알아야 한다.
2. 기본 호출 형식
    프로젝트 : Game  ==> pythonexp
    패키지(폴드) : sound ==> a07_object.a01_pck
    모듈(파일) : echo.py ==> a01_echo.py
    함수(기능) : voice()  ==> voice()  
    1) 같은 프로젝트 안에서 특정한 함수를 호출 하는 방법
        - 기본 호출과 별칭(Alias) 사용하기 가장 많이 쓰이는 방식.. 이름을 짧게 줄여 (as) 부릅니다.
        
'''
import sys
import os

# [마법의 경로 설정 코드]
current_dir = os.path.dirname(__file__)
root_dir = os.path.dirname(current_dir) # a07의 부모인 root로 이동
sys.path.append(root_dir)

# 1. 프로젝트 하위에 a07_object.a01_pck 폴드 안에 
#     a01_echo.py 파일을 가져와서 이름을  se로 설정..
import a07_object.a01_pck.a01_echo as se
# 2. 그 모듈이름이 alias로 se
#    사용  별칭.함수명()
se.voice()
# ex) a02_pck 폴드만들고  a01_call.py   안에  class Person    product="사과"  객체 일반변수로 호출하여 출력하세요.
import a07_object.a02_pck.a01_call as ca
p01 = ca.Person("홍길동",25,"수원")
p01.show()
print("외부 패키지에 있는 변수:",ca.name)

# from 패키지명.....모듈명 import 구성요소
# from 패키지명.....모듈명 import *   : 모든 구성요소를 바로 사용 가능..
from a07_object.a01_pck.a01_echo import directCallFun

directCallFun()
from a07_object.a02_pck.a01_call import *
p02 = Person("마길동",27,"서울")
p02.show()
print("name:",name)

# ex) a01_basic하위 a01_pck 를 만들고,    a01_expModule.py 만든 후,
#     class Product,  def showMsg,   fname="바나나"
#     위, import *로 호출 하여 출력하는 내용을 처리하세요..

from a01_basic.a01_pck.a01_expModule import *
prod1 = Product("사과",3000,2)
prod1 # __str__ 에서 선언된 부분이 처리된다..
showMsg()
print(fname)
