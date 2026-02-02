# 조회하는 공통 모듈 만들어서 처리하기(DB연결, 예외처리)
import sys
import os
from oracledb import DatabaseError

# vscode 코드 외부모듈 사용시 default 경로로 프로젝트명기준으로 설정하기 위한 내용
# [마법의 경로 설정 코드]
try:
    current_dir = os.path.dirname(__file__)
    root_dir = os.path.dirname(current_dir) # a07의 부모인 root로 이동
    sys.path.append(root_dir)
except Exception as e:
    print(f'[시스템 경로 설정 오류]{e}')
# 경로 설정이 끝난 후, DB 연결 클래스 설정 처리
try:
    from a08_database.a00_con import dbCon 
except ImportError:
    print(f'[오류] a08_database 패키지를 찾을 수 없습니다. 폴더 구조를 확인하세요 ')        
    dbCon = None #에러 방지용 초기화
# 



# 예외 처리까지 포함한 통합 조회 함수..
def select_data(sql):
    result = [] # 결과리스트 데이터
    con = None
    cursor = None
    
    try:
        # 1. 연결
        con = dbCon()
        # 2. 커서객체 생성
        cursor = con.cursor()
        # 3. 실행
        cursor.execute(sql)
        # 4. 결과 가져오기
        result = cursor.fetchall()
    # from oracledb import DatabaseError  : 상단 선언
    except DatabaseError as e:
        print(f"[DB 에러] 데이터 처리 중 오류가 발생했습니다: {e}")
    except Exception as e:
        print(f"[일반 에러]예외발생 {e}")
        # 에러발생시 list데이터 초기화 처리.
        result = [] 
    finally:
        # 5. 예외 상관없이 무조건 실행
        if cursor:
            try:cursor.close()  # 자원해제 처리(자체가 예외 처리 필요)
            except:pass  # pass :특정한 블럭에 처리할 내용이 없을 때..
        if con:
            try:con.close()
            except:pass
    return result


def select_dataPreOne(sql, schData):
    result = [] # 결과리스트 데이터
    con = None
    cursor = None
    
    try:
        # 1. 연결
        con = dbCon()
        # 2. 커서객체 생성
        cursor = con.cursor()
        # 3. 실행   where  컬럼 := keyword
        cursor.execute(sql, keyword=schData)
        # 4. 결과 가져오기
        result = cursor.fetchall()
    # from oracledb import DatabaseError  : 상단 선언
    except DatabaseError as e:
        print(f"[DB 에러] 데이터 처리 중 오류가 발생했습니다: {e}")
    except Exception as e:
        print(f"[일반 에러]예외발생 {e}")
        # 에러발생시 list데이터 초기화 처리.
        result = [] 
    finally:
        # 5. 예외 상관없이 무조건 실행
        if cursor:
            try:cursor.close()  # 자원해제 처리(자체가 예외 처리 필요)
            except:pass  # pass :특정한 블럭에 처리할 내용이 없을 때..
        if con:
            try:con.close()
            except:pass
    return result

def select_dataPreAll(sql, schObj):
    result = [] # 결과리스트 데이터
    con = None
    cursor = None
    
    try:
        # 1. 연결
        con = dbCon()
        # 2. 커서객체 생성
        cursor = con.cursor()
        # 3. 실행   where  컬럼 = :1 and 컬럼 = :2....
        cursor.execute(sql, schObj)
        # 4. 결과 가져오기
        result = cursor.fetchall()
    # from oracledb import DatabaseError  : 상단 선언
    except DatabaseError as e:
        print(f"[DB 에러] 데이터 처리 중 오류가 발생했습니다: {e}")
    except Exception as e:
        print(f"[일반 에러]예외발생 {e}")
        # 에러발생시 list데이터 초기화 처리.
        result = [] 
    finally:
        # 5. 예외 상관없이 무조건 실행
        if cursor:
            try:cursor.close()  # 자원해제 처리(자체가 예외 처리 필요)
            except:pass  # pass :특정한 블럭에 처리할 내용이 없을 때..
        if con:
            try:con.close()
            except:pass
    return result

# 전달할 sql, 입력할 dict형 데이터, 출력할 List의 단위객체, 조회/등록,수정,삭제
def dataProc(sql, inputObj, outObj, proc):
    result = [] # 결과리스트 데이터
    con = None
    cursor = None
    
    try:
        # 1. 연결
        con = dbCon()
        # 2. 커서객체 생성
        cursor = con.cursor()
        # 3. 실행   where  컬럼 = :key1 and 컬럼 = :key2....
        cursor.execute(sql, inputObj )
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
            if proc == 'UPDATE':
                print("수정 성공!!")
            if proc == 'DELETE':
                print("삭제 성공!!")

    # from oracledb import DatabaseError  : 상단 선언
    except DatabaseError as e:
        print(f"[DB 에러] 데이터 처리 중 오류가 발생했습니다: {e}")
        if proc != "SELECT":
            con.rollback()
        result = []     
    except Exception as e:
        print(f"[일반 에러]예외발생 {e}")
        # 에러발생시 list데이터 초기화 처리.
        result = [] 
    finally:
        # 5. 예외 상관없이 무조건 실행
        if cursor:
            try:cursor.close()  # 자원해제 처리(자체가 예외 처리 필요)
            except:pass  # pass :특정한 블럭에 처리할 내용이 없을 때..
        if con:
            try:con.close()
            except:pass
    return result


'''
# 파이썬에서의 예외 처리 
1. 파이썬에서도 try 안에서 처리되는 프로그램에서 에러가 발생하면, 프로세스를
    중단시키지 않고, 다름 프로세스로 진행하며, 에러에 대한 내용을 구체적으로
    확인할 수 있게 예외 처리를 지원하고 있다.

try:
    예외가 날만한 코드
except Exception(예외처리 내용) as e:
    print(e)
    예외가 발생시 처리할 내용.


'''

