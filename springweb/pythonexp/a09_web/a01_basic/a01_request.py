'''
# 요청처리 연습..
1. get방식
    url을 통해 key=val 형식으로 요청값을 처리해서 결과를 처리하는 것을 말한다.
2. post방식
    요청 body에 key=val 형식의 요청값을 처리해서 결과를 처리하는 것을 말한다.
'''
from flask import Flask, render_template, request
app = Flask(__name__, template_folder='../templates')
# http://localhost:9999/req01?id=himan&pwd=7777
@app.route("/req01")
def req01():
    idVal = request.args.get("id") # 요청 key와 요청값을 get방식으로 받아서 처리
    pwdVal = request.args.get("pwd")
    print("#서버에 받은 값 #")
    print(idVal)
    print(pwdVal)
    return render_template("a01_basic/a01_request.html")
# ex) http://localhost:9999/req02?prodname=apple&price=3000
#     a01_basic/a02_buy.html
@app.route("/req02")
def req02():
    prodnameVal = request.args.get("prodname") # 요청 key와 요청값을 get방식으로 받아서 처리
    priceVal = request.args.get("price")
    print("#서버에 받은 값 #")
    print(prodnameVal)
    print(priceVal)
    return render_template("a01_basic/a02_buy.html")

app.run(port=9999, debug=True)