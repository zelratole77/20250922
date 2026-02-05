from flask import Flask, render_template, request
from z01_dto import *
import a02_2dateService as service
app = Flask(__name__, template_folder='../templates', static_folder='../static')
# # http://localhost:7070/dateList  partner_name location dateList
@app.route('/dateList', methods=['GET','POST'])
def dateList():
    partner_nameSch = request.values.get('partner_name',"") # None 일 때 공백처리 요청
    locationSch = request.values.get('location',"") # None 일 때 공백처리 요청
    dateList = service.dateList(BlindDateSch(partner_nameSch, locationSch))
    return render_template("a04_date/a01_dateList.html",
                           partner_name=partner_nameSch, location=locationSch,
                           dateList=dateList)

# http://localhost:7070/dateInsert
@app.route('/dateInsert', methods=['GET','POST'])
def dateInsert():
    insDto = None
    msg = ""
    if request.method == 'POST':
        insDto = BlindDateCU(**request.form)
        print(insDto)

        msg = service.dateInsert(insDto)
    return render_template("a04_date/a02_dateInsert.html", msg = msg)




app.run(port=7070,debug=True)
