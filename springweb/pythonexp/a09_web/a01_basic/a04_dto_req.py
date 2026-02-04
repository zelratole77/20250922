from flask import Flask, render_template, request
from a09_web.z01_dto.a01_dto import *
app = Flask(__name__, template_folder='../templates')
# http://localhost:8888/personIns?name=홍길동&age=25&loc=수원
@app.route('/personIns')
def personIns():
    nameVal = request.args.get('name')
    ageVal = request.args.get('age')
    locVal = request.args.get('loc')
    person = None
    if nameVal and ageVal and locVal:  # 해당 값이 있을 때..
        ageVal = int(ageVal)
        person = Person(name=nameVal, age=ageVal, loc=locVal)
    return render_template("a01_basic/a07_reqObj.html",
                           person=person)
app.run(port=8888,debug=True)