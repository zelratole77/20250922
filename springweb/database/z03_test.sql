CREATE TABLE celestial_dex (
    body_id       NUMBER GENERATED AS IDENTITY PRIMARY KEY, -- 고유 번호
    body_name     VARCHAR2(100) NOT NULL,                   -- 천체 이름
    classification VARCHAR2(50),                             -- 분류 (행성, 은하, 성운 등)
    distance_ly   NUMBER(15, 2),                            -- 지구와의 거리 (광년)
    discovery_date DATE,                                     -- 발견 날짜 (NULL 가능)
    description   VARCHAR2(500)                             -- 특징 설명
);
-- 1. 태양 (별/항성)
INSERT INTO celestial_dex (body_name, classification, distance_ly, discovery_date, description)
VALUES ('태양', '항성', 0.000016, TO_DATE('0001-01-01', 'YYYY-MM-DD'), '태양계의 중심이 되는 항성입니다.');

-- 2. 목성 (행성)
INSERT INTO celestial_dex (body_name, classification, distance_ly, discovery_date, description)
VALUES ('목성', '행성', 0.000067, TO_DATE('1610-01-07', 'YYYY-MM-DD'), '태양계에서 가장 큰 가스 행성입니다.');

-- 3. 안드로메다 은하 (은하)
INSERT INTO celestial_dex (body_name, classification, distance_ly, discovery_date, description)
VALUES ('안드로메다', '나선 은하', 2537000, NULL, '우리 은하에서 가장 가까운 대형 은하입니다.');

-- 4. 오리온 성운 (성운)
INSERT INTO celestial_dex (body_name, classification, distance_ly, discovery_date, description)
VALUES ('오리온 성운', '성운', 1344, TO_DATE('1610-11-26', 'YYYY-MM-DD'), '밤하늘에서 맨눈으로 볼 수 있는 밝은 성운입니다.');

-- 5. 케플러-186f (외계 행성)
INSERT INTO celestial_dex (body_name, classification, distance_ly, discovery_date, description)
VALUES ('케플러-186f', '외계 행성', 582, TO_DATE('2014-04-17', 'YYYY-MM-DD'), '거주 가능 구역에서 처음 발견된 지구 크기의 행성입니다.');

-- 최종 반영
COMMIT;
SELECT * FROM celestial_dex;
-- a02_space 

class CelestialDex
private int bodyId;
private String bodyName;
private String classification;
private int distanceLy;
private DATE discoveryDate;
private String description;


