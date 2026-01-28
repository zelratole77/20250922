# 같은 폴드 인식(intellij 확인)
from a00_con import dbCon as con
con = con()
cursor = con.cursor()
cursor.execute("select * from dept")
deptList = cursor.fetchall()
print("부서번호 부서명 부서위치")
for deptTup in deptList:
    for dept in deptTup:
        print(dept, end=" ")
    print()    
con.close()
