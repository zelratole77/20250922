'''
a08_database.a09_detail_update의 Docstring
# 수정 처리
1. 전체 리스트 조회
2. 수정할 항목 key 선택
3. 해당 항목 현재데이터 확인하면서 수정여부 확인 후, 수정 데이터 처리
4. 수정 후, 상세데이터 확인.
5. 전체 리스트 화면 이동 확인..
-- 전체 조회 SQL
SELECT * FROM HERO_MART
SELECT ITEM_ID, ITEM_NAME, CATEGORY, PRICE FROM HERO_MART
-- 상세 조회 SQL
SELECT * FROM HERO_MART WHERE ITEM_ID = 1
-- 수정 처리 SQL
UPDATE HERO_MART
   SET ITEM_NAME='투명해지는 생수(수정)',
       CATEGORY = '음식1',
       PRICE = 2000,
       STOCK = 15,
       POWER_LEVEL = 6.0,
       STATUS = '준비중'
  WHERE ITEM_ID = 1   

    item_id:int
    item_name:str
    category:str
    price:int 
    stock:int 
    power_level:float 
    status:str  
'''
from z01_dto import *
from a00_dbComm import *
# 전체 검색..
def schAll():
    sel_sql = "SELECT * FROM HERO_MART"
    hero_prodList = dataProc(sel_sql, None, HeroMartDTO, "SELECT")
    #print(hero_prodList)
    print("# 히어로우 물품 리스트 #")
    for prod in hero_prodList:
        print(prod.item_id,end=" ")
        print(prod.item_name,end=" ")
        print(prod.category,end=" ")
        print(prod.price)
# 상세 내용        
def detailSch( item_id) :
    det_sql = "SELECT * FROM HERO_MART WHERE ITEM_ID = :1"
    retOb =  dataProc(det_sql, sch_id, HeroMartDTO, "SELECT")[0]
    print("# 상세 객체 #")
    print(f"아이템아이디: {retOb.item_id}")
    print(f"물건명: {retOb.item_name}")
    print(f"분류: {retOb.category}")
    print(f"가격: {retOb.price}")
    print(f"재고량: {retOb.stock}")
    print(f"중요도포인트: {retOb.power_level}")
    print(f"현재상태: {retOb.status}")
    return retOb
# 1. 전체 검색
schAll()
# 2. 수정여부 
isUpdate = input("수정하시겠습니까?(y/n):")
# 3. 계속 특정번호로 수정이 가능하게 처리..
while isUpdate =='y' :
    item_id = int(input("수정할 항목 번호를 입력:"))
    sch_id = item_id,  # item_id 정수,  item_id, (튜플형데이터)
    heroUptOb = detailSch(sch_id)   
    upt_sql = '''
        UPDATE HERO_MART
        SET ITEM_NAME = :item_name,
            CATEGORY = :category,
            PRICE = :price,
            STOCK = :stock,
            POWER_LEVEL = :power_level,
            STATUS = :status
        WHERE ITEM_ID = :item_id    
    '''
    # heroUptOb는 기존에 등록된 데이터가 있고, 변경할 데이터를 입력하면 변경되는 
    # 속성으로 저장
    item_name = input(f'현재 아이템명:{heroUptOb.item_name} 변경명입력(기존유지enter):')
    if item_name:
        heroUptOb.item_name=item_name
    category = input(f'현재 분류명:{heroUptOb.category} 변경 항목 입력(기존유지enter):')
    if category:
        heroUptOb.category=category    
    price = input(f'현재 가격:{heroUptOb.price} 변경 가격 입력(기존유지enter):')
    if price:
        heroUptOb.price=int(price)  
    stock = input(f'현재 재고량:{heroUptOb.stock} 변경 재고량 입력(기존유지enter):')
    if stock:
        heroUptOb.stock=int(stock)  
    power_level = input(f'현재 중요도 포인트:{heroUptOb.power_level} 변경 중요도 입력(기존유지enter):')
    if power_level:
        heroUptOb.power_level=float(power_level)
    status = input(f'현재 상태:{heroUptOb.status} 변경할 상태 입력(기존유지enter):')
    if status:
        heroUptOb.status=status  
    dataProc(upt_sql, heroUptOb.__dict__, None, "UPDATE")
    # 수정후
    heroUptOb = detailSch(sch_id)
    isUpdate = input("계속 수정하시겠습니까?(y/n):")

schAll()




