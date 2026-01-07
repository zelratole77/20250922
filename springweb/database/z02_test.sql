-- 1. 단일 일정 (2월 3일)
INSERT INTO calendar VALUES(cal_seq.nextval, '팀 주간 회의', '2026-02-03T10:00:00', '2026-02-03T12:00:00', 
    '#3357FF', '#FFFFFF', 0, '', '김철수', '프로젝트 진행 상황 공유');

-- 2. 며칠간 이어지는 프로젝트 일정 (2월 9일 ~ 11일)
INSERT INTO calendar VALUES(cal_seq.nextval, '기획안 집중 검토', '2026-02-09', '2026-02-12', 
    '#FF5733', '#FFFFFF', 1, 'http://docs.google.com/plan', '이영희', '상반기 신규 서비스 기획안 확정');

-- 3. 오후 시간대 짧은 미팅 (2월 14일)
INSERT INTO calendar VALUES(cal_seq.nextval, '발렌타인 이벤트 체크', '2026-02-14T14:00:00', '2026-02-14T15:30:00', 
    '#FF33A1', '#000000', 0, '', '박지민', '매장 디스플레이 및 재고 확인');

-- 4. 종일 일정 - 연차 휴가 (2월 20일)
INSERT INTO calendar VALUES(cal_seq.nextval, '개인 연차', '2026-02-20', '2026-02-21', 
    '#8E44AD', '#FFFFFF', 1, '', '홍길동', '개인 용무로 인한 휴가');

-- 5. 외부 교육 참석 (2월 24일 ~ 25일)
INSERT INTO calendar VALUES(cal_seq.nextval, 'SQL 성능 최적화 교육', '2026-02-24T09:00:00', '2026-02-25T18:00:00', 
    '#F1C40F', '#000000', 0, 'http://edu.center.com', '최대리', '데이터베이스 튜닝 실무 과정');

-- 변경사항 반영
COMMIT;

SELECT * FROM calendar;