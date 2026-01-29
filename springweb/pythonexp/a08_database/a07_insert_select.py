# 공통 모듈을 활용하여 조회 및 등록, 등록이후 내용 확인..
from z01_dto import *
from a00_dbComm import *

def seachAll():
    sel_sql = "SELECT * FROM DEPT01 ORDER BY DEPTNO DESC"
    deptList = dataProc(sel_sql, None, DeptDTO, "SELECT")
    print("# 현재 부서 정보 #")
    for dept in deptList:
        print(dept.deptno,end="  ")
        print(dept.dname,end="  ")
        print(dept.loc)
seachAll()
isInsert = input("등록하시겠습니까?(y/n):")    
if isInsert =="y":
    #print("등록합니다.")
    in_deptno = int(input("부서번호를 숫자입력:"))
    in_dname = input("부서명을 입력:")
    in_loc = input("부서위치 입력:")
    inDept = DeptDTO(in_deptno,in_dname,in_loc)
    #print(inDept.__dict__)
    ins_sql = "INSERT INTO DEPT01 VALUES(:deptno,:dname,:loc)"
    dataProc(ins_sql, inDept.__dict__, None, "INSERT")
    seachAll()
else:
    print("등록프로그램 종료!")    

# ex) a08_gourmet_insert.py  Gourmet_Store 테이블 전체 조회, 등록 처리 프로그램 만드세요.
''' 생성일.. 아래 참고..
import datetime
now = datetime.now()
1. 조회를 위한 dto
2. 전체 조회를 위한 공통함수 만들기/호출
3. 등록 입력 처리
4. 등록 후, 전체 조회 호출 ..
'''

