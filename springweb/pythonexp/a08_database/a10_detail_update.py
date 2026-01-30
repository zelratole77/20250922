'''
a08_database.a10_detail_update의 Docstring
CREATE TABLE GALAXY_PLANET (
    PLANET_ID    NUMBER PRIMARY KEY,       -- 행성 번호
    PLANET_NAME  VARCHAR2(50) NOT NULL,    -- 행성 이름
    GALAXY_NAME  VARCHAR2(50),             -- 소속 은하 (우리은하, 안드로메다 등)
    DISTANCE     NUMBER(15, 2),            -- 지구와의 거리 (광년 단위, 실수)
    POPULATION   NUMBER(20),               -- 거주 인구수 (정수)
    HAS_OXYGEN   VARCHAR2(5)               -- 산소 존재 여부 (YES/NO)
);

INSERT INTO GALAXY_PLANET VALUES (101, '지구', '우리은하', 0.00, 8000000000, 'YES');
INSERT INTO GALAXY_PLANET VALUES (102, '화성', '우리은하', 0.00001, 0, 'NO');
INSERT INTO GALAXY_PLANET VALUES (201, '케플러-22b', '시그너스', 600.00, 0, 'YES');
INSERT INTO GALAXY_PLANET VALUES (305, '판도라', '알파 센타우리', 4.37, 500000, 'YES');
INSERT INTO GALAXY_PLANET VALUES (999, '블랙홀 X-1', '미지', 15000.50, 0, 'NO');

COMMIT;
SELECT * FROM GALAXY_PLANET
SELECT * FROM GALAXY_PLANET WHERE PLANET_ID=:1
UPDATE GALAXY_PLANET
   SET PLANET_NAME = :planet_name,
       GALAXY_NAME = :galaxy_name,
       DISTANCE = :distance,
       POPULATION = :population,
       HAS_OXYGEN = :has_oxygen
 WHERE PLANET_ID = :planet_id   
 planet_id planet_name galaxy_name distance population has_oxygen
# 처리순서
1. sql 확인 (전체조회, 상세처리, 수정 처리)
2. dto 처리
3. 전체리스트 출력
-------------------------
4. 상세리스트 출력
5. 수정처리
6. 공통함수 정의(상세리스트/전체리스트) 및 순서별로 처리.
'''
from z01_dto import *
from a00_dbComm import *
# 전체 검색..
def schAll():
    print("전체 검색")
    sel_sql = "SELECT * FROM GALAXY_PLANET"
    galaxy_PlanetList = dataProc(sel_sql, None, GalaxyPlanetDTO, "SELECT")
    #print(hero_prodList)
    # planet_id planet_name galaxy_name distance population has_oxygen
    print("# 행성 리스트 #")
    for gal in galaxy_PlanetList:
        print(gal.planet_id,end=" ")
        print(gal.planet_name,end=" ")
        print(gal.galaxy_name,end=" ")
        print(gal.distance,end=" ")
        print(gal.population,end=" ")
        print(gal.has_oxygen)



# 상세 내용        
def detailSch( planet_id) :
    det_sql = "SELECT * FROM GALAXY_PLANET WHERE PLANET_ID=:1"
    sch_id = planet_id,  # 주의 : 단일 튜플데이터를 넣을 때 반드시 마지막에 ,(콤마) 추가.
    # dataProc() 한개만 있더라도 [객체] 리스트형 안에 있는 한개 데이터이기에 [0]
    schList = dataProc(det_sql, sch_id, GalaxyPlanetDTO, "SELECT")
    # key를 잘못 입력했을 때를 대비해서 처리..
    # 리스안에 한개 객체 리턴해주어야 한다. schList[0]
    retOb =  schList[0] if schList else None
    if retOb:
        print("# 상세 객체 #")
        print(f"행성명: {retOb.planet_name}")
        print(f"은하계명: {retOb.galaxy_name}")
        print(f"거리: {retOb.distance}")
        print(f"인구: {retOb.population}")
        print(f"산소여부: {retOb.has_oxygen}")
    else:
        print(f"planet_id:{planet_id}에 해당 상세 데이터 없음")  
    return retOb
# 1. 전체검색
schAll()
is_update = input("수정하시겠습니까?(y/n):")
while is_update == 'y':
    planet_id = int(input("수정할 번호를 입력하세요:"))
    # 2. 수정전 상세 검색
    uptOb = detailSch( planet_id )   
    # 3. 수정 처리 프로세스
    print("수정 처리 프로세스")
    # 수정번호를 통해서 대상 객체가 있을 때, 수정 처리..
    if uptOb :
        upt_sql = '''
            UPDATE GALAXY_PLANET
            SET PLANET_NAME = :planet_name,
                GALAXY_NAME = :galaxy_name,
                DISTANCE = :distance,
                POPULATION = :population,
                HAS_OXYGEN = :has_oxygen
            WHERE PLANET_ID = :planet_id     
        '''
        planet_name = input(f'현재 행성명:{uptOb.planet_name} 변경할 행성명 입력(기존유지enter):')
        if planet_name:
            uptOb.planet_name=planet_name
        galaxy_name = input(f'현재 은하계명:{uptOb.galaxy_name} 변경할 은하계명 입력(기존유지enter):')
        if galaxy_name:
            uptOb.galaxy_name=galaxy_name    
        distance = input(f'현재 거리:{uptOb.distance} 변경 거리 입력(기존유지enter):')
        if distance:
            uptOb.distance=float(distance)  
        population = input(f'현재 행성인구:{uptOb.population} 변경한 인구 입력(기존유지enter):')
        if population:
            uptOb.stock=int(population)  
        has_oxygen = input(f'현재 오존 여부:{uptOb.has_oxygen} 변경 오존여부 입력(기존유지enter):')
        if has_oxygen:
            uptOb.has_oxygen=has_oxygen
        dataProc(upt_sql, uptOb.__dict__, None, "UPDATE")
        # 수정후 상세 검색 출..
        detailSch(planet_id)
    is_update = input("계속 수정하시겠습니까?(y/n):")
# 4. 전체 검색.
schAll()

print("안녕")
print()