from a00_dbComm import select_data
# 1. sql작성 및 실행처리.
deptList = select_data("SELECT * FROM DEPARTMENTS")
# 2. 반복문 처리.
for deptTup in deptList:
    for dept in deptTup:
        print(dept, end = " ")
    print()    

# ex1  EMPLOYEES를  전체 데이터 검색하여 출력하세요.    
empList = select_data("SELECT * FROM EMPLOYEES")
for empTup in empList:
    for emp in empTup:
        print(emp, end= " ")
    print()    