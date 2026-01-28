import sys
import os

# [마법의 경로 설정 코드]
current_dir = os.path.dirname(__file__)
root_dir = os.path.dirname(current_dir) # a07의 부모인 root로 이동
sys.path.append(root_dir)
# EMP 사원정보 조회 처리(CONNECT 모듈 활용)
from a08_database.a00_con import dbCon as con
# 0. Connetion객체 
con = con()
# 1. 커서객체 생성(연결객체로 부터)
cursor = con.cursor()
# 2. 커서객체 수행
cursor.execute('SELECT * FROM EMP')
# 3. 커서객체가 있는 전체 []를 가져오기
empList = cursor.fetchall()
#print(empList)
# 4. for문을 통해서 출력
for empTup in empList: # 행단위 튜플리스트 가져오기
    for emp in empTup:  # 열단위 튜플을 반복을 출력
        print(emp, end=" ")
    print() # 한 행이 끝나면 줄바꾸기 처리
# 5. 자원해제
con.close()    

