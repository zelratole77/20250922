from z02_dao import *
from z01_dto import *

def dateList( schOb ):
    sql = '''
          select * 
          from BLIND_DATE
          where PARTNER_NAME like :partner_name
            and LOCATION like :location
          '''
    return dataProc(sql, schOb.__dict__, BlindDate, "SELECT")