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

def empDetail( empno ):
    sql = ''' select * 
              from emp01 
              WHERE EMPNO = :empno '''
    return dataProc(sql, (empno,), Emp, "SELECT")[0]

def empUpdate( updateOb ):
    sql = ''' UPDATE EMP01
              SET ENAME = :ename,
                  JOB = :job,
                  MGR = :mgr,
                  HIREDATE = TO_DATE(:hiredate,'YYYY-MM-DD'),
                  SAL = :sal,
                  COMM = :comm,
                  DEPTNO = :deptno
              WHERE EMPNO = :empno '''
    return dataProc(sql, updateOb.__dict__, None, "UPDATE")

def empDelete( empno ):
    sql = '''DELETE EMP01 WHERE EMPNO = :empno'''
    return dataProc(sql, (empno,), None, "DELETE")