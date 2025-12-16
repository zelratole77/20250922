SELECT * FROM dept01;
ALTER TABLE dept01
 MODIFY (dname varchar2(50), loc varchar2(50) );
-- 등록 처리
INSERT INTO dept01 values(50,'회계','수원');
-- 등록 /수정/삭제는  처리된 데이터 건수를 정수로 리턴한다..
-- 입력 데이터 매개변수만 처리..
/*
@Insert("INSERT INTO dept01 values(#{deptno},#{dname},#{loc})")
int insertDept01(Emp ins);
 * */
