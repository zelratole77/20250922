from flask import Flask, render_template, request
app = Flask(__name__, template_folder='../templates')


# http://localhost:8888/plus?no01=10&no02=20
@app.route('/plus')
def plus():
    no01Val = request.args.get('no01')
    no02Val = request.args.get('no02')
    if no01Val and no02Val: # None값이 아닐 때 처리..
        no01Val = int(no01Val)
        no02Val = int(no02Val)
    return render_template("a01_basic/a05_req_model.html",
                           no01=no01Val, no02=no02Val, sum=no01Val + no02Val)

# http://localhost:8888/changeMeter?cm=150.5 ==>  150.5cm는 1.505m 입니다. 출력.
@app.route('/changeMeter')
def changeMeter():
    cmVal = request.args.get('cm')
    meterVal =  0
    if cmVal:
        cmVal = float(cmVal)
        meterVal = cmVal/100
    else: cmVal = 0
    return render_template("a01_basic/a06_req_model.html",
                           cm=cmVal, meter=meterVal)
app.run(port=8888,debug=True)
# changeMeter cm meter