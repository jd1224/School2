'''
Module to display the content of a basic website
'''
import datetime
from datetime import timedelta
from flask import Flask
from flask import render_template

app = Flask(__name__)

@app.route('/')
def index():
    '''render the index page'''
    return render_template('index.html')

@app.route('/ncl/')
def ncl():
    '''
    render the ncl page with a countdown
    to the start of the competition
    '''
    today = datetime.datetime.today()
    then = datetime.datetime.strptime("2020-10-23", "%Y-%m-%d")
    delta = (today - then).days
    #delta = (then - today).days #uncomment this line to test logic
    return render_template('ncl.html', delta=delta)


@app.route('/clocks/')
def clocks():
    '''
    render the clocks page with the current time
    and the time moved back and forward by the
    given time delta
    '''
    txdelta = timedelta(hours=1)
    fmt = "%H:%M:%S"
    now = datetime.datetime.now()
    later = (now + txdelta).time().strftime(fmt)
    before = (now - txdelta).time().strftime(fmt)
    now = now.time().strftime(fmt)
    return render_template('clocks.html', now=now, later=later, before=before)

app.run(debug=True)
