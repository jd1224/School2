'''
Module to display the content of a basic website
'''
import datetime
from datetime import timedelta
from flask import Flask
from flask import render_template
from flask import redirect
from flask import request
from flask import session
from users import UserMethods

app = Flask(__name__)
app.secret_key = 'superkalfragilisticexpialadocious'
LOGIN_ERROR = "Request denied, You Must Login for That Page."
LOG_FILE = 'authlog.log'
LOG_FMT = "%b %d %H:%M:%S"

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
    if 'id' in session:
        today = datetime.datetime.today()
        then = datetime.datetime.strptime("2020-10-23", "%Y-%m-%d")
        delta = (today - then).days
        #delta = (then - today).days #uncomment this line to test logic
        return render_template('ncl.html', delta=delta)
    return render_template('index.html', error=LOGIN_ERROR)

@app.route('/clocks/')
def clocks():
    '''
    render the clocks page with the current time
    and the time moved back and forward by the
    given time delta
    '''
    if 'id' in session:
        txdelta = timedelta(hours=1)
        fmt = "%H:%M:%S"
        now = datetime.datetime.now()
        later = (now + txdelta).time().strftime(fmt)
        before = (now - txdelta).time().strftime(fmt)
        now = now.time().strftime(fmt)
        return render_template('clocks.html', now=now, later=later, before=before)
    return render_template('index.html', error=LOGIN_ERROR)

@app.route('/signup', methods=['GET', 'POST'])
def signup():
    '''
    render the signup page that allows a new
    user to signup for an account with a username
    password and valid email account
    '''
    if request.method == 'POST':
        username = request.form.get("username")
        email = request.form.get("email")
        password = request.form.get("password")
        try:
            user = UserMethods(username, email, password)
            user.create_users()
            session['id'] = username
            log_event(f'{datetime.datetime.now().strftime(LOG_FMT)}:\
 Account created for {username} from {request.remote_addr}')
            log_event(f'{datetime.datetime.now().strftime(LOG_FMT)}:\
 Login success for {username} from {request.remote_addr}')
            return redirect('/')
        except ValueError as exception:
            return render_template('signup.html', req=exception, color='text-danger')

    return render_template('signup.html')

@app.route('/states')
def states():
    '''
    render the states page if the user
    is logged in
    '''
    if 'id' in session:
        return render_template('states.html')
    return render_template('index.html', error=LOGIN_ERROR)

@app.route('/signin', methods=['POST'])
def signin():
    '''
    signin function to allow the user
    to sign in using the user_method
    authenticate function
    '''
    username = request.form.get("username")
    password = request.form.get("password")
    try:
        user1 = UserMethods(username, 'dummy', password)
        user1.authenticate_user()
        session['id'] = username
        log_event(f'{datetime.datetime.now().strftime(LOG_FMT)}:\
 Login success for {username} from {request.remote_addr}')
        return redirect('/')
    except ValueError as exception:
        log_event(f'{datetime.datetime.now().strftime(LOG_FMT)}:\
 Failed password for {username} from {request.remote_addr}')
        return render_template('index.html', error=exception)

@app.route('/signout', methods=['POST'])
def signout():
    '''
    sign the user out by
    popping the session id from
    the session list
    '''
    log_event(f"{datetime.datetime.now().strftime(LOG_FMT)}:\
 Session ended for {session['id']} from {request.remote_addr}")
    session.pop('id', None)
    return redirect('/')

@app.route('/passchange')
def passchange():
    '''render the passchange form'''
    if 'id' in session:
        return render_template('passchange.html')
    return render_template('index.html', error=LOGIN_ERROR)

@app.route('/changepass', methods=['POST'])
def change_pass():
    '''
    function to change the password using the UserMethods
    class
    '''
    #create variables and fill with form data
    username = session['id']
    old_pass = request.form.get('password')
    new_pass = request.form.get('new_pass')
    new_pass_conf = request.form.get('new_pass_conf')
    #stringout = f'{username} / {old_pass} / {new_pass} / {new_pass_conf}'
    try:
        #create a user
        user1 = UserMethods(username, 'dummy', old_pass)
        #authenticate the user
        user1.authenticate_user()
        #make sure the new password and confirm fields match
        if new_pass == new_pass_conf:
            user1.password_validate(new_pass)
            user1.change_password(new_pass)
            log_event(f'{datetime.datetime.now().strftime(LOG_FMT)}:\
 Password changed for {username} from {request.remote_addr}')
        else:
            raise ValueError("New password did not match confirmation field")
    #handle any ValueErrors and return the exception message with the danger color
    except ValueError as exception:
        log_event(f'{datetime.datetime.now().strftime(LOG_FMT)}:\
 Failed password change for {username} from {request.remote_addr}')
        return render_template('passchange.html', req=exception, color='text-danger')
    #if all checks work return the success message on the pass change page with the info color
    return render_template('passchange.html', req="Password Successfully Changed"\
, color='text-info')

def log_event(event):
    '''
    method to log events to the
    LOG_FILE location
    '''
    with open(LOG_FILE, 'a') as logs:
        logs.write(event)
        logs.write('\n')

app.run(host='192.168.1.111', debug=True)
