import cx_Oracle
import random, sys
from datetime import datetime, timedelta
from time import sleep

#create the lists needed in the functions below
first_names = []
last_names = []
domains = []
normal_domains = []
nicknames = []
area_codes = {}
code_list = []
num_users = 0

#fill the lists from the corresponding files
with open('firstnames.txt', 'r') as infile:
    first_names = infile.readlines()

with open('lastnames.txt', 'r') as infile:
    last_names = infile.readlines()

with open('nicknames.txt', 'r') as infile:
    nicknames = infile.readlines()

with open('domains.txt', 'r') as infile:
    domains = infile.readlines()

with open('normaldomains.txt', 'r') as infile:
    normal_domains = infile.readlines()

with open('areacodes.txt') as infile:  
    lines = infile.readlines()
    for i in lines:
        splitup = i.split(' ')
        code = splitup[0]
        state = splitup[2]
        area_codes[code] = state
        code_list.append(code)
#create database connections and return the elements needed to read and write
def create_connection(username, password):
    host_name = 'orcl.cfk3yarma72t.us-east-1.rds.amazonaws.com'
    port_number = '1521'
    service_named = 'ORCL'
    user_name = username
    password = password
    dsn_tns = cx_Oracle.makedsn(host_name, port_number, service_name=service_named) # if needed, place an 'r' before any parameter in order to address special characters such as '\'.
    conn = cx_Oracle.connect(user=user_name, password=password, dsn=dsn_tns) # if needed, place an 'r' before any parameter in order to address special characters such as '\'. For example, if your user name contains '\', you'll need to place 'r' before the user name: user=r'User Name'
    c = conn.cursor()
    return([conn, c])

#create a randomized email address
def make_email(type, firstname='', lastname=''):
    email =''
    first = ''
    domain = ''
    if type == 'name':
        seperators = ['.', '-', '']
        seperator = random.choice(seperators)
        if random.randint(1,100)>15:
            random_ender = str(random.randint(1,10000))
        else:
            random_ender = ''
        first_name = firstname
        last_name = lastname
        first = f'{first_name.rstrip()}{seperator.rstrip()}{last_name.rstrip()}{random_ender.rstrip()}'
    
    elif type == 'nickname':
        first = random.choice(nicknames).rstrip()
        if random.randint(1,100)>15:
            random_ender = str(random.randint(1,10000))
        else:
            random_ender = ''
        first += random_ender
    
    if random.randint(1,100)<25:
        domain = random.choice(domains).rstrip()
    else:
        domain = random.choice(normal_domains).rstrip()
    
    third = [first, domain]
    email = '@'.join(third)
    return(email)

#create a randomized phone number
def make_phone():
    code = random.choice(code_list)
    prefix = random.randint(100,999)
    suffix = random.randint(1000,9999)
    phone = f'{code}{prefix}{suffix}'
    return(phone)

#generate a randomized date/time in the year 2019
def gen_datetime(min_year=2019, max_year=2019):
    # generate a datetime in format yyyy-mm-dd hh:mm:ss.000000
    start = datetime(min_year, 1, 1, 00, 00, 00)
    years = max_year - min_year + 1
    end = start + timedelta(days=365 * years)
    return start + (end - start) * random.random()

#use the above functions to create a user with an email and phone number then write to the DB
def fill_users(numusers, connection):
    global num_users
    for i in range(0,numusers):
        firstname = random.choice(first_names).rstrip()
        lastname = random.choice(last_names).rstrip()
        types = ['name', 'nickname']
        email_type = random.choice(types)
        email = make_email(email_type, firstname, lastname)
        phonenum = make_phone()
        print(f'{firstname} {lastname} {email}')
        last_name = 'testin'
        connection[1].execute(f"INSERT INTO admin.CUSTOMERS (CUSTOMERLASTNAME, CUSTOMERFIRSTNAME, CUSTOMEREMAIL, CUSTOMERPHONE, CUSTOMERCELLPHONE)\
    VALUES (:lastname, :firstname, :email, :phonenum, :phonenum2)", lastname = lastname, firstname=firstname, email=email, phonenum=phonenum, phonenum2=phonenum)
        connection[0].commit()
        num_users += 1

#fill an empty projections table
def fill_projections(numprojections, connection):
    for i in range(1,num_users+1):
        id = i
        qpa = random.randint(1,10000)
        qpra = round(qpa/random.randint(2,4), 2)
        confidence = random.randint(1,100)/100
        try:
            #c.execute("INSERT INTO PROJECTIONS2020 (CUSTOMERID, QUARTERLYPURCHASEAMOUNT, QUARTERLYPROFITAMOUNT, CONFIDENCE\
    #VALUES (:id, :qpa, :qpra, :confidence)", id=id, qpa=qpa, qpra=qpra, confidence=confidence)
            connection[1].execute("INSERT INTO admin.PROJECTIONS2020 (CUSTOMERID, QUARTERLYPURCHASEAMOUNT, QUARTERLYPROFITAMOUNT, CONFIDENCE)\
    VALUES (:id, :qpa, :qpra, :confidence)", id=str(id), qpa=str(qpa), qpra=str(qpra), confidence=str(confidence))
            connection[0].commit()
        except Exception as e:
            print(e)

#enter a sale or batch of sales into the table
def fill_sales(numsales, connection):
    for i in range(1,numsales+1):
        try:
            date = str(gen_datetime()).split('.')[0]
            custid = random.randint(1,num_users)
            saleamt = round(random.uniform(1,1000), 2)
            profitamt = round(saleamt/random.randint(2,4), 2)
            #print(f'{date} {custid} {saleamt} {profitamt}')
            connection[1].execute("INSERT INTO admin.SALES2019 (CUSTOMERID, TRANSACTIONDATE, SALESAMOUNT, PROFITAMOUNT)\
VALUES (:custid, TO_DATE(:date2, 'YYYY-MM-DD hh24:mi:ss'), :saleamt, :profitamt)", date2=date, custid=custid, saleamt=saleamt, profitamt=profitamt)
            connection[0].commit()
            print('sale')
        except Exception as e:
            #print(e)
            pass

#alter a projection
def alter_projections(connection):
    id = random.randint(1,num_users)
    qpa = random.randint(1,10000)
    qpra = round(qpa/random.randint(2,4), 2)
    confidence = random.randint(1,100)/100
    try:
        connection[1].execute("UPDATE admin.PROJECTIONS2020 SET CONFIDENCE = :conf WHERE CUSTOMERID = :id",  conf=confidence, id=id)
        connection[0].commit()
        print(f'{id} projected to {confidence}')
    except Exception as e:
        print(e)

#alter a customer record
def alter_customers(connection):
    id = random.randint(1,num_users)
    newphone = make_phone()
    try:
        connection[1].execute("UPDATE admin.CUSTOMERS SET CUSTOMERCELLPHONE = :newphone WHERE CUSTOMERID = :id",  newphone=newphone, id=id)
        connection[0].commit()
        print(f'{id} cell phone set to {newphone}')
    except Exception as e:
        print(e)

#alter a set of sales records by customerid
def alter_sales(connection):
    id = random.randint(1,num_users)
    prof = random.randint(0,2500)
    try:
        connection[1].execute("update admin.sales2019 set profitamount = :prof where customerid = :id", prof=prof, id=id)
        connection[0].commit()
        print(f'Customer {id} sales set to {prof}.')
    except Exception as e:
        print(e)

#select data from a random table
def access_table(connection):
    tables = ['select * from admin.sales2019',\
        'select * from admin.customers', 'select * from admin.projections2020']
    statement = random.choice(tables)
    try:
        connection[1].execute(statement)
        print('accessed')
    except Exception as e:
        print(e)

#delete either a record from the projections or sales2019 tables
def delete_record(connection):
    statements = ['delete from admin.projections2020 where customerid = :id',\
        'delete from admin.sales2019 where customerid = :id']
    statement = random.choice(statements)
    id = random.randint(1,num_users)
    try:
        connection[1].execute(statement, id=id)
        connection[0].commit()
        print('delete')
    except Exception as e:
        print(e)

#look through the projections table and recreate projections for any customer who is missing one
def refill_projections(connection):
    connection[1].execute("SELECT CUSTOMERID FROM ADMIN.PROJECTIONS2020")
    projected = []
    for row in connection[1]:
        projected.append(row[0])

    for i in range(1,num_users):
        if i not in projected:
            id = i
            qpa = random.randint(1,10000)
            qpra = round(qpa/random.randint(2,4), 2)
            confidence = random.randint(1,100)/100
            try:
                #c.execute("INSERT INTO PROJECTIONS2020 (CUSTOMERID, QUARTERLYPURCHASEAMOUNT, QUARTERLYPROFITAMOUNT, CONFIDENCE\
        #VALUES (:id, :qpa, :qpra, :confidence)", id=id, qpa=qpa, qpra=qpra, confidence=confidence)
                connection[1].execute("INSERT INTO admin.PROJECTIONS2020 (CUSTOMERID, QUARTERLYPURCHASEAMOUNT, QUARTERLYPROFITAMOUNT, CONFIDENCE)\
        VALUES (:id, :qpa, :qpra, :confidence)", id=str(id), qpa=str(qpa), qpra=str(qpra), confidence=str(confidence))
                connection[0].commit()
            except Exception as e:
                print(e)

#create connection for admin user
admin = create_connection('admin', 'P@$$W0rd1234!@#$')
#read the number of users and assign that to the num_users variable
admin[1].execute("select * from customers")
for row in admin[1]:
    num_users+=1

#print(f'{num_users} users')
#create connections for each of the users
u1week8 = create_connection('u1week8', 'P@$$W0rd1234!@#$')
u2week8 = create_connection('u2week8', 'P@$$W0rd1234!@#$')
u3week8 = create_connection('u3week8', 'P@$$W0rd1234!@#$')
userslist=[]
userslist.append(u1week8)
userslist.append(u2week8)
userslist.append(u3week8)
#if this is the first run and there are no users fill the tables with the admin user
if num_users == 0:
    fill_users(100,admin)
    fill_projections(100,admin)
    fill_sales(500,admin)

#begin a loop to create the audit data
counter = 0
running = True
while running:
    try:
        #choose a random user
        user = random.choice(userslist)
        #choose a random choice and check choose an action from the list
        number = random.randint(1,100)
        if number>75:
            print('1')
            fill_sales(1, user)
            print(f'count {counter}')
        elif number > 60:
            print('2')
            access_table(user)
            print(f'count {counter}')
        elif number > 45:
            print('3')
            fill_users(1,user)
            print(f'count {counter}')
        elif number > 35:
            print('4')
            alter_sales(user)
            print(f'count {counter}')
        elif number > 25:
            print('4')
            alter_customers(user)
            print(f'count {counter}')
        elif number > 15:
            print('5')
            alter_projections(user)
            print(f'count {counter}')
        elif number > 5:
            print(6)
            refill_projections(user)
            print(f'count {counter}')
        else:
            print('7')
            delete_record(user)
            print(f'count {counter}')
        counter+=1
        sleep(.1) #increase this number to slow the transactions, maybe use random int from 1 to 15

    except KeyboardInterrupt:
        print(f'you completed {counter} alterations.')
        exit()
