'''
# 문자열(String) 데이터 타입
1. 파이썬의 문자열은 단순히 글자의 나열이 아니라, 아주 똑똑한 기능을 많이 가진 다재다능한 텍스트
    상자입니다.
2. 문자열은 마치 아파트와 같습니다.
    1) 각 글자는 호수(index)를 가지고 있고,
    2) 전체 층수(length)가 있으면
    3) 필요에 따라 특정 층만 절삭(slicing)해서 가져올 수 있습니다.
3. 문자열의 내장 함수
    1) 길이 : len(문자열변수) : 전체가 몇 글자인지 측정
    2) 변신 : upper()/lower() : 카멜레온과 같이 상황에 맞게 대문자 소문자로 변환된다.
    3) 확인 : isupper()/islower() : 진짜 대/소문자인지 확인 - 모두가 대문자 또는 소문자일때 True
    4) 검색 : count()/find() :레이터로 타켓이 어디에 몇개 있는지 포착해주는 역할
    5) 절삭 : [시작:끝] : 케이크 칼로 원하는 조각만 딱 잘라내기를 해준다.    
'''
# 텍스터 레이더 count, find
text = "파이썬은 쉽고, 파이썬은 재미있다."
# 파이썬이 몇번 나오는지?
print(f" 파이썬이 나오는 갯수:{text.count('파이썬')}")
# 쉽고라는 문자열이 어디(인덱스)에 있는지?
print(f"쉽고의 위치:{text.find('쉽고')}")
# ex) 사용자의 이메일 주소에서 아이디 부분만 잘라내어 출력하고, 전체 이미일의 길이를 출력하세요..
#  변수 email = "python lover@naver.com"
#  미션1  @전까지의 글자(아이디)를 슬라이싱하세요..  find()   문자열[0:마지막index번호] 활용..
email = "python lover@naver.com"
atIndex = email.find("@")
userId = email[0:atIndex]
print(f"아이디:{userId}")
#  미션2 전체 길이를 (길이/100)형식으로 출력하세요..
print(f"전체길이:{len(email)}/100")
'''
# 파이썬의 문자열 slicing 핵심 공식
1. 기본 형식 : 문자열[시작인덱스:끝인덱스]
    1) 시작 인덱스:자르기 시작할 위치(포함됨)
    2) 끝 인덱스 : 자르기를 멈출 위치(포함되지 않음!!!)
    - 앞 숫자는 이상(포함), 뒤 숫자는 미만(불포함)입니다.
    ex) [0:3] 0번, 1번, 2번 칸만 가져오고 3번 칸 바로 앞에서 칼을 멈추는 것입니다.
'''
cake = "생크림딸기케이크"
# 딸기만 자르고 싶다면 ? 인덱스는  0(생), 1(크), 2(림), 3(딸), 4(기), 5(케), 6(이), 7(크)
print(cake[3:5]) #결과 딸기 (3번부터 5번 미만)
# ex) 크림을 잘라서 출력할려면??..
print(cake[1:3])
'''
2. 끝단 생략 : [:끝] 또는 [시작:]
    1) 칼을 대는 시작점이나 끝점이 맨 앞/뒤라면 숫자를 안 써도 됩니다.

'''
# 처음부터 3글자만 : [:3]
print(cake[:3]) # 결과 생크림
# 3번부터 끝까지 : [3:]
print(cake[3:]) # 결과 딸기케이크
# ex1) 날짜 추출 연도 떼어 내기 오늘 날짜로   2026년 01월 20일   이라는 문자열이 있을 때
#     위 스라이싱 방식을 01월 20일을 출력할려면?
today = "2026년 01월 20일"
oneDay = today[5:]
print(f"전체날짜:{today}")
print(f"추출한 날짜:{oneDay}")
# ex2) 영화 예매 시스템에서 영화 제목이  [조조] 아바타:물의 길 로 저장되어 있다면 
#       [조조] 부분만 잘라서 출력하고, 뒤의 아바타:물의 길 부분만 잘라서 출력하게 처리하세요.
movie="[조조] 아바타:물의 길"
tag = movie[:4]
title = movie[5:]
print(f'영화 태그:{tag}')
print(f'영화 제목:{title}')
# 대문자로 변환 upper() 소문자로 변화 lower()
name = "gUiDo vAn rOsSuM"
# 대문자로 변신
cleanName = name.upper()
print(cleanName)
# 소문자로 변신
cleanName2 = name.lower()
print(cleanName2)
# isupper() 모두다 대문자인지?  islower() 모두 다 소문자 인지
print(cleanName, cleanName.isupper())
print(cleanName, cleanName.islower())
'''
# 기타 문자열 처리하는 함수들
1. replace(변경할대상문자, 변경문자)
2. split("구분기준") 구분기준으로 배열로 쪼개는 처리
3. strip("양옆에 공백이 있는 문자열) 공백문자열 제거
'''
text = "I love Apple"
newText = text.replace("Apple", "Python")
print(f"교체한 결과:{newText}")
hobby = "독서,영화,운동"
hobbyList = hobby.split(",") # 콤마를 기준으로 쪼갬
print(f'쪼개진 결과:{hobbyList}')
userInput = "     아이디 입력    "
cleanInput = userInput.strip()
print(f"청소 전:{userInput}, 길이:{len(userInput)}")
print(f"청소 후:{cleanInput}, 길이:{len(cleanInput)}")
# ex) 웹사이트에서 긁어온 데이터  "   Samsung/Apple/LG   "가 있습니다
# 1. 먼저 양쪽 공백을 제거하고,
comp = "   Samsung/Apple/LG   "
strComp = comp.strip()
# 2. 슬래시(/)를 기준으로 쪼개서 리스트로 만들고
compList = strComp.split("/")
# 3. 그 리스트의 길이(항목 갯수)가 몇개인지 출력하세요
comLen = len(compList)
print(strComp)
print(compList)
print(comLen)
# 리스트를 다른 구분자로 문자열로 변경..
finalStr = "-".join(compList)
print(finalStr)





