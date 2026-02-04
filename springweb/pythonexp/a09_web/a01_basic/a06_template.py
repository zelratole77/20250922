from flask import Flask, render_template, request
from a09_web.z01_dto.a01_dto import *
app = Flask(__name__, template_folder='../templates')
# # http://localhost:8888/exptmp01
@app.route('/exptmp01', methods=['GET','POST'])
def exptmp01():
    return render_template("a02_tmplate/a01_variables.html")


# # http://localhost:8888/exptmp02
@app.route('/exptmp02' )
def exptmp02():
    return render_template("a02_tmplate/a02_if.html")

# # http://localhost:8888/exptmp03
@app.route('/exptmp03' )
def exptmp03():
    return render_template("a02_tmplate/a03_loop.html")

# # http://localhost:8888/exptmp04
@app.route('/exptmp04' )
def exptmp04():
    return render_template("a02_tmplate/a04_list.html")

# ex) 동일한 화면에  학생의 국어 영어 수학 점수를 points로 선언해서 출력 하세요..


app.run(port=8888,debug=True)
