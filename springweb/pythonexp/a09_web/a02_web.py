from flask import Flask, render_template
app = Flask(__name__)
# http://localhost:9998/callPage
@app.route('/callPage')
def callPage():
    return render_template("a01_callMe.html")
app.run(port=9998, debug=True)

# ex) a03_web.py
#    http://localhost:9977/web01
#    templates 안에  a02_callMe.html 웹페이지 호출  라는 내용이 있는 화면을 호출하세요.
