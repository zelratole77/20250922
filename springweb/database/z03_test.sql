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
SELECT * FROM GALAXY_PLANET;
SELECT * FROM GALAXY_PLANET WHERE PLANET_ID=101;
UPDATE GALAXY_PLANET
   SET PLANET_NAME = '지구1',
       GALAXY_NAME = '우리은하1',
       DISTANCE = 1,
       POPULATION = 10000000000,
       HAS_OXYGEN = 'NO'
 WHERE PLANET_ID = 101;   
'''
planet_id planet_name galaxy_name distance population has_oxygen

'''
       
        

