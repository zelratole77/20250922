from z02_dao import *
from z01_dto import *

def empList( schOb ):
    sql = '''
            select * from emp01
            where ename like :ename and job like :job
            order by empno desc
            '''
    return dataProc(sql, schOb.__dict__, Emp, "SELECT")
def empInsert( insOb):
    print("등록 직전")
    print(insOb.__dict__)
    sql = '''
          insert into emp01 
          values (:empno, :ename, :job, :mgr, 
                  to_date(:hiredate, 'YYYY-MM-DD'), :sal, :comm, :deptno) 
          '''
    return dataProc(sql, insOb.__dict__, None, "INSERT")

