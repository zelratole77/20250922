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
'''
# DB 처리 상세 내용
1. 파이썬은 oracledb 라이브러리를 사용하여 오라클 데이터베이스 서버에 접속하고,
    접속된 상태에서 cursor객체를 생성하고 sql을 이용하여 결과내용을 처리하고 자원을 해제하는
    형태로 DB 처리를 한다.
2. oracledb의 Thick모드를 사용하여 데이터를 연결하는 방식이 있는데, 이는 스크립트가
    실행하는 환경에 oracle instant client가 설치되어 있어야 하며, 코드에서 해당 클라이언트
    경로를 직접 지정하여 초기화하여야 한다.
3. 데이터를 가져오는 방식으로 한 행씩 가져오는 fetchone()과 모든행을 가져오는 fetchall()이 
    cusor객체에 메서드로 지원을 하고 있다.
4. 단계별 핵심 코드에 대한 이해..
    1) Thick모드 초기화
        lib_dir_path = r'c:\\instantclient_21_20'
        oci.ini_oracle_client(lib_dir=lib_dir_path) : lib_dir_path에 설정된 경로(윈도우용
        oracle 클라이언트)로 초기화하고 있다.
        oracledb가 instant client라이브러리(oci.dll등) 찾을 수 있도록 폴드 경로를 설정하고
        명시적으로 지정한다.(자바로 비유하면 jdbc 드라이버를 말한다. 윈도우 환경에 필요한 dll
        파일 설정)
    2) 데이터베이스 서버 접속
        con = oci.connect("scott/tiger@localhost:1521/xepdb1) 계정/비번@서버주소:포트/DB명
    3) Connect객체를 통해 커서 생성
        cursor = con.cursor()
        생성된 연결 객체로부터 sql을 실행하고 결과를 처리할 수 있는 커서(cursor)객체를 생성
    4) sql 실행
        cursor.execute("select * from emp")
        커서sql 실행 : sql 문자열을 해석하여 DB서버에 전송 및 그 결과값을 cursor의 메모리에
        저장한다.
    5) 데이터 인출(한행씩/전체행)
        cursor.fetchone() : 한행씩 데이터를 인출한다. 데이터 유형은 튜플형태이다.
            호출시 마다 한 행씩 sql의 결과 순차적으로 가져온다.
        cursor.fetchall() : 전체행을 한꺼번에 인출한다. []안에 튜플형태가 들어간 형태로
        보면된다.
    6) 접속 종료 : 모든 작업이 끝난 후, con.close()를 통해서 데이터베이스 서버에 연결 자원을
        안전하게 해제/자원 반환을 한다.
    # 위 내용에서 try catch 블럭을 통해 예외가 발생할 때는 대비하여 구문을 추가적으로 처리할
    수 있다. 파이썬에서는 DB 연결 처리가 예외 필수 사항은 아니지만, 에러 트래킹이나 프로그래밍
    안정성을 위해 처리해주고 있다.




'''







