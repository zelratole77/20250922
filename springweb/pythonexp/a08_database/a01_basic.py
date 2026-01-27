'''
a08_database.a01_basic의 Docstring
# 데이터베이스 연동
1. 파일썬을 이용한 데이터베이스(DB)연결과 활용은 마치 파이썬 프로그램이 거대한 정보 도서관(DB)에 회원가입을 하고 책을
    빌려오는 과정과 똑같습니다.
2. DB 연결이란?
    데이터베이스 연결은 파이썬 프로그램이 DB 서버에 접속하여 데이터를 주고 받을 수 있는 통로를 만드는 과정입니다.
    1) API/Driver : 파이썬과 특정 DB(oracle, mysql, sqlite 등)사이의 통역사 역할을 하는 라이브러리입니다.
    2) connection : 실제 DB 서버와 연결된 물리적 통로입니다.
    3) cursor : 통로를 통해 들어간 후, 실제로 sql 문장을 실행하고 결과를 들고 나오는 장바구니를 든 점원입니다.
3. DB 연결 처리 핵심 (접, 장, 실, 인, 닫) - 식당에서 주문하는 상황으로 시각화
    1) 접(Connection) : 접속하기 - 식당(DB)문을 열고 들어감
    2) 장(Cursor) : 장바구니(커서) - 주문을 전달할 점원을 부름
    3) 실(Excute) : 실행하기 - 주문서(SQL)를 점원에게 전달
    4) 인(Commit/fetch) : 인증/인출 - 요리를 받거나(fetch), 계산을 확정합(Commit)
    5) 닫(Close ) : 닫기 -식당 문을 닫고 나옴
    DB갈 때 접장님이 살인해서 닫는다..

'''
# pip install oracledb
import oracledb as oci
# instant client 설치된 경로 설정
lib_dir_path=r'c:\instantclient_21_20'
oci.init_oracle_client(lib_dir=lib_dir_path)
con = oci.connect("scott/tiger@localhost:1521/xepdb1")
print("연결확인", con.version)
# 1. 커서객체 생성 : sql 처리 및 결과값을 받는 객체
cursor = con.cursor()
# 2. 처리할 sql
sql = "SELECT * FROM EMP"
cursor.execute(sql)
print(cursor.fetchall())
# 3. 접속종료
con.close()



