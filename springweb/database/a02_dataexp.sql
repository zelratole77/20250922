SELECT COUNT(*) FROM EMP WHERE DEPTNO=20;
/*
결과값 : 5 ==> 리턴타입으로 int 
입력값 : 10/20.. ==> 매개변수 int ==> int deptno(정수형 부서번호) ==> DB에
	sql mapping   @Param("deptno") int deptno

@Select("SELECT COUNT(*) FROM EMP WHERE DEPTNO=#{deptno}")
int getCountByDeptno(@Param("deptno") int deptno);




 * */