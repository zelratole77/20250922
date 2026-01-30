'''
# 삭제 처리
1. 프로그램에서 삭제 처리 프로세스
   1) 초기 전체 리스트 확인
   2) 입력으로 삭제한 key를 입력 받음
   3) 삭제 후, 다시 전체 리스트 확인
2. 삭제 처리 프로그래밍 순서
    1) 전체 조회 sql 및 dto 작성
        - 조회를 위한 dto
    2) 삭제 처리
        - 삭제 sql 작성
        - 입력 key
        - 입력 받은 key 삭제 처리
    3) 전체 조회 함수 선언 및 중복 호출
        - 삭제 후, 전체 조회 내용으로 삭제 내용 확인.

ZombieItemDTO

SELECT * FROM ZOMBIE_ITEMS
'''
from z01_dto import *
from a00_dbComm import *
def schAll():
    print('ZombieItem 전체 조회 리스트')
    sql = 'SELECT * FROM ZOMBIE_ITEMS'
    zombieList = dataProc(sql, None, ZombieItemDTO, "SELECT")
    #print(zombieList)
    # item_id item_name durability description
    for zombie in zombieList:
        # ctrl + d  : 줄복사
        print(zombie.item_id, end=" ")
        print(zombie.item_name, end=" ")
        print(zombie.durability, end=" ")
        print(zombie.description)
schAll()
delSql = 'delete from ZOMBIE_ITEMS where ITEM_ID = :1'
delItem_id = int(input("삭제할 아이템 아이디 입력(숫자):"))
print(delItem_id)
dataProc(delSql, (delItem_id,), None, "DELETE")
schAll()
# EX) a12_deleteExp.py
#   SECRET_GADGETS 예제로 삭제 처리..

