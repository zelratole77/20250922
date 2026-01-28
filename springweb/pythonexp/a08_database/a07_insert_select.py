# 공통 모듈을 활용하여 조회 및 등록, 등록이후 내용 확인..
from z01_dto import *
from a00_dbComm import *

sql = "SELECT * FROM DEPT01 ORDER BY DEPTNO DESC"
deptList = dataProc(sql, None, DeptDTO, "SELECT")
print(deptList)
for dept in deptList:
    print(dept.deptno,end="\t")
    print(dept.dname,end="\t")
    print(dept.loc)