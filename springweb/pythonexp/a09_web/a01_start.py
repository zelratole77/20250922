'''
# 파이썬에서 웹 개발 환경으로 프로그램 처리
1. 웹개발 환경
    1) flask 모듈 설처 및 import 및 웹 서버 실행 모드
        pip install flask
    2) url 요청 메서드 선언
2. 단계별 학습
    1) url 별로 처리 호출
        - 덱스트
        - html 코드
        - html 파일
        - 부트스트렙 템플릿 환경 설정
    2) 요청 값 처리
    3) 모델 데이터 처리
    4) DB 연결 모델 데이터 처리
    5) 요청 + 모델 데이터 처리 및 화면 출력.
    6) 조회 ==> 등록 ==> 상세 ==> 수정 ==> 삭제
'''
# 1. 모듈 호출
from flask import Flask
# 2. Flask 객체 생성
app = Flask(__name__)
# 3. http://127.0.0.1:9999/
@app.route('/')
def index():
    return '''파이썬에서 flask 시작'''


# 3. http://127.0.0.1:9999/start
@app.route('/start')
def index2():
    return '''다른 이름으로 호출(Good!!)'''
# ex) http://127.0.0.1:9999/goodday  ==> 파이썬과 좋은 하루입니다. 출력..






if __name__ == '__main__':
    app.run(port=9999,debug=True)



