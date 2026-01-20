'''
# 비교연산자
1. 프로그램의 지능을 결정하는 아주 중요한 부분입니다.  두 값을 저질질하여 관계를 따집니다.
결과는 무조건 True 아니면 False입니다.
2. 종류
    ==  : 같으면 True
    !=  : 같지 않으면 True
    >, < : 크다, 작다   
    >=, <= : 크거나 같다, 자거나 같다.
    주의) a=10는 10일 a에 넣어라이고, a==10은 a가 10이랑 똑같니?라고 묻는 것입니다. 초보자가
        가장 많이 하는 실수이니 꼭 주의하세요!!
# 논리연산자
1. 비교 연산자로 만든 여러 질문을 하나로 묶어주는 연결고리 입니다.
2. 종류
    1) and (엄격한 문지기)
        모든 조건이 True여야만 최종적으로 True를 줍니다.
        현관문도 열리고, 안방문도 열려야 방에 들어가는 것과 같습니다.
        True and True ==> True
        Ture and False ==> False
    2) or (너그러운 문지기)                    
        조건 중 하나만 True여도 최종적으로 True를 줍니다.
        정문이나 후문 중 아무 곳이나 열려 있으면 학교에 들어가는 것과 같습니다.
        True or False ==> True
        False or False = False
    3) not (청개구리)
        결과를 반대로 뒤집어 버립니다.
        숙제 했니? 라는 질문에 not을 붙여면 숙제 안 했니?가 됩니다.
        not Ture ==> False
        not False ==> True        

'''
# 1+1 행사 상품인지 여부를 확인
itemName = "초코우유"
eventItem = "딸기우유"
# 똑같은지 비교(==)
isSame = itemName == eventItem
isNotSame = itemName != eventItem
print(f'이 우유는 행사 상품인가요? {isSame}')
print(f'이 우유는 행사 상품이 아닌가요? {isNotSame}')
# [체급 관리] 복싱 경기 출전 가능한가요?
# 몸무게 제한이 있는 스포츠 경기의 체급을 판별합니다.
myWeight = 68.7
limitWeight = 70.0
# 기준 이하인지 비교
canEnter = myWeight<=limitWeight
print(f'70kg급 경기에 나갈 수 있나요? {canEnter}')
# 장학금을 받을 수 있을까?
# 성적이 우수하고 출석률이 좋아하는 엄격한 조건..
score = 95
attendance = 0.8 # 80%
# 두 판결이 모두 참이이어야 함  and
isScholarship = (score>=90) and (attendance>=0.9)
print(f'장학금 대상자입니까?{isScholarship}')
# ex) 카드별로 등급이 Gold/Silver/Bronze가 있을 때, 내 카드등급은 Silver인데,
#    출입 허용하는 등급이 Gold이라고 하며, 내 카드 등급과 허용되는 카드등급을 표시하고,
#    허용여부를 출력하세요.
myCard = 'Silver'
enterGrade = 'Gold'
canEnter = myCard == enterGrade
print(f'''나의 등급:{myCard}
출입허용등급:{enterGrade}      
나의허용여부:{canEnter}''')
# ex1) 로그인 할려면 아이디가 python이고 패스워드가 fun123이어야 합니다.
#     입력한 아이디와 패스워드를 설정하고, 로그인 여부를 처리하세요 and 논리연산식 활용
inputId = 'python'; inputPwd = 'fun777'
canLogin = inputId=='python' and inputPwd == 'fun123'
print(f"로그인 성공 여부:{canLogin}")
# ex2) 놀이공원의 한 놀이기구는 키가 140cm 이상이거나  부모님과 동반한 경우에만 탈 수 있습니다.
#  현재 아이의 키가 135cm이고 부모님과 함께 있다면, 이 아이가 탈 수 있는지 출력하세요
height = 135
hasParent = True
canRide = height>=140 or hasParent
print(f"놀이기구 탑승 가능 여부:{canRide}")

# ex3) 나이가 19세 미만이면 미성년자입니다. not 연산자를 사용하여 나이가 20 일 때 미성년자 아닌지
#    여부를 not 논리 연산식을 활용하여 처리결과를 출력하세요..
age = 20
isAdult = not(age<19)   # age<19 미성년자 ==> not (age<19) 미성년자가 아닌지?
print(f"미성년자 아닌지 여부:{isAdult}")



