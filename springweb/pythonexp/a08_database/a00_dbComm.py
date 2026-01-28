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

