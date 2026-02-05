from flask import Flask, render_template, request
from z01_dto import *
import a01_2empService as service
app = Flask(__name__, template_folder='../templates', static_folder='../static')
# # http://localhost:7070/empList
@app.route('/empList', methods=['GET','POST'])
def empList():
    enameSch = request.values.get('ename',"") # None 일 때 공백처리 요청
    jobSch = request.values.get('job',"") # None 일 때 공백처리 요청

    empList = service.empList(EmpSch(enameSch, jobSch))

    return render_template("a03_emp/a01_empList.html",
                           ename=enameSch, job=jobSch, empList=empList)

# http://localhost:7070/empInsert
@app.route('/empInsert', methods=['GET','POST'])
def empInsert():


    return render_template("a03_emp/a02_empInsert.html")


app.run(port=7070,debug=True)
