# ex) a03_web.py
#    http://localhost:9977/web01
#    templates 안에  a02_callMe.html 웹페이지 호출  라는 내용이 있는 화면을 호출하세요.
from flask import Flask, render_template
app = Flask(__name__)
#    http://localhost:9977/web01
@app.route("/web01")
def web01():
    return render_template("a02_callMe.html")

app.run(port=9977, debug=True)

