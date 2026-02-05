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
    insDto = None
    msg = ""
    if request.method == 'POST':

        empno = int(request.values.get('empno',"0"))
        ename = request.values.get('ename')
        job = request.values.get('job')
        mgr = int(request.values.get('mgr', "0"))
        hiredate = request.values.get('hiredate')
        sal = float(request.values.get('sal', "0.0"))
        comm = float(request.values.get('comm', "0.0"))
        deptno = int(request.values.get('deptno', "0"))
        insDto = EmpCU(empno,ename,job, mgr, hiredate, sal, comm, deptno)
        #insDto = EmpCU(**request.form)
        print(insDto)

        msg = service.empInsert(insDto)
    return render_template("a03_emp/a02_empInsert.html", msg = msg)


app.run(port=7070,debug=True)
