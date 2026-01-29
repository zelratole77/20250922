# 공통 모듈을 활용하여 조회 및 등록, 등록이후 내용 확인..
from z01_dto import *
from a00_dbComm import *
from datetime import datetime
def seachAll():
    sel_sql = "SELECT ID, NAME, CATEGORY, KEYWORD, TO_CHAR(DESCRIPTION), RATING, CREATED_AT FROM GOURMET_STORE ORDER BY ID DESC"
    gourmetList = dataProc(sel_sql, None, GourmetDTO, "SELECT")
    #print(gourmetList)
    
    print("# 현재 맛집 정보 #")
    for gourmet in gourmetList:
        print(gourmet.id,end="  ")
        print(gourmet.name,end="  ")
        print(gourmet.category,end="  ")
        print(gourmet.keyword,end="  ")
        print(gourmet.decription,end="  ")
        print(gourmet.rating,end="  ")
        print(gourmet.create_at)
         
seachAll()

isInsert = input("등록하시겠습니까?(y/n):")    
if isInsert =="y":
    #print("등록합니다.")
    id = int(input("맛집 아이디 (숫자입력):"))
    name = input("맛집명을 입력:")
    category = input("분류을 입력:")
    keyword = input("키워드 입력:")
    decription = input("설명 입력:")
    rating = input("좋아요 입력(숫자입력):")
    inGourmet = GourmetDTO(id,name,category,keyword, decription,rating, datetime.now() )
    ins_sql = "INSERT INTO GOURMET_STORE VALUES(:id,:name,:category, :keyword,:decription,:rating,:create_at )"
    dataProc(ins_sql, inGourmet.__dict__, None, "INSERT")
    seachAll()
else:
    print("등록프로그램 종료!")    

# ex) a08_gourmet_insert.py  Gourmet_Store 테이블 전체 조회, 등록 처리 프로그램 만드세요.
''' 생성일.. 아래 참고..
import datetime
now = datetime.now()
1. 조회를 위한 dto
2. 전체 조회를 위한 공통함수 만들기/호출
3. 등록 입력 처리
4. 등록 후, 전체 조회 호출 ..
'''

