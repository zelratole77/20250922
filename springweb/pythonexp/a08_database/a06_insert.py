'''
a08_database.a07_insert의 Docstring
# 파이썬 데이터 등록 처리..
1. 파이썬은 아래 단계로 데이터를 등록 처리를 수행합니다.
    1) 데이터 수집 : 사용자 인터페이스(콘솔창)를 통해 raw data(가공되지 않는 데이터)를 입력받는 처
        리를 합니다.
    2) 데이터 유형성 검사 및 형변환 : DB 컬럼 타입에 맞게 문자열을 정수로 변환합니다. 이 과정에서
        데이터의 무결성(숫자가 맞는지)를 1차로 검증합니다.( 문자열, 정수, 실수, 날짜형 등등..)
    3) sql 바이딩 준비 : sql 의 골격(구조)만 먼저 만들고, 실제 데이터는 바인딩 변수로 비워둡니다.
        이 sql 인젝션을 막는 가장 강력한 방법으로 수행하여야 합니다.
    4) 쿼리 실행 : 준비된 sql 골격과 실제 데이터를 DB엔진에 전송합니다.
    5) 트랜젹션 확정(commit) : 메모리에만 임시로 기록된 데이터를 실제 하드디스크에 영구 저장하여 작업을 완료합니다.
'''
from dataclasses import dataclass
@dataclass
class StudentDTO:
    std_name:str
    kor:int
    eng:int
    math:int
'''
from  a00_con import dbCon
con = dbCon()
cursor = con.cursor()
print("### 신규 학생 등록 시스템 ###")
# 1. 입력 : 이름, 국어, 영어, 수학
s_name = input("이름 : ")
s_kor = int(input("국어 : "))
s_eng = int(input("영어 : "))
s_math = int(input("수학 : "))
insObj = StudentDTO(s_name, s_kor, s_eng, s_math)

print("등록할 데이터 튜플형식")
print(insObj.__dict__)
sql = 'INSERT INTO STUDENTS VALUES(STUDENT_SEQ.NEXTVAL, :std_name, :kor, :eng, :math)'
cursor.execute(sql,insObj.__dict__)
# 확정 처리
con.commit()
print(f'{insObj.std_name} 데이터가 입력이 되었습니다.')
'''
# EX) HERO 테이블 데이터 입력 처리..
@dataclass
class HeroDTO:
    hero_code:int
    hero_name:str
    hero_email:str
    age:int
from  a00_con import dbCon
con = dbCon()
cursor = con.cursor()
hero_code = int(input("히로우코드입력(정수):"))
hero_name = input("히로우 이름 입력(문자열):")
hero_email = input("히로우 이메일 입력(문자열):")
age = int(input("히로우 나이 입력(정수):"))
insObj = HeroDTO(hero_code, hero_name, hero_email, age)
sql = "INSERT INTO HERO VALUES(:hero_code, :hero_name, :hero_email, :age)"
cursor.execute(sql,insObj.__dict__)
con.commit()
print(f'히어로우 {insObj.hero_name} 등록 성공')








