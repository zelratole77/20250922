'''
# 조건문과 반복문을 복합적으로 활용하는 알고리즘 
1. 알고리즘 문제를 풀 때, 가장 중요한 것을 코드를 한 줄씩 치는 것이 아니라
    생각의 지도를 그리는 것입니다.
2. 초보자가 응용력을 기르고 에러를 극복하여 숙련자로 가는 로드맵을 정리해 드립니다.
3. 단계별 내용
    1) 논리 설계(코딩 전 설계도 그리기 - 머리생각, 타이핑으로 정리)
        입력 : 무엇을 받을 것인가?( 숫자? 문자열?)
        처리 : for문으로 범위를 훑고, if 문으로 필터링
        출력 : 최종적으로 보여줄 결과는 무엇인가?
    2) 응용력 향상을 위한 코드 변형 훈련
        기본 예제를 익혔다면, 스스로 코드를 조금씩 바뀌보는 연습이 응용력의 핵심입니다.
        범위 비틀기 : range(1,11)을 range(10,0,-1)로 바꿔 역순으로 처리해 보기
        조건 결합하기 : if문 하나만 쓰지 말고, and, or, not을 사용하여 복합 조건
            (예 3의 배수이면서 짝수) 만들기
        누적의 원리 : sum = sum + i 와 같은 패턴이 어떻게 데이터를 쌓아가는지 손코딩으로 추정해보기
    3) 단골 에러 유형과 디버깅 방법
        에러는 실패가 아니라 성장의 신호입니다. 주로 발생하는 3대 에러를 기억하세요.
        - IndentataionError(들여쓰기 오류) : if, for 아래 줄이 제대로 들어가지 않을 때
            발생합니다. 파이썬의 계급장과 같습니다.
        - IndexError(범위 오류) : range(10)인데 11번째 숫자를 꺼내려 할때 발생합니다.
        - SyntaxError(문법 오류) : if 문 끝에 콜론(:)을 빠트리거나 =와 ==를 헷갈릴 때 발생합니다.
        # 에러 찾는 꿀팁: 프린터 기법
        에러가 난다면 코드 중간중간에 print("여기는 지나감", 변수값)을 넣어보세요.
        컴퓨터가 어디까지 정상적으로 실행했고, 어디가 값이 이상해졌는지 한눈에 알 수 있습니다.
'''
# ex1) 1~20 출력 그 이후에 if 짝수만 출력..
for cnt in range(1, 21):
    if cnt % 2 == 0:
        print(cnt, end=", ")
print()
# ex2) 10~50까지 출력하되, 3의 배수만 출력하세요..
for cnt in range(10,51):
    if cnt%3 == 0:
        print(cnt, end=" ")
print()   
# ex3) if else 짝수이면 Even, 홀수이면 Odd 출력하세요(1~10)
#      @@ [짝수],  @@ [홀수], ....    
for cnt in range(1,11):
    print(cnt, end="")
    if cnt%2==0:
        print("[짝수]", end=", ")
    else:
        print("[홀수]", end=", ")
print()        

# 전역변수를 활용해서 합계 처리하기
# 1~20까지 짝수의 합..
total = 0  # 반복문 밖에 전역변수 설정
for cnt in range(1, 21):
    if cnt%2 == 0:
        total += cnt
print(f"1~20중 짝수의 합계:{total}")   
# ex)  1~100중 5의 배수의 합계 출력..
total = 0
for cnt in range(1, 101):
    if cnt%5 == 0:
        total += cnt
print(f"1~100중 5의 배수 합계:{total}")   
# 패턴과 흐름 제어 알고리즘, if와 함께 하는 break와 continue
# break 반복문의 흐름자체를 중단 continue 해당 하는 프로세그 이후만 수행되지
# 않고 다음 step으로 넘어가는 처리.
for cnt in range(1, 10):
    if cnt == 5:
        break;
    print(cnt, end=" ")
print()    
for cnt in range(1, 10):
    if cnt == 5:
        continue;
    print(cnt, end=" ")
print()    
# ex) 1부터 50까지 숫자를 출력하되 7이 포함되어 있으면 출력하지 않고,
#     40을 넘어가면 위험이라고 출력한뒤 종료되게 처리하세요..
for cnt in range(1, 51):
    if cnt == 7:
        continue;
    if cnt >= 40:
        print("위험")
        break;
    print(cnt, end=" ")
print()
