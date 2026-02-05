from z02_dao import *
from z01_dto import *

def empList( schOb ):
    sql = '''
            select * from emp01
            where ename like :ename and job like :job
            order by empno desc
            '''
    return dataProc(sql, schOb.__dict__, Emp, "SELECT")
