from flask import Flask, render_template, request
from a09_web.z01_dto.a01_dto import *
app = Flask(__name__, template_folder='../templates', static_folder='../static')
# # http://localhost:7070/empList
@app.route('/empList', methods=['GET','POST'])
def empList():
    return render_template("a03_emp/a01_empList.html")


app.run(port=7070,debug=True)
