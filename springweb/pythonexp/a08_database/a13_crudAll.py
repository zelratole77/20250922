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





'''
from z01_dto import *
from a00_dbComm import *
def seachAll() :
    is_search = True
    while is_search :
        print("# MAGIC_VENDING 전체 검색 #")
        product_nameSch = input("검색할 물건명입력(전체검색시 enter):")
        effectSch = input("검색할 효과입력(전체검색시 enter):")
        product_nameSch = f'%{product_nameSch}%'
        effectSch = f'%{effectSch}%'
        sql = "SELECT * FROM MAGIC_VENDING WHERE PRODUCT_NAME LIKE :product_name AND EFFECT LIKE :effect"
        sch = MagicVendingSchDTO(product_nameSch, effectSch)
        magicList = dataProc(sql, sch.__dict__, MagicVendingDTO, "SELECT")
        for magic in magicList :
            print(magic.id, end="  ")
            print(magic.product_name, end="  ")
            print(magic.price, end="  ")
            print(magic.effect)
        chProc = input("1. 다시조회 2.등록 3.상세조회 4. 전체종료 (번호입력) : ")
        if chProc == "4" :
            print("!! MAGIC_VENDING 관리프로그램 종료 !!!")
            break
seachAll()





