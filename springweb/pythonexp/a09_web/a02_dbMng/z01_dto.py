from dataclasses import dataclass
from datetime import datetime
@dataclass
class EmpSch:
    ename:str
    job:str

@dataclass
class EmpCU:
    empno:int
    ename:str
    job:str
    mgr:int
    hiredate:str
    sal:float
    comm:float
    deptno:int


@dataclass
class Emp:
    empno:int
    ename:str
    job:str
    mgr:int
    hiredate:datetime
    sal:float
    comm:float
    deptno:int

@dataclass
class BlindDateSch:
    partner_name:str
    location:str

@dataclass
class BlindDateCU:
    date_no:int
    partner_name:str
    partner_age:int
    job:str
    location:str
    meet_date:str
    status:str
    score:float
    review:str

# {{date.date_no}}  partner_name partner_age job location meet_date status score review


@dataclass
class BlindDate:
    date_no:int
    partner_name:str
    partner_age:int
    job:str
    location:str
    meet_date:datetime
    status:str
    score:float
    review:str