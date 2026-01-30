from z01_dto import *
from a00_dbComm import *
# SECRET_GADGETS SecretGadgetDTO gadget_id code_name danger_level status function
def schAll():
    print("# 비밀 무기 전체 조회 #")
    sql = "SELECT * FROM SECRET_GADGETS"
    secretList = dataProc(sql, None, SecretGadgetDTO, "SELECT")
    for secret in secretList:
        print(secret.gadget_id, end=" ")
        print(secret.code_name, end=" ")
        print(secret.danger_level, end=" ")
        print(secret.status, end=" ")
        print(secret.function)
schAll()
del_sql = "DELETE FROM SECRET_GADGETS WHERE gadget_id = :1"
del_gadget_id = int(input("삭제할 비밀무기 아이디입력(숫자) : "))
dataProc(del_sql, (del_gadget_id,), None, "DELETE")
schAll()