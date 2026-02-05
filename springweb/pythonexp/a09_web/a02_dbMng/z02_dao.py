from a08_database.a00_con import dbCon
from oracledb import DatabaseError

def dataProc(sql, inputObj, outObj, proc):
    result = None  # 결과리스트 데이터
    con = None
    cursor = None

    try:
        # 1. 연결
        con = dbCon()
        # 2. 커서객체 생성
        cursor = con.cursor()
        # 3. 실행   where  컬럼 = :key1 and 컬럼 = :key2....
        cursor.execute(sql, inputObj)
        # 4. 결과 가져오기// 확정
        if proc == "SELECT":
            rows = cursor.fetchall()  # default 튜플리스트
            # DTO 리스트 변환..

            if rows:  # 데이터가 있을 때
                result = [outObj(*row) for row in rows]
                # for row in rows   여러행에 있는 각 행의 데이터 즉 하나 튜를 가져와서
                # row  (7601,'홍길동','사원', ....)
                # DTO가 위 순서대로 속성값이 선언되어 있으면 객체생성하면서 하나의
                #   행에 객체가 생성된다..
                # 컴프리핸션 개념에 의해서 여러 행이 처리되어 결국은
                # [DTO, DTO, DTO, ......]   : dto 객체가 있는 리스트가 만들어져서
                # 리턴해준다.

        else:
            con.commit()
            if proc == 'INSERT':
                print("등록 성공!!")
                result = "등록 성공!!"
            if proc == 'UPDATE':
                print("수정 성공!!")
                result = "수정 성공!!"
            if proc == 'DELETE':
                print("삭제 성공!!")
                result = "삭제 성공!!"

    # from oracledb import DatabaseError  : 상단 선언
    except DatabaseError as e:
        print(f"[DB 에러] 데이터 처리 중 오류가 발생했습니다: {e}")
        result = "에러발생!!"
        if proc != "SELECT":
            con.rollback()
    except Exception as e:
        print(f"[일반 에러]예외발생 {e}")
        # 에러발생시 list데이터 초기화 처리.
        result = []
    finally:
        # 5. 예외 상관없이 무조건 실행
        if cursor:
            try:
                cursor.close()  # 자원해제 처리(자체가 예외 처리 필요)
            except:
                pass  # pass :특정한 블럭에 처리할 내용이 없을 때..
        if con:
            try:
                con.close()
            except:
                pass
    return result