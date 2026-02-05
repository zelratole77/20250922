from flask import Flask, render_template, request
from z02_dao import *
from z01_dto import *
app = Flask(__name__, template_folder='../templates', static_folder='../static')
# # http://localhost:7070/dateList
@app.route('/dateList', methods=['GET','POST'])
def dateList():
    dateList = []
    schDic = {"partner_name":"","location":""}
    # post방식일 때, form에 있는 데이터를 처리하여 모델 데이터 처리
    if request.method == 'POST':
        schDic = request.form.to_dict() # 입력한 form데이터 내용을 넣어서 처리하고..

    # 요청값 화면에 로딩 처리..
    partner_nameSch =  schDic['partner_name'] if schDic['partner_name'] != None else ""
    locationSch = schDic['location'] if schDic['location'] != None else ""
    # sql 처리를 위해 요청값 처리
    schDic['partner_name']="%"+schDic['partner_name']+"%"
    schDic['location']="%"+schDic['location']+"%"
    sql = '''
          select * from BLIND_DATE 
          where PARTNER_NAME like :partner_name 
            and LOCATION like :location

          '''

    dateList = dataProc(sql, schDic, BlindDate, "SELECT")
    print(dateList)

    return render_template("a04_date/a01_dateList.html",
                           partner_name=partner_nameSch, location=locationSch, dateList=dateList)


app.run(port=7070,debug=True)
