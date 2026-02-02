'''
# 전체 관리프로그램
1. 기본 프로세스
    1) 조회 조건을 입력받아서 전체 조회 리스트를 출력(keyword검색)
    2) 기능을 선택해서 리스트 화면에서 -  1.등록 2.상세조회 3.전체종료
    3) 등록 선택시, 항목들을 입력 받아서 등록되게 처리
    4) 상세 조회시, 조회할 key를 입력받아서 리스트 하게 하고,
        1. 수정, 2.삭세, 3.전체조회 4.전체종료 를 선택시 해당 프로세스를 처리하게 한다.
    5) 해당 기능 번호에 따라 리스트, 상세조회, 등록, 수정, 삭제 처리를 하게 한다.
2. 처리 순서
    1) 각, 기능별로 재활용하는 내용이 많기에 해당 내용을 함수형태로 초기에 선언하고,
        프로세스에 따라서 해당 기능 함수를 호출 하는 형식으로 처리한다.
        - 기능 함수 선언
            전체리스트 seachAll() :
            등록처리  insertProc()
            상세내용  detail(key) : 상세 내용 key 매개변수 전달
            수정처리  updateProc(Obj) : 상세 내용을 리턴값으로 만들어진 객체를 매개로 전달
            삭제처리  deleteProc(key) : 삭제할 key값을 매개변수로 삭제 처리한다.

        sql 작성 ==> dto ==> 함수 정의 함수 확인.

    2) 전체 프로세스
        초기 전체 리스트 출력 : seachAll()
        선택으로 1.등록 2.상세조회 3. 전체종료 입력받게 한다. while으로 전체종료시, 프로세스 중단 처리
        조건으로 1. 등록시 insertProc() 데이터를 등록하게 한다. 등록 후에는 계속 등록할지 리스트로 갈지를 선택하게 한다.
            이 프로세스로 while 문을 통해서 리스트로 갈지를 선택할 때, 등록 반복이 종료되고 전체리스트 조회되게 처리한다.
        조건으로 2. 상세조회시 선택번호를 입력 받게 하고,  detail(key)를 통해서 데이터를 상세 검색하세 한다.
                   잘못딘 키를 입력시 예외대한 처리..
        상세화면에서    1. 수정, 2.삭세, 3.전체조회
            1. 수정시 항목별 내용으로 수정하게 하고, 수정 후에는 다시 수정후, 상세화면이 로딩되게 한다.
            2. 삭제시는 삭제 처리하게 하고, 전체조회로 자동으로 이동한다.
            3.전체조회  전체리스트 화면으로 이동하여 리스트되게 한다.
# # MAGIC_VENDING MagicVendingSchDTO MagicVendingDTO
# # id product_name price effect



UPDATE MAGIC_VENDING
   SET PRODUCT_NAME = :product_name,
       PRICE = : price
       EFFECT = : effect
WHERE ID = :id
DELETE FROM MAGIC_VENDING WHERE ID = :id

'''
from z01_dto import *
from a00_dbComm import *
def insertProc():
    print("# MAGIC_VENDING 등록 처리 #")
    product_name = input("물건명을 입력:")
    price = int(input("가격 입력(숫자):"))
    effect = input("효과 입력:")
    inMagin = MagicVendingInsDTO(product_name,price,effect)
    ins_sql = "INSERT INTO MAGIC_VENDING (PRODUCT_NAME, PRICE, EFFECT) VALUES (:product_name, :price, :effect)"
    #print(inMagin.__dict__)
    dataProc(ins_sql, inMagin.__dict__, None, "INSERT")
def updateProc(uptOb):
    upt_sql = '''
              UPDATE MAGIC_VENDING
              SET PRODUCT_NAME = :product_name,
                  PRICE = : price,
                  EFFECT = : effect
              WHERE ID = :id
              '''
    #id product_name price effect
    product_name = input(f'현재 물건명:{uptOb.product_name} 변경할 물건명 입력(기존유지enter):')
    if product_name:
        uptOb.product_name=product_name
    price = input(f'현재 가격:{uptOb.price} 변경할 가격 입력(기존유지enter):')
    if price:
        uptOb.price=int(price)
    effect = input(f'현재 효과:{uptOb.effect} 변경할 효과 입력(기존유지enter):')
    dataProc(upt_sql, uptOb.__dict__, None, "UPDATE")

def deleteProc(del_id):
    del_sql = "DELETE FROM MAGIC_VENDING WHERE ID = :id"
    dataProc(del_sql, (del_id,), None, "DELETE")

def detail(sch_id):
    if sch_id==None:
        sch_id = int(input("상세 아이디 입력:"))
    det_sql = "SELECT * FROM MAGIC_VENDING WHERE ID=:1"
    schList =  dataProc(det_sql, (sch_id,), MagicVendingDTO, "SELECT")
    # key를 잘못 입력했을 때를 대비해서 처리..
    # 리스안에 한개 객체 리턴해주어야 한다. schList[0]
    retOb =  schList[0] if schList else None

    if retOb:
        print("# 상세 객체 #")
        print(f"물건아이디: {retOb.id}")
        print(f"물건명: {retOb.product_name}")
        print(f"가격: {retOb.price}")
        print(f"효과: {retOb.effect}")
        ch_proc = input("1. 수정, 2.삭제, 3. 전체조회 - 처리할 번호 선택:")
        if ch_proc == "1":
            updateProc(retOb)
            detail(retOb.id)
        if ch_proc == "2":
            deleteProc(retOb.id)
    else:
        print(f"id :{sch_id}에 해당 상세 데이터 없음")
        reDetail = input("다시 검색하시겠습니까?(y/n)")
        if reDetail == "y":
            detail(None)
    return retOb

def seachAll(s_status) :
    is_search = True
    while is_search :
        print("# MAGIC_VENDING 전체 검색 #")
        product_nameSch =""
        effectSch = ""
        if s_status != "A":
            product_nameSch = input("검색할 물건명입력(전체검색시 enter):")
            effectSch = input("검색할 효과입력(전체검색시 enter):")
        product_nameSch = f'%{product_nameSch}%'
        effectSch = f'%{effectSch}%'
        sql = "SELECT * FROM MAGIC_VENDING WHERE PRODUCT_NAME LIKE :product_name AND EFFECT LIKE :effect ORDER BY ID"
        sch = MagicVendingSchDTO(product_nameSch, effectSch)
        magicList = dataProc(sql, sch.__dict__, MagicVendingDTO, "SELECT")
        for magic in magicList :
            print(magic.id, end="  ")
            print(magic.product_name, end="  ")
            print(magic.price, end="  ")
            print(magic.effect)
        chProc = input("1. 조회 2.등록 3.상세조회 4. 전체종료 (번호입력) : ")
        if chProc == "1" :
            s_status = "S"
        if chProc == "4" :
            print("!! MAGIC_VENDING 관리프로그램 종료 !!!")
            break
        if chProc == "2" :
            insertProc()
            s_status = "A"
        if chProc == "3" :
            detail(None)
            s_status = "A"
seachAll("A")





