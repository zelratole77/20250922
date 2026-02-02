from flask import Flask, render_template
app = Flask(__name__)
# http://localhost:9998/callPage
@app.route('/callPage')
def callPage():
    return render_template("a01_callMe.html")
app.run(port=9998, debug=True)