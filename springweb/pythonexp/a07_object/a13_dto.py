'''
a07_object.a13_dto의 Docstring
# DTO(Data Transfer Object) : 순수 배달 상자
1. DTO는 계층 간(데이터베이스 <==> 화면, 함수 <==> 함수, 객체 <==> 객체) 데이터 교환만을 위해 사용하는 객체입니다.
2. 복잡한 로직(계산, 판단) 없이 오직 데이터(속성)만 가집니다.
3. 중국집 배달 철가방 : 철가방(DTO)의 목적은 짜장면(Data)을 주방에서 손님에게 안전하게 운반하는 것입니다.
    철가방이 짜장면 맛을 보거나(로직 수행), 짜장면 요리하지 않습니다. 오직 담아서 이동하는 것이 목표입니다.
3. D(Data) - 오직 데이터만 싣는다
   T(Taxi) - 목적지까지 이동(Transfer)만 한다
   O(Only) - 기능(메서드)은 없고 변수만 있다.
   DTO는 데이터만 태우는 태시이다.
4. 기본 형식
    from dataclasses import dataclass  : 내장된 dataclasses 모듈로 부터 dataclass를 사용한다.
    @dataclass # 사용 처리할 객체를 annotation으로 선언
    class @@DTO:
        속성1:데이터유형
        속성2:데이터유형  # 클래스를 선언하고 속성과 데이터유형을 정의한다. 최신 DTO 선언형식..
    참조변수 = @@DTO("속성1값","속성2깂","속성3값")     @dataclass에서 생성자를 자동을 생성해 놓았기에 처리가 가능하다.
    print(참조변수)  @dataclass에서 내부적으로 __repr__로 가지고 있는 객체명(속성=속성값, ...)로 선언했기에 호출만 하면
    #  출력이 된다.
'''
from dataclasses import dataclass

@dataclass
class BookDTO:
    title: str   # 속성명:데이터유형   str, int, float, bool
    price: int

bk1 = BookDTO("파이썬 기초", 25000)    
bk2 = BookDTO("스프링 중급", 35000)   
print(bk1) 
print(bk2) 

# ex) DeptDTO를 선언/할당하여, 부서정보를 2개를 출력하세요..
@dataclass
class DeptDTO:
    deptno:int
    dname:str
    loc:str

d1 = DeptDTO(10,"인사","서울")
d2 = DeptDTO(20,"인사","부산")
d3 = DeptDTO(30,"회계","제주")
print(d1)
print(d1.deptno,d1.dname,d1.loc)
print(d2)
print(d3)
'''
# DTO에서 1:1관계와 1:N(다) 관계 설정..
1. DTO 안에 DTO를 넣는다는 개념만 잡으면 됩니다.

# 1:1관계 DTO(러시아 인형 마드료시카)
1. 개념 : 큰 DTO 상자 안에 작은 DTO 상자가 하나 들어있는 형태입니다.
2. 구현 : 변수의 타입 힌트에 다른 DTO 클래스 이름을 적어줍니다.
'''
# 1. 작은 상자(프로필 정보)
@dataclass
class ProfileDTO:
    email:str
    phone:str
# 2. 큰 상자(유저 정보)
@dataclass
class UserDTO:
    id:str
    name:str
    # 1:1 관계 
    profile:None   # 변수 타입을 정해놓는 경우도 있는데, 이 타입만 들어오게끔 하는 의미보다 어떤 타입을
                   # 사용하겠다는 가독성 의미만 가지고 있다.ex) profile:ProfileDTO 로 선언할 수 있지만
                   # 다른 유형을 할당하더라도 문제가 발생하지 않는다.

# 1. 프로필(작은 상자) 먼저 포장
my_profile = ProfileDTO("test@email.com","010=1234-5678")
# 2. 유정(큰 상자)에 담기
user = UserDTO("kdt_student","홍길동",my_profile)                   
print(user)
# ex) Seat (좌석 구역, 좌석번호),   Ticket(티켓명, 가격, Seat)  1:1관계로 설정해서 Ticket을 출력해보자.
@dataclass
class Seat:
    zone:str
    number:int

@dataclass
class Ticket:
    title:str
    price:int
    seat:None  # 티켓1장당 좌석1개

my_ticket = Ticket("아이유 콘서트", 150000, Seat("VIP",102))
print(my_ticket)
print(my_ticket.seat.zone)
'''
# 1:N 관계 DTO (줄줄이 소시지)
1. DTO 안에 리스트(List)가 있고, 그 리스트 안에 여러 개의 DTO가 들어갑니다.
2. 주의할 점(치명적 함정)
    리스트[]를 기본값으로 줄 때, post:list=[]라고 쓰면 에러가 나거나 모든 객체가 리스트 공유하는 대참사가 일어납니다.
    반드시 field(default_factory=list)를 써야 합니다.(이것을 새 공장(factory)에서 새 리스트를 찍어내라는 명령입니다.)
'''
from dataclasses import dataclass, field
from typing import List  # 리스트 타입 힌트용
# 1. 게시글(DTO) - 여러 개 생길 녀석들
@dataclass
class PostDTO:
    title:str
    content:str
# 2. 유정(DTO) - 게시글을 여러 개 가진 주인
@dataclass
class BlogUserDTO:
    id:str
    name:str
    # [핵심] 1:N 관계 ==> 리스트 안에 PostDTO가 들어감
    # 중요 : 리스트 기본값을 절대 []로 주면 안 됨!! 아래처럼 써야 함
    posts:List[PostDTO] = field(default_factory=list)
# 사용
user = BlogUserDTO("writer_kim","김작가")  # 처음에 게시글 없음(빈 리스트 자동 생성)    
# 게시글 생성
post1 = PostDTO("안녕","반가워요")
post2 = PostDTO("점심","배고파요")
# 리스트에 추가.(append)
user.posts.append(post1)
user.posts.append(post2)
# 출력
for post in user.posts:
    print(f"제목:{post.title}")

# ex) 최강의 길드 만들기..
#     MemberDTO(길드원) - 케릭터이름, 직업,    ==> List[MemberDTO]  다중 객체
#     GuildDTO(길드) - 길드이름, 서버이름, members:길드원목록(위 List[MemberDTO] ) 설정
#  길드객체 생성하고, 멤버를 2~3명 추가하고, 해당 길드의 이름과 멤버를 출력하세요..
#    

@dataclass
class MemberDTO:
    nickname:str
    job:str

@dataclass
class GuildDTO:
    guild_name:str
    server:str
    # 다중 내용 처리
    members:List[MemberDTO] = field(default_factory=list)

my_guild = GuildDTO("전설의 기사단", "아시아_1서버")

my_guild.members.append(MemberDTO("지존검사", "Warrior"))
my_guild.members.append(MemberDTO("힐러요청", "Cleric"))

# 결과 확인
print(f"### {my_guild.guild_name} 길드원 명단 ###")
for member in my_guild.members:
    print(f'- 닉네임: {member.nickname}, 직업:{member.job}')




