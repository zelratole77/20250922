from flask import Flask, render_template, request
from a09_web.z01_dto.a01_dto import *
app = Flask(__name__, template_folder='../templates')
'''
class OrderProduct:
    no: int
    name: str
    price: int
    cnt:int

'''
# http://localhost:8888/orderProduct?no=1&name=사과&price=3000&cnt=2
# order.no order.name order.price order.cnt
@app.route('/orderProduct')
def orderProduct():
    noVal = request.args.get('no')
    nameVal = request.args.get('name')
    priceVal = request.args.get('price')
    cntVal = request.args.get('cnt')
    orderDto = None
    if noVal and nameVal and priceVal and cntVal:  # 해당 값이 있을 때..
        noVal = int(noVal)
        priceVal = int(priceVal)
        cntVal = int(cntVal)
        orderDto = OrderProduct(noVal, nameVal, priceVal, cntVal)
    return render_template("a01_basic/a08_reqObj.html",
                           order=orderDto)

# http://localhost:8888/orderProduct2
@app.route('/orderProduct2', methods=['GET'])
def orderProduc2():
    return render_template("a01_basic/a09_reqObj.html", order=None)


@app.route('/orderProduct2', methods=['POST'])
def orderProducPost():
    orderDto = OrderProduct(**request.form) # 자동으로 type에 맞게 객체 할당..
    return render_template("a01_basic/a09_reqObj.html",
                           order=orderDto)

# http://localhost:8888/orderProduct3
@app.route('/orderProduct3', methods=['GET','POST'])
def orderProduc3():
    orderDto = None
    if request.method == 'POST':
        orderDto = OrderProduct(**request.form) # 자동으로 type에 맞게 객체 할당..
    return render_template("a01_basic/a09_reqObj.html",
                           order=orderDto)


# EX) 부서정보 등록 처리  부서번호, 부서명, 부서위치 입력  dto처리, 모델데이터로 dto 출력..
# # http://localhost:8888/insertDept
@app.route('/insertDept', methods=['GET','POST'])
def insertDept():
    deptDto = None
    if request.method == 'POST':
        deptDto = Dept(**request.form) # 자동으로 type에 맞게 객체 할당..
    return render_template("a01_basic/a10_insertDept.html",
                           dept=deptDto)
app.run(port=8888,debug=True)


