'''
# 필드값 private 설정 처리
1. 클래스의 필드(변수)는 기본적으로 공공재입니다. 누구나 객체.변수 = 0 이렇게 마음대로 값을 바꿀 수 있죠
2. 하지만 은행 계좌 잔액이나 비밀번호처럼 남들이 함부로 건드리면 안 되는 중요한 데이터는 어떻게 보호
   할까요? 이 때 필요한 것이 바로 필드값 은닉(정보 은닉) 입니다.
3. 접근 제한 (public vs private)
    1) 파이썬은 변수 이름 앞에 밑주 두 개(__)를 붙이는 것만으로 이건 내 거야! 함부로 건드리지 마!
      라고 선언할 수 있습니다.
      public (공개) : self.name  ==> 누구나 보고 바꿀 수 있음. (거실)
      private (비공개) : self.__wallet ==> 클래스 내부에서만 접근 가능. 외부에서는 안 보임(내 금고)]
      ps) self.__변수명 (앞에 __를 붙이면 투명 망토를 쓴 것과 같습니다!!)
'''
# 남이 보면 안 되는 일기장 : 비밀 일기장(__content)은 밖에서 훔쳐보려고 하면 에러가 납니다.
#   하지만, 열쇠를 열어서보면(지정된 메서드를 통해서만) 확인할 수 있습니다.
class Diary:
    def __init__(self, text):
        self.__content = text  # 앞에 __를 붙여서 숨김..

    def viewByKey(self):
        return self.__content; ## viewByKey() 메서드에 의해서만 내용을 확인할 수 있음..

my_diary = Diary("나는 사실 외계인이다!!")
# print(my_diary.__content)  
# AttributeError: 'Diary' object has no attribute '__content' 에러발생
print("허용된 기능 메서드로 접근:", my_diary.viewByKey())
'''
ex1) 닌자의 비밀 두루마리
1. 닌자는 자기의 비기(skill)를 적에게 들키면 안 됩니다. 오직 제자에게 전수할 때만 비법을 말해줍니다.
   1) Ninja 클래스를 만드세요
   2) __skill (비기)를 비공개 필드로 만들고 분신술을 생성자 안에서 바로 할당하세요.
   3) teach() 메서드를 통해서만 비기는 [분신술]이다 라고 출력되게 하세요..
   4) 직접 __skill을 출력하려다가 실패하는 주석 코드와 메서드로 성공하는 코드를 작성하세요..

'''
class Ninja:
    def __init__(self):
        self.__skill ="분신술"  # 객체 생성과 함께 은닉된 필드값 설정  쉿! 비밀기술..

    def teach(self):
        return f'비기는 [{self.__skill}]이다!!]'    

naruto = Ninja()
#print(naruto.__skill)   에러 발생! (적에게 들키지 않음)
print(naruto.teach()) # 제자에게만 전수 완료

