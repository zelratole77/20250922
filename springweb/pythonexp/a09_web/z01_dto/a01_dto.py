from dataclasses import dataclass
@dataclass
class Person:
    name: str
    age: int
    loc: str

@dataclass
class OrderProduct:
    no: int
    name: str
    price: int
    cnt: int

@dataclass
class Dept:
    deptno: int
    dname: str
    loc:str
