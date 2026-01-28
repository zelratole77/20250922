'''
a08_database.a05_select_where의 Docstring
# DB 조회 처리
1. sql 중 select 문에는 where 절을 통한 특정한 데이터에 대한 조회를 처리할 수 있다.
2. 조회 형식
    1) keyword 검색  : 컬럼 like '%%' 형식으로 데이터를 조회할 때 사용한다.
    2) 범위 검색 : 컬럼 between 시작범위 and 마지막범위
                   컬럼 >= 시작범위   비교 연산식/논리 연산식 처리
    3) 특정 데이터 정확하게 검색 : 컬럼 = 데이터.
3. 처리 프로세스
    1) 조건으로 처리해야 항목을 지정
    2) sql 구문으로 해당 내용을 매개변수로 전달
    3) sql 내용 실행..
4. sql injection 형식의 보안적인 문제가 없이 prepared statement형식 처리할 기본 형식    
    1) sql   where 컬럼명  = :keyword1
    2) 입력한 데이터 설정  data = 데이터
    3) execute(sql구문, keyword1=data)
5. 여러개의 조건검색시 사용되는 tuple형식 처리..
    1) 입력할 매개변수 내용이 여러 개일 때는 순서별로 :1, :2, :3..  형식으로 처리가 가능하다.
        sql 구문에 위 내용을 넣고,
    2) 전달할 내용을 tuple 형식(데이터1, 데이터2) 로 전송하면 해당 갯수와 데이터에 따라서
        검색되는 내용을 확인 할 수 있다.
        sql 처리
        where sal between :1 and :2
        execute(sql, (1000, 3000))



'''
from a00_dbComm import *
'''
print("# 사원정보(사원명기준으로 키워드 검색) #")
ename = input("검색할 사원명(keyword)를 입력하세요 : ")
sql = "SELECT * FROM EMP WHERE ENAME LIKE :keyword"
schEname = f'%{ename}%'
empList = select_dataPreOne(sql,schEname)
#print(empList)
for empDup in empList:
    print(empDup[0],end=" ")
    print(empDup[1],end=" ")
    print(empDup[2])
'''
'''
# ex) 부서정보를 dname으로 키워드 검색해서 출력하세요.
print("# 부서정보(부서명기준 키워드) #")
dname = input("검색할 부서명을 입력하세요 : ")
sql = "SELECT * FROM DEPT WHERE DNAME LIKE :keyword"
schDname = f"%{dname}%"
deptList =  select_dataPreOne(sql,schDname)
for deptDup in deptList:
    print(deptDup[0], end=" ")
    print(deptDup[1], end=" ")
    print(deptDup[2])
'''
'''
# 사원의 급여의 범위를 지정해서 데이터 조회 검색..
print("# 급여의 범위를 통한 사원정보 검색 #")
salFr = int(input("검색할 사원 급여 시작범위 : "))
salTo = int(input("검색할 사원 급여 마지막범위 : "))
schTup = (salFr,salTo)
sql = 'SELECT * FROM EMP WHERE SAL BETWEEN :1 AND :2 ORDER BY SAL'
empList = select_dataPreAll(sql, schTup)
for empDup in empList:
    print(empDup[0], end=" ")
    print(empDup[1], end=" ")
    print(empDup[5])
'''
# ex) HERO_LIST 의 이름(NAME)과 도시(CITY)를 조회조건으로 입력받아 KEYWORD 검색결과를
#    리스트로 출력처리.
'''
print("# 히로우리스트 검색(이름,도시로 검색)")
schName = input("검색할 히로우의 이름 입력 : ")
schCity = input("검색할 히로우 사는 도시 입력 : ")
schDic = {"name":f'%{schName}%', "city":f'%{schCity}%'}
sql = "SELECT * FROM HERO_LIST WHERE NAME LIKE :name AND CITY LIKE :city ORDER BY NAME, CITY"
heroList = select_dataPreAll(sql, schDic)
for heroDup in heroList:
    for hero in heroDup:
        print(hero, end=" ")
    print()    

'''
from dataclasses import dataclass
import datetime
@dataclass
class PokenMonDTO:
    #id : int    
    name : str
    type : str
    #poke_level : int
    #captured_at : datetime
'''
# ex POKEMON_DEX 를 위 형식 dictionary형식으로 name, type으로 키워드 검색해보세요.
print("# 포켓몬스터 검색 #")
schName = input("몬스터 이름 입력 : ")
schType = input("몬스터 타입 입력 : ")
schDic = {"name":f"%{schName}%", "type":f"%{schType}%"}

sch = PokenMonDTO(f"%{schName}%",f"%{schType}%")
#print(sch.__dict__) # dto객체를 사용할 때는 __dict__를 이용해서 딕션너리형태로 
# 변환 후 처리한다.
sql = "SELECT * FROM POKEMON_DEX WHERE NAME LIKE :name AND TYPE LIKE :type "
pokemonList = select_dataPreAll(sql, sch.__dict__)
for pokenMonDup in pokemonList:
    for pokenMon in pokenMonDup:
        print(pokenMon, end = " ")
    print()    
'''
# ex) tbl_member    real_name, position기준으로 검색 dto 객체 생성 후, 검색 조건 처리.
@dataclass
class TblMemberDTO:
    real_name:str
    position:str
print("# 아이돌 검색 #")
sch = TblMemberDTO(f'%{input("실제이름입력:")}%', f'%{input("역할입력:")}%')
#print(sch.__dict__)
sql = "SELECT * FROM TBL_MEMBER WHERE REAL_NAME LIKE :real_name AND POSITION LIKE :position"
memList = select_dataPreAll(sql, sch.__dict__)
for memDup in memList:
    for mem in memDup:
        print(mem, end = " ")
    print()
        
