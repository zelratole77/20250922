from flask import Flask, render_template, request
app = Flask(__name__, template_folder='../templates')

# http://localhost:8888/model01
@app.route("/model01")
def model01():
    # 모델 명과 값으로 name, age 설정.
    # render_template("뷰단", key=값, key2=값2, ...
    return render_template("a01_basic/a03_model.html",
                    name="홍길동", age=25)

# http://localhost:8888/model02
#     좋아하는 물건명, 가격을 a04_model.html 화면에 출력하세요..


app.run(port=8888,debug=True)


