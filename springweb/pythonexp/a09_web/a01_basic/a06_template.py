from flask import Flask, render_template, request
from a09_web.z01_dto.a01_dto import *
app = Flask(__name__, template_folder='../templates')
# # http://localhost:8888/exptmp01
@app.route('/exptmp01', methods=['GET','POST'])
def exptmp01():
    return render_template("a02_tmplate/a01_variables.html")

# # http://localhost:8888/exptmp02
@app.route('/exptmp02' )
def exptmp01():
    return render_template("a02_tmplate/a02_if.html")


app.run(port=8888,debug=True)
