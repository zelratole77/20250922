import oracledb as oci
from oracledb import DatabaseError
# DB연동 공통 모듈..
def dbCon():
    # instant client 설치된 경로 설정
    lib_dir_path=r'c:\instantclient_21_20'
    oci.init_oracle_client(lib_dir=lib_dir_path)
    con = oci.connect("scott/tiger@localhost:1521/xepdb1")
    print("연결확인:", "성공" if con else "실패")
    return con