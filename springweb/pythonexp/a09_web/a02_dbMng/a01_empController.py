from flask import Flask, render_template, request
from z02_dao import *
from z01_dto import *
app = Flask(__name__, template_folder='../templates', static_folder='../static')
# # http://localhost:7070/empList
@app.route('/empList', methods=['GET','POST'])
def empList():
    empList = []
    enameSch = ""
    jobSch = ""
    schOb = EmpSch("", "")
    # post방식일 때, form에 있는 데이터를 처리하여 모델 데이터 처리
    if request.method == 'POST':
        schOb = EmpSch(**request.form)   # 입력한 form데이터 내용을 넣어서 처리하고..

    # 요청값 화면에 로딩 처리..
    enameSch = schOb.ename
    jobSch = schOb.job
    # sql 처리를 위해 요청값 처리
    schOb.ename="%"+schOb.ename+"%"
    schOb.job="%"+schOb.job+"%"
    sql = '''
              select * from emp01
              where ename like :ename and job like :job
              order by empno desc        
        '''
    empList = dataProc(sql, schOb.__dict__, Emp, "SELECT")
    print(empList)

    return render_template("a03_emp/a01_empList.html",
                           ename=enameSch, job=jobSch, empList=empList)


app.run(port=7070,debug=True)
