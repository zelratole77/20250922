from  dataclasses import dataclass
from datetime import datetime
@dataclass
class DeptDTO:
    deptno : int
    dname : str
    loc : str

@dataclass
class GourmetDTO:
    id : int
    name : str
    category : str
    keyword : str
    decription : str
    rating : int
    create_at : datetime


