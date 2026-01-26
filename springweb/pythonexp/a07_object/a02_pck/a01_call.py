class Person:
    def __init__(self, name, age, loc):
        self.name = name
        self.age = age
        self.loc = loc
    def show(self):
        print("# 객체 정보 #")
        print("이름:",self.name)
        print("나이:",self.age)
        print("사는곳:",self.loc)
        
name ="안녕맨!!"        