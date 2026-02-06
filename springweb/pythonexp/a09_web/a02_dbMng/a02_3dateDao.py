from z02_dao import *
from z01_dto import *

def dateList( schOb ):
    sql = '''
          select * 
          from BLIND_DATE
          where PARTNER_NAME like :partner_name
            and LOCATION like :location
          ORDER BY DATE_NO DESC
          '''
    return dataProc(sql, schOb.__dict__, BlindDate, "SELECT")

def dateInsert( insOb):
    print(insOb)
    sql = '''
          insert into BLIND_DATE values (:date_no,:partner_name,
                                         :partner_age,:job,
                                         :location,
                                         to_date(:meet_date,'YYYY-MM-DD'),
                                         :status,:score,:review)
          '''
    # date_no='6', partner_name='홍마리', partner_age='28', job='빅데이터분석가', location='서울강남',
    # meet_date='2026-02-06', status='SUCCESS', score='7', review='정말 좋은 만남있었다...'

    return dataProc(sql, insOb.__dict__, None, "INSERT")